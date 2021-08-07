//package unitTests.repository;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import restaurante.model.ItemPedido;
//import restaurante.model.Pedido;
//import restaurante.model.Produto;
//import restaurante.model.Sorvete;
//import restaurante.repository.BDPedido;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BDPedidoTest {
//
//    private static BDPedido bdPedido;
//    private static Pedido pedido;
//    private static ItemPedido itemPedido;
//    private static Produto produto;
//    private static ArrayList<Pedido> arrayPedidos;
//
//
//    @BeforeAll
//    public static void init(){
//        pedido = new Pedido();
//        arrayPedidos = new ArrayList<>();
//    }
//
//    @Test
//    @DisplayName("Verificar se um pedido foi adicionado no banco")
//    public void descobrir_se_pedido_foi_adicionado_banco() throws NullPointerException {
//        bdPedido = new BDPedido();
//
//        produto = new Sorvete(1, 5);
//        itemPedido = new ItemPedido(produto, 2);
//
//        pedido.adicionarItemPedido(itemPedido);
//        bdPedido.adicionarPedido(pedido);
//
//        arrayPedidos = bdPedido.getListaPedidos();
//
//        assertEquals(10, arrayPedidos.get(0).obterValorTotalPedido());
//
//    }
//
//    @Test
//    @DisplayName("Verificar se banco de pedidos está nulo")
//    public void descobrir_se_banco_pedidos_esta_nulo() throws NullPointerException {
//
//        assertThrows(NullPointerException.class, () -> bdPedido.getListaPedidos());
//
//    }
//
//}
