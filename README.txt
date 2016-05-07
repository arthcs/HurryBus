#HurryBus
HurryBus é um projeto que se originou em sala de aula como um projeto para a cadeira de Estágio do curso de Ciência da Computação.

No projeto existem duas classes que são usadas como modelo de objetos de Evento e de Usuário, essas classes se encontram no pacote “modelo”. Existe um pacote chamado de “dao” o qual contém o pacote “banco” responsável por manter a classe que faz a conexão com o banco de dados. Ainda dentro do pacote “dao” existem as classes “EventoDao” e “UsuarioDao”, nessas classes contém todos os métodos para manipulação do bando de dados.

Foram criadas duas tabelas no banco de dados, uma para guardar as informações do usuário e outra para guardar os dados de cada evento criado pelo usuário.

Foi implementado nas classes “EventoDao” e “UsuarioDao” métodos para tratarem objetos do tipo JSON e Strings do tipo JSON, podendo com elas executar operações no banco de dados

Foi criado uma tela JSP de teste, a tela de teste pode direcionar para outras seis telas em JSP cada uma delas recebem dados por formulários e criando uma String JSON para fazer a comunicação com as classes que manipulam o banco de dados
Criado as classes UsuarioHendler e EventoHendler, porem ainda com problemas no metodo que recebe uma String JSON pelo metodo POST para fazer a persistência.
