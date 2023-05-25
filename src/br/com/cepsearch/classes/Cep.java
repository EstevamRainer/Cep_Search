package br.com.cepsearch.classes;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.valueOf;

public class Cep {
    private int cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String estado;
    private int ddd;
    public Cep(CepViaCep cep){
        this.cep = Integer.parseInt(cep.cep().replace("-", ""));
        this.logradouro = cep.logradouro();
        this.complemento = cep.complemento();
        this.bairro = cep.bairro();
        this.localidade = cep.localidade();
        this.estado = cep.uf();
        this.ddd = Integer.parseInt(cep.ddd());
    }

    public void showCepDetails (){
        System.out.println("A Cidade com o CEP " + cep + " é " + localidade + ".");
        System.out.println("O Bairro é " + bairro + ", com o Logradouro: " + logradouro + ".");
        if (complemento.equals("")){
            System.out.println("Esse CEP não possúi complemento!");
        } else {
            System.out.println("Esse CEP também contém o seguinte complemento: " + complemento + ".");
        }
        System.out.println("O estado é " + estado + ", com o DDD " + ddd + ".");
    }

    @Override
    public String toString() {
        return "(Cep = " + cep + ". Cidade = " + localidade + ")";
    }
}
