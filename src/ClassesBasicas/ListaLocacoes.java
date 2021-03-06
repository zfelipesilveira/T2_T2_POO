package ClassesBasicas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class ListaLocacoes {
    private ArrayList<Locacao> locacoes;
    private int total = 0;
    private int qtdMax;

    public ListaLocacoes(int max) {
        this.qtdMax = max;
        locacoes = new ArrayList<Locacao>(qtdMax);
    }

    public Locacao pesquisaLocacoes(String placa){
        Locacao retorno = null;
        for(int i = 0; i<locacoes.size(); i++){
            if(locacoes.get(i).getAutomovel().getPlaca().equals(placa)){
                retorno = locacoes.get(i);
            }
        }
        return retorno;
    }

    public void atualizaValorDasLocacoes(){
        for(int i = 0; i<locacoes.size(); i++){
            locacoes.get(i).calculaPeriodo();
            locacoes.get(i).setValorLocacao();
        }
    }

    public ArrayList<Locacao> getLocacoes(){
        return locacoes;
    }

    public boolean procuraLocacaoNessaData(String data){
        for(int i = 0; i<locacoes.size(); i++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dataChave = null;
            try {
                dataChave = simpleDateFormat.parse(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            locacoes.get(i).setDates();
            Date dataUm = locacoes.get(i).getDataUm();
            Date dataDois = locacoes.get(i).getDataDois();
            if (dataChave.after(dataUm) && dataChave.before(dataDois)) return true;

        }
        return false;
    }

    public boolean insere(Locacao novaLocacao) {
        boolean retorno = false;
        if(locacoes.add(novaLocacao)){
            total = total + 1;
            retorno = true;
        }
        return retorno;

    }

    public boolean remove(Locacao umaLocacao) {
        for (int i = 0; i < locacoes.size(); i++) {
            Locacao outraLocacao = locacoes.get(i);
            if (umaLocacao==outraLocacao){
                locacoes.remove(umaLocacao);
                total = total - 1;
                return true;
            }
        }
        return false;
    }

    public void mostraTotal(){
        System.out.print(total);
    }

    public String toString(){
        if (total < 1) System.out.println("Não há locações ");
        if (total > 0) {
            String str = " ";
            str = "";
            for (int i = 0; i < locacoes.size(); i++) {
                str = str + locacoes.get(i).toString() + "\n" + "/////////////////////////////" + "\n";
            }
            return str;
        }
        return "Ocorreu algum erro";
    }

    public void mostra() {
        if (total < 1) System.out.println("Não há locações ");
        if (total > 0) {
            String str = " ";
            str = "Lista de locações: + \n";
            for (int i = 0; i < locacoes.size(); i++) {
                str = str + locacoes.get(i).toString() + "\n" + "//////////////////////";
            }
            System.out.println(str);
        }
    }
}
