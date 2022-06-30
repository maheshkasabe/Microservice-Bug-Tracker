import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Modal1 from '../Modal/Modal1';
import "./table.css"

const Table = () => {
    const navigate = useNavigate();
    const [btnstate, Setbtnstate] = useState(false);

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

                    <tr>
                        <td   > <a href='/bug'>Oops </a> </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>

                    <tr>
                        <td> Oops </td>
                        <td> 1 </td>
                        <td> 2 </td>
                        <td> Admin </td>
                        <td> 26/06/22 </td>
                        <td><button> Edit </button> <button>X</button> </td>
                    </tr>


                </table>
            </div>
        </div>
    )
}

export default Table