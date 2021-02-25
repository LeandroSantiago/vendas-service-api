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
@Table(name = "estoque_produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstoqueProdutos.findAll", query = "SELECT e FROM EstoqueProdutos e"),
    @NamedQuery(name = "EstoqueProdutos.findEstoqueProdutosByIdLancamento", query = "SELECT e FROM EstoqueProdutos e WHERE e.idEmpresa = :idEmpresa and  e.idLancamento = :idLancamento"),
    @NamedQuery(name = "EstoqueProdutos.findEstoqueProdutosByIdProduto", query = "SELECT e FROM EstoqueProdutos e WHERE e.idEmpresa = :idEmpresa and  e.idProduto = :idProduto"),
    @NamedQuery(name = "EstoqueProdutos.findByDtEntrada", query = "SELECT e FROM EstoqueProdutos e WHERE e.dtEntrada = :dtEntrada"),
    @NamedQuery(name = "EstoqueProdutos.findByQuantidade", query = "SELECT e FROM EstoqueProdutos e WHERE e.quantidade = :quantidade"),
    @NamedQuery(name = "EstoqueProdutos.findByQuantidadeMinima", query = "SELECT e FROM EstoqueProdutos e WHERE e.quantidadeMinima = :quantidadeMinima"),
    @NamedQuery(name = "EstoqueProdutos.findByDtVencimento", query = "SELECT e FROM EstoqueProdutos e WHERE e.dtVencimento = :dtVencimento"),
    @NamedQuery(name = "EstoqueProdutos.findByObs", query = "SELECT e FROM EstoqueProdutos e WHERE e.obs = :obs"),
    @NamedQuery(name = "EstoqueProdutos.findByDtAtualizacao", query = "SELECT e FROM EstoqueProdutos e WHERE e.dtAtualizacao = :dtAtualizacao")})
public class EstoqueProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTOQUE_PRODUTOS")
    private Integer idEstoqueProdutos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dtEntrada;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE_MINIMA")
    private int quantidadeMinima;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_VENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    
    @Size(max = 45)
    @Column(name = "OBS")
    private String obs;
    
    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstoqueProdutos")
    private List<EstoqueVenda> estoqueVendaList;
    
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;
    
    @JoinColumn(name = "ID_LANCAMENTO", referencedColumnName = "ID_LANCAMENTO")
    @ManyToOne(optional = false)
    private Lancamentos idLancamento;
    
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    @ManyToOne(optional = false)
    private Produto idProduto;
    
    @JoinColumn(name = "ID_USER_ATUALIZACAO_ESTOQUE_COMPRA", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacaoEstoqueCompra;
    
    @JoinColumn(name = "ID_USER_CADASTRO_ESTOQUE_COMPRA", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastroEstoqueCompra;

    public EstoqueProdutos() {
    }

    public EstoqueProdutos(Integer idEstoqueProdutos) {
        this.idEstoqueProdutos = idEstoqueProdutos;
    }

    public EstoqueProdutos(Integer idEstoqueProdutos, Date dtEntrada, int quantidade, int quantidadeMinima, Date dtVencimento) {
        this.idEstoqueProdutos = idEstoqueProdutos;
        this.dtEntrada = dtEntrada;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.dtVencimento = dtVencimento;
    }

    public Integer getIdEstoqueProdutos() {
        return idEstoqueProdutos;
    }

    public void setIdEstoqueProdutos(Integer idEstoqueProdutos) {
        this.idEstoqueProdutos = idEstoqueProdutos;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    @XmlTransient
    public List<EstoqueVenda> getEstoqueVendaList() {
        return estoqueVendaList;
    }

    public void setEstoqueVendaList(List<EstoqueVenda> estoqueVendaList) {
        this.estoqueVendaList = estoqueVendaList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Lancamentos getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(Lancamentos idLancamento) {
        this.idLancamento = idLancamento;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Usuario getIdUserAtualizacaoEstoqueCompra() {
        return idUserAtualizacaoEstoqueCompra;
    }

    public void setIdUserAtualizacaoEstoqueCompra(Usuario idUserAtualizacaoEstoqueCompra) {
        this.idUserAtualizacaoEstoqueCompra = idUserAtualizacaoEstoqueCompra;
    }

    public Usuario getIdUserCadastroEstoqueCompra() {
        return idUserCadastroEstoqueCompra;
    }

    public void setIdUserCadastroEstoqueCompra(Usuario idUserCadastroEstoqueCompra) {
        this.idUserCadastroEstoqueCompra = idUserCadastroEstoqueCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoqueProdutos != null ? idEstoqueProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstoqueProdutos)) {
            return false;
        }
        EstoqueProdutos other = (EstoqueProdutos) object;
        if ((this.idEstoqueProdutos == null && other.idEstoqueProdutos != null) || (this.idEstoqueProdutos != null && !this.idEstoqueProdutos.equals(other.idEstoqueProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.EstoqueProdutos[ idEstoqueProdutos=" + idEstoqueProdutos + " ]";
    }
    
}
