package restaurante.controller;

import restaurante.model.Pedido;

public class ControleGerencial implements Gerenciavel {

    public void cancelarPedido(Pedido pedido) {
        pedido.cancelado = true;
    }

}
