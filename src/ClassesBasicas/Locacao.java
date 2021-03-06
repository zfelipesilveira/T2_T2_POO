package ClassesBasicas;

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
    private Date dataUm;
    private Date dataDois;


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

    public String getDataInicial(){
        return dataInicio;
    }

    public String getDataFinal(){
        return dataFinal;
    }

    public void setDates(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dataUm = simpleDateFormat.parse(dataInicio);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dataDois = simpleDateFormat.parse(dataFinal);
        } catch (ParseException e) {
            e.printStackTrace();
        }

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

    public double getValorLocacao2(){
        if(cliente instanceof PessoaJuridica){
            valor = (automovel.getModelo().getValorFixo()/1000) + ((automovel.getValorDiaria()*0.95) * periodo);
            return valor;
        }
        else{
            valor = (automovel.getModelo().getValorFixo()/1000) + (automovel.getValorDiaria() * periodo);
            return valor;
        }
    }

    public void setValorLocacao(){
        if(cliente instanceof PessoaFisica){
            valor = (automovel.getModelo().getValorFixo()/1000) + ((automovel.getValorDiaria()*0.95) * periodo);

        }
        else{
            valor = (automovel.getModelo().getValorFixo()/1000) + (automovel.getValorDiaria() * periodo);

        }
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

    public Date getDataUm(){
        return dataUm;
    }

    public Date getDataDois(){
        return dataDois;
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
                "Data de início: " + dataInicio + "\n" +
                "Data final: " + dataFinal + "\n" +
                "Valor: " + valor + "\n" + "//////////////////////////////";
    }


}
