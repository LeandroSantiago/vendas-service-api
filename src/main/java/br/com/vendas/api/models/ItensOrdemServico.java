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
@Table(name = "itens_ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensOrdemServico.findAll", query = "SELECT i FROM ItensOrdemServico i"),
    @NamedQuery(name = "ItensOrdemServico.findByIdItensOrdemServico", query = "SELECT i FROM ItensOrdemServico i WHERE i.idItensOrdemServico = :idItensOrdemServico"),
    @NamedQuery(name = "ItensOrdemServico.findByQtd", query = "SELECT i FROM ItensOrdemServico i WHERE i.qtd = :qtd"),
    @NamedQuery(name = "ItensOrdemServico.findByVlr", query = "SELECT i FROM ItensOrdemServico i WHERE i.vlr = :vlr"),
    @NamedQuery(name = "ItensOrdemServico.findByDesconto", query = "SELECT i FROM ItensOrdemServico i WHERE i.desconto = :desconto"),
    @NamedQuery(name = "ItensOrdemServico.findByTotal", query = "SELECT i FROM ItensOrdemServico i WHERE i.total = :total")})
public class ItensOrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ITENS_ORDEM_SERVICO")
    private Integer idItensOrdemServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD")
    private int qtd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR")
    private double vlr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESCONTO")
    private Double desconto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private double total;
    @JoinColumn(name = "ID_ORDEM_SERVICO", referencedColumnName = "ID_ORDEM_SERVICO")
    @ManyToOne(optional = false)
    private OrdemServico idOrdemServico;
    @JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID_SERVICO")
    @ManyToOne(optional = false)
    private Servico idServico;

    /**
     *
     */
    public ItensOrdemServico() {
    }

    /**
     *
     * @param idItensOrdemServico
     */
    public ItensOrdemServico(Integer idItensOrdemServico) {
        this.idItensOrdemServico = idItensOrdemServico;
    }

    /**
     *
     * @param idItensOrdemServico
     * @param qtd
     * @param vlr
     * @param total
     */
    public ItensOrdemServico(Integer idItensOrdemServico, int qtd, double vlr, double total) {
        this.idItensOrdemServico = idItensOrdemServico;
        this.qtd = qtd;
        this.vlr = vlr;
        this.total = total;
    }

    /**
     *
     * @return
     */
    public Integer getIdItensOrdemServico() {
        return idItensOrdemServico;
    }

    /**
     *
     * @param idItensOrdemServico
     */
    public void setIdItensOrdemServico(Integer idItensOrdemServico) {
        this.idItensOrdemServico = idItensOrdemServico;
    }

    /**
     *
     * @return
     */
    public int getQtd() {
        return qtd;
    }

    /**
     *
     * @param qtd
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     *
     * @return
     */
    public double getVlr() {
        return vlr;
    }

    /**
     *
     * @param vlr
     */
    public void setVlr(double vlr) {
        this.vlr = vlr;
    }

    /**
     *
     * @return
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     *
     * @param desconto
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    /**
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public OrdemServico getIdOrdemServico() {
        return idOrdemServico;
    }

    /**
     *
     * @param idOrdemServico
     */
    public void setIdOrdemServico(OrdemServico idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    /**
     *
     * @return
     */
    public Servico getIdServico() {
        return idServico;
    }

    /**
     *
     * @param idServico
     */
    public void setIdServico(Servico idServico) {
        this.idServico = idServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItensOrdemServico != null ? idItensOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensOrdemServico)) {
            return false;
        }
        ItensOrdemServico other = (ItensOrdemServico) object;
        if ((this.idItensOrdemServico == null && other.idItensOrdemServico != null) || (this.idItensOrdemServico != null && !this.idItensOrdemServico.equals(other.idItensOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.ItensOrdemServico[ idItensOrdemServico=" + idItensOrdemServico + " ]";
    }

}
