package unitTests.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restaurante.model.pedido.ItemPedido;
import restaurante.model.produto.Baiao;
import restaurante.model.produto.Produto;
import restaurante.model.produto.Sorvete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ItemPedidoTest {

    private ItemPedido itemPedidoTest;
    private Produto baiao;
    private Produto sorvete;

    @BeforeEach
    public void init(){
        this.baiao = new Baiao(1, 10, "Corda");
        this.sorvete = new Sorvete(2, 20, "Nestle");
    }

    @Test
    @DisplayName("Verifica se o valor do item pedido está correto")
    public void verificar_se_valor_item_pedido_esta_correto(){

        itemPedidoTest = new ItemPedido(baiao, 3);

        assertEquals(30, itemPedidoTest.obterValorItem(baiao));
    }

    @Test
    @DisplayName("Verifica se o mesmo produto criado realmente foi adicionado ao item pedido")
    public void verificar_se_produto_e_um_baiao(){

        itemPedidoTest = new ItemPedido(baiao, 3);

        assertEquals(baiao, itemPedidoTest.getProduto());
        assertNotEquals(sorvete, itemPedidoTest.getProduto());

    }

    @Test
    @DisplayName("Verifica se o um produto adicionado, substitui um produto antigo")
    public void verificar_se_produto_foi_substituido(){

        itemPedidoTest = new ItemPedido(baiao, 3);
        itemPedidoTest.setProduto(sorvete);

        assertEquals(sorvete, itemPedidoTest.getProduto());
        assertNotEquals(baiao, itemPedidoTest.getProduto());

    }

}
