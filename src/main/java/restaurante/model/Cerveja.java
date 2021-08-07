package restaurante.model;

public class Cerveja extends Bebida{

    public Cerveja(int codigoProduto, double valorUnitario, String nomeProduto) {
        super(codigoProduto, valorUnitario);
        this.tipoProduto = "Cerveja";
        this.nomeProduto = nomeProduto;
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
