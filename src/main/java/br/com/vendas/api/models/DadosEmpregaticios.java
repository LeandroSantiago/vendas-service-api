/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "dados_empregaticios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DadosEmpregaticios.findAll", query = "SELECT d FROM DadosEmpregaticios d"),
    @NamedQuery(name = "DadosEmpregaticios.findByIdDadosEmpregaticios", query = "SELECT d FROM DadosEmpregaticios d WHERE d.idDadosEmpregaticios = :idDadosEmpregaticios"),
    @NamedQuery(name = "DadosEmpregaticios.findByDtAdmissao", query = "SELECT d FROM DadosEmpregaticios d WHERE d.dtAdmissao = :dtAdmissao"),
    @NamedQuery(name = "DadosEmpregaticios.findByNomeGerente", query = "SELECT d FROM DadosEmpregaticios d WHERE d.nomeGerente = :nomeGerente")})
public class DadosEmpregaticios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DADOS_EMPREGATICIOS")
    private Integer idDadosEmpregaticios;
    
    @OneToOne(mappedBy = "idDadosEmpregaticios")
    private Cliente cliente;
    
    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private Cargo idCargo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dtAdmissao;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOME_GERENTE")
    private String nomeGerente;

    @OneToOne(optional = false, mappedBy = "idDadosEmpregaticios")
    private Cliente idCliente;

    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARIO")
    private double salario;
    
        @Size(max = 100)
    @Column(name = "NOME_EMPRESA")
    private String nomeEmpresa;
    
    @Size(max = 18)
    @Column(name = "CNPJ")
    private String cnpj;
    
    @Size(max = 15)
    @Column(name = "FONE_CONTATO")
    private String foneContato;
    
    @Size(max = 100)
    @Column(name = "FUNCAO")
    private String funcao;
    
    @JoinColumn(name = "ID_SEG_NEGOCIO", referencedColumnName = "ID_SEGMENTO_NEGOCIO")
    @ManyToOne
    private SegmentoNegocio idSegNegocio;
    
    @JoinColumn(name = "ID_SETOR", referencedColumnName = "ID_SETOR")
    @ManyToOne
    private Setor idSetor;

    public DadosEmpregaticios() {
    }

    public DadosEmpregaticios(Integer idDadosEmpregaticios) {
        this.idDadosEmpregaticios = idDadosEmpregaticios;
    }

    public DadosEmpregaticios(Integer idDadosEmpregaticios, Date dtAdmissao, String nomeGerente) {
        this.idDadosEmpregaticios = idDadosEmpregaticios;
        this.dtAdmissao = dtAdmissao;
        this.nomeGerente = nomeGerente;
    }

    public Integer getIdDadosEmpregaticios() {
        return idDadosEmpregaticios;
    }

    public void setIdDadosEmpregaticios(Integer idDadosEmpregaticios) {
        this.idDadosEmpregaticios = idDadosEmpregaticios;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }


    public Cliente getIdCliente() {

        if (idCliente == null) {
            idCliente = new Cliente();
        }
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Cliente getCliente() {
        
        if(cliente == null)
        {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cargo getIdCargo() {
        
        if(idCargo == null)
        {
            idCargo = new Cargo();
        }
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDadosEmpregaticios != null ? idDadosEmpregaticios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DadosEmpregaticios)) {
            return false;
        }
        DadosEmpregaticios other = (DadosEmpregaticios) object;
        if ((this.idDadosEmpregaticios == null && other.idDadosEmpregaticios != null) || (this.idDadosEmpregaticios != null && !this.idDadosEmpregaticios.equals(other.idDadosEmpregaticios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.DadosEmpregaticios[ idDadosEmpregaticios=" + idDadosEmpregaticios + " ]";
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFoneContato() {
        return foneContato;
    }

    public void setFoneContato(String foneContato) {
        this.foneContato = foneContato;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public SegmentoNegocio getIdSegNegocio() {
        return idSegNegocio;
    }

    public void setIdSegNegocio(SegmentoNegocio idSegNegocio) {
        this.idSegNegocio = idSegNegocio;
    }

    public Setor getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Setor idSetor) {
        this.idSetor = idSetor;
    }

    
}
