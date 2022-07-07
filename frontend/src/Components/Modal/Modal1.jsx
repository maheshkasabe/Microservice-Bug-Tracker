import axios from 'axios';
import React, { useState } from 'react'
import "./modal.css"

const Modal1 = ({Setbtnstate }) => {
    const [projectname, setProjectname] = useState("");
    const user =  localStorage.getItem("username");

    const newproject= () => {
        axios.post("http://localhost:8082/projects/", {
            name: projectname,
            creator : user
        })
    }
    return (
        <div className='modal'>
            <div className='modal-bug'>

                <div className='project'>
                <p>ADD A NEW PROJECT </p> <button id='projectbtn' onClick={() => {Setbtnstate(false)}}>x</button>
                </div>
                
                <input type="text" placeholder='Project Name' onChange={(e) => {setProjectname(e.target.value)}}/>
                <input type="text" placeholder='Select Members' />
                <button onClick={newproject}>CREATE A NEW PROJECT</button>
            </div>
        </div>
    )
}

export default Modal1