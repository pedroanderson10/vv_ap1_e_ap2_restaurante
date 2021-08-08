package restaurante.model.produto;

public class Baiao extends PratoPrincipal {

    public Baiao(int codigoProduto, double valorUnitario, String nomeProduto) {
        super(codigoProduto, valorUnitario);
        this.tipoProduto = "Baião";
        this.nomeProduto = nomeProduto;
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
