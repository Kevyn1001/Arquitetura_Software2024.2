package camadaDominio;

import entidades.SupervisorDTO;

import java.util.ArrayList;
import java.util.List;

public class SupervisorRT {

    // Simula um repositório ou banco de dados em memória
    private List<SupervisorDTO> supervisores;

    public SupervisorRT() {
        this.supervisores = new ArrayList<>();
    }

    // Método para criar um supervisor
    public boolean criarSupervisor(SupervisorDTO supervisor) {
        if (supervisor == null || supervisor.getEmail() == null || supervisor.getEmail().isEmpty()) {
            System.out.println("Dados do supervisor são inválidos.");
            return false;
        }

        // Verifica se já existe um supervisor com o mesmo email
        for (SupervisorDTO s : supervisores) {
            if (s.getEmail().equals(supervisor.getEmail())) {
                System.out.println("Supervisor já cadastrado com este email: " + supervisor.getEmail());
                return false;
            }
        }

        supervisores.add(supervisor);
        System.out.println("Supervisor criado com sucesso!");
        return true;
    }

    // Método para buscar um supervisor por email
    public SupervisorDTO buscarSupervisor(String email) {
        for (SupervisorDTO supervisor : supervisores) {
            if (supervisor.getEmail().equals(email)) {
                return supervisor;
            }
        }
        System.out.println("Supervisor não encontrado para o email: " + email);
        return null;
    }

    // Método para listar todos os supervisores
    public List<SupervisorDTO> listarSupervisores() {
        return new ArrayList<>(supervisores); // Retorna uma cópia para evitar mutações externas
    }

    // Método para atualizar os dados de um supervisor
    public boolean atualizarSupervisor(String email, SupervisorDTO novosDados) {
        SupervisorDTO supervisorExistente = buscarSupervisor(email);
        if (supervisorExistente != null) {
            supervisorExistente.setNome(novosDados.getNome());
            supervisorExistente.setFuncao(novosDados.getFuncao());
            supervisorExistente.setNomeEmpresa(novosDados.getNomeEmpresa());
            supervisorExistente.setCnpj(novosDados.getCnpj());
            supervisorExistente.setTelefone(novosDados.getTelefone());
            supervisorExistente.setNumeroPedidoEstagio(novosDados.getNumeroPedidoEstagio());
            System.out.println("Supervisor atualizado com sucesso!");
            return true;
        }
        System.out.println("Supervisor não encontrado para atualização.");
        return false;
    }

    // Método para remover um supervisor por email
    public boolean removerSupervisor(String email) {
        SupervisorDTO supervisor = buscarSupervisor(email);
        if (supervisor != null) {
            supervisores.remove(supervisor);
            System.out.println("Supervisor removido com sucesso!");
            return true;
        }
        System.out.println("Supervisor não encontrado para remoção.");
        return false;
    }
}
