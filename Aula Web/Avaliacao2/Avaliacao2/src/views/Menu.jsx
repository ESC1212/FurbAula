export function Menu({ paginaAtual, onNavegar }) {
  return (
    <nav className="menu-horizontal">
      <ul>
        <li>
          <button
            className={paginaAtual === 'HOME' ? 'ativo' : ''}
            onClick={() => onNavegar('HOME')}
          >
            HOME
          </button>
        </li>
        <li>
          <button
            className={paginaAtual === 'FUNCIONARIOS' ? 'ativo' : ''}
            onClick={() => onNavegar('FUNCIONARIOS')}
          >
            FUNCIONÁRIOS
          </button>
        </li>
      </ul>
    </nav>
  );
}