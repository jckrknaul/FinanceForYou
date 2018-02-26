package br.com.jckrknaul.FinanceForYou.model;

import javax.persistence.*;

@Entity
public class TipoPagamento extends AbstractEntity {

    @Column(length = 60)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
