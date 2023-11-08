import React from "react";
import "./styles.css";
import LogoMude from "../../Assets/mudeLogo.svg";

function Header() {
  return (
    <header>
      <img src={LogoMude} alt="logo" className="img-header" />
      <button className="headerButton">Sobre nós</button>
      <button className="headerButton">Nosso objetivo</button>
      <button className="headerButton">Conheça o Mude</button>
      <button className="headerButton">Nossas Versões</button>
      <button className="headerButton">Avalie o app</button>
      <button className="headerButton">Contatos</button>
      <button id="engrenagem" />
      <button id="user" />
    </header>
  );
}

export default Header;
