import React from "react"
import ReactDOM from "react-dom"
import TitlePage from "./titlePage"

it("renders without breaking", ()=>{
  const div = document.createElement("div");
  ReactDOM.render(<TitlePage />, div);
  ReactDOM.unmountComponentAtNode(div);
});
