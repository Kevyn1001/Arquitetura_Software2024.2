package camadaDados;

import entidades.ResultSet.Tabela;
import entidades.ResultSet.ResultSet;

public class PedidoEstagioGateway {

    private final ResultSet resultSet;

    // Construtor
    public PedidoEstagioGateway(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    //Busca um pedido de estágio pelo número do pedido
    public Linha buscarPedido(int numeroPedido) {
        Tabela tabela = resultSet.getTabela("PedidoEstagio");
        if (tabela != null) {
            return tabela.buscarLinhaPorValor("numeroPedido", numeroPedido);
        }
        return null;
    }

    //Valida se um pedido de estágio existe e está ativo
    public boolean validarPedido(int numeroPedido) {
        return buscarPedido(numeroPedido) != null;
    }

    //Insere um novo pedido de estágio
    public boolean inserirPedido(Linha novoPedido) {
        Tabela tabela = resultSet.getTabela("PedidoEstagio");
        if (tabela != null) {
            tabela.inserirLinha(novoPedido);
            return true;
        }
        return false;
    }
}
