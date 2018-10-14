package com.ceobarros.produto.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.ceobarros.produto.model.Produto;
import com.ceobarros.produto.service.ProdutoService;

@Component
public class ProdutoRouter extends BaseRouterBuilder {

	private static final long serialVersionUID = -115276733991443938L;

	@Autowired
	private ProdutoService produtoService;

	@Override
	public void configure() throws Exception {
		rest("/produto").get().description("Serviço para Listar Produtos").id("ms-produto-lista")
				.produces(MediaType.APPLICATION_JSON_VALUE).bindingMode(RestBindingMode.auto)
				.to("direct:listar-produtos").post().description("Serviço de inclusão de novo Produto")
				.produces(MediaType.APPLICATION_JSON_VALUE).consumes(MediaType.APPLICATION_JSON_VALUE)
				.bindingMode(RestBindingMode.auto).type(Produto.class).to("direct:incluir-produto");

		from("direct:listar-produtos").process(processorProduto);
		from("direct:incluir-produto").process(processorProdutoNovo);
	}

	/**
	 * Busca o todos os produtos.
	 */
	Processor processorProduto = new Processor() {
		@Override
		public void process(Exchange exchange) throws Exception {
			exchange.getOut().setBody(produtoService.findAll());
		}
	};

	/**
	 * Busca o todos os produtos.
	 */
	Processor processorProdutoNovo = new Processor() {
		@Override
		public void process(Exchange exchange) throws Exception {
			exchange.getOut().setBody(produtoService.inserirProduto((Produto) exchange.getIn().getBody()));
		}
	};
}
