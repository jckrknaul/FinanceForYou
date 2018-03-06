package br.com.jckrknaul.FinanceForYou.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipoPagamento extends AbstractEntity {

    @Column(length = 60)
    private String descricao;

    @OneToMany(mappedBy = "tipoDePagamento")
    private List<Titulo> titulos = new ArrayList<>();

    public String getDescricao() {return descricao; }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }
}
