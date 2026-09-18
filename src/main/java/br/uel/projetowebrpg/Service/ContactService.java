package br.uel.projetowebrpg.Service;

import br.uel.projetowebrpg.Model.Contact;
import br.uel.projetowebrpg.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listarContatos(){
        return contactRepository.findAll();
    }

    public Contact buscarContato(Long id){
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato com id " + id + " não encontrado"));
    }

    public void adicionarContato(Contact c){
        contactRepository.save(c);
    }

    public void removerContato(Long id){
        if(!contactRepository.existsById(id)){
            throw new RuntimeException("Contato com id " + id + " não encontrado");
        }

        else{
            contactRepository.deleteById(id);
        }
    }

    public void atualizarContato(Long id, Contact contato_atualizado) {
        contactRepository.findById(id)
                .map(c -> {
                    c.setNome(contato_atualizado.getNome());
                    c.setTelefone(contato_atualizado.getTelefone());
                    c.setEmail(contato_atualizado.getEmail());
                    c.setEndereco(contato_atualizado.getEndereco());
                    c.setDataNascimento(contato_atualizado.getDataNascimento());
                    return contactRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Contato com id " + id + " não encontrado"));
    }

}
