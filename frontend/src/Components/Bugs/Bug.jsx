import axios from 'axios'
import React,{useEffect, useState} from 'react'
import BugList from './BugList'
import Bugs from './Bugs'

const Bug = () => {
  const [bugs, setBugs] = useState([])
  const [buginfo, setbuginfo] = useState([])


  useEffect(() => {
    axios.get(`http://localhost:8082/projects/${3}`).then((response) => {
        setBugs([...bugs,response.data.buglist])
        console.log(response.data.buglist)
    })
}, [])

useEffect(() => {
  [bugs].map(async (bugid) => { 
    const response = await axios.get(`http://localhost:8083/bugs/?bugid=${bugid}`)
    setbuginfo(response.data)
    console.log(response.data)
   })
}, [])

  return (
    <div>
        <Bugs id={3} />
        <BugList id={3} bugs={bugs} buginfo={buginfo}/>
    </div>
  )
}

export default Bug