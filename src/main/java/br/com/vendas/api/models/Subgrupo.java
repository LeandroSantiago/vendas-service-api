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
@Table(name = "subgrupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subgrupo.findAll", query = "SELECT s FROM Subgrupo s"),
    @NamedQuery(name = "Subgrupo.findByIdSubgrupo", query = "SELECT s FROM Subgrupo s WHERE s.idSubgrupo = :idSubgrupo"),
    @NamedQuery(name = "Subgrupo.findByDescSubgrupo", query = "SELECT s FROM Subgrupo s WHERE s.descSubgrupo = :descSubgrupo"),
    @NamedQuery(name = "Subgrupo.buscarSubgruposPorIdGrupoProduto", query = "SELECT s FROM Subgrupo s WHERE s.idGrupoProduto = :idGrupoProduto"),
    @NamedQuery(name = "Subgrupo.findByDtCadastro", query = "SELECT s FROM Subgrupo s WHERE s.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Subgrupo.findByDtAtualizacao", query = "SELECT s FROM Subgrupo s WHERE s.dtAtualizacao = :dtAtualizacao")})

public class Subgrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUBGRUPO")
    private Integer idSubgrupo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_SUBGRUPO")
    private String descSubgrupo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSubgrupo")
    private List<Produto> produtoList;

    @JoinColumn(name = "ID_GRUPO_PRODUTO", referencedColumnName = "ID_GRUPO_PRODUTO")
    @ManyToOne(optional = false)
    private GrupoProduto idGrupoProduto;

    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacao;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    public Subgrupo() {
    }

    public Subgrupo(Integer idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public Subgrupo(Integer idSubgrupo, String descSubgrupo, Date dtCadastro) {
        this.idSubgrupo = idSubgrupo;
        this.descSubgrupo = descSubgrupo;
        this.dtCadastro = dtCadastro;
    }

    public Integer getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(Integer idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public String getDescSubgrupo() {
        return descSubgrupo;
    }

    public void setDescSubgrupo(String descSubgrupo) {
        this.descSubgrupo = descSubgrupo;
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

    public GrupoProduto getIdGrupoProduto() {

        if (idGrupoProduto == null) {
            idGrupoProduto = new GrupoProduto();
        }
        return idGrupoProduto;
    }

    public void setIdGrupoProduto(GrupoProduto idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }

    public Usuario getIdUserAtualizacao() {
        return idUserAtualizacao;
    }

    public void setIdUserAtualizacao(Usuario idUserAtualizacao) {
        this.idUserAtualizacao = idUserAtualizacao;
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
        hash += (idSubgrupo != null ? idSubgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subgrupo)) {
            return false;
        }
        Subgrupo other = (Subgrupo) object;
        if ((this.idSubgrupo == null && other.idSubgrupo != null) || (this.idSubgrupo != null && !this.idSubgrupo.equals(other.idSubgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Subgrupo[ idSubgrupo=" + idSubgrupo + " ]";
    }

}
