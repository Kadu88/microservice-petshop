import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';
import { RestService } from '../rest.service';


const PATH = 'product';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private rest: RestService) { }

  listar(): Observable<any> {
    return this.rest.get(PATH + '/get-all-product');
  }

  count(): Observable<any> {
    return this.rest.get(PATH + '/count');
  }

  salvar(product: Produto): Observable<any> {
    console.log('produto-service' + product);
    return this.rest.post(PATH + '/add-product', product);
  }

  deletar(produto: Produto): Observable<any> {
    return this.rest.delete(PATH, produto.ididProduto);
  }
}
