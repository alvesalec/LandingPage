import { useRef } from "react";
import celular from "../../Assets/img-celular.svg";
import "./styles.css";
import seta from "../../Assets/seta.svg";
import setaEsquerda from "../../Assets/seta_esquerda.svg";

function TelaCarrossel() {
  const carousel = useRef(null);

  // botões para mudar a tela do carrossel quando apertados
  const handleLeftClick = (e) => {
    e.preventDefault();
    console.log(carousel.current.offsetWidth);
    carousel.current.scrollLeft -= carousel.current.offsetWidth;
  };

  const handleRightClick = (e) => {
    e.preventDefault();
    console.log(carousel.current.offsetWidth);
    carousel.current.scrollLeft += carousel.current.offsetWidth;
  };

  return (
    <div className="container">
      <div className="carousel" ref={carousel}>
        {/* classe item são as diferentes telas do carrossel */}
        <div className="item">
          <img src={celular} alt="Imagem celular" title="Imagem celular" />
          <ul class="info">
            {/* classe info mostra as informações dentro do carrossel  */}
            <h1>Na versão 2.0:</h1>
            <li>Sistema de plano premium;</li>
            <li>Benefícios exclusivos;</li>
            <li>Compras diretamente no aplicativo.</li>
          </ul>
          {/* classe buttons chama os botões de esquerda ou direita  */}
          <div className="buttons" id="direita">
            <button onClick={handleRightClick}>
              <img src={seta} alt="Scroll left" />
            </button>
          </div>
        </div>
        <div class="item">
          <div className="buttons" id="esquerda">
            <button onClick={handleLeftClick}>
              <img src={setaEsquerda} alt="Scroll right"></img>
            </button>
          </div>
          <img src={celular} alt="Imagem celular" title="Imagem celular" />
          <ul class="info">
            <h1>Na versão 3.0:</h1>
            <li>Recomendações de livros;</li>
            <li>Leituras no aplicativo;</li>
            <li>Avaliações pelos usuários.</li>
          </ul>
          <div className="buttons" id="direita">
            <button onClick={handleRightClick}>
              <img src={seta} alt="Scroll left" />
            </button>
          </div>
        </div>
        <div class="item">
          <div className="buttons" id="esquerda">
            <button onClick={handleLeftClick}>
              <img src={setaEsquerda} alt="Scroll right"></img>
            </button>
          </div>
          <img src={celular} alt="Imagem celular" title="Imagem celular" />
          <ul class="info">
            <h1>Na versão 4.0:</h1>
            <li>Cadastro de produtos;</li>
            <li>Plataforma de vendas;</li>
            <li>Compra e venda pelo aplicativo.</li>
          </ul>
          <div className="buttons" id="direita">
            <button onClick={handleRightClick}>
              <img src={seta} alt="Scroll left" />
            </button>
          </div>
        </div>
        <div class="item">
          <div className="buttons" id="esquerda">
            <button onClick={handleLeftClick}>
              <img src={setaEsquerda} alt="Scroll right"></img>
            </button>
          </div>
          <img src={celular} alt="Imagem celular" title="Imagem celular" />
          <ul class="info">
            <h1>Na versão 5.0:</h1>
            <li>Modo anônimo;</li>
            <li>Chats em grupo;</li>
            <li>Publicações anônimas.</li>
          </ul>
          <div className="buttons" id="direita">
            <button onClick={handleRightClick}>
              <img src={seta} alt="Scroll left" />
            </button>
          </div>
        </div>
        <div class="item">
          <div className="buttons" id="esquerda">
            <button onClick={handleLeftClick}>
              <img src={setaEsquerda} alt="Scroll right"></img>
            </button>
          </div>
          <img src={celular} alt="Imagem celular" title="Imagem celular" />
          <ul class="info">
            <h1>Na versão 6.0:</h1>
            <li>Cadastro de médicos;</li>
            <li>Chats/Chamadas com médicos;</li>
            <li>Posição geográfica.</li>
          </ul>
        </div>
      </div>
    </div>
  );
}

export default TelaCarrossel;
