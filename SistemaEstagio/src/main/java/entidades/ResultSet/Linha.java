package entidades.ResultSet;

import java.util.HashMap;
import java.util.Map;

public class Linha {
    private final Map<String, Object> dados;

    // Construtor
    public Linha() {
        this.dados = new HashMap<>();
    }

    // Adiciona um dado na linha
    public void adicionarDado(String coluna, Object valor) {
        if (coluna == null || coluna.isEmpty()) {
            throw new IllegalArgumentException("O nome da coluna não pode ser nulo ou vazio.");
        }
        dados.put(coluna, valor);
    }

    // Obtém o valor de uma coluna
    public Object get(String coluna) {
        if (!dados.containsKey(coluna)) {
            throw new IllegalArgumentException("A coluna '" + coluna + "' não existe na linha.");
        }
        return dados.get(coluna);
    }

    // Remove um dado da linha
    public void removerDado(String coluna) {
        dados.remove(coluna);
    }

    // Verifica se a linha contém uma coluna específica
    public boolean contemColuna(String coluna) {
        return dados.containsKey(coluna);
    }

    // Representação da linha (útil para depuração)
    @Override
    public String toString() {
        return "Linha{" +
                "dados=" + dados +
                '}';
    }
}
