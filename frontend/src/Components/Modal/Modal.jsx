import axios from 'axios'
import React, { useState } from 'react'
import "./modal.css"

const Modal = ({ Setstate, id }) => {
  const [bugname, setBugname] = useState()
  const [priority, setPriority] = useState("LOW")
  const [status, setStatus] = useState("OPEN")

  const postbug = () => {
    axios.post(`http://localhost:9191/projects/addbug/${id}`, {
      name: bugname,
      priority: priority,
      status: status
    }).then((response) => {
      console.log(response.data)
    })
  }

  const btnhandler = (msg) => {
      setPriority(msg);
  }

  return (
    <div className='modal'>

      <div className='modal-bug'>
        <div className='project'>
          <p>ADD A NEW BUG </p> <button onClick={() => { Setstate(false) }}>x</button>
        </div>
        <input type="text" placeholder='Title' onChange={(e) => { setBugname(e.target.value) }} />
        <div className='buttons'>
          Priority : <button id='low' onClick={() => {btnhandler("LOW")}}>Low</button>
          <button id='med' onClick={() => btnhandler("MEDIUM")}>Medium</button>
          <button id='high' onClick={() => btnhandler("HIGH")}>High</button>
        </div>

        <button onClick={postbug}>CREATE A NEW BUG </button>
      </div>

    </div>
  )
}

export default Modal