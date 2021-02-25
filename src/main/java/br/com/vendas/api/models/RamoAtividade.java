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
@Table(name = "ramo_atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RamoAtividade.findAll", query = "SELECT r FROM RamoAtividade r"),
    @NamedQuery(name = "RamoAtividade.findByIdRamoAtividade", query = "SELECT r FROM RamoAtividade r WHERE r.idRamoAtividade = :idRamoAtividade"),
    @NamedQuery(name = "RamoAtividade.findByDescricao", query = "SELECT r FROM RamoAtividade r WHERE r.descricao = :descricao")})
public class RamoAtividade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_RAMO_ATIVIDADE")
    private Integer idRamoAtividade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRamoAtividade")
    private List<SegmentoNegocio> segmentoNegocioList;

    /**
     *
     */
    public RamoAtividade() {
    }

    /**
     *
     * @param idRamoAtividade
     */
    public RamoAtividade(Integer idRamoAtividade) {
        this.idRamoAtividade = idRamoAtividade;
    }

    /**
     *
     * @param idRamoAtividade
     * @param descricao
     */
    public RamoAtividade(Integer idRamoAtividade, String descricao) {
        this.idRamoAtividade = idRamoAtividade;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdRamoAtividade() {
        return idRamoAtividade;
    }

    /**
     *
     * @param idRamoAtividade
     */
    public void setIdRamoAtividade(Integer idRamoAtividade) {
        this.idRamoAtividade = idRamoAtividade;
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
    @XmlTransient
    public List<SegmentoNegocio> getSegmentoNegocioList() {
        return segmentoNegocioList;
    }

    /**
     *
     * @param segmentoNegocioList
     */
    public void setSegmentoNegocioList(List<SegmentoNegocio> segmentoNegocioList) {
        this.segmentoNegocioList = segmentoNegocioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRamoAtividade != null ? idRamoAtividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RamoAtividade)) {
            return false;
        }
        RamoAtividade other = (RamoAtividade) object;
        if ((this.idRamoAtividade == null && other.idRamoAtividade != null) || (this.idRamoAtividade != null && !this.idRamoAtividade.equals(other.idRamoAtividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.RamoAtividade[ idRamoAtividade=" + idRamoAtividade + " ]";
    }

}
