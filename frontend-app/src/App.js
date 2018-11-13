import React, { Component } from 'react';
import Banner from "./components/banner";
import TitlePage from "./components/titlePage";
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Banner/>
        <TitlePage />
      </div>
    );
  }
}

export default App;
