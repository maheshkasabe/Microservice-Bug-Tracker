import axios from 'axios'
import React, { useEffect, useState } from 'react'
import "./usermodal.css"

const AddMembers = ({Setstate,id}) => {
    const [list, setList] = useState([]);
    const [members, setMembers] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:9191/users/list").then((response) => {
            setList(response.data);
        })
    }, [])

    const addmembers = () => {
        axios.put(`http://localhost:9191/projects/addmembers/${id}`, {
          members: members
        }).then((response) => {
          console.log(response);
        })
      }

      const handler= (username) => {
        setMembers([...members,username]);
        addmembers();
      }

  return (
    <div className='userlist'>
        {
            list.map((user) => {
                return(
                <div className='items'>
                <p>{user.username} </p>
                <button onClick={() => {handler(user.username)}}> Add </button>
                </div>
                )
            })
        }

    </div>
  )
}

export default AddMembers