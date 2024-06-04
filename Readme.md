# CoastalCare

## Diagrama Entidade Relacionamento (DER)
![DER.png](doc-images/DER.png)

## Rotas
| **Recurso** | **Rota**           | **Método** | **Descrição**           |
|-------------|--------------------|------------|-------------------------|
| User        | /users/:user_id    | POST       | Cria um usuário         |
| User        | /users             | GET        | Busca todos os usuários |
| User        | /users/:user_id    | GET        | Busca usuário pelo ID   |
| User        | /users/:user_id    | PUT        | Atualiza um usuário     |
| User        | /users/:user_id    | DELETE     | Deleta um usuário       |
| Beach       | /beaches/:beach_id | POST       | Cria uma praia          |
| Beach       | /beaches           | GET        | Busca todas as praias   |
| Beach       | /beaches/:beach_id | GET        | Busca praia pelo ID     |
| Beach       | /beaches/:beach_id | PUT        | Atualiza uma praia      |
| Beach       | /beaches/:beach_id | DELETE     | Deleta uma praia        |
| Event       | /events/:event_id  | POST       | Cria um evento          |
| Event       | /events            | GET        | Busca todos os eventos  |
| Event       | /events/:event_id  | GET        | Busca evento pelo ID    |
| Event       | /events/:event_id  | PUT        | Atualiza um evento      |
| Event       | /events/:event_id  | DELETE     | Deleta um evento        |
| Photo       | /photo/:photo_id   | POST       | Faz upload de uma foto  |
