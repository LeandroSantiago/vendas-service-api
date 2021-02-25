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
@Table(name = "autorizados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorizados.findAll", query = "SELECT a FROM Autorizados a"),
    @NamedQuery(name = "Autorizados.findByIdAutorizados", query = "SELECT a FROM Autorizados a WHERE a.idAutorizados = :idAutorizados"),
    @NamedQuery(name = "Autorizados.findByNomeCompleto", query = "SELECT a FROM Autorizados a WHERE a.nomeCompleto = :nomeCompleto"),
    @NamedQuery(name = "Autorizados.findByRg", query = "SELECT a FROM Autorizados a WHERE a.rg = :rg"),
    @NamedQuery(name = "Autorizados.findByCpf", query = "SELECT a FROM Autorizados a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Autorizados.findByDtNacimento", query = "SELECT a FROM Autorizados a WHERE a.dtNacimento = :dtNacimento"),
    @NamedQuery(name = "Autorizados.findByDtCadastro", query = "SELECT a FROM Autorizados a WHERE a.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Autorizados.findByDtAtualizacao", query = "SELECT a FROM Autorizados a WHERE a.dtAtualizacao = :dtAtualizacao")})
public class Autorizados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AUTORIZADOS")
    private Integer idAutorizados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;
    @Size(max = 12)
    @Column(name = "RG")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_NACIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtNacimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO")
    @ManyToOne(optional = false)
    private Endereco idEndereco;
    @JoinColumn(name = "ID_ESTADO_CIVIL", referencedColumnName = "ID_ESTADO_CIVIL")
    @ManyToOne(optional = false)
    private EstadoCivil idEstadoCivil;
    @JoinColumn(name = "ID_PROFISSAO", referencedColumnName = "ID_PROFISSAO")
    @ManyToOne(optional = false)
    private Profissao idProfissao;
    @JoinColumn(name = "ID_SEXO", referencedColumnName = "ID_SEXO")
    @ManyToOne(optional = false)
    private Sexo idSexo;

    /**
     *
     */
    public Autorizados() {
    }

    /**
     *
     * @param idAutorizados
     */
    public Autorizados(Integer idAutorizados) {
        this.idAutorizados = idAutorizados;
    }

    /**
     *
     * @param idAutorizados
     * @param nomeCompleto
     * @param cpf
     * @param dtNacimento
     * @param dtCadastro
     */
    public Autorizados(Integer idAutorizados, String nomeCompleto, String cpf, Date dtNacimento, Date dtCadastro) {
        this.idAutorizados = idAutorizados;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dtNacimento = dtNacimento;
        this.dtCadastro = dtCadastro;
    }

    /**
     *
     * @return
     */
    public Integer getIdAutorizados() {
        return idAutorizados;
    }

    /**
     *
     * @param idAutorizados
     */
    public void setIdAutorizados(Integer idAutorizados) {
        this.idAutorizados = idAutorizados;
    }

    /**
     *
     * @return
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     *
     * @param nomeCompleto
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     *
     * @return
     */
    public String getRg() {
        return rg;
    }

    /**
     *
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     *
     * @return
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return
     */
    public Date getDtNacimento() {
        return dtNacimento;
    }

    /**
     *
     * @param dtNacimento
     */
    public void setDtNacimento(Date dtNacimento) {
        this.dtNacimento = dtNacimento;
    }

    /**
     *
     * @return
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     *
     * @param dtCadastro
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     *
     * @return
     */
    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    /**
     *
     * @param dtAtualizacao
     */
    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    /**
     *
     * @return
     */
    public Cliente getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     */
    public Endereco getIdEndereco() {
        return idEndereco;
    }

    /**
     *
     * @param idEndereco
     */
    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     *
     * @return
     */
    public EstadoCivil getIdEstadoCivil() {
        return idEstadoCivil;
    }

    /**
     *
     * @param idEstadoCivil
     */
    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    /**
     *
     * @return
     */
    public Profissao getIdProfissao() {
        return idProfissao;
    }

    /**
     *
     * @param idProfissao
     */
    public void setIdProfissao(Profissao idProfissao) {
        this.idProfissao = idProfissao;
    }

    /**
     *
     * @return
     */
    public Sexo getIdSexo() {
        return idSexo;
    }

    /**
     *
     * @param idSexo
     */
    public void setIdSexo(Sexo idSexo) {
        this.idSexo = idSexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutorizados != null ? idAutorizados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorizados)) {
            return false;
        }
        Autorizados other = (Autorizados) object;
        if ((this.idAutorizados == null && other.idAutorizados != null) || (this.idAutorizados != null && !this.idAutorizados.equals(other.idAutorizados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Autorizados[ idAutorizados=" + idAutorizados + " ]";
    }

}
