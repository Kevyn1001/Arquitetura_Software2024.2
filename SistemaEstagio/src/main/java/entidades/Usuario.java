package entidades;

import entidades.ResultSet.Tabela;

public class Usuario extends Tabela {
    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Usuario other = (Usuario) obj;
            return this.email.equals(other.email);
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario [email=" + email + "]";
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

}
