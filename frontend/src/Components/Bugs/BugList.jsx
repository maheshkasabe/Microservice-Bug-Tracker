import React, { useState } from 'react'
import "./bugs.css"
import Modal from '../Modal/Modal';

const BugList = () => {
    const [state, Setstate] = useState(false);

    return (
        <div className='buglist'>
            {
                state && (
                    <Modal Setstate={Setstate} />
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

                    <tr>
                        <td> Oops </td>
                        <td> <button id='pr'> LOW </button> </td>
                        <td> <button id='st'> OPEN </button> </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>
                </table>
            </div>

        </div>
    )
}

export default BugList