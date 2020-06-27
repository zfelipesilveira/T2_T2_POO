package Teste;

public class MarcaAutomovel {
    private String nome;

    public MarcaAutomovel(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        return "Marca: " + nome + " - ";
    }


}