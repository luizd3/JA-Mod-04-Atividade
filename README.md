## Curso Java Avançado - Mentorama

### Atividade do módulo 4

Criar API de filmes utilizando um padrão de camadas semelhante ao que vimos nessa aula. 
- Cada filme deve possuir os seguintes campos:
  - Id, Nome, Nome do Diretor, Ano, Nota (1-5)
- Deve possuir as seguintes regras de negócio:
  - Id do filme deve ser único;
  - A nota do filme deve ser um inteiro entre 1 e 5, não sendo aceitas notas diferentes; 
  - O conjunto de Nome, Ano e Diretor deve ser único para evitar o cadastro de filmes duplicados. 
- Lembre-se de separar as responsabilidades das camadas conforme vimos durante esse módulo. 
- Evite depender diretamente de implementações, dependa de abstrações. 
- Utilize interfaces, para diminuir o acoplamento. 
- Utilize injeção de dependências (do próprio Spring).