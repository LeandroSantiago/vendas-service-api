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
import java.util.Objects;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "grupo_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoProduto.findAll", query = "SELECT g FROM GrupoProduto g"),
    @NamedQuery(name = "GrupoProduto.findByIdGrupoProduto", query = "SELECT g FROM GrupoProduto g WHERE g.idGrupoProduto = :idGrupoProduto"),
    @NamedQuery(name = "GrupoProduto.findByIdEmpresa", query = "SELECT g FROM GrupoProduto g WHERE g.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "GrupoProduto.buscarDescricaoGrupo", query = "SELECT g.descricao FROM GrupoProduto g WHERE g.idEmpresa = :idEmpresa and  g.descricao like :descricao"),
    @NamedQuery(name = "GrupoProduto.buscarGrupoporDescricao", query = "SELECT g FROM GrupoProduto g WHERE g.idEmpresa = :idEmpresa and g.descricao = :descricao")})
public class GrupoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GRUPO_PRODUTO")
    private Integer idGrupoProduto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupoProduto")
    private List<Subgrupo> subgrupoList;

    public GrupoProduto() {
    }

    public Subgrupo adicionarSubGrupos(Subgrupo subGrupo) {
        getSubgrupoList().add(subGrupo);
        subGrupo.setIdGrupoProduto(this);

        return subGrupo;
    }

    public Subgrupo excluiSubGrupos(Subgrupo subGrupo) {
        getSubgrupoList().remove(subGrupo);
        subGrupo.setIdGrupoProduto(null);

        return subGrupo;
    }

    public GrupoProduto(Integer idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }

    public GrupoProduto(Integer idGrupoProduto, String descricao) {
        this.idGrupoProduto = idGrupoProduto;
        this.descricao = descricao;
    }

    public Integer getIdGrupoProduto() {
        return idGrupoProduto;
    }

    public void setIdGrupoProduto(Integer idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Usuario getIdUserCadastro() {

        if (idUserCadastro == null) {
            idUserCadastro = new Usuario();
        }
        return idUserCadastro;
    }

    public void setIdUserCadastro(Usuario idUserCadastro) {
        this.idUserCadastro = idUserCadastro;
    }

    @XmlTransient
    public List<Subgrupo> getSubgrupoList() {

        if (subgrupoList == null) {
            subgrupoList = new ArrayList<>();
        }
        return subgrupoList;
    }

    public void setSubgrupoList(List<Subgrupo> subgrupoList) {
        this.subgrupoList = subgrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idGrupoProduto);
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
        final GrupoProduto other = (GrupoProduto) obj;
        if (!Objects.equals(this.idGrupoProduto, other.idGrupoProduto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.GrupoProduto[ idGrupoProduto=" + idGrupoProduto + " ]";
    }

}
