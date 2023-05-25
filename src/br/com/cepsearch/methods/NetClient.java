package br.com.cepsearch.methods;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.valueOf;

public class NetClient {
    private String cep;
    public NetClient(String cep) {
        this.cep = cep;
    }
    public String returnJson() throws IOException, InterruptedException {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        HttpClient client = HttpClient
                .newBuilder()
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
