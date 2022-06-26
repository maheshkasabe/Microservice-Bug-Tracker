import React from 'react'
import "./header.css"
import logo from "../logo512.png"

const Header = () => {
  return (
    <div className='header'>
        
        <div className='main-header'>

        <img src={logo} alt='/' /> <p> Bug Tracker</p>
        </div>

        <div className='btns'>
            <p>Admin</p>
            <button>LogIn</button>
        </div>
    </div>
  )
}

export default Header