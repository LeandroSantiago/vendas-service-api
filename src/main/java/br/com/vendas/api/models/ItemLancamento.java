/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "item_lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemLancamento.findAll", query = "SELECT i FROM ItemLancamento i"),
    @NamedQuery(name = "ItemLancamento.findByIdItemLancamento", query = "SELECT i FROM ItemLancamento i WHERE i.idItemLancamento = :idItemLancamento"),
    @NamedQuery(name = "ItemLancamento.findByDtVencimento", query = "SELECT i FROM ItemLancamento i WHERE i.dtVencimento = :dtVencimento"),
    @NamedQuery(name = "ItemLancamento.findItensLancamentoByIdLancamento", query = "SELECT i FROM ItemLancamento i WHERE  i.idLancamento = :idLancamento"),
    @NamedQuery(name = "ItemLancamento.findByVlrUnitario", query = "SELECT i FROM ItemLancamento i WHERE i.vlrUnitario = :vlrUnitario"),
    @NamedQuery(name = "ItemLancamento.findByVlrTotal", query = "SELECT i FROM ItemLancamento i WHERE i.vlrTotal = :vlrTotal")})
public class ItemLancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ITEM_LANCAMENTO")
    private Integer idItemLancamento;

    @Column(name = "DT_VENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_RECEBIDO")
    private int qtdRecebido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_UNITARIO")
    private double vlrUnitario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_TOTAL")
    private double vlrTotal;

    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    @ManyToOne(optional = false)
    private Produto idProduto;

    @JoinColumn(name = "ID_LANCAMENTO", referencedColumnName = "ID_LANCAMENTO")
    @ManyToOne(optional = false)
    private Lancamentos idLancamento;

    public ItemLancamento() {
    }

    public ItemLancamento(Integer idItemLancamento) {
        this.idItemLancamento = idItemLancamento;
    }

    public Integer getIdItemLancamento() {
        return idItemLancamento;
    }

    public void setIdItemLancamento(Integer idItemLancamento) {
        this.idItemLancamento = idItemLancamento;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public int getQtdRecebido() {
        return qtdRecebido;
    }

    public void setQtdRecebido(int qtdRecebido) {
        this.qtdRecebido = qtdRecebido;
    }

    public double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Produto getIdProduto() {
        if (idProduto == null) {
            idProduto = new Produto();
        }
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Lancamentos getIdLancamento() {

        if (idLancamento == null) {
            idLancamento = new Lancamentos();
        }
        return idLancamento;
    }

    public void setIdLancamento(Lancamentos idLancamento) {
        this.idLancamento = idLancamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemLancamento != null ? idItemLancamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemLancamento)) {
            return false;
        }
        ItemLancamento other = (ItemLancamento) object;
        if ((this.idItemLancamento == null && other.idItemLancamento != null) || (this.idItemLancamento != null && !this.idItemLancamento.equals(other.idItemLancamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.ItemLancamento[ idItemLancamento=" + idItemLancamento + " ]";
    }

}
