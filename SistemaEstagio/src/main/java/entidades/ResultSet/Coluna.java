package entidades.ResultSet;

public class Coluna {
    private String nome;
    private Class<?> tipo;

    // Construtor
    public Coluna(String nome, Class<?> tipo) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome da coluna não pode ser nulo ou vazio.");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo da coluna não pode ser nulo.");
        }
        this.nome = nome;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome da coluna não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public Class<?> getTipo() {
        return tipo;
    }

    public void setTipo(Class<?> tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo da coluna não pode ser nulo.");
        }
        this.tipo = tipo;
    }

    // Representação da coluna (útil para depuração)
    @Override
    public String toString() {
        return "Coluna{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo.getSimpleName() +
                '}';
    }
}
