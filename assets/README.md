Guia de testes
==============

Para efetuar os testes será necessário o uso do Postman para envio das chamadas GET/PUT para os microserviços

Substitua `<SEU-HOST>` pelo IP do seu host, ou utilize localhost caso esteja fazendo testes locais.

Endpoints
---------

1. Criar vários filmes em lote

```
http://<SEU-HOST>:8081/api/moviesvc/v1/movieservice/create/batch
```
