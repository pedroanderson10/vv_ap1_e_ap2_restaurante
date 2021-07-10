package restaurante.validation;

public class ProdutoNaoEncontradoException extends Exception {

    private int codigoProduto;

    public ProdutoNaoEncontradoException(int codigoProduto) {
        super("\nO Produto de codigo " + codigoProduto + " nao esta cadastrado no sistema!!!\n");
        this.codigoProduto = codigoProduto;
    }

}
