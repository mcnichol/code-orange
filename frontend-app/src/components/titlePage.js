import React, {Component} from "react";

import logo from "../res/discover-logo-heart.png"
import "./titlePage.css"

class TitlePage extends Component {
  render() {
    return (
      <div className="title-page">
        <img id="discover-logo" src={logo} alt="discover-logo"/>
        <p>Welcome to <span className="text-title">Code Orange</span> [USER]! Have fun [ROLE]ing</p>
      </div>
    );
  }
}

export default TitlePage;
