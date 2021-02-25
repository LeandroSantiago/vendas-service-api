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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "estoque_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstoqueVenda.findAll", query = "SELECT e FROM EstoqueVenda e"),
    @NamedQuery(name = "EstoqueVenda.findByIdEstoqueVenda", query = "SELECT e FROM EstoqueVenda e WHERE e.idEstoqueVenda = :idEstoqueVenda"),
    @NamedQuery(name = "EstoqueVenda.findByQuantidade", query = "SELECT e FROM EstoqueVenda e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "EstoqueVenda.findByDtAlteracao", query = "SELECT e FROM EstoqueVenda e WHERE e.dtAlteracao = :dtAlteracao"),
    @NamedQuery(name = "EstoqueVenda.findByQtdMinima", query = "SELECT e FROM EstoqueVenda e WHERE e.qtdMinima = :qtdMinima")})
public class EstoqueVenda implements Serializable {

    @JoinColumn(name = "ID_ESTOQUE_PRODUTOS", referencedColumnName = "ID_ESTOQUE_PRODUTOS")
    @ManyToOne(optional = false)
    private EstoqueProdutos idEstoqueProdutos;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTOQUE_VENDA")
    private Integer idEstoqueVenda;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    
    @Column(name = "DT_ALTERACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAlteracao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_MINIMA")
    private int qtdMinima;
    
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    @ManyToOne(optional = false)
    private Produto idProduto;
    
    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacao;
    
    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    public EstoqueVenda() {
    }

    public EstoqueVenda(Integer idEstoqueVenda) {
        this.idEstoqueVenda = idEstoqueVenda;
    }

    public EstoqueVenda(Integer idEstoqueVenda, int quantidade, int qtdMinima) {
        this.idEstoqueVenda = idEstoqueVenda;
        this.quantidade = quantidade;
        this.qtdMinima = qtdMinima;
    }

    public Integer getIdEstoqueVenda() {
        return idEstoqueVenda;
    }

    public void setIdEstoqueVenda(Integer idEstoqueVenda) {
        this.idEstoqueVenda = idEstoqueVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
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
        hash += (idEstoqueVenda != null ? idEstoqueVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstoqueVenda)) {
            return false;
        }
        EstoqueVenda other = (EstoqueVenda) object;
        if ((this.idEstoqueVenda == null && other.idEstoqueVenda != null) || (this.idEstoqueVenda != null && !this.idEstoqueVenda.equals(other.idEstoqueVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.EstoqueVenda[ idEstoqueVenda=" + idEstoqueVenda + " ]";
    }

    public EstoqueProdutos getIdEstoqueProdutos() {
        return idEstoqueProdutos;
    }

    public void setIdEstoqueProdutos(EstoqueProdutos idEstoqueProdutos) {
        this.idEstoqueProdutos = idEstoqueProdutos;
    }

}
