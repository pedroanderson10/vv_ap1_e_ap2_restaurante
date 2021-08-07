package restaurante;


import restaurante.dao.DAOProduto;
import restaurante.view.ViewAcesso;

public class RestauranteApplication {

    private static DAOProduto DAOProduto;
    private static ViewAcesso viewAcesso;

    public static void main(String[] args) throws Exception {

        instanciarAtributos();
        //DAOProduto.povoarArrayProdutos();
        viewAcesso.decidirTipoAcesso(DAOProduto);

    }

    private static void instanciarAtributos() {
        DAOProduto = new DAOProduto();
        viewAcesso = new ViewAcesso();
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
