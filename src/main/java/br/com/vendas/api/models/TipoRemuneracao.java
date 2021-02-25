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
@Table(name = "tipo_remuneracao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRemuneracao.findAll", query = "SELECT t FROM TipoRemuneracao t"),
    @NamedQuery(name = "TipoRemuneracao.findByIdTipoRemuneracao", query = "SELECT t FROM TipoRemuneracao t WHERE t.idTipoRemuneracao = :idTipoRemuneracao"),
    @NamedQuery(name = "TipoRemuneracao.findByDescTipoRemuneracao", query = "SELECT t FROM TipoRemuneracao t WHERE t.descTipoRemuneracao = :descTipoRemuneracao")})
public class TipoRemuneracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_REMUNERACAO")
    private Integer idTipoRemuneracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_TIPO_REMUNERACAO")
    private String descTipoRemuneracao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRemuneracao")
    private List<Funcionario> funcionarioList;

    public TipoRemuneracao() {
    }

    public TipoRemuneracao(Integer idTipoRemuneracao) {
        this.idTipoRemuneracao = idTipoRemuneracao;
    }

    public TipoRemuneracao(Integer idTipoRemuneracao, String descTipoRemuneracao) {
        this.idTipoRemuneracao = idTipoRemuneracao;
        this.descTipoRemuneracao = descTipoRemuneracao;
    }

    public Integer getIdTipoRemuneracao() {
        return idTipoRemuneracao;
    }

    public void setIdTipoRemuneracao(Integer idTipoRemuneracao) {
        this.idTipoRemuneracao = idTipoRemuneracao;
    }

    public String getDescTipoRemuneracao() {
        return descTipoRemuneracao;
    }

    public void setDescTipoRemuneracao(String descTipoRemuneracao) {
        this.descTipoRemuneracao = descTipoRemuneracao;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRemuneracao != null ? idTipoRemuneracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRemuneracao)) {
            return false;
        }
        TipoRemuneracao other = (TipoRemuneracao) object;
        if ((this.idTipoRemuneracao == null && other.idTipoRemuneracao != null) || (this.idTipoRemuneracao != null && !this.idTipoRemuneracao.equals(other.idTipoRemuneracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.TipoRemuneracao[ idTipoRemuneracao=" + idTipoRemuneracao + " ]";
    }
    
}
