export function Header({ usuarioLogado, onLogoClick }) {
  return (
    <header>
      <div className="logo">
        <a href="#home" onClick={(e) => { e.preventDefault(); onLogoClick('HOME'); }}>
          <img src="/esp-logo.png" alt="ESP" />
        </a>
      </div>
      <div className="auth-info">
        {usuarioLogado ? (
          <>
            <span>{usuarioLogado}</span>
            <img src="/Miata.jpg" alt="Foto do Usuário" />
          </>
        ) : (
          <span>Usuário não autenticado</span>
        )}
      </div>
    </header>
  );
}