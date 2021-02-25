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
@Table(name = "departamento_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartamentoProduto.findAll", query = "SELECT d FROM DepartamentoProduto d"),
    @NamedQuery(name = "DepartamentoProduto.findByIdDepartamentoProduto", query = "SELECT d FROM DepartamentoProduto d WHERE d.idDepartamentoProduto = :idDepartamentoProduto"),
    @NamedQuery(name = "DepartamentoProduto.findByDescDepartamentoProduto", query = "SELECT d FROM DepartamentoProduto d WHERE d.idEmpresa = :idEmpresa and d.descDepartamentoProduto = :descDepartamentoProduto"),
    @NamedQuery(name = "DepartamentoProduto.BuscarNomesDeptosProduto", query = "SELECT d.descDepartamentoProduto FROM DepartamentoProduto d WHERE d.idEmpresa = :idEmpresa and  d.descDepartamentoProduto like :descDepartamentoProduto"),
    @NamedQuery(name = "DepartamentoProduto.findByDtCadastro", query = "SELECT d FROM DepartamentoProduto d WHERE d.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "DepartamentoProduto.buscarDeptoProdutosPorEmpresa", query = "SELECT d FROM DepartamentoProduto d WHERE d.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "DepartamentoProduto.findByDtAtualizacao", query = "SELECT d FROM DepartamentoProduto d WHERE d.dtAtualizacao = :dtAtualizacao")})
public class DepartamentoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DEPARTAMENTO_PRODUTO")
    private Integer idDepartamentoProduto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_DEPARTAMENTO_PRODUTO")
    private String descDepartamentoProduto;

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

    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDeptoProduto")
    private List<Produto> produtoList;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public DepartamentoProduto() {
    }

    public DepartamentoProduto(Integer idDepartamentoProduto) {
        this.idDepartamentoProduto = idDepartamentoProduto;
    }

    public Integer getIdDepartamentoProduto() {
        return idDepartamentoProduto;
    }

    public void setIdDepartamentoProduto(Integer idDepartamentoProduto) {
        this.idDepartamentoProduto = idDepartamentoProduto;
    }

    public String getDescDepartamentoProduto() {
        return descDepartamentoProduto;
    }

    public void setDescDepartamentoProduto(String descDepartamentoProduto) {
        this.descDepartamentoProduto = descDepartamentoProduto;
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

    public Usuario getIdUserAtualizacao() {

        if (idUserAtualizacao == null) {
            idUserAtualizacao = new Usuario();
        }
        return idUserAtualizacao;
    }

    public void setIdUserAtualizacao(Usuario idUserAtualizacao) {
        this.idUserAtualizacao = idUserAtualizacao;
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        if (produtoList == null) {
            produtoList = new ArrayList<>();
        }
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamentoProduto != null ? idDepartamentoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoProduto)) {
            return false;
        }
        DepartamentoProduto other = (DepartamentoProduto) object;
        if ((this.idDepartamentoProduto == null && other.idDepartamentoProduto != null) || (this.idDepartamentoProduto != null && !this.idDepartamentoProduto.equals(other.idDepartamentoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.DepartamentoProduto[ idDepartamentoProduto=" + idDepartamentoProduto + " ]";
    }

}
