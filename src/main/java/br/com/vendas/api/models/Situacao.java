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
@Table(name = "situacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacao.findAll", query = "SELECT s FROM Situacao s"),
    @NamedQuery(name = "Situacao.findByIdSituacao", query = "SELECT s FROM Situacao s WHERE s.idSituacao = :idSituacao"),
    @NamedQuery(name = "Situacao.findByDescSituacao", query = "SELECT s FROM Situacao s WHERE s.descSituacao = :descSituacao")})
public class Situacao implements Serializable {

    public static enum situacao {
            ATIVO(1), INATIVO(2), BLOQUEADO(3), CANCELADO(4);

        private final Integer identificadorSituacao;

        private situacao(Integer identificadorSituacao) {
            this.identificadorSituacao = identificadorSituacao;
        }

        public Situacao getInstance() {
            Situacao situacao = new Situacao(identificadorSituacao, this.toString());

            return situacao;
        }

    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SITUACAO")
    private Integer idSituacao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_SITUACAO")
    private String descSituacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacao")
    private List<Vendedor> vendedorList;
    
    

    public Situacao() {
    }

    public Situacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Situacao(Integer idSituacao, String descSituacao) {
        this.idSituacao = idSituacao;
        this.descSituacao = descSituacao;
    }

    public Integer getIdSituacao() {
        return idSituacao;
    }

    public void setIdSituacao(Integer idSituacao) {
        this.idSituacao = idSituacao;
    }

    public String getDescSituacao() {
        return descSituacao;
    }

    public void setDescSituacao(String descSituacao) {
        this.descSituacao = descSituacao;
    }
    
    @XmlTransient
    public List<Vendedor> getVendedorList() {
        
        if(vendedorList == null)
        {
            vendedorList = new ArrayList<>();
        }
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacao != null ? idSituacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacao)) {
            return false;
        }
        Situacao other = (Situacao) object;
        if ((this.idSituacao == null && other.idSituacao != null) || (this.idSituacao != null && !this.idSituacao.equals(other.idSituacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.Situacao[ idSituacao=" + idSituacao + " ]";
    }

    
}
