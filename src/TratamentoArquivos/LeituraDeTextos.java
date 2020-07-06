package TratamentoArquivos;

import ClassesBasicas.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LeituraDeTextos {

    public void leRegistrosTextoClientes(ListaClientes lcli) {
        Path path = Paths.get("clientes.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                String cpfcnpj = sc.next();
                String nome = sc.next();
                String telefone = sc.next();
                String tipoCliente = sc.next();

                if(tipoCliente.equalsIgnoreCase("J"))
                {
                    Cliente pj = new PessoaJuridica(nome,telefone,cpfcnpj);
                    lcli.insere(pj);
                }
                if(tipoCliente.equalsIgnoreCase("F"))
                {
                    Cliente pf = new PessoaFisica(nome,telefone,cpfcnpj);
                    lcli.insere(pf);
                }
                //System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void leRegistrosTextoCategorias(ListaCategoria lcat) {
        Path path = Paths.get("categorias.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                String nomeCateforia = sc.next();
                CategoriaAutomovel cat = new CategoriaAutomovel(nomeCateforia);
                lcat.insere(cat);

                //System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void leRegistrosTextoMarcas(ListaMarcas lmarca) {
        Path path = Paths.get("marcas.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                String nomeMarca = sc.next();
                MarcaAutomovel marca = new MarcaAutomovel(nomeMarca);
                lmarca.insere(marca);

                //System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void leRegistrosTextoModelos(ListaModelo lmodelo, ListaCategoria lcat, ListaMarcas lmarc) {
        Path path = Paths.get("modelos.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                String nomeMod = sc.next();
                String nomeCat = sc.next();
                String nomeMar = sc.next();
                double valorMod = Double.parseDouble(sc.next());
                double ipiTaxa = Double.parseDouble(sc.next());

                if(lmodelo.pesquisaModelo(nomeMod) instanceof ModeloNacional){
                    ModeloNacional modn = new ModeloNacional(nomeMod,lmarc.pesquisaMarca(nomeMar),
                            lcat.pesquisaCategoria(nomeCat),valorMod,ipiTaxa);
                    lmodelo.insere(modn);
                }
                if(lmodelo.pesquisaModelo(nomeMod) instanceof ModeloImportado){
                    ModeloImportado modi = new ModeloImportado(nomeMod,lmarc.pesquisaMarca(nomeMar),
                            lcat.pesquisaCategoria(nomeCat),valorMod,ipiTaxa);
                    lmodelo.insere(modi);
                }

                //System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void leRegistrosTextoAutomoveis(ListaAutomoveis lauto, ListaModelo lmodelo) {
        Path path = Paths.get("automoveis.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                String placa = sc.next();
                int ano = Integer.parseInt(sc.next());
                double valorDiaria = Double.parseDouble(sc.next());
                String nomeModelo = sc.next();
                String tipoAuto = sc.next();

                if(tipoAuto.equals("T"))
                {
                    Automovel auto = new Automovel(placa, ano, valorDiaria, lmodelo.pesquisaModelo(nomeModelo),true);
                    lauto.insere(auto);
                }
                if(tipoAuto.equals("F"))
                {
                    Automovel auto = new Automovel(placa, ano, valorDiaria, lmodelo.pesquisaModelo(nomeModelo),false);
                    lauto.insere(auto);
                }

                //System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void leRegistrosTextoLocacoes(ListaLocacoes llocacoes, ListaClientes lcli, ListaAutomoveis lauto) {
        Path path = Paths.get("teste2.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // separador: ;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                String placa = sc.next();
                String cpfcnpj = sc.next();
                String dataIni = sc.next();
                String dataFim = sc.next();
                double valorLocacao = Double.parseDouble(sc.next());

                if(lcli.pesquisaClientePorCpf(cpfcnpj) instanceof PessoaFisica)
                {
                    Locacao pf = new Locacao(lcli.pesquisaClientePorCpf(cpfcnpj), lauto.pesquisaAutomovel(placa), dataIni, dataFim);
                    llocacoes.insere(pf);
                }
                if(lcli.pesquisaClientePorCpf(cpfcnpj) instanceof PessoaJuridica)
                {
                    Locacao pj = new Locacao(lcli.pesquisaClientePorCpf(cpfcnpj), lauto.pesquisaAutomovel(placa), dataIni, dataFim);
                    llocacoes.insere(pj);
                }

                // System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }


}
