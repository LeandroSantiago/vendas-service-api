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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.buscarProdutoPorIdProduto", query = "SELECT p FROM Produto p WHERE p.idEmpresa = :idEmpresa and p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.buscarPorNome", query = "SELECT p.nomeProduto FROM Produto p WHERE p.idEmpresa = :idEmpresa and p.nomeProduto like :nomeProduto"),
    @NamedQuery(name = "Produto.findByCodBarra", query = "SELECT p FROM Produto p WHERE p.idEmpresa = :idEmpresa and  p.codBarra = :codBarra"),
    @NamedQuery(name = "Produto.buscarProdutoPorNomeProduto", query = "SELECT p FROM Produto p WHERE p.idEmpresa = :idEmpresa and p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto.findByDescProduto", query = "SELECT p FROM Produto p WHERE p.descProduto = :descProduto"),
    @NamedQuery(name = "Produto.findByDtCadastro", query = "SELECT p FROM Produto p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Produto.findByDtAtualizacao", query = "SELECT p FROM Produto p WHERE p.dtAtualizacao = :dtAtualizacao"),
    @NamedQuery(name = "Produto.buscarProdutosPorEmpresa", query = "SELECT p FROM Produto p WHERE p.idEmpresa = :idEmpresa")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUTO")
    private Integer idProduto;

    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 20)
    @Column(name = "COD_BARRA")
    private String codBarra;

    @JoinColumn(name = "ID_PRECO_PRODUTO", referencedColumnName = "ID_PRECO_PRODUTO")
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private PrecoProduto idPrecoProduto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DESC_PRODUTO")
    private String descProduto;

    @Basic(optional = false)
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @Column(name = "QTD_PRODUTO")
    private Integer qtdProduto;

    @Column(name = "IMAGEM_PRODUTO")
    private String imagemProduto;

    @Lob
    @Column
    private byte[] foto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<ItemLancamento> itemLancamentoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<EstoqueProdutos> estoqueProdutosList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<EstoqueVenda> estoqueVendaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<ItensVenda> itensVendaList;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @JoinColumn(name = "ID_MARCA_PRODUTO", referencedColumnName = "ID_MARCA_PRODUTO")
    @ManyToOne(optional = false)
    private MarcaProduto idMarcaProduto;

    @JoinColumn(name = "ID_UNIDADE_MEDIDA", referencedColumnName = "ID_UNIDADE_MEDIDA")
    @ManyToOne(optional = false)
    private UnidadeMedida idUnidadeMedida;

    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacao;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadstro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<ItensPedido> itensPedidoList;

    @JoinColumn(name = "ID_SUBGRUPO", referencedColumnName = "ID_SUBGRUPO")
    @ManyToOne(optional = false)
    private Subgrupo idSubgrupo;

    @JoinColumn(name = "ID_DEPTO_PRODUTO", referencedColumnName = "ID_DEPARTAMENTO_PRODUTO")
    @ManyToOne(optional = false)
    private DepartamentoProduto idDeptoProduto;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
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

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    @XmlTransient
    public List<EstoqueVenda> getEstoqueVendaList() {
        return estoqueVendaList;
    }

    public void setEstoqueVendaList(List<EstoqueVenda> estoqueVendaList) {
        this.estoqueVendaList = estoqueVendaList;
    }

    @XmlTransient
    public List<ItensVenda> getItensVendaList() {
        return itensVendaList;
    }

    public void setItensVendaList(List<ItensVenda> itensVendaList) {
        this.itensVendaList = itensVendaList;
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

    public MarcaProduto getIdMarcaProduto() {
        if (idMarcaProduto == null) {
            idMarcaProduto = new MarcaProduto();

        }
        return idMarcaProduto;
    }

    public void setIdMarcaProduto(MarcaProduto idMarcaProduto) {
        this.idMarcaProduto = idMarcaProduto;
    }

    public UnidadeMedida getIdUnidadeMedida() {

        if (idUnidadeMedida == null) {
            idUnidadeMedida = new UnidadeMedida();
        }
        return idUnidadeMedida;
    }

    public void setIdUnidadeMedida(UnidadeMedida idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
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

    public Usuario getIdUserCadstro() {

        if (idUserCadstro == null) {
            idUserCadstro = new Usuario();
        }
        return idUserCadstro;
    }

    public void setIdUserCadstro(Usuario idUserCadstro) {
        this.idUserCadstro = idUserCadstro;
    }

    @XmlTransient
    public List<ItensPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItensPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }

    public PrecoProduto getIdPrecoProduto() {

        if (idPrecoProduto == null) {
            idPrecoProduto = new PrecoProduto();
        }
        return idPrecoProduto;
    }

    public void setIdPrecoProduto(PrecoProduto idPrecoProduto) {
        this.idPrecoProduto = idPrecoProduto;
    }

    public Subgrupo getIdSubgrupo() {

        if (idSubgrupo == null) {
            idSubgrupo = new Subgrupo();
        }
        return idSubgrupo;
    }

    public void setIdSubgrupo(Subgrupo idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public DepartamentoProduto getIdDeptoProduto() {
        if (idDeptoProduto == null) {
            idDeptoProduto = new DepartamentoProduto();
        }
        return idDeptoProduto;
    }

    public void setIdDeptoProduto(DepartamentoProduto idDeptoProduto) {
        this.idDeptoProduto = idDeptoProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Produto[ idProduto=" + idProduto + " ]";
    }

    @XmlTransient
    public List<ItemLancamento> getItemLancamentoList() {
        return itemLancamentoList;
    }

    public void setItemLancamentoList(List<ItemLancamento> itemLancamentoList) {
        this.itemLancamentoList = itemLancamentoList;
    }

    @XmlTransient
    public List<EstoqueProdutos> getEstoqueProdutosList() {
        return estoqueProdutosList;
    }

    public void setEstoqueProdutosList(List<EstoqueProdutos> estoqueProdutosList) {
        this.estoqueProdutosList = estoqueProdutosList;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    
}
