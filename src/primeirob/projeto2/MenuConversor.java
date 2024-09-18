package primeirob.projeto2;

import java.util.Scanner;

public class MenuConversor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] - Converter número para romano");
            System.out.println("[2] - Converter moedas");
            System.out.println("[3] - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um número inteiro (1-3999): ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        String romano = ConversorRomanos.converterParaRomano(numero);
                        System.out.println("Número Romano: " + romano);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Digite o valor a ser convertido: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Digite a moeda de origem (USD, EUR, JPY, GBP, BRL): ");
                    String moedaOrigem = scanner.nextLine().toUpperCase();
                    System.out.print("Digite a moeda de destino (USD, EUR, JPY, GBP, BRL): ");
                    String moedaDestino = scanner.nextLine().toUpperCase();
                    try {
                        double valorConvertido = ConversorMoeda.converterMoeda(valor, moedaOrigem, moedaDestino);
                        System.out.println("Valor convertido: " + valorConvertido + " " + moedaDestino);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
