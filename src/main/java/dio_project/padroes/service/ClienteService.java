package dio_project.padroes.service;

import dio_project.padroes.model.Cliente;
import dio_project.padroes.model.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ClienteService{
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void deletar(Long id);
    void Atualizar(Long id);

    
}
