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
@Table(name = "escolaridade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridade.findAll", query = "SELECT e FROM Escolaridade e"),
    @NamedQuery(name = "Escolaridade.findByIdEscolaridade", query = "SELECT e FROM Escolaridade e WHERE e.idEscolaridade = :idEscolaridade"),
    @NamedQuery(name = "Escolaridade.findByDescricao", query = "SELECT e FROM Escolaridade e WHERE e.descricao = :descricao")})
public class Escolaridade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESCOLARIDADE")
    private Integer idEscolaridade;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    


    /**
     *
     */
    public Escolaridade() {
    }

    /**
     *
     * @param idEscolaridade
     */
    public Escolaridade(Integer idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
    }

    /**
     *
     * @param idEscolaridade
     * @param descricao
     */
    public Escolaridade(Integer idEscolaridade, String descricao) {
        this.idEscolaridade = idEscolaridade;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdEscolaridade() {
        return idEscolaridade;
    }

    /**
     *
     * @param idEscolaridade
     */
    public void setIdEscolaridade(Integer idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscolaridade != null ? idEscolaridade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridade)) {
            return false;
        }
        Escolaridade other = (Escolaridade) object;
        if ((this.idEscolaridade == null && other.idEscolaridade != null) || (this.idEscolaridade != null && !this.idEscolaridade.equals(other.idEscolaridade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Escolaridade[ idEscolaridade=" + idEscolaridade + " ]";
    }

   
}
