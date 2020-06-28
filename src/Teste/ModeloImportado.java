package Teste;

public class ModeloImportado extends ModeloAutomovel {
    private double taxa;
    private double valor;
    private double valorFixo;

    public ModeloImportado(String nome, MarcaAutomovel marca, CategoriaAutomovel categoria, double valor, double taxa){
        super(nome, marca, categoria);
        this.taxa = taxa;
        this.valor = valor;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public CategoriaAutomovel getCategoria() {
        return super.getCategoria();
    }

    @Override
    public MarcaAutomovel getMarca() {
        return super.getMarca();
    }

    public double getTaxa() {
        return taxa;
    }

    public double getValor() {
        return valor;
    }

    public double getValorFixo(){
        valorFixo = getValor() + ((getValor() * taxa)/100);
        return valorFixo;
    }

    public String toString(){
        return "Modelo: " + getNome() + " - " + "Marca: " + getMarca() + " - " + "Categoria: " + getCategoria()
                + " - " + "Taxa de importação: " + getTaxa() + " - " + "Valor: " + getValor();
    }
}

