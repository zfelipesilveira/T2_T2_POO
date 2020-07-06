package ClassesBasicas;

public class PessoaJuridica extends Cliente {
    private String cnpj = "";

    public PessoaJuridica(String nome, String telefone, String cnpj){
        super(nome, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj(){
        return cnpj;
    }

    @Override
    public String toString(){
        String str = super.toString();
        str = str + "CNPJ: " + cnpj;
        return str;
    }
}
