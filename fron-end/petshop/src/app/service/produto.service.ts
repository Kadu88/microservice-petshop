import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';
import { RestService } from '../rest.service';


const PATH = 'produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private rest: RestService) { }

  listar(): Observable<any> {
    return this.rest.get(PATH);
  }

  count(): Observable<any> {
    return this.rest.get(PATH + '/count');
  }

  salvar(produto: Produto): Observable<any> {
    return this.rest.post(PATH, produto);
  }

  deletar(produto: Produto): Observable<any> {
    return this.rest.delete(PATH, produto.ididProduto);
  }
}
