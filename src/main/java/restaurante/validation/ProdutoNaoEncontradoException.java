package restaurante.validation;

public class ProdutoNaoEncontradoException extends Exception {

    private int codigoProduto;

    public ProdutoNaoEncontradoException(int codigoProduto) {
        super("O Produto de codigo " + codigoProduto + " nao esta cadastrado no sistema!!!");
        this.codigoProduto = codigoProduto;
    }

}
