package restaurante.repository;

import restaurante.model.Pedido;

import java.util.ArrayList;

public class BDPedido {

    private static ArrayList<Pedido> array = new ArrayList<Pedido>();

    public BDPedido() {
        super();
    }

    public static void adicionarPedido(Pedido pedido) {
        array.add(pedido);
    }

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
