package unitTests.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.model.pedido.ItemPedido;
import restaurante.model.pedido.Pedido;
import restaurante.model.produto.Baiao;
import restaurante.model.produto.Linguica;
import restaurante.model.produto.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    private Pedido pedidoTest;
    private Produto baiao;
    private Produto linguica;

    @BeforeEach
    public void init(){
        this.pedidoTest = new Pedido();
        this.baiao = new Baiao(1, 10, "Corda");
        this.linguica = new Linguica(2, 5, "Frango");
    }

    @Test
    @DisplayName("Verifica se vários itens pedidos estão sendo adicionados ao pedido")
    public void verificar_adicao_varios_itensPedidos_no_pedido(){

        ItemPedido itemPedido1 = new ItemPedido(baiao, 2);
        ItemPedido itemPedido2 = new ItemPedido(linguica, 1);

        pedidoTest.adicionarItemPedido(itemPedido1);
        pedidoTest.adicionarItemPedido(itemPedido2);

        assertEquals(25, pedidoTest.obterValorTotalPedido());

    }


}
