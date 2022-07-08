import React, { useEffect, useState } from 'react'
import "./bugs.css"
import Modal from '../Modal/Modal';
import axios from 'axios';

const BugList = ({ id }) => {
    const [state, Setstate] = useState(false);
    const [bugs, setBugs] = useState([ ]);
    const [buginfo, setbuginfo] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8082/projects/${id}`).then((response) => {
          setBugs(response.data.buglist)
          console.log(response.data.buglist);
    
        })
      }, [])
    

    useEffect(() => {
        bugs.forEach((bugid) => {
                axios.get(`http://localhost:8083/bugs/${bugid}`).then((response) => {
                    setbuginfo(response.data);
                    console.log(response)
            })
        })
    },[buginfo])

    return (
        <div className='buglist'>
            {
                state && (
                    <Modal Setstate={Setstate} id={id} />
                )
            }
            <div className='addbug'>
                <h1>Bugs</h1>
                <button onClick={() => { Setstate(true) }}> + Add Bug </button>
            </div>

            <div className='list'>

                <table>
                    <tr id='one'>
                        <th>Name</th>
                        <th>Priority</th>
                        <th>Status</th>
                        <th>Added At</th>
                        <th>Actions</th>
                    </tr>
                    {
                        buginfo.map((bug) => {
                            return (
                                <>
                                    <tr>
                                        <td> {bug.name} </td>
                                        <td> <button id='pr'> LOW </button> </td>
                                        <td> <button id='st'> OPEN </button> </td>
                                        <td> 26/06/22 </td>
                                        <td><button> Edit </button> <button>X</button> </td>
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