package restaurante.view;

import restaurante.repository.BDProduto;

public class ViewAcesso extends View{

    public void decidirTipoAcesso() throws Exception {

        instanciarAtributos();

        while (!end){
            System.out.println("-------------------------------------");
            System.out.println("----- Escolha o tipo de acesso -----");
            System.out.println("1 - Administrador");
            System.out.println("2 - Cliente (Fora do Ar)");
            System.out.println("0 - Sair");
            System.out.println("-------------------------------------");

            escolhaUsuario = scan.nextInt();

            switch (escolhaUsuario){
                case 1:{
                    viewMenu.menuAdministrador();
                    break;
                }
                case 2:{
                    viewMenu.menuCliente();
                    break;
                }
                case 0:{
                    end = true;
                    break;
                }
                default:
                    System.out.println("Insira uma opção válida");
            }
        }

    }

}
