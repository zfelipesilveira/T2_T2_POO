package Teste;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class ListaCategoria {
    public ArrayList<CategoriaAutomovel> categorias;
    private int total = 0;
    private int qtdMax;


    public ListaCategoria(int max) {
        this.qtdMax = max;
        categorias = new ArrayList<CategoriaAutomovel>(qtdMax);
    }

    public ArrayList<CategoriaAutomovel> getCategorias(){
        return categorias;
    }


    public CategoriaAutomovel pesquisaCategoria(String nome){
        CategoriaAutomovel umaCategoria = null;
        String umNome;
        for(int i = 0; i<categorias.size(); i++){
            umNome = categorias.get(i).getNome();
            if(umNome.equals(nome)){
                umaCategoria = categorias.get(i);
            }
        }
        return umaCategoria;
    }

    public boolean pesquisaCategoriaBoolean(String nome){
        for(int i = 0; i<categorias.size(); i++){
            if(categorias.get(i).getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public boolean insere(CategoriaAutomovel novaCategoria) {
        if(categorias.add(novaCategoria)){
            total++;
            return true;
        }
        return false;
    }

    public boolean remove(String nome) {
        for (int i = 0; i < categorias.size(); i++) {
            CategoriaAutomovel umaCategoria = categorias.get(i);
            String umNome = categorias.get(i).getNome();
            if (nome.equals(umNome)){
                categorias.remove(umaCategoria);
                total = total - 1;
                return true;
            }
        }
        return false;
    }

    public void mostraTotal(){
        System.out.print(total);
    }

    public void mostra() {
        if (total < 1) System.out.println("Não há categorias cadastradas");
        if (total > 0) {
            String str = " ";
            str = "Lista de categorias:" + "\n";
            for (int i = 0; i < categorias.size(); i++) {
                str = str + categorias.get(i).toString() + "\n";
            }
            System.out.println(str);
        }
    }



}
