document.addEventListener('DOMContentLoaded', verificarAutenticacao);

function verificarAutenticacao() {
    const authInfo = document.getElementById('auth-info');
    if (!authInfo) return;

    const usuario = localStorage.getItem('usuarioLogado');

    if (usuario) {
        authInfo.innerHTML = `
            <span>${usuario}</span>
            <a href="cadastro.html" title="Acessar Cadastro">
                <img src="Miata.jpg" alt="Foto do Usuário">
            </a>
        `;
    } else {
        authInfo.innerHTML = `<span>Usuário não autenticado</span>`;
    }
}

function fazerLogin() {
    const loginInput = document.getElementById('login').value.trim();
    const senhaInput = document.getElementById('senha').value.trim();

    if (loginInput !== "" && senhaInput !== "") {
        localStorage.setItem('usuarioLogado', loginInput);
        window.location.href = 'index.html';
    } else {
        alert("Preencha todos os campos!!");
    }
}

function mudarEstilo() {
    const estilo = document.getElementById('estilo-form').value;
    const form = document.getElementById('cadastro-form');
    
    const labels = form.querySelectorAll('label');
    const inputs = form.querySelectorAll('input[type="text"], input[type="email"], input[type="date"]');

    if (estilo === 'custom') {
        labels.forEach(label => label.style.fontFamily = 'Courier New, Courier, monospace');
        inputs.forEach(input => input.style.backgroundColor = '#d1f2eb');
    } else {
        labels.forEach(label => label.style.fontFamily = '');
        inputs.forEach(input => input.style.backgroundColor = '');
    }
}