package Teste;

import java.util.ArrayList;

public class ListaClientes {
    private ArrayList<Cliente> clientes;
    private int total = 0;
    private int qtdMax;

    public ListaClientes(int max) {
        this.qtdMax = max;
        clientes = new ArrayList<Cliente>(qtdMax);
    }

    public Cliente pesquisaCliente(String nome){
        Cliente retorno = null;
        for(int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getNome().equals(nome)){
                retorno = clientes.get(i);
            }
        }
        return retorno;
    }

    public boolean insere(Cliente novoCliente) {
        clientes.add(novoCliente);
        total = total + 1;
        return true;
    }

    public boolean remove(String nome) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente umCliente = clientes.get(i);
            String umNome = clientes.get(i).getNome();
            if (nome.equals(umNome)){
                clientes.remove(umCliente);
                total = total - 1;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void mostraTotal(){
        System.out.print(total);
    }

    public void mostra() {
        if (total < 1) System.out.println("Não há clientes cadastrados");
        if (total > 0) {
            String str = " ";
            str = "Lista de clientes:" + "\n";
            for (int i = 0; i < clientes.size(); i++) {
                str = str + clientes.get(i).toString() + "\n";
            }
            System.out.println(str);
        }
    }

    public String toString(){
        if (total < 1) System.out.println("Não há clientes cadastrados");
        if (total > 0) {
            String str = " ";
            str = "Lista de clientes:" + "\n";
            for (int i = 0; i < clientes.size(); i++) {
                str = str + clientes.get(i).toString() + "\n";
            }
            return str;
        }
        else return "Não há clientes cadastrados";
    }


}