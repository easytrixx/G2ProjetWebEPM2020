import React from 'react';
import logo from './logo.svg';
import './App.css';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";


import Employe from './component/Employe';
import AddEmploye from "./component/AddEmploye";

function App() {
    return (
        <Router>
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href="#">Espace Membre</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item active">
                                <Link to="/Employe" className="nav-link">Personnel <span className="sr-only">(current)</span></Link>
                            </li>
                            <li className="nav-item">
                                <Link to="/AddEmploye" className="nav-link" >Ajouter un membre</Link>
                            </li>


                        </ul>
                    </div>
                </nav>
                <Switch>
                    <Route path="/Employe">
                        <Employe />


                    </Route>

                    <Route path="/AddEmploye">
                        <AddEmploye />

                    </Route>
                </Switch>



            </div>
        </Router>
    );
}

export default App;