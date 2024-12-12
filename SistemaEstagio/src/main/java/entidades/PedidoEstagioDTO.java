package entidades;

public class PedidoEstagioDTO {
    private int numeroPedido;
    private String nomeEmpresa;
    private String enderecoEmpresa;
    private String modalidade;
    private int cargaHorariaSemanal;
    private double valorBolsa;
    private String resumoAtividades;
    private String relacaoConteudos;
    private String motivo;

    // Construtor
    public PedidoEstagioDTO(int numeroPedido, String nomeEmpresa, String enderecoEmpresa, String modalidade,
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

    public String getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public String getResumoAtividades() {
        return resumoAtividades;
    }

    public void setResumoAtividades(String resumoAtividades) {
        this.resumoAtividades = resumoAtividades;
    }

    public String getRelacaoConteudos() {
        return relacaoConteudos;
    }

    public void setRelacaoConteudos(String relacaoConteudos) {
        this.relacaoConteudos = relacaoConteudos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    // Override do método toString
    @Override
    public String toString() {
        return "PedidoEstagioDTO [numeroPedido=" + numeroPedido + ", nomeEmpresa=" + nomeEmpresa + "]";
    }
}
