const proxy = [
    {
      context: '/product',
      target: 'http://localhost:8086',
    //   pathRewrite: {'^/product' : ''}
    }
  ];
  module.exports = proxy;
//   context: 'O contexto que deve ser requisitado para tratar o proxy/redirecionamento da requisição'
//   target: 'endpoint ao qual você quer que seja feito o proxy/redirecionamento'
//   pathRewrite: 'Objeto opcional em que você escreve uma expressão regular como atributo e o que deve substituir o resultado da expressão para reescrever a url resultado do proxy/redirecionamento'
//   Exemplos:
//   Sem pathRewrite
//   http://localhost:4200/api/user => http://localhost:8080/api/user
//   Com pathRewrite: { '^/api': '' }
//   http://localhost:4200/api/user => http://localhost:8080/user
//   Com pathRewrite: { '^/api': '/bacon' }
//   http://localhost:4200/api/user => http://localhost:8080/bacon/user  