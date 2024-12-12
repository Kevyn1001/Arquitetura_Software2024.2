package entidades;

import entidades.ResultSet.Tabela;

public class Discente extends Usuario {
    private String nome;
    private String matricula;
    private String telefone;
    private double ira;
    private int cargaHorariaObrigatoriaCumprida;

    public Discente(String email, String senha, String nome, String matricula, 
                    String telefone, double ira, int cargaHorariaObrigatoriaCumprida) {
    	super(email, senha);
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.ira = ira;
        this.cargaHorariaObrigatoriaCumprida = cargaHorariaObrigatoriaCumprida;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Discente other = (Discente) obj;
            return this.matricula.equals(other.matricula);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Discente [nome=" + nome + ", matricula=" + matricula + "]";
    }
    
 // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
