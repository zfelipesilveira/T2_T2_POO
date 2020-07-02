package Teste;

public class Automovel {
    private String placa;
    private int ano;
    private double valorDiaria;
    private boolean disponivel = true;
    public ModeloAutomovel modelo;



    public Automovel(String placa, int ano, double valorDiaria, ModeloAutomovel modelo){
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.modelo = modelo;
    }

    public Automovel(String placa, int ano, double valorDiaria, ModeloAutomovel modelo, boolean disp){
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.modelo = modelo;
        this.disponivel = disp;
    }

    public void setDisponivel(int d){
        if (d==1) disponivel = true;
        else disponivel = false;
    }



    public boolean getDisponivel(){
        return disponivel;
    }

    public String mostraDisponibilidade(){
        if(disponivel == true) return "Está disponível";
        else return "Já está locado.";
    }

    public double getValorDiaria(){
        return valorDiaria;
    }

    public String getNomeModelo(){
        return modelo.getNome();
    }

    public CategoriaAutomovel getCategoria(){
        return modelo.getCategoria();
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public ModeloAutomovel getModelo(){
        return modelo;
    }

    public String toString(){
        String ifmodelo = "";
        if(modelo!=null){ifmodelo = modelo.getNome();}
        return "Modelo: " + ifmodelo+ "\n" + "Placa: " + placa + "\n" + "Ano: " + ano + "\n" + "Valor Diária: " + valorDiaria
                + "\n" ;
    }

}
