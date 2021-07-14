# agenda-api
Sistema Web Service de Agenda de Contatos - Projeto Final Engenharia de Software IFCE


## Projeto Agenda Telefônica

Instituto Federal do Ceará- Campus Fortaleza

Projeto da disciplina de Engenharuia de Software

Professor: César Olavo de Moura Filho

Equipe: Bruno Oliveira, 
        Bruno Wilson,
        Marcus Vinicius,
        Kellory Meneses.



1) Casos de uso


                                                  Caso de uso: Sistema web de Agenda de Contatos

Atores: Usuário

Visão Geral: O usuário realiza o login no sistema de agenda (validação de usuário), após isso é exibido a listagem de contatos que já foram salvos na agenda. Após a listagem dos contatos salvos, o usuário pode realizar o cadastro de um novo contato, a edição de um contato já existente ou apagar um contato que já foi cadastrado.
Dentro do contato, é possível a visualização dos telefones; assim como o cadastro de um novo telefone, edição de telefone e exclusão dentro de um contato já cadastrado.



2) Desenvolva as telas do sistema.

[Web_Agenda_2 (1).pdf](https://github.com/BrunoSnt07/Projeto-Agenda/files/6816566/Web_Agenda_2.1.pdf)

link para as telas no Figma: https://www.figma.com/proto/5m08vL4EPkaEdT9n9abN3l/Web_Agenda_2?node-id=2%3A3&scaling=contain&page-id=0%3A1&starting-point-node-id=2%3A3

[Web_Agenda_2 .pdf](https://github.com/BrunoSnt07/Projeto-Agenda/files/6817373/Web_Agenda_2.1.pdf)


3) UML:

a. Desenvolver os casos de uso do sistema. 

                                                         Caso de uso-Agenda

![Caso de uso](https://user-images.githubusercontent.com/23100493/125636586-a6c7ae36-9772-4265-91d9-68863b826a5b.jpeg)

b. Elaborar diagramas de sequência para os casos de uso mais importantes. Aqui as lifelines e as  respectivas interações devem ser consistentes com os objetos do padrão arquitetural escolhido (MVC, 4- Layer, Transaction Scripts, Domain Model, etc.). No mínimo, os seguintes cenários devem ser  contemplados:  
– Busca de um contato 
– Adição de um novo grupo de contato 

                                                Diagrama de sequência- Adiciona Novo contato

![sequence-diagram_adiciona_novocontato-3](https://user-images.githubusercontent.com/23100493/125648560-adcb4b45-e316-47f7-97d7-60e2eef21b45.jpeg)


                                                          Diagrama de sequência- Busca Contato

![sequence-diagram_Busca_contato-2](https://user-images.githubusercontent.com/23100493/125649315-346240bd-e040-498c-9469-78b9e0ae9cf8.jpeg)


                                                          Diagrama de sequência- Cadastro

![sequence-diagram_cadastro-1](https://user-images.githubusercontent.com/23100493/125648567-28a8dcaf-47c4-4749-a9db-868d73a50f35.jpeg)



c. Elaborar diagramas de atividade. Lembre-se que este tipo de diagrama é importante para entender os  processos de um dado négocio, capturando a interaçao entre atores envolvidos, o fluxo de informaçao (que  pode ser feito à base de papel, por exemplo). Imagine que uma dada empresa ainda usa papel e você é um  ser “invisível”, que apenas observa como os funcionários dessa empresa interagem, geram e modificam  documentos, etc, ao longo da execução de um dado processo. Claro que processos envolvendo computador também podem ser modelados. 
Elabore, no mínimo, os seguintes diagramas de atividades:  
 - listagem de um dado contato 
 - mapa de navegação de telas  
                                                               
                                                         Diagrama de Atividade-Cadastro

![activity-diagram_cadastro-1](https://user-images.githubusercontent.com/23100493/125648629-c17e02fe-4bec-44c0-8463-497eb3732064.jpeg)


                                                         Diagrama de Atividade- Listagem de Contatos
                                                         
![activity-diagram_Listagem_contato-4](https://user-images.githubusercontent.com/23100493/125648633-18fdd805-65e3-4707-9532-bfbe7a881bd7.jpeg)


                                                         Diagrama de Atividade- Login

![activity-diagram_login-2](https://user-images.githubusercontent.com/23100493/125648636-40de6388-41c7-4f7c-92aa-6bacc87226a1.jpeg)


                                                        Diagrama de Atividade- Mapa de navegação


![activity-diagram_mapa_navegacao-3](https://user-images.githubusercontent.com/23100493/125648645-40d80109-8d13-485c-90f6-486a5e9d6bf8.jpeg)




d. Elaborar os diagramas de classe do sistema. Separe as classes em diagramas, de acordo com suas  responsabilidades. O diagrama de classe acima só traz as classes de entidades. Lembre-se que um  aplicativo precisa de várias outras classes para funcionar. 

                                                        Diagrama de Classe- Agenda 

![diagrama de classe](https://user-images.githubusercontent.com/23100493/125637414-0cd55f3c-055d-457f-9209-2623e2230cb3.jpeg)



e. Elaborar os diagramas de estado de um objeto Conta (Account) 

                                                         Diagrama de Estado- Account
                                                         

![behavior-state-machine-diagram_account](https://user-images.githubusercontent.com/23100493/125648724-6565ceed-4ad3-4806-8d2f-0fcda7d94bbb.jpeg)



f. Explicitar a arquitetura escolhida. Nela você deverá explicitar os módulos do sistema, sempre  respeitando o padrão arquitetural escolhido (4-Layer, Transaction Scripts, Domain Model, etc). Use, para  tal, diagramas de componentes e/ou de pacotes.


                                                         Diagrama de Componentes- MVC


![component-diagram-arquitetura_mvc](https://user-images.githubusercontent.com/23100493/125700739-b5b1c726-9b56-448b-82a8-7e44292f8ec0.jpeg)


g. Elaborar os diagramas de implantação (deployment), para especificar em que máquinas (virtuais,  containers, cloud, etc) e recursos os componentes desenvolvidos no item anterior devem ser alocados.


                                                                      Diagrama de Implantação

![Diagrama de implantação](https://user-images.githubusercontent.com/23100493/125639251-755defab-1e12-4b92-80a1-4830371f88a8.jpeg)


4) Design Patterns 
Fazer uso dos seguintes design patterns no seu código: 
• factories (objetos só podem ser criados por meio de factories) 
• observer 


5) Implementar um sistema de acordo com sua modelagem. O sistema deverá ser apresentado ao  professor com pelo menos os casos de uso sugeridos acima - implementados e funcionando - até o mais  tardar o prazo final de entrega do trabalho. Você pode usar frameworks que aceleram a implementação do  seu sistema, desde que devidamente documentado no projeto. 



Ferramentas utilizadas na prototipação do projeto

Para confecção das telas foi utilizado o software web Figma, desenvolvido pela empresa Figma Organization. Para confecção dos Diagramas e casos de uso foi utilizado o softwre
Genmymodel, deenvolvido pela Axellience. Para o desenvolvimento do software Agenda foi feito com um framework Spring Boot, na linguagem Java.

Para organização geral das atribuiçoes da equipe utilizados o software Trello, para acompanhamento das atividades dentro do prazo estipulado com a melhor qualidade possível



                                                                 Organização das atribuições-Trello

![Trello_metodologiaAgil](https://user-images.githubusercontent.com/23100493/125702966-ca4e0749-f240-4e47-bd0f-4d5b670234bb.png)











