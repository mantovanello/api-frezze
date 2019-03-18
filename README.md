# Frezze Track Recommendations API v1.0


**EXPLICAÇÃO DA IMPLEMENTAÇÃO:**

Essa API foi desenvolvida utilizando-se de tecnologias da stack apresentada no case. O projeto faz uso principalmente de Spring Boot, Angular, Maven, Git, JPA e JUnit. Foi utilizado, também, o PostgreSQL como banco de dados persistente, e, o Swagger2 para geração de uma documentação básica da API.


**A SOLUÇÃO:**

A aplicação desenvolvida consiste em exibir através de uma interface de usuário um número determinado de recomendações de música que são consultadas com alguns parâmetros fixados através da API pública do Spotify, além de permitir que estes dados sejam ordenados e filtrados de maneira simples e rápida na tela.

O desenvolvimento foi dividido em duas partes, back-end e front-end. O código do back-end encontra-se neste mesmo repositório - https://github.com/mantovanello/api-frezze - enquanto que o front-end encontra-se no repositório https://github.com/mantovanello/frezze.


**ARQUITETURA DA SOLUÇÃO:**

Conforme já mencionado acima, o front-end e o back-end foram totalmente separados durante o desenvolvimento, sendo que:

* O back-end, desenvolvido através de uma arquitetura REST, é responsável por:
    1. Chamar a API pública do Spotify durante sua inicialização para carregar os dados de recomendações de músicas no banco de dados (LoadDatabase.java), que consiste nos seguintes passos:
        - Invocar seu próprio controller para acessar a API do Spotify (FetchSpotifyController.java);
        - Buscar token na API de autorização do Spotify (FetchSpotifyService.getSimpleClientToken());
        - Chamar API de recomendações de músicas utilizando o token previamente gerado (FetchSpotifyService.fetchRecommendations(String token));
        - Salvar dados parseados da resposta JSON do Spotify no banco de dados (TrackRepository.save(Track)).
    2. Processar requisições feitas aos recursos da API - fetch-recommendations e list-recommendations, que consiste em:
        - fetch-recommendations, buscar novamente as informações na API do Spotify. Segue o fluxo similar ao descrito no item 1. Neste caso, por limitação da API, o limite de recomendações é de 100 músicas, e, como os parâmetros estão fixados, a tendência é que a resposta não mude, porém, é possível que um número pequeno de músicas novas seja retornado no lugar de outras anteriormente presentes na resposta. Caso isso aconteça, as músicas novas devem ser salvas no banco e o número de resultados exibidos em tela pode passar de 100. Essa funcionalidade foi exposta como recurso da API também para efeitos de exploração e testes;
        - list-recommendations (TrackRecommendationsController.java/TrackRecommendationsService.listRecommendations()), recupera os dados de recomendações de músicas salvos em banco de dados (TrackRepository.findAll()) e retorna somente as informações que devem ser exibidas em tela (TrackTO(Track)).


**CONSIDERAÇÕES SOBRE O DESENVOLVIMENTO DA APLICAÇÃO:**

1. O back-end baseado em Spring Boot foi desenvolvido utilizando-se de padrões como:
    - Transaction Script (https://martinfowler.com/eaaCatalog/transactionScript.html), que propicia uma maneira simples e intuitiva de organizar o código em camadas, principalmente quando o projeto é de pequeno porte;
    - Repository (https://docs.microsoft.com/en-us/dotnet/standard/microservices-architecture/microservice-ddd-cqrs-patterns/infrastructure-persistence-layer-design), que abstrai a os acessos ao banco de dados e simplifica a implementação de código quando utilização com ORMs;
    - Data Transfer Object (https://martinfowler.com/eaaCatalog/dataTransferObject.html), padrão conhecido que tem sido utilizado no desenvolvimento de serviços web para blindar e filtrar dados que são trafegados de/para o cliente que consome a API.
2. Junto com o projeto do back-end está sendo disponibilizado um Dockerfile para geração de uma imagem Docker;
3. O front-end em Angular foi desenvolvido utilizando-se de componentes baseado na Material Table, que entrega uma maneira simples de exibir os dados em tela  e disponibiliza funcionalidades nativas como ordenação e filtros;


**DISPONIBILIZAÇÃO DA APLICAÇÃO**

* A aplicação desenvolvida foi disponibilizada através do Firebase Hosting na URL **https://frezze-app-poc.firebaseapp.com/** e os recursos da API REST se encontram em: 
    - **https://api-frezze.herokuapp.com/fetch-recommendations**
    - **https://api-frezze.herokuapp.com/list-recommendations**
 
**NOTA: A conta gratuita do Heroku possui algumas limitações, dentre elas, os projetos hospedados neste tipo de conta são naturalmente colocados em modo de dormência quando não utilizados por um certo período. Portanto, ao utilizar a aplicação em Angular pela primeira vez depois de um certo tempo, pode ocorrer um atraso na resposta da API e, por consequência, uma demora na exibição dos dados. Uma vez que seja feita a primeira requisição à API, as seguintes requisições deverão funcionar normalmente.**


**DOCUMENTAÇÃO**

Por fim, uma documentação básica da API foi gerada utilizando o Swagger2 e está disponibilizada no link abaixo:

Swagger2 Frezze Track Recommendations API Documentation:
*  https://api-frezze.herokuapp.com/swagger-ui.html


**CONTATO**

Quaisquer problemas ou dúvidas, por favor, entre em contato através do e-mail felipe.mantovanello@gmail.com.

>  “Always walk through life as if you have something new to learn, and you will.” ― Vernon Howard 




