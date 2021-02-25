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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIdEstado", query = "SELECT e FROM Estado e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "Estado.findByNomeEstado", query = "SELECT e FROM Estado e WHERE e.nomeEstado = :nomeEstado"),
    @NamedQuery(name = "Estado.findBySiglaUf", query = "SELECT e FROM Estado e WHERE e.siglaUf = :siglaUf")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO")
    private Integer idEstado;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_ESTADO")
    private String nomeEstado;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "SIGLA_UF")
    private String siglaUf;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Cidade> cidadeList;

    /**
     *
     */
    public Estado() {
    }

    /**
     *
     * @param idEstado
     */
    public Estado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    /**
     *
     * @param idEstado
     * @param nomeEstado
     * @param siglaUf
     */
    public Estado(Integer idEstado, String nomeEstado, String siglaUf) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.siglaUf = siglaUf;
    }

    /**
     *
     * @return
     */
    public Integer getIdEstado() {
        return idEstado;
    }

    /**
     *
     * @param idEstado
     */
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    /**
     *
     * @return
     */
    public String getNomeEstado() {
        return nomeEstado;
    }

    /**
     *
     * @param nomeEstado
     */
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    /**
     *
     * @return
     */
    public String getSiglaUf() {
        return siglaUf;
    }

    /**
     *
     * @param siglaUf
     */
    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Cidade> getCidadeList() {
        return cidadeList;
    }

    /**
     *
     * @param cidadeList
     */
    public void setCidadeList(List<Cidade> cidadeList) {
        this.cidadeList = cidadeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Estado[ idEstado=" + idEstado + " ]";
    }

}
