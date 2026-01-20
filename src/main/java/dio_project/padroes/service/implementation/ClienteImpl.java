package dio_project.padroes.service.implementation;

import dio_project.padroes.model.Cliente;
import dio_project.padroes.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteImpl implements ClienteService {
    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void Atualizar(Long id) {

    }
}
