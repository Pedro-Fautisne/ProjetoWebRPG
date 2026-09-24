package br.uel.projetowebrpg.Repository;


import br.uel.projetowebrpg.Model.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidade, Long> {

    public boolean existsHabilidadeByNomeAndIdNot(String nome, Long id);
}
