package restaurante.model;

public class Linguica extends Tiragosto{

    public Linguica(int codigoProduto, double valorUnitario, String nomeProduto) {
        super(codigoProduto, valorUnitario);
        this.tipoProduto = "Linguiça";
        this.nomeProduto = nomeProduto;
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
