package restaurante;


import restaurante.jdbcConnection.ConnectionJdbc;
import restaurante.repository.BDProduto;
import restaurante.validation.ProdutoNaoEncontradoException;
import restaurante.view.ViewAcesso;

import java.sql.Connection;

public class RestauranteApplication {

    private static BDProduto bdProduto;
    private static ViewAcesso viewAcesso;
    private static Connection connectionJdbc;

    public static void main(String[] args) throws Exception {


        //connectionJdbc =  new ConnectionJdbc().getConexao();

        instanciarAtributos();

//        bdProduto.povoarArrayProdutos();
        viewAcesso.decidirTipoAcesso(bdProduto);


    }

    private static void instanciarAtributos() {
        bdProduto = new BDProduto();
        viewAcesso = new ViewAcesso();
    }

//    	//Teste de exceção
//		System.out.println("\n[EXTRA] Teste de exceção");
//			try {
//			Produto produto = BDproduto.ProcurarProduto(8);
//		}catch(ProdutoNaoEncontradoException x) {
//			System.out.println(x.getMessage());
//		}
//
//		//Teste de Cancelar Pedido
//		ControleGerencial controle = new ControleGerencial();
//		novoPedido = BDPedido.ProcurarPedido(0);
//		if(novoPedido == null) System.out.println("Pedido nao existente");
//		else controle.cancelarPedido(novoPedido);

}
