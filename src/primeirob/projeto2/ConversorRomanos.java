package primeirob.projeto2;

public class ConversorRomanos {

    public static String converterParaRomano(int numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("Número fora do intervalo (1-3999)");
        }

        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romano = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                romano.append(simbolos[i]);
                numero -= valores[i];
            }
        }

        return romano.toString();
    }
}
