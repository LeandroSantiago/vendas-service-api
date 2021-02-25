/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.vendas.api.utils.CriptografiaUtil;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findUserByidPessoa", query = "SELECT u FROM Usuario u WHERE u.idPessoa = :idPessoa"),
    @NamedQuery(name = "Usuario.findByLoginPassword", query = "SELECT u FROM Usuario u WHERE u.username = :username and  u.password = :password"),
    @NamedQuery(name = "Usuario.findByDtCadastro", query = "SELECT u FROM Usuario u WHERE u.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Usuario.findByDtAtualizacao", query = "SELECT u FROM Usuario u WHERE u.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "Usuario.findByAtivo", query = "SELECT u FROM Usuario u WHERE u.ativo = :ativo")})
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    
    @Size(max = 45)
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;

    @Basic(optional = false)
    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Email inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "USERNAME")
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASSWORD")
    private String password;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @Column(name = "ATIVO")
    private Boolean ativo;

    @OneToOne(cascade = CascadeType.ALL)
    private UsuarioGrupo grupo;

    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @OneToOne(optional = false)
    private Pessoa idPessoa;

    /**
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param idUsuario
     */
    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     *
     * @param idUsuario
     * @param username
     * @param password
     * @param dtCadastro
     */
    public Usuario(Integer idUsuario, String username, String password, Date dtCadastro) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.dtCadastro = dtCadastro;
    }

    /**
     *
     * @return
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * @throws NoSuchAlgorithmException
     */
    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = CriptografiaUtil.encriptografarSenha(password);
        //this.password = password;
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
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     *
     * @param ativo
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    /**
     *
     * @return
     */
    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    /**
     *
     * @param idPessoa
     */
    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public UsuarioGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(UsuarioGrupo grupo) {
		this.grupo = grupo;
	}

	@Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + '}';
    }

}
