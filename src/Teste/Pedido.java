package Teste;

public class Pedido {
    private String codPedido;
    private String cpfcnpj;
    private CategoriaAutomovel categoria;
    private String dataInicio;
    private String dataFim;

    public Pedido(String codPedido, String cpfcnpj, CategoriaAutomovel categoria, String dataInicio, String dataFim){
        this.codPedido = codPedido;
        this.cpfcnpj = cpfcnpj;
        this.categoria = categoria;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public CategoriaAutomovel getCategoria() {
        return categoria;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public String toString(){
        return "Código do pedido: " + codPedido + "\n" +
                "CPF/CNPJ do cliente: " + cpfcnpj + "\n" +
                "Categoria do automóvel: " + categoria.getNome() + "\n" +
                "Data de início: " + dataInicio + "\n" +
                "Data do fim: " + dataFim +"\n";

    }
}

