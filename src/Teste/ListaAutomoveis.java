package Teste;

import java.util.ArrayList;
public class ListaAutomoveis {
    public ArrayList<Automovel> automoveis;
    private int total = 0;
    private int qtdMax;

    public ListaAutomoveis(int max) {
        this.qtdMax = max;
        automoveis = new ArrayList<Automovel>(qtdMax);
    }

    public void pesquisaPorCategoria(CategoriaAutomovel categoria){
        for(int i = 0; i<automoveis.size(); i++){
            if(automoveis.get(i).getModelo().getCategoria() == categoria){
                System.out.println(automoveis.get(i).toString());
            }
        }
    }

    public Automovel pesquisaAutomovel(String placa){
        Automovel retorno = null;
        for(int i = 0; i<automoveis.size(); i++){
            if(automoveis.get(i).getPlaca().equals(placa)){
                retorno = automoveis.get(i);
            }
        }
        return retorno;
    }

    public boolean insere(Automovel novoAutomovel) {
        if(automoveis.add(novoAutomovel)){
            total++;
            return true;
        }
        else return false;
    }

    public boolean remove(String placa) {
        for (int i = 0; i < automoveis.size(); i++) {
            Automovel umAutomovel = automoveis.get(i);
            String umaPlaca = automoveis.get(i).getPlaca();
            if (placa.equals(umaPlaca)){
                automoveis.remove(umAutomovel);
                total--;
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return automoveis.size();
    }

    public Automovel get(int index){
        return automoveis.get(index);
    }

    public void mostraTotal(){
        System.out.print(total);
    }

    public void mostra() {
        if (total < 1) System.out.println("Não há automóveis cadastrados");
        if (total > 0) {
            String str = " ";
            str = "Lista de Automóveis:" + "\n";
            for (int i = 0; i < automoveis.size(); i++) {
                str = str + automoveis.get(i).toString() + "\n";
            }
            System.out.println(str);
        }
    }



}
