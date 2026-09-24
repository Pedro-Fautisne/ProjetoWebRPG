package br.uel.projetowebrpg.Service;

import br.uel.projetowebrpg.Model.Habilidade;
import br.uel.projetowebrpg.Repository.HabilidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabilidadeService {
    @Autowired
    private HabilidadesRepository repository;

    public List<Habilidade> listarHabilidades(){
        return repository.findAll();
    }

    public Habilidade buscarHabilidade(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habilidade com id " + id + " não encontrado"));
    }

    public void adicionarHabilidade(Habilidade h){
        repository.save(h);
    }

    public void removerHabilidade(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Habilidade com id " + id + " não encontrado");
        }

        else{
            repository.deleteById(id);
        }
    }

    public void atualizarHabilidade(Long id, Habilidade habilidade_atualizada) {
        repository.findById(id)
                .map(h -> {
                    h.setNome(habilidade_atualizada.getNome());
                    h.setTipo(habilidade_atualizada.getTipo());
                    h.setPre_requesitos(habilidade_atualizada.getPre_requesitos());
                    h.setDescricao(habilidade_atualizada.getDescricao());
                    return repository.save(h);
                })
                .orElseThrow(() -> new RuntimeException("Habilidade com id " + id + " não encontrado"));
    }

    public boolean habilidadeJaExiste(Habilidade h){
        return repository.existsHabilidadeByNomeAndIdNot(h.getNome(), h.getId());
    }

}
