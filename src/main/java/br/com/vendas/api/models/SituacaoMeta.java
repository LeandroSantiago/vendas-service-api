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
@Table(name = "situacao_meta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacaoMeta.findAll", query = "SELECT s FROM SituacaoMeta s"),
    @NamedQuery(name = "SituacaoMeta.findByIdSituacaoMeta", query = "SELECT s FROM SituacaoMeta s WHERE s.idSituacaoMeta = :idSituacaoMeta"),
    @NamedQuery(name = "SituacaoMeta.findByDescSituacaoMeta", query = "SELECT s FROM SituacaoMeta s WHERE s.descSituacaoMeta = :descSituacaoMeta")})
public class SituacaoMeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SITUACAO_META")
    private Integer idSituacaoMeta;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_SITUACAO_META")
    private String descSituacaoMeta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacaoMeta")
    private List<ControleMeta> controleMetaList;

    public SituacaoMeta() {
    }

    public SituacaoMeta(Integer idSituacaoMeta) {
        this.idSituacaoMeta = idSituacaoMeta;
    }

    public SituacaoMeta(Integer idSituacaoMeta, String descSituacaoMeta) {
        this.idSituacaoMeta = idSituacaoMeta;
        this.descSituacaoMeta = descSituacaoMeta;
    }

    public Integer getIdSituacaoMeta() {
        return idSituacaoMeta;
    }

    public void setIdSituacaoMeta(Integer idSituacaoMeta) {
        this.idSituacaoMeta = idSituacaoMeta;
    }

    public String getDescSituacaoMeta() {
        return descSituacaoMeta;
    }

    public void setDescSituacaoMeta(String descSituacaoMeta) {
        this.descSituacaoMeta = descSituacaoMeta;
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
        hash += (idSituacaoMeta != null ? idSituacaoMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacaoMeta)) {
            return false;
        }
        SituacaoMeta other = (SituacaoMeta) object;
        if ((this.idSituacaoMeta == null && other.idSituacaoMeta != null) || (this.idSituacaoMeta != null && !this.idSituacaoMeta.equals(other.idSituacaoMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.SituacaoMeta[ idSituacaoMeta=" + idSituacaoMeta + " ]";
    }

}
