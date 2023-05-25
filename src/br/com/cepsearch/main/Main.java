package br.com.cepsearch.main;

import br.com.cepsearch.classes.Cep;
import br.com.cepsearch.classes.CepViaCep;
import br.com.cepsearch.methods.NetClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String cep = " ";
        List<Cep> cepList = new ArrayList<>();

        while (!cep.equalsIgnoreCase("sair")) {
            try {
                System.out.println("Digite o CEP Desejado:");
                System.out.println("(Caso deseje fechar o programa, digite Sair)");
                cep = scanner.next().replace("-", "");
                if (cep.equalsIgnoreCase("sair")) {
                    break;
                }
                NetClient netClient = new NetClient(cep);
                String json = netClient.returnJson();
                CepViaCep newCep = gson.fromJson(json, CepViaCep.class);
                Cep choosedCep = new Cep(newCep);
                choosedCep.showCepDetails();
                cepList.add(choosedCep);
            } catch (JsonSyntaxException exception) {
                System.out.println("Por favor, digite um CEP Válido!!");
            }
        }
        FileWriter writer = new FileWriter("DocsExit/Cep.json");
        writer.write(gson.toJson(cepList));
        writer.close();
        System.out.println("Obrigado por usar o CepSearch!!!");

    }
}
