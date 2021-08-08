package restaurante.view;

import restaurante.model.produto.Produto;

public class ViewMenu extends View {


    public void menuCliente() throws Exception {

        instanciarAtributos();

        while (!end) {
            System.out.println("-------------------------------------");
            System.out.println("---------- Menu do cliente ----------");
            System.out.println("1 - Realizar Pedido (Fora do ar)");
            System.out.println("0 - Voltar");
            System.out.println("-------------------------------------");

            escolhaUsuario = scan.nextInt();

            switch (escolhaUsuario) {
                case 1: {
                    //controladorPedido.realizarPedido(DAOProduto);
                    break;
                }
                case 0: {
                    end = true;
                    break;
                }
                default:
                    System.out.println("Insira uma opção válida");
            }
        }
    }

    public void menuAdministrador() throws Exception {

        instanciarAtributos();

        while (!end) {
            System.out.println("-------------------------------------");
            System.out.println("---------- Menu do cliente ----------");
            System.out.println("1 - Cadastrar um produto");
            System.out.println("2 - Alterar dados do produto");
            System.out.println("3 - Listar todos produtos disponíveis");
            System.out.println("4 - Deletar um produto");
            System.out.println("5 - Buscar um produto por código");
            System.out.println("0 - Voltar");
            System.out.println("-------------------------------------");

            escolhaUsuario = scan.nextInt();

            switch (escolhaUsuario) {
                case 1: {
                    Produto produto = controladorProduto.escolherProduto();
                    if(produto == null) break;
                    //bdProduto.adicionarProduto(produto);
                    controladorProduto.adicionarProduto(produto);
                    break;
                }
                case 2: {
                    controladorProduto.alterarDadosProduto();
                    break;
                }
                case 3: {
                    controladorProduto.listarProdutos();
                    break;
                }
                case 4: {
                    controladorProduto.deletarProduto();
                    break;
                }
                case 5: {
                    controladorProduto.buscarProdutoPorCodigo();
                    break;
                }
                case 0: {
                    end = true;
                    break;
                }
                default:
                    System.out.println("Insira uma opção válida");
            }
        }
    }

}
