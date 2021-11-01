# testeesig
Criar um crud de tarefas
 
Para esse teste foi criado um projeto maven que contem as dependencias do BOOTSTRAP, PRIMEFACES e ADMIN LTE com JSF

# Necessidades do projeto
Para se iniciar o projeto necessita apenas ter um banco MYSQL que está no localhost e com o nome de database "crudteste" e com o acesso "root" e senha "". 

Para esse banco eu utilizei o xampp que já vem com o banco configura dessa mesma maneira, apenas criei o database com o nome a cima.

#Regras do projeto
Para rodar o projeto foi-se utilizado o Tomcat v8 e subido na porta do localhost:8080 com o nome "teste-esig". Sendo o primeiro acesso ao index.xhtml sendo por: http://localhost:8080/teste-esig/

Apos o aceso irá retorna a pagina de menu inicial do sistema, como mostra a figura a baixo:

![image](https://user-images.githubusercontent.com/78569602/139676815-600017ff-c3e7-45af-bb24-a4403d61badf.png)

E nessa pagina temos 2 (duas) navegações, a primeira é de cadastro:

![image](https://user-images.githubusercontent.com/78569602/139677031-e1a30f0d-83a5-4e13-8993-9a6a8f505332.png)

Onde temos como voltar para o index ou salvar/criar uma nova tarefa, e apartir dessa navegação de salvar temos algumas regras:

1 - Todo cadastro gera uma tarefa com a situação EMANDAMENTO;
2 - Todo cadastro cadastra a data que a tarefa está sendo criada;
3 - Não é possivel cadastrar uma tarefa com a deadline com data anterior a data de hoje (Não é possivel cadastrar tarefas no passado, já que toda tarefa criada está setada com sua situação EMANDAMENTO);
4 - E por fim todos os campos de cadastro são obrigatorios.

a segunda navegação da pagina index é de busca, e ela tem dois estados, antes de pesquisar:

![image](https://user-images.githubusercontent.com/78569602/139677854-1d47e61b-10ef-4c2d-8fbf-e285e2df9b76.png)

Onde temos como pesquisar a partir de 4 campos (Número, Título, Responsável e Situação) e se todos os campos estiverem vazios/nulos ele me retornará todos as tarefas cadastradas, ou seja, sem filtros:

E depois da pesquisa:

![image](https://user-images.githubusercontent.com/78569602/139678061-2a93a6cb-2053-4828-9505-f53e4bb02f09.png)

Onde temos como concluir tarefas, excluir tarefas ou detalhar tarefas, e apartir dessas funções temos algumas regras:

1 - As 3(três) funcionalidades podem ser selecionadas varias ou apenas 1(uma) tarefa;
2 - Se tentar concluir uma tarefa com situação CONCLUIDA, o sistema irá avisar por meio de mensagem, porém eu posso concluir outras tarefas em grupo se elas estiverem ainda com situação EMANDAMENTO;
3 - As prioridades das tarefas estão sendo colocadas na tabela com as cores padrão de prioridades (verde-baixa, amarelo-média e vermelho-alta);
4 - Para editar qualquer tarefa, basta clicar no nome do título que também é um link que passará como parametro o id da tarefa selecionada e abrira a pagina de cadastro com os dados daquela tarefa, como mostrado abaixo.
![image](https://user-images.githubusercontent.com/78569602/139679344-e7de155c-0317-4cd0-9c2d-d5a9a797c0f5.png)

Para finalizar toda navegação irá gerar um histórico que fica a cima na parte direita como mostrado abaixo, e ao click irá nos retornar a ultima navegação feita.
![image](https://user-images.githubusercontent.com/78569602/139679553-691340ea-8590-47bc-8c3c-a459fee31189.png)


