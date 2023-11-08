import {
    React,
    useRef
} from "react";
import "./styles.css";
import LogoMude from "../../Assets/mudeLogo.svg";
import {redirect} from "react-router-dom";

function Header() {
    const about = useRef(null)

  return (
    <header>
      <img src={LogoMude} alt="logo" className="img-header" />
      <button className="headerButton" onClick={() => {
          document.querySelector("#sobre").scrollIntoView({ behavior: 'smooth' })
      }
      }>Sobre nós</button>
      <button className="headerButton">Nosso objetivo</button>
      <button className="headerButton">Conheça o Mude</button>
      <button className="headerButton">Nossas Versões</button>
      <button className="headerButton">Avalie o app</button>
      <button className="headerButton">Contatos</button>
        <a href="http://localhost:8080/ServletMudeUser_war_exploded/"><button id="engrenagem"></button></a>
      <a href="http://localhost:8080/ServletMudeUser_war_exploded/"><button id="user"></button></a>
    </header>
  );
}

export default Header;
