import React from "react";
import "./styles.css";
import email from "../../Assets/email.svg";
import insta from "../../Assets/instagram.svg";

function TelaContatos() {
  return (
    <body id="fundo">
      <div id="containerCo">
        <h1 id="entre-contato">Entre em contato!</h1>
        <div id="container2">
          <div class="card">
            <p className="textinho">
              Siga-nos no Instagram e fique por dentro das novidades!
            </p>
            <img
              id="img-insta"
              src={insta}
              alt="logo insta"
              title="Instagram"
            />
            <h1 id="insta">@todostec</h1>
          </div>
          <div id="card1" class="card">
            <p class="textinho">Tem alguma dúvida? Entre em contato!</p>
            <img
              id="img-email"
              src={email}
              alt="simbolo gmail"
              title="G-Mail"
            />
            <a id="email" href="mailto:todos.tec7@gmail.com">
              todos.tec7@gmail.com
            </a>
          </div>
        </div>
      </div>
    </body>
  );
}

export default TelaContatos;
