package restaurante.view;

//import restaurante.controller.ControladorPedido;
import restaurante.controller.ControladorProduto;

import java.util.Scanner;

public class View {

    protected ViewMenu viewMenu;
    protected ControladorProduto controladorProduto;
    protected ViewAcesso viewAcesso;
    protected Scanner scan;
    protected int escolhaUsuario;
    protected boolean end;


    public void instanciarAtributos(){
        this.scan = new Scanner(System.in);
        this.viewMenu = new ViewMenu();
        this.controladorProduto = new ControladorProduto();
        this.viewAcesso = new ViewAcesso();
        this.end = false;
    }

}
