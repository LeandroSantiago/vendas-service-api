/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(name = "consultarClienteCPF",
            query = "SELECT C.* "
            + "FROM CLIENTE C, PESSOA P, PESSOA_FISICA PF "
            + "WHERE PF.CPF = ?1 "
            + "AND C.ID_EMPRESA = ?2 "
            + "AND P.ID_PESSOA = PF.ID_PESSOA "
            + "AND PF.ID_PESSOA = C.ID_PESSOA ",
            resultClass = Cliente.class)})

@NamedQueries({
    @NamedQuery(name = "Cliente.consultarClientes",
            query = "SELECT c FROM Cliente c WHERE c.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Cliente.consultarClientePorNome",
            query = "SELECT c FROM Cliente c WHERE c.idEmpresa = :idEmpresa and c.idPessoa.nome = :nome"),
    @NamedQuery(name = "Cliente.listaClientesPorNome",
            query = "SELECT c FROM Cliente c WHERE c.idEmpresa = :idEmpresa and c.idPessoa.nome like :nome"),
    @NamedQuery(name = "Cliente.consultarNomeClientes",
            query = "SELECT c.idPessoa.nome FROM Cliente c WHERE c.idEmpresa = :idEmpresa and c.idPessoa.nome like :nome"),   
    @NamedQuery(name = "Cliente.findAll",
            query = "SELECT c FROM Cliente c")})

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @OneToOne(cascade = CascadeType.MERGE)
    private Pessoa idPessoa;

    @OneToOne(mappedBy = "idCliente")
    private Crediario crediario;

    @Size(max = 45)
    @Column(name = "CONJUGE")
    private String conjuge;

    @Size(max = 15)
    @Column(name = "RG_CONJUGE")
    private String rgConjuge;

    @Size(max = 15)
    @Column(name = "CPF_CONJUGE")
    private String cpfConjuge;

    @Column(name = "DT_NASCIMENTO_CONJUGE")
    @Temporal(TemporalType.DATE)
    private Date dtNascimentoConjuge;

    @Size(max = 45)
    @Column(name = "INDICACAO")
    private String indicacao;

    @Size(max = 15)
    @Column(name = "FONE_RESID")
    private String foneResid;

    @Size(max = 15)
    @Column(name = "FONE_COMERCIAL")
    private String foneComercial;

    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 4)
    @Column(name = "RAMAL")
    private String ramal;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @JoinColumn(name = "ID_DADOS_EMPREGATICIOS", referencedColumnName = "ID_DADOS_EMPREGATICIOS")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private DadosEmpregaticios idDadosEmpregaticios;

    public Cliente() {
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public String getRgConjuge() {
        return rgConjuge;
    }

    public void setRgConjuge(String rgConjuge) {
        this.rgConjuge = rgConjuge;
    }

    public String getCpfConjuge() {
        return cpfConjuge;
    }

    public void setCpfConjuge(String cpfConjuge) {
        this.cpfConjuge = cpfConjuge;
    }

    public Date getDtNascimentoConjuge() {
        return dtNascimentoConjuge;
    }

    public void setDtNascimentoConjuge(Date dtNascimentoConjuge) {
        this.dtNascimentoConjuge = dtNascimentoConjuge;
    }

    public Empresa getIdEmpresa() {

        if (idEmpresa == null) {
            idEmpresa = new Empresa();
        }
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public DadosEmpregaticios getIdDadosEmpregaticios() {

        if (idDadosEmpregaticios == null) {
            idDadosEmpregaticios = new DadosEmpregaticios();
        }
        return idDadosEmpregaticios;
    }

    public void setIdDadosEmpregaticios(DadosEmpregaticios idDadosEmpregaticios) {
        this.idDadosEmpregaticios = idDadosEmpregaticios;
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getFoneResid() {
        return foneResid;
    }

    public void setFoneResid(String foneResid) {
        this.foneResid = foneResid;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public void setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public Crediario getCrediario() {

        if (crediario == null) {
            crediario = new Crediario();
        }
        return crediario;
    }

    public void setCrediario(Crediario crediario) {
        this.crediario = crediario;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.Cliente[ idCliente=" + idCliente + " ]";
    }
}
