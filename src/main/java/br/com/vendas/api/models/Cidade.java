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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByIdCidade", query = "SELECT c FROM Cidade c WHERE c.idCidade = :idCidade"),
    @NamedQuery(name = "Cidade.findByNomeCidade", query = "SELECT c FROM Cidade c WHERE c.nomeCidade = :nomeCidade"),
    @NamedQuery(name = "Cidade.buscarCidadesPorEstado", query = "SELECT c FROM Cidade c WHERE c.idEstado = :idEstado"),
    @NamedQuery(name = "Cidade.consultarNomeCidades", query = "SELECT c  FROM Cidade c WHERE c.nomeCidade like :nomeCidade"),
    @NamedQuery(name = "Cidade.findByCep", query = "SELECT c FROM Cidade c WHERE c.cep = :cep")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CIDADE")
    private Integer idCidade;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_CIDADE")
    private String nomeCidade;

    @Size(max = 11)
    @Column(name = "CEP")
    private String cep;

    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private Estado idEstado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidade")
    private List<Endereco> enderecoList;

    /**
     *
     */
    public Cidade() {
    }

    /**
     *
     * @param idCidade
     */
    public Cidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    /**
     *
     * @param idCidade
     * @param nomeCidade
     */
    public Cidade(Integer idCidade, String nomeCidade) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
    }

    /**
     *
     * @return
     */
    public Integer getIdCidade() {
        return idCidade;
    }

    /**
     *
     * @param idCidade
     */
    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    /**
     *
     * @return
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     *
     * @param nomeCidade
     */
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    /**
     *
     * @return
     */
    public String getCep() {
        return cep;
    }

    /**
     *
     * @param cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     *
     * @return
     */
    public Estado getIdEstado() {

        if (idEstado == null) {
            idEstado = new Estado();
        }
        return idEstado;
    }

    /**
     *
     * @param idEstado
     */
    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    /**
     *
     * @param enderecoList
     */
    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Cidade[ idCidade=" + idCidade + " ]";
    }

}
