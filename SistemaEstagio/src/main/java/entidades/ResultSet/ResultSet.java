package entidades.ResultSet;

import java.util.HashMap;
import java.util.Map;

public class ResultSet {
    private final Map<String, Tabela> tabelas;

    // Construtor
    public ResultSet() {
        this.tabelas = new HashMap<>();
    }

    // Adiciona uma tabela ao ResultSet
    public void addTabela(String nome, Tabela tabela) {
        if (nome == null || tabela == null) {
            throw new IllegalArgumentException("Nome ou tabela não podem ser nulos.");
        }
        this.tabelas.put(nome, tabela);
    }

    // Verifica se o ResultSet está vazio
    public boolean isEmpty() {
        return this.tabelas.isEmpty();
    }

    // Obtém uma tabela pelo nome
    public Tabela getTabela(String nome) {
        Tabela tabela = this.tabelas.get(nome);
        if (tabela == null) {
            throw new IllegalArgumentException("Tabela com o nome '" + nome + "' não encontrada.");
        }
        return tabela;
    }

    // Remove uma tabela pelo nome
    public void removerTabela(String nome) {
        this.tabelas.remove(nome);
    }

    // Verifica se uma tabela existe no ResultSet
    public boolean contemTabela(String nome) {
        return this.tabelas.containsKey(nome);
    }

    // Obtém o número total de tabelas no ResultSet
    public int tamanho() {
        return this.tabelas.size();
    }

    // Busca uma linha específica em uma tabela com base no índice
    public Linha buscarLinhaNaTabela(String nomeTabela, int numeroLinha) {
        Tabela tabela = getTabela(nomeTabela);
        return tabela.getLinha(numeroLinha);
    }

    // Insere uma nova linha em uma tabela específica
    public void inserirLinhaNaTabela(String nomeTabela, Linha linha) {
        Tabela tabela = getTabela(nomeTabela);
        tabela.inserirLinha(linha);
    }

    // Representação do ResultSet (útil para depuração)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResultSet:\n");
        for (Map.Entry<String, Tabela> entry : tabelas.entrySet()) {
            sb.append("Tabela: ").append(entry.getKey()).append("\n")
              .append(entry.getValue().toString()).append("\n");
        }
        return sb.toString();
    }
}
