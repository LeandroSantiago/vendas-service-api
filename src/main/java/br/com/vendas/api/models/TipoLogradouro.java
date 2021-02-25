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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "tipo_logradouro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLogradouro.findAll", query = "SELECT t FROM TipoLogradouro t"),
    @NamedQuery(name = "TipoLogradouro.findByIdTipoLogradouro", query = "SELECT t FROM TipoLogradouro t WHERE t.idTipoLogradouro = :idTipoLogradouro"),
    @NamedQuery(name = "TipoLogradouro.findByDescTipoLogradouro", query = "SELECT t FROM TipoLogradouro t WHERE t.descTipoLogradouro = :descTipoLogradouro")})
public class TipoLogradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_LOGRADOURO")
    private Integer idTipoLogradouro;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_TIPO_LOGRADOURO")
    private String descTipoLogradouro;

    public TipoLogradouro() {
    }

    public TipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public TipoLogradouro(Integer idTipoLogradouro, String descTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
        this.descTipoLogradouro = descTipoLogradouro;
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getDescTipoLogradouro() {
        return descTipoLogradouro;
    }

    public void setDescTipoLogradouro(String descTipoLogradouro) {
        this.descTipoLogradouro = descTipoLogradouro;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoLogradouro != null ? idTipoLogradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLogradouro)) {
            return false;
        }
        TipoLogradouro other = (TipoLogradouro) object;
        if ((this.idTipoLogradouro == null && other.idTipoLogradouro != null) || (this.idTipoLogradouro != null && !this.idTipoLogradouro.equals(other.idTipoLogradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.TipoLogradouro[ idTipoLogradouro=" + idTipoLogradouro + " ]";
    }
    
}
