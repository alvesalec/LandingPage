import React from "react";
import styles from "./styles.css";
import BorboletaConheca from "../../Assets/BorboletaConheça.svg";

function TelaConheca() {
  return (
    <div id="div">
      <img
        id="BorboletaConheca"
        src={BorboletaConheca}
        alt="borboleta"
        title="borboleta"
      ></img>
      <h1>Conheça o Mude!</h1>
      <h2>
        O “Mude!” é um aplicativo focado para a comunidade LGBT+ que oferece:
        <ul>
          <li>Chats para interação entre usuários;</li>
          <li>Indicações de mídia com representatividade;</li>
          <li>Posts para compartilhar pensamentos entre a comunidade.</li>
        </ul>
      </h2>
    </div>
  );
}
export default TelaConheca;
