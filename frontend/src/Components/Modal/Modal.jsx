import axios from 'axios'
import React, { useState } from 'react'
import "./modal.css"

const Modal = ({ Setstate,id}) => {
  const [bugname, setBugname] = useState()
  const[priority, setPriority] = useState("LOW")
  const[status, setStatus] = useState("OPEN")

  const postbug = () => {
    axios.post(`http://localhost:8082/projects/addbug/${id}`,{
              name: bugname,
              priority: priority,
              status: status
    }).then((response) => {
      console.log(response.data)
    })
  }

  return (
    <div className='modal'>

      <div className='modal-bug'>
        <div className='project'>
          <p>ADD A NEW BUG </p> <button onClick={() => { Setstate(false) }}>x</button>
        </div>
        <input type="text" placeholder='Title' onChange={(e) => {setBugname(e.target.value)}}/>
        <div className='buttons'>
        {/* Priority : <button id='low' onClick={setPriority("LOW")}>Low</button>  */}
         {/* <button id='med' onClick={setPriority("MEDIUM")}>Medium</button> <button id='high' onClick={setPriority("HIGH")}>High</button> */}
        </div>

        <button onClick={postbug}>CREATE A NEW BUG </button>
      </div>

    </div>
  )
}

export default Modal