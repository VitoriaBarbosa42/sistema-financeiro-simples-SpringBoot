document.getElementById('form-cadastro').addEventListener('submit', function(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const sobrenome = document.getElementById('sobrenome').value;
    const cpf = document.getElementById('cpf').value;
    const email = document.getElementById('email').value;

    const mensagemDiv = document.getElementById('mensagem');
    mensagemDiv.textContent = '';


    const dados = {
        nome: nome,
        sobrenome: sobrenome,
        cpf: cpf,
        email: email
    };

    fetch('http://localhost:8080/api/usuarios', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(errorData => {
                    const errors = errorData.errors || [errorData.message];
                    throw new Error(errors.join(', '));
                });
            }
            return response.json();
        })
        .then(data => {
            console.log('Usuário cadastrado com sucesso:', data);
            mensagemDiv.textContent = 'Usuário cadastrado com sucesso!';
            mensagemDiv.style.color = 'green';
            document.getElementById('form-cadastro').reset();
        })
        .catch((error) => {
            console.error('Erro ao cadastrar:', error);
            mensagemDiv.textContent = `Erro: ${error.message}`;
            mensagemDiv.style.color = 'red';
        });
});