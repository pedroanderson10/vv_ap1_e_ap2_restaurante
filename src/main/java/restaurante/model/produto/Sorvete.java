package restaurante.model.produto;

public class Sorvete extends Sobremesa {

    public Sorvete(int codigoProduto, double valorUnitario, String nomeProduto) {
        super(codigoProduto, valorUnitario);
        this.tipoProduto = "Sorvete";
        this.nomeProduto = nomeProduto;
    }

    public double obterValorUnitario() {
        return valorUnitario;
    }

}
