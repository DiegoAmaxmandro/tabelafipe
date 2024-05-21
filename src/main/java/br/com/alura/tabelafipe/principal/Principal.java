package br.com.alura.tabelafipe.principal;

import br.com.alura.tabelafipe.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private  final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibirMenu(){
        var menu = """
                *** OPCOES ***
                Carro
                Moto
                Caminhao
                
                Digite uma das opcoes acima para consultar:
                """;
        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        }else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

    }
}
