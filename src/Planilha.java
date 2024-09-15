import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Planilha {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Informe o número de colunas: ");
        int numeroDeColunas = Integer.parseInt(scanner.nextLine());
        
        List<String> colunas = new ArrayList<>();
        for (int i = 0; i < numeroDeColunas; i++) {
            System.out.println("Informe o nome da coluna " + (i+1) + ": ");
            colunas.add(scanner.nextLine());
        }
        
        System.out.println("Informe o número de linhas de dados: ");
        int numeroDeLinhas = Integer.parseInt(scanner.nextLine());
        
        List<List<String>> dados = new ArrayList<>();
        for (int i = 0; i < numeroDeLinhas; i++) {
            List<String> linha = new ArrayList<>();
            System.out.println("Informe os dados da linha " + (i+1) + ":");
            for (int j = 0; j < numeroDeColunas; j++) {
                System.out.println("Informe o dado para a coluna " + colunas.get(j) + ": ");
                linha.add(scanner.nextLine());
            }
            dados.add(linha);
        }
        
        String nomeDoArquivo = "saida.csv";
        try (FileWriter writer = new FileWriter(nomeDoArquivo)) {
            // Escreve as colunas no arquivo
            writer.append(String.join(",", colunas));
            writer.append("\n");
            
            for (List<String> linha : dados) {
                writer.append(String.join(",", linha));
                writer.append("\n");
            }
            
            System.out.println("Arquivo CSV '" + nomeDoArquivo + "' gerado com sucesso!");
            
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo CSV: " + e.getMessage());
        }
    }
}
