/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "pessoa_juridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p"),
    @NamedQuery(name = "PessoaJuridica.findByIdPessoa", query = "SELECT p FROM PessoaJuridica p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "PessoaJuridica.findByRazaoSocial", query = "SELECT p FROM PessoaJuridica p WHERE p.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "PessoaJuridica.findByCgc", query = "SELECT p FROM PessoaJuridica p WHERE p.cgc = :cgc"),
    @NamedQuery(name = "PessoaJuridica.findByInscricaoEstadual", query = "SELECT p FROM PessoaJuridica p WHERE p.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "PessoaJuridica.findByContatoEmpresa", query = "SELECT p FROM PessoaJuridica p WHERE p.contatoEmpresa = :contatoEmpresa"),
    @NamedQuery(name = "PessoaJuridica.findByFone", query = "SELECT p FROM PessoaJuridica p WHERE p.fone = :fone"),
    @NamedQuery(name = "PessoaJuridica.findByFax", query = "SELECT p FROM PessoaJuridica p WHERE p.fax = :fax")})
@PrimaryKeyJoinColumn(name = "ID_PESSOA")
@DiscriminatorValue("J")
public class PessoaJuridica extends Pessoa implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Size(max = 14)
    @Column(name = "CGC")
    private String cgc;

    @Size(max = 14)
    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;

    @Size(max = 45)
    @Column(name = "CONTATO_EMPRESA")
    private String contatoEmpresa;

    @Size(max = 15)
    @Column(name = "FONE")
    private String fone;

    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "FAX")
    private String fax;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Empresa empresa;
    
    public PessoaJuridica() {
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getContatoEmpresa() {
        return contatoEmpresa;
    }

    public void setContatoEmpresa(String contatoEmpresa) {
        this.contatoEmpresa = contatoEmpresa;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}