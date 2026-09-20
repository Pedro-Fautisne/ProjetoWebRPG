package br.uel.projetowebrpg.Repository;


import br.uel.projetowebrpg.Model.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Habilidade, Long> {
}
