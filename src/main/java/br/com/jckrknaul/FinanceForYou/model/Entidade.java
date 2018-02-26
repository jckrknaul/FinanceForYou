package br.com.jckrknaul.FinanceForYou.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Entidade extends AbstractEntity{

    @NotBlank
    @Column(length = 60)
    private String nome;

    @NotBlank
    @Column(length = 20, name = "cpf_ou_cnpj")
    private String cpfOuCnpj;

    @NotBlank
    @Column(length = 80)
    private String endereco;

    @Column(length = 60)
    private String cidade;

    @Column(length = 60)
    private String bairro;

    @Column(length = 20)
    private String estado;

    @NotBlank
    @Column(length = 20)
    private String telefone;

    @NotBlank
    @Column(length = 100, name = "e_mail")
    private String email;

    @OneToMany(mappedBy = "entidade", orphanRemoval = true)
    private List<Titulo> titulos = new ArrayList<>();

    public Entidade(String nome, String cpfOuCnpj, String endereco, String cidade, String bairro, String estado, String telefone, String email, List<Titulo> titulos) {
        this.nome = nome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
        this.titulos = titulos;
    }

    public Entidade() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }

    @Override
    public String toString() {
        return "Entidade{" +
                "nome='" + nome + '\'' +
                ", cpfOuCnpj='" + cpfOuCnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
