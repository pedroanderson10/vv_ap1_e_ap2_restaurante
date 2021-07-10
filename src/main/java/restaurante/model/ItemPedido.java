package restaurante.model;

public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        super();
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double obterValorItem(Produto produto) {
        return produto.valorUnitario * quantidade;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
