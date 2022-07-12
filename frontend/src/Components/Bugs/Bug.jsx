import axios from 'axios'
import React, { useEffect, useState } from 'react'
import BugList from './BugList'
import Bugs from './Bugs'

const Bug = () => {
  const [project, setProject] = useState([]);
  const [mem_list, setMemlist] = useState([]);
  const [bugs, setBugs] = useState([])
  const [bug, setBug] = useState([])
  const [buginfo, setbuginfo] = useState([])


  useEffect(() => {
    axios.get(`http://localhost:8082/projects/${1}`).then((response) => {
      setProject(response.data)
      setMemlist(response.data.members);
      setBugs(response.data.buglist)
      console.log(response.data.buglist)
    })
  }, [])

  useEffect(() => {
      return Promise.all([bugs].map(async (bugid) => {
        const response = await axios.get(`http://localhost:8083/bugs/${bugid}`)
        setbuginfo(response.data)
        console.log(response.data)
      })

      )
        

  }, [])

  return (
    <div>
      <Bugs id={1} project={project} mem_list={mem_list} />
      <BugList id={1} bugs={bugs} buginfo={buginfo} />
    </div>
  )
}

export default Bug