package camadaDados;

import entidades.ResultSet.Tabela;
import entidades.ResultSet.ResultSet;
import entidades.Supervisor;

public class SupervisorGateway {

    private final ResultSet resultSet;

    // Construtor
    public SupervisorGateway(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    // Busca um supervisor pelo número do pedido de estágio
    public Tabela buscarSupervisorPorPedido(int numeroPedidoEstagio) {
        Tabela tabela = resultSet.getTabela("Supervisor");
        if (tabela != null) {
            for (Tabela linha : tabela.getLinhas()) {
                int numeroPedido = (int) linha.get("numeroPedidoEstagio");
                if (numeroPedido == numeroPedidoEstagio) {
                    return linha;
                }
            }
        }
        return null;
    }

    // Insere um novo supervisor na tabela
    public boolean inserirSupervisor(Supervisor supervisor) {
        Tabela tabela = resultSet.getTabela("Supervisor");
        if (tabela != null) {
            tabela.inserirLinha(supervisor);
            return true;
        }
        return false;
    }

    // Verifica se um supervisor já está vinculado a um pedido
    public boolean verificarSupervisorAssociado(int numeroPedidoEstagio) {
        return buscarSupervisorPorPedido(numeroPedidoEstagio) != null;
    }
}
