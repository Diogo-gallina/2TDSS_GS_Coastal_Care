# CoastalCare

## Diagrama Entidade Relacionamento (DER)
![DER.png](doc-images/DER.png)

## Rotas
| **Recurso**   | **Rota**                                       | **Método** | **Descrição**                                                       |
|---------------|------------------------------------------------|------------|---------------------------------------------------------------------|
| User          | /users                                         | POST       | Cria um usuário                                                     |
| User          | /users                                         | GET        | Busca todos os usuários                                             |
| User          | /users/:user_id                                | GET        | Busca usuário pelo ID                                               |
| User          | /users/:user_id                                | PUT        | Atualiza um usuário                                                 |
| User          | /users/:user_id                                | DELETE     | Deleta um usuário                                                   |
| Beach         | /beaches                                       | POST       | Cria uma praia                                                      |
| Beach         | /beaches                                       | GET        | Busca todas as praias                                               |
| Beach         | /beaches/byname                                | GET        | Busca todas por uma parte do nome                                   |
| Beach         | /beaches/:beach_id                             | GET        | Busca praia pelo ID                                                 |
| Beach         | /beaches/:beach_id                             | PUT        | Atualiza uma praia                                                  |
| Beach         | /beaches/:beach_id                             | DELETE     | Deleta uma praia                                                    |
| Event         | /events/                                       | POST       | Cria um evento                                                      |
| Event         | /events                                        | GET        | Busca todos os eventos                                              |
| Event         | /events/:event_id                              | GET        | Busca evento pelo ID                                                |
| Event         | /events/:event_id                              | PUT        | Atualiza um evento                                                  |
| Event         | /events/:event_id                              | DELETE     | Deleta um evento                                                    |
| Participation | /participations                                | POST       | Registra usuário em um evento                                       |
| Participation | /participations/:participationId/users/:userId | PUT        | Confirma participação de usuário em um evento                       |
| Participation | /participations/users/:userId                  | GET        | Busca todas participações de eventos que um usuário está registrado |
| Participation | /participations/:participationId/users/:userId | DELETE     | Deleta participação de um usuário                                   |
| Photo         | /photos                                        | POST       | Adiciona uma foto                                                   |
| Photo         | /photos                                        | GET        | Busca todas as fotos                                                |
| Photo         | /photos/:photo_id                              | GET        | Busca foto pelo ID                                                  |
| Photo         | /photos/:beach_id                              | GET        | Busca todas as fotos de uma praia                                   |
| Photo         | /photos/:user_id                               | GET        | Busca todas as fotos que um usuário adicionou                       |
| Photo         | /photos/:photo_id                              | PUT        | Atualiza uma foto                                                   |
| Photo         | /photos/:photo_id                              | DELETE     | Deleta uma foto pelo id                                             |
|
