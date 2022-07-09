import React from 'react'
import "./header.css"
import logo from "../../logo512.png"
import { useNavigate } from 'react-router-dom'

const Header = () => {

  const navigate = useNavigate();

  const logout= () => {
    localStorage.setItem("username", "")
    navigate("/login")
  }
  return (
    <div className='header'>
        
        <div className='main-header'>

        <img src={logo} alt='/' /> <p> Bug Tracker</p>
        </div>

        <div className='btns'>
            <p>{localStorage.getItem("username")}</p>
            <button onClick={logout}>Logout</button>
        </div>
    </div>
  )
}

export default Header