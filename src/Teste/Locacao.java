package Teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Locacao {
    private Cliente cliente;
    private Automovel automovel;
    private String dataInicio;
    private String dataFinal;
    private double periodo;
    private double valor;
    private String tipoCliente;


    public Locacao(Cliente cliente, Automovel automovel, String dataInicio, String dataFinal){
        this.cliente = cliente;
        this.automovel = automovel;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Locacao(Automovel auto, String dataInicio, String dataFinal){
        this.automovel = auto;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public Locacao(Automovel auto, String dataInicio, String dataFinal, String tipoCliente){
        this.automovel = auto;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.tipoCliente = tipoCliente;
    }

    public double getValorLocacao(){
        if(tipoCliente.equalsIgnoreCase("J")){
            valor = (automovel.getModelo().getValorFixo()/1000) + ((automovel.getValorDiaria()*0.95) * periodo);
            return valor;
        }
        else{
            valor = (automovel.getModelo().getValorFixo()/1000) + (automovel.getValorDiaria() * periodo);
            return valor;
        }
    }

    public void setValorLocacao(){
        valor = (automovel.getModelo().getValorFixo()/1000) + (automovel.getValorDiaria() * periodo);
    }

    public void calculaPeriodo(){
        String dataUm = dataInicio;
        String dataDois = dataFinal;

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
        periodo = diasInt;
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
