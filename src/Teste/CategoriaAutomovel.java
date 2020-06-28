package Teste;

public class CategoriaAutomovel{
    private String nome;

    public CategoriaAutomovel(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        return "Categoria: " + nome + " - ";
    }

}
