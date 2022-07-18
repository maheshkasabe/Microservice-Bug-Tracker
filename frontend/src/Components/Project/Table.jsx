import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import App from '../../App';
import Modal1 from '../Modal/Modal1';
import "./table.css"

const Table = ({setID}) => {
    const navigate = useNavigate();
    const [btnstate, Setbtnstate] = useState(false);
    const [Projects, setProjects] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:9191/projects/").then((response) => {
            setProjects(response.data)
        })
    }, [])

    const deleteproject = (id) => {
        axios.delete(`http://localhost:9191/projects/${id}`, {
            headers: {
                Authorization: "token"
            }
        }).then((response) => {
            console.log(response);
        })
    }

    const redirect = (id) => {
        setID(id);
        navigate(`/bug/${id}`);
    }


    return (
        <div className='main'>
            <div className='add-btn'>
                <button onClick={() => { Setbtnstate(true) }}> + Add Project </button>
            </div>

            {
                btnstate && (
                    <Modal1 Setbtnstate={Setbtnstate} />
                )
            }

            <div className='table'>
                <table>
                    <tr id='one'>
                        <th>Name</th>
                        <th>Bugs</th>
                        <th>Assign</th>
                        <th>Admin</th>
                        <th>Added On</th>
                        <th>Actions</th>
                    </tr>

                    {
                        Projects.map((project) => {
                            return (
                                <>
                                    <tr>
                                        <td onClick={() =>  redirect(project.id) } >{project.name} </td>
                                        {
                                            project.buglist && project.buglist.length ? (
                                                <td> {project.buglist.length}</td>
                                            ) : <td>0</td>
                                        }
                                        {
                                            project.members && project.members.length ? (
                                                <td> {project.members.length}</td>
                                            ) : <td>0</td>
                                        }
                                        <td> {project.creator} </td>
                                        <td> {project.timestamp.substring(0, 10)} </td>
                                        <td><button onClick={() => { deleteproject(project.id) }}>X</button> </td>
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

export default Table