import React from 'react';
import axios from 'axios';


class Employe extends React.Component{

    state  = { employe : []};

    componentDidMount() {
        axios.get("http://localhost:8080/employeList")
            .then(res => {
                const employe = res.data;
                this.setState({employe})
            })
    }

    render(){
        return(
            <table className="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Addresse</th>
                    <th scope="col">Type d'employe</th>
                    <th scope="col">Moyen de payement</th>
                    <th scope="col">Dâte de  payement</th>

                </tr>
                </thead>
                <tbody>
                {this.state.employe.map((element,key) => {
                    return <tr>
                        <td>{key+1}</td>
                        <td>{element.name}</td>
                        <td>{element.address}</td>
                        <td>{element.type}</td>
                        <td>{element.method}</td>
                        <td>{element.schedule}</td>

                    </tr>
                })}


                </tbody>
            </table>
        )
    }


}

export default Employe;