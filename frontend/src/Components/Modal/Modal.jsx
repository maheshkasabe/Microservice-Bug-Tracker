import React from 'react'
import "./modal.css"

const Modal = ({Setstate}) => {
  return (
    <div className='modal'>
        
        <div className='modal-bug'>
        <div className='project'>
                <p>Add a new bug </p> <button onClick={() => {Setstate(false)}}>x</button>
                </div>
        <input type="text" placeholder='Title' />
        <button>CREATE A NEW BUG </button>
        </div>
        
    </div>
  )
}

export default Modal