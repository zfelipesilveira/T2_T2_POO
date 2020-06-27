package Teste;

public abstract class Cliente {
    protected String nome = "";
    protected String telefone = "";

    public Cliente(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public String getTelefone(){
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - " +
                "Telefone: " + telefone + " - ";
    }


}