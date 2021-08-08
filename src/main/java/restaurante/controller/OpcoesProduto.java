package restaurante.controller;

import restaurante.model.produto.Produto;

public interface OpcoesProduto {

    public Produto escolherProduto();
    public void adicionarProduto(Produto produto) throws Exception;
    public void alterarDadosProduto() throws Exception;
    public void listarProdutos() throws Exception;
    public void deletarProduto() throws Exception;

}
