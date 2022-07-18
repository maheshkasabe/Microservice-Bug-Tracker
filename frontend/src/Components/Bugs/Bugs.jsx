import axios from 'axios';
import React, { useState, useEffect } from 'react'
import AddMembers from '../Modal/AddMembers';
import "./bugs.css"

const Bugs = ({id,project,mem_list}) => {
  const [show, setshow] = useState(false);
  const [state, Setstate] = useState(false)

  const deleteproject = (id) => {
    axios.delete(`http://localhost:9191/projects/${id}`, {
      headers: {
        Authorization: "token"
      }
    }).then((response) => {
      console.log(response);
    })
  }

  const members_list = project.members;

  return (
    <div className='bugs'>
      <div className='info'>
        <h1>{project.name}</h1>
        <p>Admin  :  {project.creator}</p>
        <p>Created At  :  {project.timestamp} </p>

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
           mem_list && mem_list.map((mem) => {
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