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
import javax.persistence.OneToOne;
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
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByIdEndereco", query = "SELECT e FROM Endereco e WHERE e.idEndereco = :idEndereco"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;
    
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa idPessoa;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Size(max = 100)
    @Column(name = "PTO_REFERENCIA")
    private String ptoReferencia;

    @Size(max = 100)
    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Size(max = 45)
    @Column(name = "CAIXA_POSTAL")
    private String caixaPostal;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "BAIRRO")
    private String bairro;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CEP")
    private String cep;
    @Column(name = "NUMERO")
    private int numero;

    @JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE")
    @ManyToOne(optional = false)
    private Cidade idCidade;

    @JoinColumn(name = "ID_TIPO_LOGRADOURO", referencedColumnName = "ID_TIPO_LOGRADOURO")
    @ManyToOne(optional = false)
    private TipoLogradouro idTipoLogradouro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEndereco")
    private List<Autorizados> autorizadosList;

    /**
     *
     */
    public Endereco() {
    }

    /**
     *
     * @param idEndereco
     */
    public Endereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     *
     * @param idEndereco
     * @param logradouro
     * @param bairro
     * @param cep
     */
    public Endereco(Integer idEndereco, String logradouro, String bairro, String cep) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
    }

    /**
     *
     * @return
     */
    public Integer getIdEndereco() {
        return idEndereco;
    }

    /**
     *
     * @param idEndereco
     */
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     *
     * @return
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     *
     * @param logradouro
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     *
     * @return
     */
    public String getBairro() {
        return bairro;
    }

    /**
     *
     * @param bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
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
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public Cidade getIdCidade() {
        return idCidade;
    }

    /**
     *
     * @param idCidade
     */
    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Autorizados> getAutorizadosList() {
        return autorizadosList;
    }

    /**
     *
     * @param autorizadosList
     */
    public void setAutorizadosList(List<Autorizados> autorizadosList) {
        this.autorizadosList = autorizadosList;
    }

    public String getPtoReferencia() {
        return ptoReferencia;
    }

    public void setPtoReferencia(String ptoReferencia) {
        this.ptoReferencia = ptoReferencia;
    }

    public TipoLogradouro getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(TipoLogradouro idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(String caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public Pessoa getIdPessoa() {

        if (idPessoa == null) {
            idPessoa = new Fornecedor();
        }
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Endereco[ idEndereco=" + idEndereco + " ]";
    }
}
