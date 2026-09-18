package br.uel.projetowebrpg.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o campo nome não pode estar em branco")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "o campo telefone não pode estar em branco")
    @Size(max = 14, message = "o telefone não deve passar de 14 caracteres")
    private String telefone;

    @NotBlank(message = "o email é um campo obrigatório")
    @Size(max = 150, message = "o email não deve passar de 150 caracteres")
    @Email(message = "digite um email válido")
    private String email;

    private String endereco;

    @DateTimeFormat
    private LocalDate dataNascimento;

    public Contact(String nome, String telefone, String email, String endereco, LocalDate dataNascimento){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Contact(){}

    public String getNome(){
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
}
