package entidades;

public class SupervisorDTO {
    private String nome;
    private String funcao;
    private String nomeEmpresa;
    private String cnpj;
    private String email;
    private String senha; // Idealmente, gerenciar senhas de forma segura
    private String telefone;
    private int numeroPedidoEstagio;

    // Construtor
    public SupervisorDTO(String nome, String funcao, String nomeEmpresa, String cnpj,
                         String email, String senha, String telefone, int numeroPedidoEstagio) {
        this.nome = nome;
        this.funcao = funcao;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.numeroPedidoEstagio = numeroPedidoEstagio;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNumeroPedidoEstagio() {
        return numeroPedidoEstagio;
    }

    public void setNumeroPedidoEstagio(int numeroPedidoEstagio) {
        this.numeroPedidoEstagio = numeroPedidoEstagio;
    }

    // Override do método toString
    @Override
    public String toString() {
        return "SupervisorDTO [nome=" + nome + ", funcao=" + funcao + ", nomeEmpresa=" + nomeEmpresa 
                + ", email=" + email + ", numeroPedidoEstagio=" + numeroPedidoEstagio + "]";
    }
}
