package ClassesBasicas;

import java.util.Stack;

public class PilhaPedidosLocacoes {
    private Stack<Locacao> pedidosLocacoes;
    private int total = 0;
    private int qtdMax;

    public PilhaPedidosLocacoes() {
        pedidosLocacoes = new Stack<Locacao>();
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

    public void insere(Locacao novaLocacao) {
        pedidosLocacoes.push(novaLocacao);
        total = total +1;

    }

    public Locacao remove(){
        total = total - 1;
        return pedidosLocacoes.pop();

    }

    public int getTotal(){
        return total;
    }

    public Stack<Locacao> getPedidos() {
        return pedidosLocacoes;
    }

    public String toString(){
        return pedidosLocacoes.toString();
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
