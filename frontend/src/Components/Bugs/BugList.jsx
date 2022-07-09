import React, { useEffect, useState } from 'react'
import "./bugs.css"
import Modal from '../Modal/Modal';
import axios from 'axios';

const BugList = ({ id }) => {
    const [state, Setstate] = useState(false)
    const [bugs, setBugs] = useState([])
    const [buginfo, setbuginfo] = useState([])

    useEffect(() => {
        axios.get(`http://localhost:8082/projects/${id}`).then((response) => {
            setBugs(response.data.buglist)
            console.log(response.data.buglist)
        })

    }, [id])


    useEffect(() => {
        [bugs].map((bugid) => {
            return axios.get(`http://localhost:8083/bugs/${bugid}`).then((response) => {
                setbuginfo(response.data)
                console.log(response.data)
            })
        })
    }, [])

    const deletebug = (id) => {
        axios.delete(`http://localhost:8083/bugs/${id}`).then((response) => {
            console.log(response)
        })
    }

    return (
        <div className='buglist'>
            {
                state && (
                    <Modal Setstate={Setstate} id={id} />
                )
            }
            <div className='addbug'>
                <h1>BugList</h1>
                <button onClick={() => { Setstate(true) }}> + Add Bug </button>
            </div>

            <div className='list'>

                <table>
                    <tr id='one'>
                        <th>Name</th>
                        <th>Priority</th>
                        <th>Status</th>
                        <th>Updated At</th>
                        <th>Actions</th>
                    </tr>
                    {
                        buginfo.map((bug) => {
                            return (
                                <>
                                    <tr key={bug.bugid}>
                                        <td> {bug.name} </td>
                                        <td> <button id='pr'> {bug.priority} </button> </td>
                                        <td> <button id='st'> {bug.status} </button> </td>
                                        <td> {bug.updated_At.substring(0, 10)} </td>
                                        <td><button onClick={() => { deletebug(bug.bugid) }}>X</button> </td>
                                    </tr>

                                </>
                            )
                        })
                    }

                </table>
            </div>

        </div>
    )
}

export default BugList