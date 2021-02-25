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
@Table(name = "forma_pagto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPagto.findAll", query = "SELECT f FROM FormaPagto f"),
    @NamedQuery(name = "FormaPagto.findByIdFormaPagto", query = "SELECT f FROM FormaPagto f WHERE f.idFormaPagto = :idFormaPagto"),
    @NamedQuery(name = "FormaPagto.findByDescFormaPagto", query = "SELECT f FROM FormaPagto f WHERE f.descFormaPagto = :descFormaPagto")})
public class FormaPagto implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPagto")
    private List<Venda> vendaList;
    
    public static enum formaPagto{
        
        AVISTA(1), CREDITO(2), DEBITO(3), CREDIARIO(4);
        
        Integer Identificador;
        
        private formaPagto(Integer Identificador)
        {
            this.Identificador = Identificador;       
        }
        
        public FormaPagto getInstance()
        {
            FormaPagto forma = new FormaPagto(Identificador, this.toString());
            
            return forma;
        }
            
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FORMA_PAGTO")
    private Integer idFormaPagto;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_FORMA_PAGTO")
    private String descFormaPagto;
    

    public FormaPagto() {
    }

    public FormaPagto(Integer idFormaPagto) {
        this.idFormaPagto = idFormaPagto;
    }

    public FormaPagto(Integer idFormaPagto, String descFormaPagto) {
        this.idFormaPagto = idFormaPagto;
        this.descFormaPagto = descFormaPagto;
    }

    public Integer getIdFormaPagto() {
        return idFormaPagto;
    }

    public void setIdFormaPagto(Integer idFormaPagto) {
        this.idFormaPagto = idFormaPagto;
    }

    public String getDescFormaPagto() {
        return descFormaPagto;
    }

    public void setDescFormaPagto(String descFormaPagto) {
        this.descFormaPagto = descFormaPagto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaPagto != null ? idFormaPagto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagto)) {
            return false;
        }
        FormaPagto other = (FormaPagto) object;
        if ((this.idFormaPagto == null && other.idFormaPagto != null) || (this.idFormaPagto != null && !this.idFormaPagto.equals(other.idFormaPagto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.FormaPagto[ idFormaPagto=" + idFormaPagto + " ]";
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }
    
}
