package entidades.ResultSet;

public class Coluna {
    private String nome;
    private Object valor; // Valor associado à coluna
    private Class<?> tipo; // Tipo do valor da coluna

    // Construtor
    public Coluna(String nome, Class<?> tipo, Object valor) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome da coluna não pode ser nulo ou vazio.");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo da coluna não pode ser nulo.");
        }
        if (valor != null && !tipo.isInstance(valor)) {
            throw new IllegalArgumentException("O valor não corresponde ao tipo especificado.");
        }
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
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

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        if (valor != null && !tipo.isInstance(valor)) {
            throw new IllegalArgumentException("O valor não corresponde ao tipo especificado.");
        }
        this.valor = valor;
    }

    // Representação da coluna (útil para depuração)
    @Override
    public String toString() {
        return "Coluna{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", tipo=" + tipo.getSimpleName() +
                '}';
    }
}
