package restaurante.view;

import restaurante.model.produto.*;

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
                    Produto produto = escolherProduto();
                    if(produto == null) break;
                    //bdProduto.adicionarProduto(produto);
                    controladorProduto.adicionarProduto(produto);
                    break;
                }
                case 2: {

                    System.out.println("Insira o código do produto que deseja alterar");
                    int codigo = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Insira o novo valor do produto");
                    double valor = scan.nextDouble();

                    controladorProduto.alterarDadosProduto(codigo, valor);
                    break;
                }
                case 3: {
                    controladorProduto.listarProdutos();
                    break;
                }
                case 4: {

                    System.out.println("Insira o código do produto que deseja excluir");
                    int codigo = scan.nextInt();

                    controladorProduto.deletarProduto(codigo);
                    break;
                }
                case 5: {

                    System.out.println("Insira o código do produto que deseja buscar");
                    int codigo = scan.nextInt();

                    controladorProduto.buscarProdutoPorCodigo(codigo);
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

    private Produto escolherProduto() {

        instanciarAtributos();

        while (!end) {
            System.out.println("-----------------------------------------------------");
            System.out.println("---------- Qual produto deseja adicionar ? ----------");
            System.out.println("1 - Cerveja");
            System.out.println("2 - Baiao");
            System.out.println("3 - Linguiça");
            System.out.println("4 - Sorvete");
            System.out.println("0 - Voltar");
            System.out.println("------------------------------------------------------");

            escolhaUsuario = scan.nextInt();

            switch (escolhaUsuario) {
                case 1: {
                    //System.out.println("Insira a marca da cerveja");
                    System.out.println("Insira o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Insira o valor da unidade");
                    double valor = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Insira o nome do produto");
                    String nome = scan.nextLine();

                    return new Cerveja(cod, valor, nome);
                }
                case 2: {
                    //System.out.println("Insira a marca da cerveja");
                    System.out.println("Insira o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Insira o valor da unidade");
                    double valor = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Insira o nome do produto");
                    String nome = scan.nextLine();

                    return new Baiao(cod, valor, nome);
                }
                case 3: {
                    //System.out.println("Insira a marca da cerveja");
                    System.out.println("Insira o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Insira o valor da unidade");
                    double valor = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Insira o nome do produto");
                    String nome = scan.nextLine();

                    return new Linguica(cod, valor, nome);
                }
                case 4: {
                    //System.out.println("Insira a marca da cerveja");
                    System.out.println("Insira o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Insira o valor da unidade");
                    double valor = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Insira o nome do produto");
                    String nome = scan.nextLine();

                    return new Sorvete(cod, valor, nome);
                }
                case 0: {
                    end = true;
                    break;
                }
                default:
                    System.out.println("Insira uma opção válida");
            }
        }
        return null;
    }


}
