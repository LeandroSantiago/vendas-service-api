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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll",
            query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdPessoa", 
            query = "SELECT p FROM Pessoa p WHERE p.idPessoa = :idPessoa"),
    @NamedQuery(name = "Pessoa.buscarPorUsuario", 
            query = "SELECT p FROM Pessoa p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Pessoa.findByNomeCompleto", 
            query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoa.consultarNome", 
            query = "SELECT p FROM Pessoa p WHERE p.nome like :nome"),
    @NamedQuery(name = "Pessoa.findByDtCadastro", 
            query = "SELECT p FROM Pessoa p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Pessoa.findByDtAtualizacao", 
            query = "SELECT p FROM Pessoa p WHERE p.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "Pessoa.findByEmail", 
            query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
    @NamedQuery(name = "Pessoa.findByStatus", 
            query = "SELECT p FROM Pessoa p WHERE p.status = :status"),
    @NamedQuery(name = "Pessoa.findByTelefone", 
            query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone")})

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_PESSOA", discriminatorType = DiscriminatorType.STRING)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Endereco endereco;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobreNome;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    //@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Email inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private boolean status;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONE")
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idPessoa")
    private Usuario usuario;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserCadastro;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TIPO_PESSOA")
    private String tipoPessoa;

    @OneToOne(mappedBy = "idPessoa")
    private Cliente cliente;

    public Pessoa() {
    }

    /**
     *
     * @param idPessoa
     */
    public Pessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     *
     * @return
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     *
     * @param idPessoa
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public boolean getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*
     * @return usuario
     */
    public Usuario getUsuario() {

        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getIdUserCadastro() {

        if (idUserCadastro == null) {
            idUserCadastro = new Usuario();
        }
        return idUserCadastro;
    }

    public void setIdUserCadastro(Usuario idUserCadastro) {
        this.idUserCadastro = idUserCadastro;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Endereco getEndereco() {

        if (endereco == null) {
            endereco = new Endereco();
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Cliente getCliente() {

        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPessoa != null ? idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idPessoa == null && other.idPessoa != null) || (this.idPessoa != null && !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
