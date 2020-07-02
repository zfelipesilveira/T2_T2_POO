package Teste;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PilhaPedidos {
    private Stack<Pedido> pedidos;
    private int total = 0;
    private int qtdMax;

    public PilhaPedidos() {
        pedidos = new Stack<Pedido>();
    }

//    public Pedido pesquisaLocacoes(String codPedido){
//        Pedido retorno = null;
//        for(int i = 0; i<pedidos.size(); i++){
//            if(pedidos.get(i).getCodPedido().equals(codPedido)){
//                retorno = pedidos.get(i);
//            }
//        }
//        return retorno;
//    }

    public void insere(Pedido novoPedido) {
        pedidos.push(novoPedido);
        total = total +1;

    }



    public Stack<Pedido> getPedidos() {
        return pedidos;
    }

    public void mostraTotal(){
        System.out.print(total);
    }

//    public void mostra() {
//        if (total < 1) System.out.println("Não há locações ");
//        if (total > 0) {
//            String str = " ";
//            str = "Lista de locações: + \n";
//            for (int i = 0; i < locacoes.size(); i++) {
//                str = str + locacoes.get(i).toString() + "\n" + "//////////////////////";
//            }
//            System.out.println(str);
//        }
//    }
}