import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';
import { RestService } from '../rest.service';


URL: 'http://localhost:8086/'
const PATH = 'product';
const URL_PATH = URL + PATH;

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private rest: RestService) { }

  listar(): Observable<any> {
    return this.rest.get(URL_PATH + '/get-all-product');
  }

  count(): Observable<any> {
    return this.rest.get(URL_PATH + '/count');
  }

  salvar(product: Produto): Observable<any> {
    return this.rest.post(URL_PATH + '/add-product', product);
  }

  deletar(produto: Produto): Observable<any> {
    return this.rest.delete(URL_PATH, produto.ididProduto);
  }
}
