/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "usuario_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioGrupo.findAll", query = "SELECT u FROM UsuarioGrupo u"),
    @NamedQuery(name = "UsuarioGrupo.findByusername", query = "SELECT u FROM UsuarioGrupo u WHERE u.username = :username"),
    @NamedQuery(name = "UsuarioGrupo.findByGrupoNomeGrupo", query = "SELECT u FROM UsuarioGrupo u WHERE u.grupoNomeGrupo = :grupoNomeGrupo")})
public class UsuarioGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "GRUPO_NOME_GRUPO")
    private String grupoNomeGrupo;

    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
    @OneToOne(optional = false, mappedBy = "grupo")
    private Usuario usuario;

    public UsuarioGrupo() {
    }

    public UsuarioGrupo(String username) {
        this.username = username;
    }

    public UsuarioGrupo(String username, String grupoNomeGrupo) {
        this.username = username;
        this.grupoNomeGrupo = grupoNomeGrupo;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getGrupoNomeGrupo() {
        return grupoNomeGrupo;
    }

    public void setGrupoNomeGrupo(String grupoNomeGrupo) {
        this.grupoNomeGrupo = grupoNomeGrupo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioGrupo)) {
            return false;
        }
        UsuarioGrupo other = (UsuarioGrupo) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Pessoa.UsuarioGrupo_1[ username=" + username + " ]";
    }

}
