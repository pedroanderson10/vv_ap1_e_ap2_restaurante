package restaurante.model;

public class Baiao extends PratoPrincipal {

    public Baiao(int codigoProduto, double valorUnitario) {
        super(codigoProduto, valorUnitario);
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
