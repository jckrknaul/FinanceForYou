package br.com.jckrknaul.FinanceForYou.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Titulo extends AbstractEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidadeId")
    private Entidade entidade;

    @NotNull
    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataEmissao;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataValidade;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    @NotNull
    private BigDecimal valor;
    private BigDecimal valorPago;
    @NotNull
    private BigDecimal valorOriginal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_pagamento_id")
    private TipoPagamento tipoDePagamento;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoDePagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoDePagamento = tipoPagamento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "entidade=" + entidade +
                ", descricao='" + descricao + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", dataValidade=" + dataValidade +
                ", dataPagamento=" + dataPagamento +
                ", valor=" + valor +
                ", valorPago=" + valorPago +
                ", valorOriginal=" + valorOriginal +
                ", tipoPagamento=" + tipoDePagamento +
                ", tipo=" + tipo +
                ", situacao=" + situacao +
                '}';
    }
}
