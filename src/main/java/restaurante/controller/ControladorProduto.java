package restaurante.controller;

import restaurante.dao.ProdutoDAO;
import restaurante.model.produto.*;

import java.util.ArrayList;

public class ControladorProduto extends Controlador implements OpcoesControladorProduto {

    private ProdutoDAO produtoDAO;

    public ControladorProduto(ProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    public boolean adicionarProduto(Produto produto) throws Exception {
        return produtoDAO.addProdutos(produto);
    }

    public boolean alterarDadosProduto(int codigo, double valor) throws Exception {

        instanciarAtributos();

        return produtoDAO.alteraValorDoProduto(codigo, valor);

        //DAOProduto.alterarDadosProduto(cod, valor);
        //BDProduto.alteraValorDoProduto(cod, valor);
    }

    public ArrayList<Produto> listarProdutos() throws Exception {

        instanciarAtributos();

        return produtoDAO.listProdutosDisponiveis();

        //bdProduto.listarProdutosDisponiveis();
        //BDProduto.listProdutosDisponiveis();
    }

    public boolean deletarProduto(int codigo) throws Exception {

        instanciarAtributos();

        return produtoDAO.deletProduto(codigo);

        //DAOProduto.deletarProduto(cod);
        //BDProduto.deletProduto(cod);
    }


    public Produto buscarProdutoPorCodigo(int codigo) throws Exception {

        instanciarAtributos();

        return produtoDAO.buscarProdutoPorCodigo(codigo);
    }
}
