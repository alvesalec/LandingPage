import React from "react";
import styles from "./styles.css";
import MudeVetor from "../../Assets/MudeVetorPaginaInicial.svg";
import Header from "../Header";

function TelaInicial() {
  const comunidade = "comunidade";
  return (
    <div id="tela">
      <Header />
      <div id="texto">
        <h1 id="tituloInicio">
          A melhor forma de se comunicar com sua{" "}
          <tag id="comunidade">comunidade!</tag>
        </h1>
      </div>
      <img id="MudeVetor" src={MudeVetor} alt="Borboleta Logo" title="Mude!" />
      <button id="Setinha"></button>
    </div>
  );
}
export default TelaInicial;
