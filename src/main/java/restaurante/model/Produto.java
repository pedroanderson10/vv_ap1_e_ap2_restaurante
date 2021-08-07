package restaurante.model;

public abstract class Produto {

    protected int codigoProduto;
    protected double valorUnitario;
    protected String tipoProduto;
    protected String nomeProduto;

    public Produto() {

    }

    public Produto(int codigoProduto, double valorUnitario) {
        super();
        this.codigoProduto = codigoProduto;
        this.valorUnitario = valorUnitario;
    }

    public String toString() {
        return "\nCodigo do Produto = " + codigoProduto + "\nValor Unitario = " + valorUnitario + "\nTipo do Produto = " + tipoProduto + " " + nomeProduto ;
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

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
