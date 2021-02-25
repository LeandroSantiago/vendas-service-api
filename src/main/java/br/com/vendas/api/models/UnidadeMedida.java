/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
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
@Table(name = "unidade_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadeMedida.findAll", query = "SELECT u FROM UnidadeMedida u"),
    @NamedQuery(name = "UnidadeMedida.findByIdEmpresa", query = "SELECT u FROM UnidadeMedida u where u.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "UnidadeMedida.BuscarUnidadeMedidaPorId", query = "SELECT u FROM UnidadeMedida u WHERE u.idEmpresa = :idEmpresa and u.idUnidadeMedida = :idUnidadeMedida"),
    @NamedQuery(name = "UnidadeMedida.findByDescAbrev", query = "SELECT u FROM UnidadeMedida u WHERE u.descAbrev = :descAbrev"),
    @NamedQuery(name = "UnidadeMedida.BuscarNomesUnidadeMedidas", query = "SELECT u.descricao FROM UnidadeMedida u WHERE u.idEmpresa = :idEmpresa and  u.descricao like :descricao"),
    @NamedQuery(name = "UnidadeMedida.BuscarPorDescricao", query = "SELECT u FROM UnidadeMedida u WHERE u.idEmpresa = :idEmpresa and  u.descricao = :descricao")})
public class UnidadeMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UNIDADE_MEDIDA")
    private Integer idUnidadeMedida;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_ABREV")
    private String descAbrev;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidadeMedida")
    private List<Produto> produtoList;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserCadastro;

    public UnidadeMedida() {
    }

    public UnidadeMedida(Integer idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
    }

    public UnidadeMedida(Integer idUnidadeMedida, String descAbrev, String descricao) {
        this.idUnidadeMedida = idUnidadeMedida;
        this.descAbrev = descAbrev;
        this.descricao = descricao;
    }

    public Integer getIdUnidadeMedida() {
        return idUnidadeMedida;
    }

    public void setIdUnidadeMedida(Integer idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
    }

    public String getDescAbrev() {
        return descAbrev;
    }

    public void setDescAbrev(String descAbrev) {
        this.descAbrev = descAbrev;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    /**
     *
     * @return
     */
    public Empresa getIdEmpresa() {

        if (idEmpresa == null) {
            idEmpresa = new Empresa();
        }
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadeMedida != null ? idUnidadeMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeMedida)) {
            return false;
        }
        UnidadeMedida other = (UnidadeMedida) object;
        if ((this.idUnidadeMedida == null && other.idUnidadeMedida != null) || (this.idUnidadeMedida != null && !this.idUnidadeMedida.equals(other.idUnidadeMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.UnidadeMedida[ idUnidadeMedida=" + idUnidadeMedida + " ]";
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

}
