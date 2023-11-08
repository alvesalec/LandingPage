import React from "react";
import "./style.css";
import LogoTodosTec from "../../Assets/logoTodos.png";

function TelaObjetivo() {
  return (
    <body id="objetivo">
      <div id="texto">
        <p id="textoOb">
          <h1 id="titulo">Nosso Objetivo</h1>
          Nosso objetivo é um: mitigar as diferenças em relação a comunidade
          LGBTQIA+ seja de fora ou dentro da mesma. Espalhar a informação e
          experiência da comunidade entre si é uma forma que encontramos para
          diminuir esta desigualdade.
        </p>
      </div>
      <div id="logo">
        <img
          id="logo-tt"
          src={LogoTodosTec}
          alt="Logo TodosTec"
          title="Logo TodosTec"
        />
      </div>
    </body>
  );
}

export default TelaObjetivo;
