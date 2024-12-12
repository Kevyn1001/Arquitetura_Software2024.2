package camadaDominio;

import entidades.PedidoEstagioDTO;

import java.util.ArrayList;
import java.util.List;

public class PedidoEstagioRT {

    // Simula um repositório ou banco de dados em memória
    private List<PedidoEstagioDTO> pedidosEstagio;

    public PedidoEstagioRT() {
        this.pedidosEstagio = new ArrayList<>();
    }

    // Método para criar um pedido de estágio
    public boolean criarPedidoEstagio(PedidoEstagioDTO pedido) {
        if (pedido == null || pedido.getNumeroPedido() <= 0 || pedido.getNomeEmpresa() == null) {
            System.out.println("Dados do pedido de estágio são inválidos.");
            return false;
        }
        // Verifica se já existe um pedido com o mesmo número
        for (PedidoEstagioDTO p : pedidosEstagio) {
            if (p.getNumeroPedido() == pedido.getNumeroPedido()) {
                System.out.println("Pedido de estágio já existe com este número: " + pedido.getNumeroPedido());
                return false;
            }
        }
        pedidosEstagio.add(pedido);
        System.out.println("Pedido de estágio criado com sucesso!");
        return true;
    }

    // Método para buscar um pedido de estágio por número
    public PedidoEstagioDTO buscarPedidoEstagio(int numeroPedido) {
        for (PedidoEstagioDTO pedido : pedidosEstagio) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        System.out.println("Pedido de estágio não encontrado para o número: " + numeroPedido);
        return null;
    }

    // Método para listar todos os pedidos de estágio
    public List<PedidoEstagioDTO> listarPedidosEstagio() {
        return new ArrayList<>(pedidosEstagio); // Retorna uma cópia para evitar mutações externas
    }

    // Método para remover um pedido de estágio pelo número
    public boolean removerPedidoEstagio(int numeroPedido) {
        PedidoEstagioDTO pedido = buscarPedidoEstagio(numeroPedido);
        if (pedido != null) {
            pedidosEstagio.remove(pedido);
            System.out.println("Pedido de estágio removido com sucesso!");
            return true;
        }
        System.out.println("Pedido de estágio não encontrado para remoção.");
        return false;
    }
}
