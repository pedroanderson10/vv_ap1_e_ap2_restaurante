package restaurante.controller;

import restaurante.model.*;
import restaurante.dao.DAOProduto;
import restaurante.validation.ProdutoNaoEncontradoException;

public class ControladorProduto extends Controlador {

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

    public void alterarDadosProduto(DAOProduto DAOProduto) throws ProdutoNaoEncontradoException {

        instanciarAtributos();

        System.out.println("Insira o código do produto que deseja alterar");
        int cod = scan.nextInt();

        System.out.println("Insira o novo valor do produto");
        double valor = scan.nextDouble();

        DAOProduto.alterarDadosProduto(cod, valor);
    }

    public void listarProdutos(DAOProduto DAOProduto) throws Exception {

        instanciarAtributos();

//        bdProduto.listarProdutosDisponiveis();
          DAOProduto.listProdutosDisponiveis();
    }

    public void deletarProduto(DAOProduto DAOProduto) throws ProdutoNaoEncontradoException {

        instanciarAtributos();

        System.out.println("Insira o código do produto que deseja excluir");
        int cod = scan.nextInt();

        DAOProduto.deletarProduto(cod);
    }

}
