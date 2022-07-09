import React from 'react'
import BugList from './BugList'
import Bugs from './Bugs'

const Bug = () => {
  return (
    <div>
        <Bugs id={1} />
        <BugList id={1} />
    </div>
  )
}

export default Bug