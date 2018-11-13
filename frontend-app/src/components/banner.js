import React, {Component} from "react";
import bannerLogo from '../res/niu-banner.png';
import './banner.css';

class Banner extends Component {
  render(){
    return (
      <div className="banner" >
        <img src={bannerLogo} alt="niu-banner" />
      </div>
    );
  }
}

export default Banner;
