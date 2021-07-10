package restaurante.repository;

import restaurante.model.*;
import restaurante.validation.ProdutoNaoEncontradoException;

import java.util.ArrayList;

public class BDProduto {

    private static ArrayList<Produto> array = new ArrayList<Produto>();

    public BDProduto() {
        super();
    }

    public void povoarArrayProdutos(){
        adicionarProduto(new Cerveja(1,5));
        adicionarProduto(new Baiao(2,10));
        adicionarProduto(new Linguica(3,15));
        adicionarProduto(new Sorvete(4,20));
    }

    public void adicionarProduto(Produto produto) {
        array.add(produto);
    }

    public void deletarProduto(int codigoProduto) {
        for(Produto produto : array) {
            if(produto.getCodigoProduto() == codigoProduto) {
                array.remove(produto);
                System.out.println("Produto deletado!!!");
                return;
            }
        }
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

}
