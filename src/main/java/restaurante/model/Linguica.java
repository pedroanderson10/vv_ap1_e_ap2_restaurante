package restaurante.model;

public class Linguica extends Tiragosto{

    public Linguica(int codigoProduto, double valorUnitario) {
        super(codigoProduto, valorUnitario);
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
