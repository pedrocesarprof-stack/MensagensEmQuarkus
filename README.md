# Mensagens em Quarkus

API REST simples para cadastro e consulta de mensagens.

## Rodar local

```powershell
.\mvnw.cmd quarkus:dev
```

API: `http://localhost:8080`

## Endpoints

- `POST /mensagens` - cria mensagem
- `GET /mensagens` - lista mensagens
- `GET /mensagens/{id}` - busca por id
- `DELETE /mensagens/{id}` - remove por id

Exemplo de body para `POST /mensagens`:

```json
{
  "remetente": "Pedro",
  "conteudo": "Mensagem de teste"
}
```

## Evidencias de testes (substituir depois)

### Cadastro - `POST /mensagens`
Resultado esperado: mensagem criada com sucesso (status `201`).

![Teste POST criar](docs/images/testes/01-post-criar.png)

### Listagem - `GET /mensagens`
Resultado esperado: retorno da lista de mensagens (status `200`).

![Teste GET listar](docs/images/testes/02-get-listar.png)

### Busca por id - `GET /mensagens/{id}`
Resultado esperado: retorno da mensagem correspondente ao id (status `200`).

![Teste GET por id](docs/images/testes/03-get-por-id.png)

### Delecao - `DELETE /mensagens/{id}`
Resultado esperado: mensagem removida com sucesso (status `200`).

![Teste DELETE - cenario 1](docs/images/testes/04-delete-01.png)
![Teste DELETE - cenario 2](docs/images/testes/04-delete-02.png)
![Teste DELETE - cenario 3](docs/images/testes/04-delete-03.png)
