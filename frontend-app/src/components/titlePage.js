import React, {Component} from "react";

import logo from "../res/discover-logo-heart.png"
import "./titlePage.css"

class TitlePage extends Component {
  constructor(props){
    super(props);

    this.state = {isLoading: true};
  }

  componentDidMount(){
    fetch("http://localhost:8080/users/mcnichol")
    .then((response)=>{
      return response.json();
    }).then((response) =>{
      this.setState({name: response.name, role: response.role});
    });
    this.setState({isLoading: false});
  }

  render() {
    return this.state.isLoading ? <div>Loading...</div> : ( <div className="title-page">
        <img id="discover-logo" src={logo} alt="discover-logo"/>
        <p>Welcome to <span className="text-title">Code Orange</span> <span className="highlight">{this.state.name}</span>! Have fun <span className="highlight">{this.state.role}</span>ing</p>
      </div>
    );
  }
}

export default TitlePage;
