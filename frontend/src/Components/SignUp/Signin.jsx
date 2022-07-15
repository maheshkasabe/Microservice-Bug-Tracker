import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import "./signin.css"

const Signin = () => {
    const navigate = useNavigate("")

    const [loginEmail, setLoginEmail] = useState("")
    const [loginPass, setLoginPass] = useState("")

    const login = () => {
        axios.get("http://localhost:9191/users/login/", {
            username: loginEmail,
            password: loginPass
        }).then((response) =>{
            console.log(response);
            localStorage.setItem("username", response.config.username);
            console.log(localStorage.getItem("username"))
            navigate("/home")
        })
    }

    return (
        <div className='signin'>
            <div className='main-div'>
                <h3>Sign in to Bug Tracker </h3>
            </div>

            <div className='form-div'>

                        <input placeholder='Email' onChange={(event) => {
                            setLoginEmail(event.target.value)
                        }} />

                        <input placeholder='Password' onChange={(event) => {
                            setLoginPass(event.target.value)
                        }} />

                        <button onClick={login}>
                            Login
                        </button>
            </div>

        </div>
    )
}

export default Signin