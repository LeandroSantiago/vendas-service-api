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
@Table(name = "marca_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaProduto.findAll", query = "SELECT m FROM MarcaProduto m"),
    @NamedQuery(name = "MarcaProduto.findByIdMarcaProduto", query = "SELECT m FROM MarcaProduto m WHERE m.idMarcaProduto = :idMarcaProduto"),
    @NamedQuery(name = "MarcaProduto.buscarMarcasPorDescMarca", query = "SELECT m FROM MarcaProduto m WHERE m.idEmpresa = :idEmpresa and m.descMarca = :descMarca"),
    @NamedQuery(name = "MarcaProduto.buscarNomesMarca", query = "SELECT m.descMarca FROM MarcaProduto m WHERE m.idEmpresa = :idEmpresa and m.descMarca like :descMarca"),
    @NamedQuery(name = "MarcaProduto.buscarMarcaProdutoPorIdFornecedor", query = "SELECT m FROM MarcaProduto m WHERE m.idEmpresa = :idEmpresa and m.idFornecdor = :idFornecdor"),
    @NamedQuery(name = "MarcaProduto.buscarMarcasPorEmpresa", query = "SELECT m FROM MarcaProduto m WHERE m.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "MarcaProduto.findByDtCadastro", query = "SELECT m FROM MarcaProduto m WHERE m.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "MarcaProduto.findByDtAtualizacao", query = "SELECT m FROM MarcaProduto m WHERE m.dtAtualizacao = :dtAtualizacao")})

public class MarcaProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MARCA_PRODUTO")
    private Integer idMarcaProduto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_MARCA")
    private String descMarca;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarcaProduto")
    private List<Produto> produtoList;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @JoinColumn(name = "ID_FORNECDOR", referencedColumnName = "ID_FORNECEDOR")
    @ManyToOne(optional = false)
    private Fornecedor idFornecdor;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserCadastro;

    public MarcaProduto() {
    }

    public MarcaProduto(Integer idMarcaProduto) {
        this.idMarcaProduto = idMarcaProduto;
    }

    public MarcaProduto(Integer idMarcaProduto, String descMarca, Date dtCadastro) {
        this.idMarcaProduto = idMarcaProduto;
        this.descMarca = descMarca;
        this.dtCadastro = dtCadastro;
    }

    public Integer getIdMarcaProduto() {
        return idMarcaProduto;
    }

    public void setIdMarcaProduto(Integer idMarcaProduto) {
        this.idMarcaProduto = idMarcaProduto;
    }

    public String getDescMarca() {
        return descMarca;
    }

    public void setDescMarca(String descMarca) {
        this.descMarca = descMarca;
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
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Fornecedor getIdFornecdor() {
        if (idFornecdor == null) {
            idFornecdor = new Fornecedor();
        }
        return idFornecdor;
    }

    public void setIdFornecdor(Fornecedor idFornecdor) {
        this.idFornecdor = idFornecdor;
    }

    public Usuario getIdUserCadastro() {
        return idUserCadastro;
    }

    public void setIdUserCadastro(Usuario idUserCadastro) {
        this.idUserCadastro = idUserCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMarcaProduto != null ? idMarcaProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaProduto)) {
            return false;
        }
        MarcaProduto other = (MarcaProduto) object;
        if ((this.idMarcaProduto == null && other.idMarcaProduto != null) || (this.idMarcaProduto != null && !this.idMarcaProduto.equals(other.idMarcaProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.MarcaProduto[ idMarcaProduto=" + idMarcaProduto + " ]";
    }

}
