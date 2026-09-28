package br.uel.projetowebrpg.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "talentos2")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "é obrigatório que a habilidade tenha um nome")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "o campo tipo da habilidade é obrigatório")
    private String tipo;

    @Size(max = 100, message = "o requisito(s) não deve passar de 100 caracteres")
    private String requisitos;

    @NotBlank(message = "o campo descrição é obrigatório")
    private String descricao;

    public Habilidade(String nome, String tipo, String pre_requisitos, String descricao){
        this.nome = nome;
        this.tipo = tipo;
        requisitos = pre_requisitos;
        this.descricao = descricao;
    }

    public Habilidade(){}

    public Long getId(){ return this.id;}

    public String getNome(){
        return this.nome;
    }

    public String getTipo(){ return this.tipo;}

    public String getRequisitos() {
        return this.requisitos;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRequisitos(String pre_requisitos) {
        requisitos = pre_requisitos;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(Long id){this.id = id;}

}
