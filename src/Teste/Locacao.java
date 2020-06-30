package Teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Locacao {
    private Cliente cliente;
    private Automovel automovel;
    private int periodo;
    private double valor;


    public Locacao(Cliente cliente, Automovel automovel, int periodo){
        this.cliente = cliente;
        this.automovel = automovel;
        this.periodo = periodo;
    }

    public double getValorLocacao(){
        valor = (automovel.getModelo().getValorFixo()/1000) + (automovel.getValorDiaria() * periodo);
        return valor;
    }

    public void calculaDias(){
        String dataUm = "12/03/2020";
        String dataDois = "25/03/2020";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); // dd/MM/yyyy é o formato brasileiro que você está usando, para mais formatos, veja o link de referência

        Date dateUm = null;
        try {
            dateUm = simpleDateFormat.parse(dataUm);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateDois = null;
        try {
            dateDois = simpleDateFormat.parse(dataDois);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diferencaEmMilisegundos = dateDois.getTime() - dateUm.getTime();
        long dias = diferencaEmMilisegundos / 1000 / 60 / 60 / 24;
        int diasInt = (int)dias;
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
