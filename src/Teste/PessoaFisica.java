package Teste;

public class PessoaFisica extends Cliente {
    private String cpf = "";

    public PessoaFisica(String nome, String telefone, String cpf) {
        super(nome, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str = str + "CPF: " + cpf;
        return str;
    }
}
