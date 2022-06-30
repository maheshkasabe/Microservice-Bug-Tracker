import './App.css';
import BugList from './Components/Bugs/BugList';
import Bugs from './Components/Bugs/Bugs';
import Header from './Components/Project/Header';
import Table from './Components/Project/Table';
import { BrowserRouter as Router , Route, Routes  } from "react-router-dom"
import Modal from './Components/Modal/Modal';
import Signup from './Components/SignUp/Signup';
import Signin from './Components/SignUp/Signin';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>

          <Route path='/' element={<> <Signup /> </>} />
          <Route path='/login' element={<> <Signin /> </>} />
          <Route path='/home' element={<> <Header/> <Table />  </> } />
          <Route path='/bug' element={<> <Header/> <Bugs /> <BugList /> </> } />

        </Routes>
      </Router>
    </div>
  );
}

export default App;
