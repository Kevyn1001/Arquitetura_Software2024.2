package entidades;

import entidades.ResultSet.Tabela;

public class PedidoEstagio extends Tabela {
    private int numeroPedido;
    private String nomeEmpresa;
    private String enderecoEmpresa;
    private String modalidade;
    private int cargaHorariaSemanal;
    private double valorBolsa;
    private String resumoAtividades;
    private String relacaoConteudos;
    private String motivo;

    public PedidoEstagio(int numeroPedido, String nomeEmpresa, String enderecoEmpresa, String modalidade,
                         int cargaHorariaSemanal, double valorBolsa, String resumoAtividades, 
                         String relacaoConteudos, String motivo) {
        this.numeroPedido = numeroPedido;
        this.nomeEmpresa = nomeEmpresa;
        this.enderecoEmpresa = enderecoEmpresa;
        this.modalidade = modalidade;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.valorBolsa = valorBolsa;
        this.resumoAtividades = resumoAtividades;
        this.relacaoConteudos = relacaoConteudos;
        this.motivo = motivo;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            PedidoEstagio other = (PedidoEstagio) obj;
            return this.numeroPedido == other.numeroPedido;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "PedidoEstagio [numeroPedido=" + numeroPedido + ", nomeEmpresa=" + nomeEmpresa + "]";
    }
    
 // Getters e Setters
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
}
