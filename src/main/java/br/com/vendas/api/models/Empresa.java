/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByNomeFantasia", query = "SELECT e FROM Empresa e WHERE e.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj")})

public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "CNPJ")
    private String cnpj;
    
    @Size(max = 255)
    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;
    
    @Column(name = "INSCRICAO_ESTADUAL")
    private Integer inscricaoEstadual;
    
    @Column(name = "INCRICAO_MUNICIPAL")
    private Integer incricaoMunicipal;

    @JoinColumn(name = "ID_PORTE", referencedColumnName = "ID_PORTE")
    @ManyToOne(optional = false)
    private Porte idPorte;

    @JoinColumn(name = "ID_SEGMENTO_NEGOCIO", referencedColumnName = "ID_SEGMENTO_NEGOCIO")
    @ManyToOne(optional = false)
    private SegmentoNegocio idSegmentoNegocio;
    
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private PessoaJuridica idPessoa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresa")
    private List<Vendedor> vendedores;
    
    @OneToOne(mappedBy = "idEmpresa")
    private ControleMeta controleMeta;

    /**
     *
     */
    public Empresa() {
    }

    /**
     *
     * @return
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     *
     * @param nomeFantasia
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     *
     * @return
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     *
     * @param cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     *
     * @return
     */
    public Porte getIdPorte() {
        return idPorte;
    }

    /**
     *
     * @param idPorte
     */
    public void setIdPorte(Porte idPorte) {
        this.idPorte = idPorte;
    }

    /**
     *
     * @return
     */
    public SegmentoNegocio getIdSegmentoNegocio() {
        return idSegmentoNegocio;
    }

    /**
     *
     * @param idSegmentoNegocio
     */
    public void setIdSegmentoNegocio(SegmentoNegocio idSegmentoNegocio) {
        this.idSegmentoNegocio = idSegmentoNegocio;
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }


    public List<Vendedor> getVendedores() {

        if (vendedores == null) {
            vendedores = new ArrayList<>();
        }
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public ControleMeta getControleMeta() {

        if (controleMeta == null) {
            controleMeta = new ControleMeta();
        }
        return controleMeta;
    }

    public void setControleMeta(ControleMeta controleMeta) {
        this.controleMeta = controleMeta;
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Integer getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(Integer inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Integer getIncricaoMunicipal() {
        return incricaoMunicipal;
    }

    public void setIncricaoMunicipal(Integer incricaoMunicipal) {
        this.incricaoMunicipal = incricaoMunicipal;
    }

    public PessoaJuridica getIdPessoa() {
        
        if(idPessoa == null)
        {
            idPessoa = new PessoaJuridica();
        }
        return idPessoa;
    }

    public void setIdPessoa(PessoaJuridica idPessoa) {
        this.idPessoa = idPessoa;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    

}
