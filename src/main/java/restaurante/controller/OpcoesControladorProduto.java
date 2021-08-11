package restaurante.controller;

import restaurante.model.produto.Produto;

import java.util.ArrayList;

public interface OpcoesControladorProduto {

    public boolean adicionarProduto(Produto produto) throws Exception;
    public boolean alterarDadosProduto(int codigo, double valor) throws Exception;
    public ArrayList<Produto> listarProdutos() throws Exception;
    public boolean deletarProduto(int codigo) throws Exception;
    public Produto buscarProdutoPorCodigo(int codigo) throws Exception;

}
