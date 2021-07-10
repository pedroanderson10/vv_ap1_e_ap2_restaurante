package restaurante.model;

public abstract class Produto {

    protected int codigoProduto;
    protected double valorUnitario;

    public Produto() {

    }

    public Produto(int codigoProduto, double valorUnitario) {
        super();
        this.codigoProduto = codigoProduto;
        this.valorUnitario = valorUnitario;
    }

    public String toString() {
        return "\nCodigo do Produto = " + codigoProduto + "\nValor Unitario = " + valorUnitario;
    }

    abstract public double obterValorUnitario();
    public void cancelarPedido(Pedido pedido) {

    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
