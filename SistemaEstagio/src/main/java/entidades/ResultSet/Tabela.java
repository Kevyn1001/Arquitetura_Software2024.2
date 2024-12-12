package entidades.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class Tabela {
    private String nome; // Nome da tabela
    private List<Coluna> colunas; // Lista de colunas
    private List<Linha> linhas;   // Lista de linhas

    // Construtor
    public Tabela(String nome) {
        this.nome = nome;
        this.colunas = new ArrayList<>();
        this.linhas = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Coluna> getColunas() {
        return colunas;
    }

    public List<Linha> getLinhas() {
        return linhas;
    }

    // Adiciona uma coluna à tabela
    public void adicionarColuna(Coluna coluna) {
        colunas.add(coluna);
    }

    // Adiciona uma linha à tabela
    public void inserirLinha(Linha linha) {
        if (linha != null) {
            linhas.add(linha);
        }
    }

    // Busca uma linha pelo índice (número do pedido, por exemplo)
    public Linha getLinha(int index) {
        if (index >= 0 && index < linhas.size()) {
            return linhas.get(index);
        }
        return null;
    }

    // Remove uma linha pelo índice
    public void removerLinha(int index) {
        if (index >= 0 && index < linhas.size()) {
            linhas.remove(index);
        }
    }

    // Representação da tabela (útil para depuração)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tabela: ").append(nome).append("\n");
        sb.append("Colunas: ").append(colunas).append("\n");
        sb.append("Linhas: ").append(linhas).append("\n");
        return sb.toString();
    }
}
