package TratamentoArquivos;

import Teste.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EscritaArquivos {

    //private Pessoa lista[];
    private Cliente listaCli[];
    private CategoriaAutomovel listaCategoria[];


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

//    public void gravaRegistrosTexto() {
//        Path path1 = Paths.get("teste2.txt");
//        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
//            for (Pessoa p : lista) {
//                writer.format("%s;%d;%s%n",p.getNome(),p.getIdade(),p.getEnd());
//            }
//        }
//        catch (IOException e) {
//            System.err.format("Erro de E/S: %s%n", e);
//        }
//    }

    public void gravaRegistrosCategorias(CategoriaAutomovel[] lista){
        Path path1 = Paths.get("categorias.txt");
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            for (CategoriaAutomovel cat : lista) {
                if(cat instanceof CategoriaAutomovel){
                    writer.format("%s%n",cat.getNome());
                }


            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void gravaRegistrosMarcas(MarcaAutomovel[] lista){
        Path path1 = Paths.get("marcas.txt");
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            for (MarcaAutomovel mar : lista) {
                if(mar instanceof MarcaAutomovel) writer.format("%s%n",mar.getNome());
                //writer.format("%s",mar.getNome());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void gravaRegistrosModelos(ModeloAutomovel[] lista){
        Path path1 = Paths.get("modelos.txt");
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            for (ModeloAutomovel mod : lista) {
                if(mod instanceof ModeloNacional) {
                    writer.format("%s;%s;%s;%f;%f%n", mod.getNome(), mod.getCategoria().getNome(), mod.getMarca().getNome(),
                            ((ModeloNacional) mod).getValor(), ((ModeloNacional) mod).getIpi());
                }
                if(mod instanceof ModeloImportado) {
                    writer.format("%s;%s;%s;%f;%f%n", mod.getNome(), mod.getCategoria().getNome(), mod.getMarca().getNome(),
                            ((ModeloImportado) mod).getValor(), ((ModeloImportado) mod).getTaxa());
                }

            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

    }

    public void gravaRegistrosAutomoveis(Automovel[] lista){
        Path path1 = Paths.get("automoveis.txt");
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
            for (Automovel auto : lista) {
                if(auto instanceof Automovel && auto.getDisponivel()==true) writer.format("%s;%d;%f;%s;%s%n",auto.getPlaca(),auto.getAno(),auto.getValorDiaria(),auto.getModelo().getNome(),"T");
                //writer.format("%s",mar.getNome());
                if(auto instanceof Automovel && auto.getDisponivel()==false) writer.format("%s;%d;%f;%s;%s%n",auto.getPlaca(),auto.getAno(),auto.getValorDiaria(),auto.getModelo().getNome(),"F");
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void gravaRegistrosLocacoes(Locacao[] lista){

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