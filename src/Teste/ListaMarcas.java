package Teste;

import java.util.ArrayList;

public class ListaMarcas{
    private ArrayList<MarcaAutomovel> marcas;
    private int total = 0;
    private int qtdMax;

    public ListaMarcas(int max) {
        this.qtdMax = max;
        marcas = new ArrayList<MarcaAutomovel>(qtdMax);
    }

    public ArrayList<MarcaAutomovel> getMarcas(){
        return marcas;
    }



    public MarcaAutomovel pesquisaMarca(String nome){
        MarcaAutomovel umaMarca = null;
        for(int i = 0; i<marcas.size(); i++){
            String umNome = marcas.get(i).getNome();
            if(umNome.equals(nome)){
                umaMarca = marcas.get(i);
            }
        }
        return umaMarca;
    }

    public boolean insere(MarcaAutomovel umaMarca) {
        marcas.add(umaMarca);
        total = total + 1;
        return true;
    }

    public boolean remove(String nome) {
        for (int i = 0; i < marcas.size(); i++) {
            MarcaAutomovel umaMarca = marcas.get(i);
            String umNome = marcas.get(i).getNome();
            if (nome.equals(umNome)){
                marcas.remove(umaMarca);
                total = total - 1;
                return true;
            }
        }
        return false;
    }

    public void mostraTotal(){
        System.out.print(total);
    }

    public String toString(){
        if (total < 1) return "Não há marcas cadastradas";
        if (total > 0) {
            String str = " ";
            str = "";
            for (int i = 0; i < marcas.size(); i++) {
                str = str + marcas.get(i).toString() + "\n" ;
            }
            return str;
        }
        return "Não há marcas cadastradas";
    }

    public void mostra() {
        if (total < 1) System.out.println("Não há marcas cadastradas");
        if (total > 0) {
            String str = " ";
            str = "Lista de marcas:" + "\n";
            for (int i = 0; i < marcas.size(); i++) {
                str = str + marcas.get(i).toString() + "\n" ;
            }
            System.out.println(str);
        }
    }


}

