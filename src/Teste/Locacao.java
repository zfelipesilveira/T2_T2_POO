package Teste;

public class Locacao {
    private Cliente cliente;
    private Automovel automovel;
    private double periodo;
    private double valor;


    public Locacao(Cliente cliente, Automovel automovel, double periodo){
        this.cliente = cliente;
        this.automovel = automovel;
        this.periodo = periodo;
    }

    public double getValorLocacao(){
        valor = (automovel.getModelo().getValorFixo()/1000) + (automovel.getValorDiaria() * periodo);
        return valor;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Automovel getAutomovel(){
        return automovel;
    }

    public double getPeriodo() {
        return periodo;
    }

    public String toString(){
        return "Cliente: " + cliente.getNome() + "\n" +
                "Automóvel: " + automovel.toString() + "\n" +
                "Valor: " + valor;
    }


}
