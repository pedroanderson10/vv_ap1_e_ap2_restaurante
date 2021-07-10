package restaurante.model;

public class Cerveja extends Bebida{

    public Cerveja(int codigoProduto, double valorUnitario) {
        super(codigoProduto, valorUnitario);
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
