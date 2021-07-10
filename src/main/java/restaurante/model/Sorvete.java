package restaurante.model;

public class Sorvete extends Sobremesa {

    public Sorvete(int codigoProduto, double valorUnitario) {
        super(codigoProduto, valorUnitario);
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
