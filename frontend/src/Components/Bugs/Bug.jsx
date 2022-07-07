import React from 'react'
import BugList from './BugList'
import Bugs from './Bugs'

const Bug = () => {
  return (
    <div>
        <Bugs id={10}/>
        <BugList id={10} />
    </div>
  )
}

export default Bug