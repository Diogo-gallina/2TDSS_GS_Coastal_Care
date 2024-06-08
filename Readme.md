# CoastalCare

## Colaboradores:
- Diogo Gallina – RM98605
- Pedro Archila – RM550450
- Pedro Couto - RM98402
- Rafael Kanfler - RM99791
- João Dubas - RM76153

## Sobre o Aplicativo

No âmbito das tecnologias para monitoramento e conservação marinha, estamos desenvolvendo uma solução inovadora que visa engajar a comunidade e utilizar inteligência artificial para promover a limpeza e a preservação das praias. O projeto consiste em um aplicativo que integra voluntários e cidadãos interessados em reportar a poluição marinha através de fotografias. Esta abordagem colaborativa não apenas facilita o monitoramento das condições das praias, mas também estimula a participação ativa na conservação do meio ambiente.

Nossa solução contempla dois tipos de usuários: voluntários que se dispõem a participar de eventos de limpeza das praias e cidadãos que registram a poluição através de fotos. Essas imagens são avaliadas por um modelo de inteligência artificial que classifica e compara as praias com base nos níveis de poluição. A tecnologia utilizada permite identificar e categorizar os tipos de lixo, como plásticos, óleo, plantas marinhas e vida marinha em risco, além de avaliar a gravidade da situação em níveis alto, médio e baixo.

Ao coletar e analisar dados fotográficos, o aplicativo oferece aos usuários informações precisas sobre as praias mais próximas que necessitam de atenção. Através dessa funcionalidade, pretendemos organizar eventos de limpeza, reunindo voluntários para ações coordenadas e eficazes. A integração de dados de localização e classificação permite que as ações sejam direcionadas de forma estratégica, garantindo maior impacto e eficiência na remoção de resíduos.

Além disso, o aplicativo visa fomentar uma rede de colaboração e conscientização ambiental. Ao proporcionar uma plataforma onde as pessoas podem contribuir ativamente para a redução da poluição marinha, estamos criando um movimento de preservação que transcende o uso da tecnologia. A combinação de monitoramento preciso e mobilização comunitária torna nossa solução uma ferramenta poderosa para enfrentar os desafios da poluição marinha e promover a sustentabilidade dos ecossistemas costeiros.

### Video Pitch - Link
- https://www.youtube.com/watch?v=jobwEEUnBkk

## Diagrama Entidade Relacionamento (DER)
![img.png](doc-images/DER.png)

## Diagrama de classes
![DER.png](doc-images/class_diagram.svg)
n

## Rotas
| **Recurso**   | **Rota**                                       | **Método** | **Descrição**                                                       |
|---------------|------------------------------------------------|------------|---------------------------------------------------------------------|
| User          | /users                                         | POST       | Cria um usuário                                                     |
| User          | /users                                         | GET        | Busca todos os usuários                                             |
| User          | /users/:user_id                                | GET        | Busca usuário pelo ID                                               |
| User          | /users/by-name                                 | GET        | Busca os usuários por parte do nome                                 |
| User          | /users/by-email                                | GET        | Busca os usuários por parte do email                                |
| User          | /users/by-type                                 | GET        | Busca usuários pelo tipo                                            |
| User          | /users/by-type-count                           | GET        | Agrupa por tipo de usuário                                          |
| User          | /users/:user_id                                | PUT        | Atualiza um usuário                                                 |
| User          | /users/:user_id                                | DELETE     | Deleta um usuário                                                   |
| Beach         | /beaches                                       | POST       | Cria uma praia                                                      |
| Beach         | /beaches                                       | GET        | Busca todas as praias                                               |
| Beach         | /beaches/by-name                               | GET        | Busca todas por uma parte do nome                                   |
| Beach         | /beaches/by-pollution-level                    | GET        | Busca todas por nível de poluição                                   |
| Beach         | /beaches/by-pollution-level-count              | GET        | Agrupa por nível de poluição                                        |
| Beach         | /beaches/:beach_id                             | GET        | Busca praia pelo ID                                                 |
| Beach         | /beaches/:beach_id                             | PUT        | Atualiza uma praia                                                  |
| Beach         | /beaches/:beach_id                             | DELETE     | Deleta uma praia                                                    |
| Event         | /events/                                       | POST       | Cria um evento                                                      |
| Event         | /events                                        | GET        | Busca todos os eventos                                              |
| Event         | /events/:event_id                              | GET        | Busca evento pelo ID                                                |
| Event         | /events/by-name                                | GET        | Busca todos os eventos por pate do nome                             |
| Event         | /events/by-status                              | GET        | Busca todos os eventos por status                                   |
| Event         | /events/by-status-count                        | GET        | Agrupa por status                                                   |
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
| Photo         | /photos/by-classification-count                | GET        | Agrupa por classificação da foto                                    |
| Photo         | /photos/:photo_id                              | PUT        | Atualiza uma foto                                                   |
| Photo         | /photos/:photo_id                              | DELETE     | Deleta uma foto pelo id                                             |

