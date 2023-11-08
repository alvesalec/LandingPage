import React from "react";
import styles from "./styles.css";
import QRCode from "qrcode.react";

const TelaCode = () => {
  const urlDoForms = "https://forms.office.com/r/yzGy1AYx5x?embed=true";
  const tamanhoQRCode = 350;

  return (
    <div className="qr-code-container">
      <div classname="textosAvalie">
        <h1 id="tituloAvalie">Avalie o Mude!</h1>
        <p id="textinhoAvalie">
          Deseja participar de um sorteio para concorrer a uma camiseta e um
          copo personalizados do Mude? Preencha o formulário ao lado e concorra!
        </p>
      </div>
      <QRCode id="qrcode" value={urlDoForms} size={tamanhoQRCode} />
    </div>
  );
};
export default TelaCode;
