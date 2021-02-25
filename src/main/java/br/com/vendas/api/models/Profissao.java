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
@Table(name = "profissao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profissao.findAll", query = "SELECT p FROM Profissao p"),
    @NamedQuery(name = "Profissao.findByIdProfissao", query = "SELECT p FROM Profissao p WHERE p.idProfissao = :idProfissao"),
    @NamedQuery(name = "Profissao.findByDescricao", query = "SELECT p FROM Profissao p WHERE p.descricao = :descricao")})
public class Profissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROFISSAO")
    private Integer idProfissao;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;

    /**
     *
     */
    public Profissao() {
    }

    /**
     *
     * @param idProfissao
     */
    public Profissao(Integer idProfissao) {
        this.idProfissao = idProfissao;
    }

    /**
     *
     * @param idProfissao
     * @param descricao
     */
    public Profissao(Integer idProfissao, String descricao) {
        this.idProfissao = idProfissao;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdProfissao() {
        return idProfissao;
    }

    /**
     *
     * @param idProfissao
     */
    public void setIdProfissao(Integer idProfissao) {
        this.idProfissao = idProfissao;
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
        hash += (idProfissao != null ? idProfissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissao)) {
            return false;
        }
        Profissao other = (Profissao) object;
        if ((this.idProfissao == null && other.idProfissao != null) || (this.idProfissao != null && !this.idProfissao.equals(other.idProfissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Profissao[ idProfissao=" + idProfissao + " ]";
    }

  
}
