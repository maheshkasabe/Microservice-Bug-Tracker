import './App.css';
import Bug from './Components/Bugs/Bug';
import Header from './Components/Project/Header';
import Table from './Components/Project/Table';
import { BrowserRouter as Router , Route, Routes  } from "react-router-dom"
import Signup from './Components/SignUp/Signup';
import Signin from './Components/SignUp/Signin';
import { useState } from 'react';

function App() {
  const [ID, setID] = useState();

  return (
    <div className="App">
      <Router>
        <Routes>

          <Route path='/' element={<> <Signup /> </>} />
          <Route path='/login' element={<> <Signin /> </>} />
          <Route path='/home' element={<> <Header/> <Table setID={setID} />  </> } />
          <Route path={`/bug/${ID}`} element={<> <Header/> <Bug id={ID} /> </> } />

        </Routes>
      </Router>
    </div>
  );
}

export default App;
