package br.uel.projetowebrpg.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "habilidades")
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "é obrigatório que a habilidade tenha um nome")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "o campo tipo da habilidade é obrigatório")
    private String tipo;

    @Size(max = 100, message = "o pre_requesito(s) não deve passar de 100 caracteres")
    private String pre_requesitos;

    @NotBlank(message = "o campo descrição é obrigatório")
    private String descricao;

    public Habilidade(String nome, String tipo, String pre_requesitos, String descricao){
        this.nome = nome;
        this.tipo = tipo;
        this.pre_requesitos = pre_requesitos;
        this.descricao = descricao;
    }

    public Habilidade(){}

    public Long getId(){ return this.id;}

    public String getNome(){
        return this.nome;
    }

    public String getTipo(){ return this.tipo;}

    public String getPre_requesitos() {
        return this.pre_requesitos;
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

    public void setPre_requesitos(String pre_requesitos) {
        this.pre_requesitos = pre_requesitos;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
