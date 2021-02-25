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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sleandro
 *
 * Classe responsável por representar a Entidade Pessoa Física
 *
 * @author sleandro
 */
@Entity
@Table(name = "pessoa_fisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p"),
    @NamedQuery(name = "PessoaFisica.findByIdPessoa", query = "SELECT p FROM PessoaFisica p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "PessoaFisica.findByRg", query = "SELECT p FROM PessoaFisica p WHERE p.rg = :rg"),
    @NamedQuery(name = "PessoaFisica.consultarClientePorCPF", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf and p.cliente is not null"),
    @NamedQuery(name = "PessoaFisica.ConsultarPorNome", query = "SELECT p FROM PessoaFisica p WHERE p.funcionario is not null and p.nome = :nome"),
    @NamedQuery(name = "PessoaFisica.ConsultarClientesPorNome", 
            query = "SELECT p FROM PessoaFisica p WHERE p.cliente is not null and  p.nome like :nome"),
    @NamedQuery(name = "PessoaFisica.ConsultarNomeFuncionarios", query = "SELECT p FROM PessoaFisica p WHERE p.funcionario is not null and  p.nome like :nome"),
    @NamedQuery(name = "PessoaFisica.findByNomePai", query = "SELECT p FROM PessoaFisica p WHERE p.nomePai = :nomePai"),
    @NamedQuery(name = "PessoaFisica.findByNomeMae", query = "SELECT p FROM PessoaFisica p WHERE p.nomeMae = :nomeMae"),
    @NamedQuery(name = "PessoaFisica.findByNacionalidade", query = "SELECT p FROM PessoaFisica p WHERE p.nacionalidade = :nacionalidade"),
    @NamedQuery(name = "PessoaFisica.findByNaturalidade", query = "SELECT p FROM PessoaFisica p WHERE p.naturalidade = :naturalidade")})

@PrimaryKeyJoinColumn(name = "ID_PESSOA")
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa implements Serializable {

    @OneToOne(mappedBy = "idPessoa", cascade = CascadeType.ALL)
    private Funcionario funcionario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 15)
    @Column(name = "RG")
    private String rg;

    @Basic(optional = false)
    //@NotNull
    @Size(max = 15)
    @Column(name = "CPF")
    private String cpf;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "NOME_PAI")
    private String nomePai;

    @Basic(optional = false)
    @NotNull
    @Size(max = 50)
    @Column(name = "NOME_MAE")
    private String nomeMae;

    @Size(max = 45)
    @Column(name = "NACIONALIDADE")
    private String nacionalidade;

    @Size(max = 50)
    @Column(name = "NATURALIDADE")
    private String naturalidade;

    @JoinColumn(name = "ID_SEXO", referencedColumnName = "ID_SEXO")
    @ManyToOne(optional = false)
    private Sexo idSexo;

    @JoinColumn(name = "ID_ESTADO_CIVIL", referencedColumnName = "ID_ESTADO_CIVIL")
    @ManyToOne(optional = false)
    private EstadoCivil idEstadoCivil;

    @JoinColumn(name = "ID_ESCOLARIDADE", referencedColumnName = "ID_ESCOLARIDADE")
    @ManyToOne(optional = false)
    private Escolaridade idEscolaridade;

    @JoinColumn(name = "ID_PROFISSAO", referencedColumnName = "ID_PROFISSAO")
    @ManyToOne(optional = false)
    private Profissao idProfissao;

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Sexo getIdSexo() {

        if (idSexo == null) {
            idSexo = new Sexo();
        }
        return idSexo;
    }

    public void setIdSexo(Sexo idSexo) {
        this.idSexo = idSexo;
    }

    public EstadoCivil getIdEstadoCivil() {

        if (idEstadoCivil == null) {
            idEstadoCivil = new EstadoCivil();
        }
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Escolaridade getIdEscolaridade() {

        if (idEscolaridade == null) {
            idEscolaridade = new Escolaridade();
        }
        return idEscolaridade;
    }

    public void setIdEscolaridade(Escolaridade idEscolaridade) {
        this.idEscolaridade = idEscolaridade;
    }

    public Profissao getIdProfissao() {

        if (idProfissao == null) {
            idProfissao = new Profissao();
        }
        return idProfissao;
    }

    public void setIdProfissao(Profissao idProfissao) {
        this.idProfissao = idProfissao;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }


    public Funcionario getFuncionario() {

        if (funcionario == null) {
            funcionario = new Funcionario();
        }
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
