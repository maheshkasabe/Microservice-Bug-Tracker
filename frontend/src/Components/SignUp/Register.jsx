import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import "./signin.css"


const Register = ({ setState }) => {
    const navigate = useNavigate("")

    const [Email, setRegisterEmail] = useState("")
    const [Password, setRegisterPassword] = useState("")

    const register = () => {
        axios.post("http://localhost:9191/users/register/", {
            username: Email,
            password: Password
        }).then((response) =>{
            console.log(response);
        })
    }

    return (
        <div className='signin'>
            <div className='main-div'>
                <h3>Register with Bug Tracker </h3>
            </div>


            <div className='form-div'>
                <input placeholder='Email' onChange={(event) => {
                    setRegisterEmail(event.target.value)
                }} />

                <input placeholder='Password' onChange={(event) => {
                    setRegisterPassword(event.target.value)
                }} />

                <button onClick={register}>
                    Sign In With Email
                </button>
                <p> Already have an account ? <a href='/login'> login here </a> </p>

            </div>

        </div>
    )
}

export default Register