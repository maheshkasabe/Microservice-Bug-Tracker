import './App.css';
import BugList from './Components/BugList';
import Bugs from './Components/Bugs';
import Header from './Components/Header';
import Table from './Components/Table';
import { BrowserRouter as Router , Route, Routes  } from "react-router-dom"
import Modal from './Components/Modal/Modal';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>

          <Route path='/' element={<> <Header/> <Table />  </> } />
          <Route path='/bug' element={<> <Header/> <Bugs /> <BugList /> </> } />

        </Routes>
      </Router>
    </div>
  );
}

export default App;
