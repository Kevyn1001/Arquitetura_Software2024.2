package entidades.ResultSet;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Linha {
    private final Map<String, Object> dados;
    private List<Coluna> colunas;

    // Construtor
    public Linha() {
        this.dados = new HashMap<>();
    }
    
    // Método para obter a lista de colunas
    public List<Coluna> getColunas() {
        return colunas;
    }
    
    //Método para adicionar uma coluna à linha
    public void adicionarColuna(Coluna coluna) {
        if (coluna != null) {
            colunas.add(coluna);
        }
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

    public Object getValor(String nomeColuna) {
        for (Coluna coluna : colunas) {
            if (coluna.getNome().equalsIgnoreCase(nomeColuna)) {
                return coluna.getValor();
            }
        }
        return null; // Retorna null se a coluna não for encontrada
    }

}
