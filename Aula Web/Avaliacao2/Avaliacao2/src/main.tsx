import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './App.css';
import { useAppController } from './controllers/AppController';
import { Header } from './views/Header';
import { Menu } from './views/Menu';
import { Home } from './views/home';
import { Funcionarios } from './views/Funcionarios';
import { Footer } from './views/Footer';

function App() {
  const { paginaAtual, navegarPara, funcionarios, usuarioLogado } = useAppController();

  return (
    <div className="app-wrapper">
      <Header usuarioLogado={usuarioLogado} onLogoClick={navegarPara} />
      <Menu paginaAtual={paginaAtual} onNavegar={navegarPara} />
      
      <main>
        {paginaAtual === 'HOME' ? (
          <Home />
        ) : (
          <Funcionarios funcionarios={funcionarios} />
        )}
      </main>

      <Footer />
    </div>
  );
}

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
  </StrictMode>,
);