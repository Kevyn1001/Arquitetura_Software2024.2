package camadaDados;

import entidades.ResultSet.Tabela;
import entidades.ResultSet.ResultSet;
import entidades.ResultSet.Linha;
import entidades.SupervisorDTO;

public class SupervisorGateway {

    private final ResultSet resultSet;

    // Construtor
    public SupervisorGateway(ResultSet resultSet) {
        if (resultSet == null) {
            throw new IllegalArgumentException("O ResultSet não pode ser nulo.");
        }
        this.resultSet = resultSet;
    }

    // Busca um supervisor pelo número do pedido de estágio
    public Linha buscarSupervisorPorPedido(int numeroPedidoEstagio) {
        Tabela tabela = resultSet.getTabela("Supervisor");
        if (tabela != null) {
            // Busca a linha que contém o número do pedido de estágio
            return tabela.buscarLinhaPorValor("numeroPedidoEstagio", numeroPedidoEstagio);
        }
        return null;
    }

    // Insere um novo supervisor na tabela
    public boolean inserirSupervisor(Linha novoSupervisor) {
        if (novoSupervisor == null) {
            throw new IllegalArgumentException("O supervisor não pode ser nulo.");
        }

        Tabela tabela = resultSet.getTabela("Supervisor");
        if (tabela != null) {
            // Verifica se o supervisor já existe baseado no email
            if (tabela.buscarLinhaPorValor("email", novoSupervisor.getValor("email")) != null) {
                System.out.println("Já existe um supervisor com este email.");
                return false;
            }
            tabela.inserirLinha(novoSupervisor);
            return true;
        }
        return false;
    }

    // Verifica se um supervisor já está vinculado a um pedido
    public boolean verificarSupervisorAssociado(int numeroPedidoEstagio) {
        return buscarSupervisorPorPedido(numeroPedidoEstagio) != null;
    }
}
