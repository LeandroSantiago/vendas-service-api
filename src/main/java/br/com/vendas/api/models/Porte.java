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
@Table(name = "porte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Porte.findAll", query = "SELECT p FROM Porte p"),
    @NamedQuery(name = "Porte.findByIdPorte", query = "SELECT p FROM Porte p WHERE p.idPorte = :idPorte"),
    @NamedQuery(name = "Porte.findByDescricao", query = "SELECT p FROM Porte p WHERE p.descricao = :descricao")})
public class Porte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PORTE")
    private Integer idPorte;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPorte")
    private List<Empresa> empresaList;

    /**
     *
     */
    public Porte() {
    }

    /**
     *
     * @param idPorte
     */
    public Porte(Integer idPorte) {
        this.idPorte = idPorte;
    }

    /**
     *
     * @param idPorte
     * @param descricao
     */
    public Porte(Integer idPorte, String descricao) {
        this.idPorte = idPorte;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdPorte() {
        return idPorte;
    }

    /**
     *
     * @param idPorte
     */
    public void setIdPorte(Integer idPorte) {
        this.idPorte = idPorte;
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
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    /**
     *
     * @param empresaList
     */
    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPorte != null ? idPorte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Porte)) {
            return false;
        }
        Porte other = (Porte) object;
        if ((this.idPorte == null && other.idPorte != null) || (this.idPorte != null && !this.idPorte.equals(other.idPorte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Porte[ idPorte=" + idPorte + " ]";
    }

}
