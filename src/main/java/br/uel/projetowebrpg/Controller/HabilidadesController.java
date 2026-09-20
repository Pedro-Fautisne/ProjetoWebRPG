package br.uel.projetowebrpg.Controller;

import br.uel.projetowebrpg.Model.Habilidade;
import br.uel.projetowebrpg.Service.HabilidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro_habilidades")
public class HabilidadesController {

    private final HabilidadeService service;

    @Autowired
    public HabilidadesController(HabilidadeService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Habilidade>> listar(){
        return ResponseEntity.ok(service.listarHabilidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> buscar(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.buscarHabilidade(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Habilidade> adicionar(@Valid @RequestBody Habilidade c){
        service.adicionarHabilidade(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Habilidade> remover(@PathVariable Long id){
        try{
            service.removerHabilidade(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        catch(RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> atualizar(@PathVariable Long id, @Valid @RequestBody Habilidade c){

        try{
            service.atualizarHabilidade(id, c);
            return ResponseEntity.ok(c);
        }

        catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
