package restaurante.view;

import restaurante.model.Produto;
import restaurante.repository.BDProduto;
import restaurante.validation.ProdutoNaoEncontradoException;

public class ViewMenu extends View {

    public void menuCliente(BDProduto bdProduto) {

        instanciarAtributos();

        while (!end) {
            System.out.println("-------------------------------------");
            System.out.println("---------- Menu do cliente ----------");
            System.out.println("1 - Realizar Pedido");
            System.out.println("0 - Voltar");
            System.out.println("-------------------------------------");

            escolhaUsuario = scan.nextInt();

            switch (escolhaUsuario) {
                case 1: {
                    controladorPedido.realizarPedido(bdProduto);
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

    public void menuAdministrador(BDProduto bdProduto) throws ProdutoNaoEncontradoException {

        instanciarAtributos();

        while (!end) {
            System.out.println("-------------------------------------");
            System.out.println("---------- Menu do cliente ----------");
            System.out.println("1 - Cadastrar um produto");
            System.out.println("2 - Alterar dados do produto");
            System.out.println("3 - Listar produtos existentes");
            System.out.println("4 - Deletar um produto");
            System.out.println("0 - Voltar");
            System.out.println("-------------------------------------");

            escolhaUsuario = scan.nextInt();

            switch (escolhaUsuario) {
                case 1: {
                    Produto produto = controladorProduto.escolherProduto();
                    if(produto == null) break;
                    bdProduto.adicionarProduto(produto);
                    break;
                }
                case 2: {
                    controladorProduto.alterarDadosProduto(bdProduto);
                    break;
                }
                case 3: {
                    controladorProduto.listarProdutos(bdProduto);
                    break;
                }
                case 4: {
                    controladorProduto.deletarProduto(bdProduto);
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
