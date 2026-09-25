package br.uel.projetowebrpg.Controller;

import br.uel.projetowebrpg.Model.Habilidade;
import br.uel.projetowebrpg.Service.HabilidadeService;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/habilidades")
public class HabilidadesController {

    private final HabilidadeService service;

    @Autowired
    public HabilidadesController(HabilidadeService service){
        this.service = service;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("habilidades", service.listarHabilidades());
        return "habilidades/lista";
    }

    @GetMapping("/nova")
    public String abrirCadastro(Model model){
        model.addAttribute("habilidade", new Habilidade());
        return "habilidades/formulario";
    }

    @PostMapping
    public String cadastrar(@Valid @ModelAttribute("habilidade") Habilidade h, BindingResult erros, RedirectAttributes re){

        if (service.habilidadeJaExiste(h)){
            erros.rejectValue("nome", "nome.duplicado", "Opa meu cupincha, parece" +
                    " que já existe uma habilidade com esse nome");
        }

        if(erros.hasErrors()){
            return "redirect:/habilidades";
        }

        service.adicionarHabilidade(h);
        re.addFlashAttribute("msg", "Bah que irado! sua nova habilidade foi cadastrada");
        return "redirect:/habilidades";
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id, RedirectAttributes re){
        try{
            service.removerHabilidade(id);
            re.addFlashAttribute("msg", "Habilidade removida com sucesso!");
            return "redirect:/habilidades";
        }

        catch(RuntimeException e) {
            re.addFlashAttribute("erromsg", "Calma lá amigão, a habilidade número " +
                    id + " nem existe...");
            return "redirect:/habilidades";
        }
    }

    @GetMapping("/editar/{id}")
    public String abrirEdicao(@PathVariable Long id, Model model, RedirectAttributes re){
        try{

            Habilidade editar = service.buscarHabilidade(id);

            model.addAttribute("habilidade", editar);
            return "habilidades/formulario";
        }

        catch(RuntimeException e) {
            re.addFlashAttribute("erromsg", "Calma lá amigão, a habilidade número " +
                    id + " nem existe...");
            return "redirect:/habilidades";
        }
    }

    @PutMapping("/{id}")
    public String editar(@PathVariable Long id, @Valid @ModelAttribute("habilidade") Habilidade atualizada,
                         BindingResult erros, RedirectAttributes re){

        if (service.habilidadeJaExiste(atualizada)){
            erros.rejectValue("nome", "nome.duplicado", "Opa meu cupincha, parece" +
                    " que já existe uma habilidade com esse nome");
        }

        if(erros.hasErrors()){
            return "habilidades/formulario";
        }

        service.atualizarHabilidade(id, atualizada);
        re.addFlashAttribute("msg", "Que massa! você atualizou a sua habilidade");
        return "redirect:/habilidades";
    }

}
