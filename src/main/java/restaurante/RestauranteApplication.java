package restaurante;


import restaurante.repository.BDProduto;
import restaurante.view.ViewAcesso;

public class RestauranteApplication {

    private static BDProduto BDProduto;
    private static ViewAcesso viewAcesso = new ViewAcesso();

    public static void main(String[] args) throws Exception {

        //DAOProduto.povoarArrayProdutosDAO();
        //BDProduto.povoarArrayProdutos();

        viewAcesso.decidirTipoAcesso();

    }


//    create table produto (codigo_produto integer NOT NULL,
//                          valor_unitario double precision NOT NULL,
//                          tipo_produto varchar(50) NOT NULL,
//                          nome_produto varchar(50) NOT NULL,
//                          UNIQUE(codigo_produto),
//                          PRIMARY KEY (codigo_produto));

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
