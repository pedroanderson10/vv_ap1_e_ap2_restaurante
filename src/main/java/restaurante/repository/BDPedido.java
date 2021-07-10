package restaurante.repository;

import restaurante.model.Pedido;

import java.util.ArrayList;

public class BDPedido {

    private static ArrayList<Pedido> array = new ArrayList<Pedido>();

    public BDPedido() {

    }

    public void adicionarPedido(Pedido pedido) {
        array.add(pedido);
    }

    public ArrayList<Pedido> getListaPedidos() throws NullPointerException {
        if (array != null){
            return array;
        }
        throw new NullPointerException();
    }

    //Decidi não ir adiante para o sistema não ficar tão grande, mas seria uma lógica como a de BDProdutos

//	public static Pedido ProcurarPedido(int codigoPedido) {
//		Pedido pedido;
//		if ((pedido = array.get(codigoPedido)) instanceof Pedido)
//			return pedido;
//		else
//			return null;
//	}
//
//	public String toString() {
//		return "BDPedido [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
//				+ "]";
//	}

}
