import axios from 'axios';
import React, { useState, useEffect } from 'react'
import AddMembers from '../Modal/AddMembers';
import "./bugs.css"

const Bugs = ({id}) => {
  const [project, setProject] = useState([]);
  const [mem_list, setMemlist] = useState([]);
  const [show, setshow] = useState(false);
  const [state, Setstate] = useState(false)

  useEffect(() => {
    axios.get(`http://localhost:8082/projects/${id}`).then((response) => {
      setProject(response.data)
      setMemlist(response.data.members);

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

  const members_list = project.members;
  console.log(members_list)

  return (
    <div className='bugs'>
      <div className='info'>
        <h1>{project.name}</h1>
        <p>Admin: {project.creator}</p>
        <p>Created At: {project.timestamp} </p>

        <div className='info-btn'>

          <button onClick={() => {setshow(!show)}}> ^ View Members</button>
          <button onClick={() => { Setstate(!state)}}>+ Add Members </button>
          <button onClick={() => { deleteproject(project.id) }}>X Delete Project </button>

        </div>

        {
                state && (
                    <AddMembers Setstate={Setstate} id={id} />
                )
            }

        {
          show && 
          <div className='memlist'>
          Members :
          {
            mem_list.map((mem) => {
              return (
                <div className='mem_name'>
                  <p> {mem} </p>
                </div>
              )
            })
          }
        </div>
        }

      </div>



    </div>
  )
}

export default Bugs