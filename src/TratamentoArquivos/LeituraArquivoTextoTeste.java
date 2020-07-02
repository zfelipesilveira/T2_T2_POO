package TratamentoArquivos;


import Teste.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LeituraArquivoTextoTeste {

    public void leLinhasTexto() {
        Path path1 = Paths.get("teste1.txt");
        try (BufferedReader reader = Files.newBufferedReader(path1,
                Charset.defaultCharset())) {
            String line = null;
            int numLinha = 0;
            while ((line = reader.readLine()) != null) {
                numLinha++;
                System.out.println("Linha " + numLinha + ": " + line);
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }

    }

    public void leRegistrosTexto() {

        Path path = Paths.get("teste2.txt");
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            String pal = null;
            sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
            while (sc.hasNext()) {
                pal = sc.next();
                System.out.println(pal);
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

    public void leRegistrosTextoCarga(ListaCategoria lcat, ListaMarcas lmar, ListaModelo lmod, ListaAutomoveis la, ListaClientes lcli, PilhaPedidos pp) {
        int contComentarios = 0;
        String secao = "";
        Path path = Paths.get("carga.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = null;
            while ((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha).useDelimiter(";");
                if(linha.startsWith("/")) contComentarios++;
                if(linha.startsWith("[")) secao = linha.substring(1,linha.length()-1);
                if(secao.equals("CATEGORIA"))
                    if (!linha.startsWith("/") && !linha.startsWith("[") ) {
                        String codCat = sc.next();
                        String nomeCat = sc.next();
                        CategoriaAutomovel cat = new CategoriaAutomovel(nomeCat);
                        lcat.insere(cat);
                        System.out.println("Cadastrando categorias...");

                    }
                if(secao.equals("MARCA"))
                    if (!linha.startsWith("/") && !linha.startsWith("[")){
                        String codMar = sc.next();
                        String nomeMar = sc.next();
                        MarcaAutomovel mar = new MarcaAutomovel(nomeMar);
                        lmar.insere(mar);
                        System.out.println("Cadastrando marcas...");

                        //System.out.println(sc.next());

                    }
                if(secao.equals("MODELO"))
                    if (!linha.startsWith("/") && !linha.startsWith("[")){
                        String codMod = sc.next();
                        String nomeMod = sc.next();
                        double valorMod = Double.parseDouble(sc.next());
                        String nomeCat = sc.next();
                        String nomeMar = sc.next();
                        String tipoMod = sc.next();
                        Double ipiTaxa = Double.parseDouble(sc.next());
                        if(tipoMod.equals("N")){
                            ModeloNacional modn = new ModeloNacional(nomeMod,lmar.pesquisaMarca(nomeMar),
                                    lcat.pesquisaCategoria(nomeCat),valorMod,ipiTaxa);
                            lmod.insere(modn);
                        }
                        if(tipoMod.equals("I")){
                            ModeloImportado modi = new ModeloImportado(nomeMod,lmar.pesquisaMarca(nomeMar),
                                    lcat.pesquisaCategoria(nomeCat),valorMod,ipiTaxa);
                            lmod.insere(modi);
                        }
                        System.out.println("Cadastrando modelos...");

//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
                    }
                if(secao.equals("AUTOMOVEL"))
                    if (!linha.startsWith("/") && !linha.startsWith("[")){
                        String placa = sc.next();
                        String nomeMod = sc.next();
                        int ano = Integer.parseInt(sc.next());
                        Double valorDiaria = Double.parseDouble(sc.next());
                        String dispString = sc.next();
                        boolean dispBoolean;
                        if(dispString.equalsIgnoreCase("T")) dispBoolean = true;
                        if(dispString.equalsIgnoreCase("F")) dispBoolean = false;
                        Automovel auto = new Automovel(placa,ano,valorDiaria,lmod.pesquisaModelo(nomeMod));
                        la.insere(auto);
                        System.out.println("Cadastrando automóveis...");

//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
                    }
                if(secao.equals("CLIENTE"))
                    if (!linha.startsWith("/") && !linha.startsWith("[")) {
                        String cpfcnpj = sc.next();
                        String nome = sc.next();
                        String tel = sc.next();
                        String tipo = sc.next();
                        if (tipo.equalsIgnoreCase("F")) {
                            PessoaFisica pf = new PessoaFisica(nome, tel, cpfcnpj);
                            lcli.insere(pf);
                        }
                        if (tipo.equalsIgnoreCase("J")) {
                            PessoaJuridica pj = new PessoaJuridica(nome, tel, cpfcnpj);
                            lcli.insere(pj);
                        }
                        System.out.println("Cadastrando clientes...");
                    }
                if(secao.equals("PEDIDO"))
                    if (!linha.startsWith("/") && !linha.startsWith("[")){
                        String codPedido = sc.next();
                        String cpfcnpjped = sc.next();
                        String nomeCategoria = sc.next();
                        String dataInicio = sc.next();
                        String dataFim = sc.next();
                        Pedido ped = new Pedido(codPedido,cpfcnpjped,lcat.pesquisaCategoria(nomeCategoria),dataInicio, dataFim);
                        //System.out.println(ped.toString());
                        pp.insere(ped);
                        System.out.println("Cadastrando pedidos" + "\n");

                    }



//                        System.out.println(sc.next());
//                        System.out.println(sc.next());
//                        System.out.println(sc.next());




                //System.out.println(secao);
//                Scanner sc = new Scanner(linha).useDelimiter(";");
//                System.out.println(sc.next()+"; "+sc.next()+"; "+ sc.next());
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }

//    public static void main(String args[]) {
//        LeituraArquivoTextoTeste exemplo = new LeituraArquivoTextoTeste();
////        exemplo.leLinhasTexto();
////        System.out.println("------");
////        exemplo.leRegistrosTexto();
////        System.out.println("------");
//        //exemplo.leRegistrosTexto2();
//    }

}
