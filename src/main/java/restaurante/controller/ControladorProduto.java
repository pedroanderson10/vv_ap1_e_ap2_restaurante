package restaurante.controller;

import restaurante.model.*;
import restaurante.repository.BDProduto;
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

                    return new Cerveja(cod, valor);
                }
                case 2: {
                    //System.out.println("Insira a marca da cerveja");
                    System.out.println("Insira o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Insira o valor da unidade");
                    double valor = scan.nextDouble();

                    return new Baiao(cod, valor);
                }
                case 3: {
                    //System.out.println("Insira a marca da cerveja");
                    System.out.println("Insira o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Insira o valor da unidade");
                    double valor = scan.nextDouble();

                    return new Linguica(cod, valor);
                }
                case 4: {
                    //System.out.println("Insira a marca da cerveja");
                    System.out.println("Insira o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Insira o valor da unidade");
                    double valor = scan.nextDouble();

                    return new Sorvete(cod, valor);
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

    public void alterarDadosProduto(BDProduto bdProduto) throws ProdutoNaoEncontradoException {

        instanciarAtributos();

        System.out.println("Insira o código do produto que deseja alterar");
        int cod = scan.nextInt();

        System.out.println("Insira o novo valor do produto");
        double valor = scan.nextDouble();

        bdProduto.alterarDadosProduto(cod, valor);
    }

    public void listarProdutos(BDProduto bdProduto) throws ProdutoNaoEncontradoException {

        instanciarAtributos();

        bdProduto.listarProdutosDisponiveis();
    }

    public void deletarProduto(BDProduto bdProduto) throws ProdutoNaoEncontradoException {

        instanciarAtributos();

        System.out.println("Insira o código do produto que deseja excluir");
        int cod = scan.nextInt();

        bdProduto.deletarProduto(cod);
    }

}
