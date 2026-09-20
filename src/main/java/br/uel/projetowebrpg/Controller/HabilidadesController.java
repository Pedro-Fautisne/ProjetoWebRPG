package br.uel.projetowebrpg.Controller;

import br.uel.projetowebrpg.Model.Habilidade;
import br.uel.projetowebrpg.Service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Habilidade>> listar(){
        return ResponseEntity.ok(service.listarContatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> buscar(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.buscarContato(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Habilidade> adicionar(@Valid @RequestBody Habilidade c){
        service.adicionarContato(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Habilidade> remover(@PathVariable Long id){
        try{
            service.removerContato(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        catch(RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> atualizar(@PathVariable Long id, @Valid @RequestBody Habilidade c){

        try{
            service.atualizarContato(id, c);
            return ResponseEntity.ok(c);
        }

        catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
