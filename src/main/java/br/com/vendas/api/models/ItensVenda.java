/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "itens_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensVenda.findAll", query = "SELECT i FROM ItensVenda i"),
    @NamedQuery(name = "ItensVenda.findByIdItensVenda", query = "SELECT i FROM ItensVenda i WHERE i.idItensVenda = :idItensVenda"),
    @NamedQuery(name = "ItensVenda.findByQuantidade", query = "SELECT i FROM ItensVenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItensVenda.findByVlrUnitario", query = "SELECT i FROM ItensVenda i WHERE i.vlrUnitario = :vlrUnitario"),
    @NamedQuery(name = "ItensVenda.findByVlrTotal", query = "SELECT i FROM ItensVenda i WHERE i.vlrTotal = :vlrTotal")})
public class ItensVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ITENS_VENDA")
    private Integer idItensVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
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
    @JoinColumn(name = "ID_VENDA", referencedColumnName = "ID_VENDA")
    @ManyToOne(optional = false)
    private Venda idVenda;

    /**
     *
     */
    public ItensVenda() {
    }

    /**
     *
     * @param idItensVenda
     */
    public ItensVenda(Integer idItensVenda) {
        this.idItensVenda = idItensVenda;
    }

    /**
     *
     * @param idItensVenda
     * @param quantidade
     * @param vlrUnitario
     * @param vlrTotal
     */
    public ItensVenda(Integer idItensVenda, int quantidade, double vlrUnitario, double vlrTotal) {
        this.idItensVenda = idItensVenda;
        this.quantidade = quantidade;
        this.vlrUnitario = vlrUnitario;
        this.vlrTotal = vlrTotal;
    }

    /**
     *
     * @return
     */
    public Integer getIdItensVenda() {
        return idItensVenda;
    }

    /**
     *
     * @param idItensVenda
     */
    public void setIdItensVenda(Integer idItensVenda) {
        this.idItensVenda = idItensVenda;
    }

    /**
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     *
     * @return
     */
    public double getVlrUnitario() {
        return vlrUnitario;
    }

    /**
     *
     * @param vlrUnitario
     */
    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    /**
     *
     * @return
     */
    public double getVlrTotal() {
        return vlrTotal;
    }

    /**
     *
     * @param vlrTotal
     */
    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    /**
     *
     * @return
     */
    public Produto getIdProduto() {
        return idProduto;
    }

    /**
     *
     * @param idProduto
     */
    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    /**
     *
     * @return
     */
    public Venda getIdVenda() {
        return idVenda;
    }

    /**
     *
     * @param idVenda
     */
    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItensVenda != null ? idItensVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensVenda)) {
            return false;
        }
        ItensVenda other = (ItensVenda) object;
        if ((this.idItensVenda == null && other.idItensVenda != null) || (this.idItensVenda != null && !this.idItensVenda.equals(other.idItensVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.ItensVenda[ idItensVenda=" + idItensVenda + " ]";
    }

}
