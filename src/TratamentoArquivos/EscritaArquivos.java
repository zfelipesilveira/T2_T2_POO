package TratamentoArquivos;

import Teste.Cliente;
import Teste.PessoaFisica;
import Teste.PessoaJuridica;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EscritaArquivos {

    //private Pessoa lista[];
    private Cliente lista[];

    public void gravaLinhasTexto() {
        Path path1 = Paths.get("teste1.txt");
        // Abaixo: defaultCharset retorna a codificação padrão de
        // textos (usualmente UTF-8)
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            writer.println("Escrevendo linha em arquivo texto");
            writer.println("Outra linha...");
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void gravaRegistrosTexto(Cliente[] lista) {
        Path path1 = Paths.get("clientes.txt");
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            for (Cliente c : lista) {
                if (c instanceof PessoaFisica) {
                    writer.format("%s;%s;%s;%s%n", ((PessoaFisica) c).getCpf(), ((PessoaFisica) c).getNome(),
                            ((PessoaFisica) c).getTelefone(), "F");

                }
                if (c instanceof PessoaJuridica) {
                    writer.format("%s;%s;%s;%s%n", ((PessoaJuridica) c).getCnpj(), ((PessoaJuridica) c).getNome(),
                            ((PessoaJuridica) c).getTelefone(), "J");
                }

            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public static void main(String args[]) {
        EscritaArquivos exemplo = new EscritaArquivos();
        Cliente c1 = new PessoaFisica("Marcelo","3912039", "84632981");
        Cliente c2 = new PessoaJuridica("Dell","9423849", "984373");
        Cliente c3 = new PessoaFisica("Gabriel","9849382", "8493042");
        Cliente[] lista = {c1, c2, c3};
        //exemplo.gravaLinhasTexto();
        exemplo.gravaRegistrosTexto(lista);
    }
}