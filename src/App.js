import "./App.css";
import TelaObjetivo from "./Components/TelaObjetivo";
import TelaContatos from "./Components/TelaContatos";
import TelaSobre from "./Components/TelaSobre";
import TelaCarrossel from "./Components/TelaCarrossel";
import TelaInicial from "./Components/TelaInicial";
import TelaCode from "./Components/TelaCode";

function App() {
  return (
    <div className="App">
      <TelaInicial />
      <TelaSobre />
      <TelaObjetivo />
      <TelaCarrossel />
      <TelaCode />
      <TelaContatos />
    </div>
  );
}

export default App;
