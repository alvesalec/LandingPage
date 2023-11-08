import React from "react";
import styles from "./styles.css";
import imagem from "../../Assets/imagem.svg";

function TelaInicial() {
  return (
    <body id="sobre">
      <div id="containerS">
        <img
          id="img-grupo"
          src={imagem}
          alt="Imagem do grupo"
          title="Equipe TodosTec"
        />
        <p id="textoSobre">
          <h1 id="tituloSobre">Sobre nós</h1>
          A TodosTec é uma empresa
          <br /> fundada em Maio de 2023, com o<br /> intuito de ajudar a
          comunidade
          <br /> LGBT+ a se encontrar, visando unir
          <br /> a comunidade e fazer com que
          <br />
          sejam mais reconhecidos em <br />
          sociedade.
        </p>
      </div>
    </body>
  );
}

export default TelaInicial;
