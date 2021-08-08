package restaurante.controller;

import restaurante.dao.ProdutoDAO;
import restaurante.model.*;
import restaurante.repository.BDProduto;

public class ControladorProduto extends Controlador {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public Produto escolherProduto() {

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

    public void adicionarProduto(Produto produto) throws Exception {
        produtoDAO.addProdutos(produto);
    }

    public void alterarDadosProduto() throws Exception {

        instanciarAtributos();

        System.out.println("Insira o código do produto que deseja alterar");
        int cod = scan.nextInt();
        scan.nextLine();

        System.out.println("Insira o novo valor do produto");
        double valor = scan.nextDouble();
        scan.nextLine();

        produtoDAO.alteraValorDoProduto(cod, valor);

        //DAOProduto.alterarDadosProduto(cod, valor);
        //BDProduto.alteraValorDoProduto(cod, valor);
    }

    public void listarProdutos() throws Exception {

        instanciarAtributos();

        produtoDAO.listProdutosDisponiveis();

        //bdProduto.listarProdutosDisponiveis();
        //BDProduto.listProdutosDisponiveis();
    }

    public void deletarProduto() throws Exception {

        instanciarAtributos();

        System.out.println("Insira o código do produto que deseja excluir");
        int cod = scan.nextInt();
        scan.nextLine();

        produtoDAO.deletProduto(cod);

        //DAOProduto.deletarProduto(cod);
        //BDProduto.deletProduto(cod);
    }


}
