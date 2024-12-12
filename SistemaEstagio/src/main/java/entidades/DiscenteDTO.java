package entidades;

public class DiscenteDTO {
    private String email;
    private String senha;
    private String nome;
    private String matricula;
    private String telefone;
    private double ira;
    private int cargaHorariaObrigatoriaCumprida;

    // Construtor
    public DiscenteDTO(String email, String senha, String nome, String matricula, 
                       String telefone, double ira, int cargaHorariaObrigatoriaCumprida) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.ira = ira;
        this.cargaHorariaObrigatoriaCumprida = cargaHorariaObrigatoriaCumprida;
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public int getCargaHorariaObrigatoriaCumprida() {
        return cargaHorariaObrigatoriaCumprida;
    }

    public void setCargaHorariaObrigatoriaCumprida(int cargaHorariaObrigatoriaCumprida) {
        this.cargaHorariaObrigatoriaCumprida = cargaHorariaObrigatoriaCumprida;
    }

    // Override do método toString
    @Override
    public String toString() {
        return "DiscenteDTO [nome=" + nome + ", matricula=" + matricula + ", ira=" + ira + "]";
    }
}
