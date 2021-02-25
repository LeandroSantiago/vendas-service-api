/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "plano_pgto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanoPgto.findAll", query = "SELECT p FROM PlanoPgto p"),
    @NamedQuery(name = "PlanoPgto.findByIdPlanoPgto", query = "SELECT p FROM PlanoPgto p WHERE p.idPlanoPgto = :idPlanoPgto"),
    @NamedQuery(name = "PlanoPgto.findByDescricao", query = "SELECT p FROM PlanoPgto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "PlanoPgto.findByQtdParcelas", query = "SELECT p FROM PlanoPgto p WHERE p.qtdParcelas = :qtdParcelas")})
public class PlanoPgto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PLANO_PGTO")
    private Integer idPlanoPgto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRICAO")
    private String descricao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_PARCELAS")
    private int qtdParcelas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlanoPgto")
    private List<CrediarioVendas> crediarioVendasList;
    
    @OneToMany(mappedBy = "idPlanoPgto")
    private List<Venda> vendaList;

    /**
     *
     */
    public PlanoPgto() {
    }

    /**
     *
     * @param idPlanoPgto
     */
    public PlanoPgto(Integer idPlanoPgto) {
        this.idPlanoPgto = idPlanoPgto;
    }

    /**
     *
     * @param idPlanoPgto
     * @param descricao
     * @param qtdParcelas
     */
    public PlanoPgto(Integer idPlanoPgto, String descricao, int qtdParcelas) {
        this.idPlanoPgto = idPlanoPgto;
        this.descricao = descricao;
        this.qtdParcelas = qtdParcelas;
    }

    /**
     *
     * @return
     */
    public Integer getIdPlanoPgto() {
        return idPlanoPgto;
    }

    /**
     *
     * @param idPlanoPgto
     */
    public void setIdPlanoPgto(Integer idPlanoPgto) {
        this.idPlanoPgto = idPlanoPgto;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public int getQtdParcelas() {
        return qtdParcelas;
    }

    /**
     *
     * @param qtdParcelas
     */
    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<CrediarioVendas> getCrediarioVendasList() {
        return crediarioVendasList;
    }

    /**
     *
     * @param crediarioVendasList
     */
    public void setCrediarioVendasList(List<CrediarioVendas> crediarioVendasList) {
        this.crediarioVendasList = crediarioVendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanoPgto != null ? idPlanoPgto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoPgto)) {
            return false;
        }
        PlanoPgto other = (PlanoPgto) object;
        if ((this.idPlanoPgto == null && other.idPlanoPgto != null) || (this.idPlanoPgto != null && !this.idPlanoPgto.equals(other.idPlanoPgto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.PlanoPgto[ idPlanoPgto=" + idPlanoPgto + " ]";
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

}
