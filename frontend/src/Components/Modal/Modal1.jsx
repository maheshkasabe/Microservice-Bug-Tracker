import React from 'react'
import "./modal.css"

const Modal1 = ({Setbtnstate }) => {
    return (
        <div className='modal'>
            <div className='modal-bug'>

                <div className='project'>
                <p>ADD A NEW PROJECT </p> <button id='projectbtn' onClick={() => {Setbtnstate(false)}}>x</button>
                </div>
                
                <input type="text" placeholder='Project Name' />
                <input type="text" placeholder='Select Members' />
                <button>CREATE A NEW PROJECT</button>
            </div>
        </div>
    )
}

export default Modal1