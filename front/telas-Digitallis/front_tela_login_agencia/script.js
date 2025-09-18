document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    const messageElement = document.getElementById('message');

    // Endpoint do seu backend. Ajuste se o URL for diferente.
    const API_ENDPOINT = 'http://localhost:8080/api/login/agencia';

    loginForm.addEventListener('submit', async (event) => {
        event.preventDefault(); // Impede o envio padrão do formulário

        const agencia = document.getElementById('agencia').value;
        const senha = document.getElementById('senha').value;

        // Limpa mensagens anteriores
        messageElement.textContent = '';
        messageElement.className = 'message';

        // Validação no cliente antes de enviar
        if (!agencia) {
            showMessage('O campo Agência é obrigatório.', 'error');
            return;
        }

        if (!senha) {
            showMessage('O campo Senha é obrigatório.', 'error');
            return;
        }

        try {
            const response = await fetch(API_ENDPOINT, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ agencia, senha }),
            });

            if (response.ok) {
                // A resposta do servidor foi 200 OK
                const data = await response.json();
                showMessage('Login bem-sucedido! Redirecionando...', 'success');
                // Em um cenário real, você faria o redirecionamento aqui
                // Exemplo:
                // window.location.href = '/dashboard';
            } else {
                // A resposta foi um erro (ex: 401, 404, 500)
                const errorData = await response.json();
                showMessage(errorData.message || 'Erro ao fazer login. Tente novamente.', 'error');
            }
        } catch (error) {
            // Erro de rede ou outro problema na requisição
            console.error('Erro na requisição:', error);
            showMessage('Não foi possível conectar ao servidor. Verifique sua conexão.', 'error');
        }
    });

    function showMessage(msg, type) {
        messageElement.textContent = msg;
        messageElement.className = `message ${type}`;
        messageElement.style.display = 'block';
    }
});