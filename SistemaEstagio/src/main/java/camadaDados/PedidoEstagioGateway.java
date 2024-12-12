package camadaDados;

import entidades.ResultSet.Tabela;
import entidades.ResultSet.ResultSet;
import entidades.ResultSet.Linha;

public class PedidoEstagioGateway {

    private final ResultSet resultSet;

    // Construtor
    public PedidoEstagioGateway(ResultSet resultSet) {
        if (resultSet == null) {
            throw new IllegalArgumentException("O ResultSet não pode ser nulo.");
        }
        this.resultSet = resultSet;
    }

    // Busca um pedido de estágio pelo número do pedido
    public Linha buscarPedido(int numeroPedido) {
        Tabela tabela = resultSet.getTabela("PedidoEstagio");
        if (tabela != null) {
            return tabela.buscarLinhaPorValor("numeroPedido", numeroPedido);
        }
        return null;
    }

    // Valida se um pedido de estágio existe e está ativo
    public boolean validarPedido(int numeroPedido) {
        Linha pedido = buscarPedido(numeroPedido);
        return pedido != null;
    }

    // Insere um novo pedido de estágio
    public boolean inserirPedido(Linha novoPedido) {
        if (novoPedido == null) {
            throw new IllegalArgumentException("O pedido de estágio não pode ser nulo.");
        }
        
        Tabela tabela = resultSet.getTabela("PedidoEstagio");
        if (tabela != null) {
            // Verifica se o pedido já existe antes de inserir
            if (tabela.buscarLinhaPorValor("numeroPedido", novoPedido.getValor("numeroPedido")) != null) {
                System.out.println("Já existe um pedido com este número.");
                return false;
            }
            tabela.inserirLinha(novoPedido);
            return true;
        }
        return false;
    }
}
