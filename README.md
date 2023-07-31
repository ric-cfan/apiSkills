# BackEnd Java Spring
### Projeto de skills:

<h4> Um projeto de BackEnd feito em Java Spring.</h4>

<p>Projeto criado segundo os requisitos mencionados por e-mail. Uma API que permite o usuário, criar uma conta, logar e criar uma lista de skills para seu usuário, podendo adicionar ou deletar skills da sua lista e até mesmo atualiza-las.</p>

<p>Também está incluso nesse repositório, o script de criação do banco de dados em SQL.</p>

Ele foi gerado tendo em mente os seguintes frontends para seu uso: 
<br>
https://github.com/ric-cfan/reactSkills
<br>
https://github.com/ric-cfan/nativeSkills/
<br><br>

`Requisitos BackEnd:`

1. Serviço de Login<br>
a. Esse serviço deve receber login e senha e verificar se está igual ao da base<br>
b. A senha deverá ser criptografada<br>
c. Deverá retornar um token para acesso aos demais serviços<br>
2. Serviço de Cadastro
a. Esse serviço receberá o login e senha para ser cadastrado na base de dados<br>
b. A senha deve ser armazenada criptografada<br>
3. Serviço de Listagem de Skills
a. Esse serviço deve receber o id do usuário e retornar todas as skills associadas a
ele e seu respectivo level para preenchimento da interface.<br>
4. Serviço de Associar Skill
a. Esse serviço deve receber o usuário, a skill e o level para persistir na base de
dados<br>
5. Serviço de Atualizar Associação de Skill
a. Esse serviço deve receber o id da associação da skill e o level para atualização
na base de dados<br>
6. Serviço de Excluir Associação de Skill
a. Esse serviço deve receber o id da associação da skill e excluir da base de dados<br>
7. Apenas o Serviço de Login deve ser público. Os demais devem ter segurança JWT e
ser acessados apenas com um token válido
8. O projeto deve conter o Spring Fox para gerar documentação automática dos serviços
pelo swagger.
9. Lembre-se de seguir as boas práticas de API RESTFul
10. O projeto deve ser compartilhado no github num repositório público

`Requisitos Banco de Dados:`

1. Façam a modelagem do banco que comporte os requisitos solicitados, utilizando
constraints corretamente, e salvem os scripts em um arquivo chamado SistemaSkill.sql;
2. O script deverá ser salvo juntamente no repositório para fins de avaliação sobre a
modelagem do banco;
3. Criem as devidas sequences para utilização de ids auto incremento em todas as
tabelas, incluindo qualquer associativa que por ventura seja necessária;
4. Os ids devem usar a sequence criada;
