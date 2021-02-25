/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "tipo_meta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMeta.findAll", query = "SELECT t FROM TipoMeta t"),
    @NamedQuery(name = "TipoMeta.findByIdTipoMeta", query = "SELECT t FROM TipoMeta t WHERE t.idTipoMeta = :idTipoMeta"),
    @NamedQuery(name = "TipoMeta.findByDescTipoMeta", query = "SELECT t FROM TipoMeta t WHERE t.descTipoMeta = :descTipoMeta")})
public class TipoMeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_META")
    private Integer idTipoMeta;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_TIPO_META")
    private String descTipoMeta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMeta")
    private List<ControleMeta> controleMetaList;

    public TipoMeta() {
    }

    public TipoMeta(Integer idTipoMeta) {
        this.idTipoMeta = idTipoMeta;
    }

    public TipoMeta(Integer idTipoMeta, String descTipoMeta) {
        this.idTipoMeta = idTipoMeta;
        this.descTipoMeta = descTipoMeta;
    }

    public Integer getIdTipoMeta() {
        return idTipoMeta;
    }

    public void setIdTipoMeta(Integer idTipoMeta) {
        this.idTipoMeta = idTipoMeta;
    }

    public String getDescTipoMeta() {
        return descTipoMeta;
    }

    public void setDescTipoMeta(String descTipoMeta) {
        this.descTipoMeta = descTipoMeta;
    }

    @XmlTransient
    public List<ControleMeta> getControleMetaList() {

        if (controleMetaList == null) {
            controleMetaList = new ArrayList<>();
        }
        return controleMetaList;
    }

    public void setControleMetaList(List<ControleMeta> controleMetaList) {
        this.controleMetaList = controleMetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMeta != null ? idTipoMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMeta)) {
            return false;
        }
        TipoMeta other = (TipoMeta) object;
        if ((this.idTipoMeta == null && other.idTipoMeta != null) || (this.idTipoMeta != null && !this.idTipoMeta.equals(other.idTipoMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.TipoMeta[ idTipoMeta=" + idTipoMeta + " ]";
    }

}
