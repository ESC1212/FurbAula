export function Funcionarios({ funcionarios }) {
  return (
    <section>
      <h2 style={{ textAlign: 'center' }}>Funcionários</h2>
      <div className="cards-container">
        {funcionarios.map((func) => (
          <div className="card" key={func.id}>
            <div className="card-foto">
              <img src={func.foto} alt={func.nome} />
            </div>
            <div className="card-nome">{func.nome}</div>
            <div className="card-prop1">{func.subobjeto.propriedade1}</div>
            <div className="card-prop2">{func.subobjeto.propriedade2}</div>
            <div className="card-email">
              <a href={`mailto:${func.email}`}>{func.email}</a>
            </div>
          </div>
        ))}
      </div>
    </section>
  );
}