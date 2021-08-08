package restaurante.repository;

import restaurante.model.produto.*;
import restaurante.validation.ProdutoNaoEncontradoException;
import java.util.ArrayList;

public class BDProduto {

    private static ArrayList<Produto> array = new ArrayList<Produto>();

    public BDProduto() {
        super();
    }

    public void povoarArrayProdutos() throws Exception {
        adicionarProduto(new Cerveja(1,5, "Skol"));
        adicionarProduto(new Baiao(2,10, "De Dois"));
        adicionarProduto(new Linguica(3,15, "Calabresa"));
        adicionarProduto(new Sorvete(4,20, "Kibom de Morango"));
    }

    public void adicionarProduto(Produto produto) {
        array.add(produto);
    }


    public void deletarProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
        for(Produto produto : array) {
            if(produto.getCodigoProduto() == codigoProduto) {
                array.remove(produto);
                System.out.println("\nProduto deletado!!!\n");
                return;
            }
        }
        throw new ProdutoNaoEncontradoException(codigoProduto);
    }


    public Produto procurarProduto(int codigoProduto) throws ProdutoNaoEncontradoException {
        for(Produto produto : array) {
            if(produto.getCodigoProduto() == codigoProduto) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException(codigoProduto);
    }


    public void alterarDadosProduto(int codigoProduto, double valorProduto) throws ProdutoNaoEncontradoException {
        for(Produto produto : array) {
            if(produto.getCodigoProduto() == codigoProduto) {
                produto.setValorUnitario(valorProduto);
                return;
            }
        }
        throw new ProdutoNaoEncontradoException(codigoProduto);
    }



    public String listarProdutosDisponiveis(){
        System.out.println("-----PRODUTOS DISPONIVEIS----- ");
        for(Produto produto : array) {
            System.out.println(produto.toString());
        }
        return null;
    }


    public int getTamanhoArray(){
        return array.size();
    }

}
