import axios from 'axios';
import React, { useState, useEffect } from 'react'
import "./bugs.css"

const Bugs = ({ id }) => {
  const [project, setProject] = useState([]);
  const [members, setMembers] = useState(["john"]);

  useEffect(() => {
    axios.get(`http://localhost:8082/projects/${id}`).then((response) => {
      setProject(response.data)
      console.log(response.data)

    })
  }, [])

  const deleteproject = (id) => {
    axios.delete(`http://localhost:8082/projects/${id}`, {
      headers: {
        Authorization: "token"
      }
    }).then((response) => {
      console.log(response);
    })
  }

  const addmembers = (id) => {
    axios.put(`http://localhost:8082/projects/addmembers/${id}`, {
      members: members
    }).then((response) => {
      console.log(response);
    })
  }

  return (
    <div className='bugs'>
      <div className='info'>
        <h1>{project.name}</h1>
        <p>Admin: {project.creator}</p>
        <p>Created At: {project.timestamp} </p>

        <div className='info-btn'>

          <button> ^ View Members</button>
          <button onClick={() => {addmembers(project.id)}}>+ Add Members </button>
          <button onClick={() => { deleteproject(project.id) }}>X Delete Project </button>
        </div>

        <div>
            Members : {project.members}
        </div>

      </div>



    </div>
  )
}

export default Bugs