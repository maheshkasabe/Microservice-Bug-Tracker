import axios from 'axios'
import React, { useEffect, useState } from 'react'
import BugList from './BugList'
import Bugs from './Bugs'

const Bug = ({id}) => {
  const [project, setProject] = useState([])
  const [mem_list, setMemlist] = useState([])
  const [bugs, setBugs] = useState([])
  const [buginfo, setbuginfo] = useState([])
  const [Id,setId] = useState(id);


  useEffect(() => {
    axios.get(`http://localhost:9191/projects/${Id}`).then((response) => {
      setProject(response.data)
      setMemlist(response.data.members)
      setBugs(response.data.buglist)
      console.log(response.data.buglist)
    })
  }, [])

  useEffect(() => {
    async function r() {
      for (let i = 0; i < bugs.length; i++) {
        await axios.get(`http://localhost:9191/bugs/${bugs[i]}`).then((response) => {
          console.log(response.data)
          setbuginfo(bug => [...bug, { ...response.data }])
        }).catch((err) => {
          console.log(err)
        })
      }
    }
    r()
  }, [bugs])

  return (
    <div>
      <Bugs id={Id} project={project} mem_list={mem_list} />
      <BugList id={Id} bugs={bugs} buginfo={buginfo} />
    </div>
  )
}

export default Bug