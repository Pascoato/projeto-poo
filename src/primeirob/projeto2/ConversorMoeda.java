package primeirob.projeto2;

import java.util.HashMap;
import java.util.Map;

public class ConversorMoeda {

    private static final Map<String, Double> TAXAS_CAMBIO = new HashMap<>();

    static {
        TAXAS_CAMBIO.put("USD", 1.0);
        TAXAS_CAMBIO.put("EUR", 0.93);
        TAXAS_CAMBIO.put("JPY", 134.0);
        TAXAS_CAMBIO.put("GBP", 0.81);
        TAXAS_CAMBIO.put("BRL", 5.19);
    }

    public static double converterMoeda(double valor, String moedaOrigem, String moedaDestino) {
        if (!TAXAS_CAMBIO.containsKey(moedaOrigem) || !TAXAS_CAMBIO.containsKey(moedaDestino)) {
            throw new IllegalArgumentException("Moeda desconhecida");
        }

        double taxaOrigem = TAXAS_CAMBIO.get(moedaOrigem);
        double taxaDestino = TAXAS_CAMBIO.get(moedaDestino);

        double valorEmUSD = valor / taxaOrigem;
        return valorEmUSD * taxaDestino;
    }
}
