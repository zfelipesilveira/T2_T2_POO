package ClassesBasicas;

public class ModeloNacional extends ModeloAutomovel{
    private double ipi;
    private double valor;
    private double valorFixo;

    public ModeloNacional(String nome, MarcaAutomovel marca, CategoriaAutomovel categoria, double valor, double ipi){
        super(nome, marca, categoria);
        this.valor = valor;
        this.ipi = ipi;
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

    public double getIpi() {
        return ipi;
    }

    public double getValor() {
        return valor;
    }

    public double getValorFixo(){
        double ipi10 = ((getValor() * ipi)/100) * 0.10;
        valorFixo = getValor() + ((getValor() * ipi)/100);
        double valorFixoFinal = getValor() + ipi10;
        return valorFixoFinal;
    }

    public String toString(){
        return "Modelo: " + getNome() + " - " + "Marca: " + getMarca().getNome() + " - " + "Categoria: " + getCategoria().getNome()
                + " - " + "IPI: " + getIpi() + " - " + "Valor: " + getValor();
    }

}