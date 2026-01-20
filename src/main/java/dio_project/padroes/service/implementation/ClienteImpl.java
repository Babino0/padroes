package dio_project.padroes.service.implementation;

import dio_project.padroes.model.Cliente;
import dio_project.padroes.model.ClienteRepository;
import dio_project.padroes.model.Endereco;
import dio_project.padroes.model.EnderecoRepository;
import dio_project.padroes.service.ClienteService;
import dio_project.padroes.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cliente não encontrado"));
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarPorCep(cliente);
        clienteRepository.save(cliente);
    }


    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

        Optional<Cliente> clienteExiste = clienteRepository.findById(id);
        if (clienteExiste.isPresent()) {
            salvarPorCep(cliente);
        }

    }

    private void salvarPorCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep)
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });

        // 🔥 ISSO É O QUE FALTAVA
        cliente.setEndereco(endereco);
    }
}




