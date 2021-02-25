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
import javax.persistence.OneToOne;
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
@Table(name = "preco_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecoProduto.findAll", query = "SELECT p FROM PrecoProduto p"),
    @NamedQuery(name = "PrecoProduto.findByIdPrecoProduto", query = "SELECT p FROM PrecoProduto p WHERE p.idPrecoProduto = :idPrecoProduto"),
    @NamedQuery(name = "PrecoProduto.findByVlrBruto", query = "SELECT p FROM PrecoProduto p WHERE p.vlrBruto = :vlrBruto"),
    @NamedQuery(name = "PrecoProduto.findByQtd", query = "SELECT p FROM PrecoProduto p WHERE p.qtd = :qtd"),
    @NamedQuery(name = "PrecoProduto.findByPercentDescVenda", query = "SELECT p FROM PrecoProduto p WHERE p.percentDescVenda = :percentDescVenda"),
    @NamedQuery(name = "PrecoProduto.findByVlrDescVenda", query = "SELECT p FROM PrecoProduto p WHERE p.vlrDescVenda = :vlrDescVenda"),
    @NamedQuery(name = "PrecoProduto.findByPercentIpi", query = "SELECT p FROM PrecoProduto p WHERE p.percentIpi = :percentIpi"),
    @NamedQuery(name = "PrecoProduto.findByVlrIpi", query = "SELECT p FROM PrecoProduto p WHERE p.vlrIpi = :vlrIpi"),
    @NamedQuery(name = "PrecoProduto.findByPercentIcms", query = "SELECT p FROM PrecoProduto p WHERE p.percentIcms = :percentIcms"),
    @NamedQuery(name = "PrecoProduto.findByVlrIcms", query = "SELECT p FROM PrecoProduto p WHERE p.vlrIcms = :vlrIcms"),
    @NamedQuery(name = "PrecoProduto.findByPercentMargemVenda", query = "SELECT p FROM PrecoProduto p WHERE p.percentMargemVenda = :percentMargemVenda"),
    @NamedQuery(name = "PrecoProduto.findByVlrMargemVenda", query = "SELECT p FROM PrecoProduto p WHERE p.vlrMargemVenda = :vlrMargemVenda"),
    @NamedQuery(name = "PrecoProduto.findByPercentMargemAtacado", query = "SELECT p FROM PrecoProduto p WHERE p.percentMargemAtacado = :percentMargemAtacado"),
    @NamedQuery(name = "PrecoProduto.findByVlrMargemAtacado", query = "SELECT p FROM PrecoProduto p WHERE p.vlrMargemAtacado = :vlrMargemAtacado"),
    @NamedQuery(name = "PrecoProduto.findByPercentComissao", query = "SELECT p FROM PrecoProduto p WHERE p.percentComissao = :percentComissao"),
    @NamedQuery(name = "PrecoProduto.findByVlrComissao", query = "SELECT p FROM PrecoProduto p WHERE p.vlrComissao = :vlrComissao"),
    @NamedQuery(name = "PrecoProduto.findByVlrVenda", query = "SELECT p FROM PrecoProduto p WHERE p.vlrVenda = :vlrVenda"),
    @NamedQuery(name = "PrecoProduto.findByVlrLucro", query = "SELECT p FROM PrecoProduto p WHERE p.vlrLucro = :vlrLucro"),
    @NamedQuery(name = "PrecoProduto.findByDtCadastro", query = "SELECT p FROM PrecoProduto p WHERE p.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "PrecoProduto.findByDtAtualizacao", query = "SELECT p FROM PrecoProduto p WHERE p.dtAtualizacao = :dtAtualizacao")})
public class PrecoProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRECO_PRODUTO")
    private Integer idPrecoProduto;


    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD")
    private int qtd;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PERCENT_DESC_VENDA")
    private Double percentDescVenda;

    @Column(name = "VLR_DESC_VENDA")
    private Double vlrDescVenda;
    
    @Column(name = "PERCENT_JUROS_VENDA_PRAZO")
    private Double percentJurosVendaPrazo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_BRUTO")
    private double vlrBruto;
    
    @Column(name = "VLR_JUROS_VENDA_PRAZO")
    private Double vlrJurosVendaPrazo;

    @Column(name = "PERCENT_IPI")
    private Double percentIpi;

    @Column(name = "VLR_IPI")
    private Double vlrIpi;

    @Column(name = "PERCENT_ICMS")
    private Double percentIcms;

    @Column(name = "VLR_ICMS")
    private Double vlrIcms;

    @Column(name = "PERCENT_MARGEM_VENDA")
    private Double percentMargemVenda;

    @Column(name = "VLR_MARGEM_VENDA")
    private Double vlrMargemVenda;

    @Column(name = "PERCENT_MARGEM_ATACADO")
    private Double percentMargemAtacado;

    @Column(name = "VLR_MARGEM_ATACADO")
    private Double vlrMargemAtacado;

    @Column(name = "PERCENT_COMISSAO")
    private Double percentComissao;

    @Column(name = "VLR_COMISSAO")
    private Double vlrComissao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_VENDA")
    private double vlrVenda;

    @Column(name = "VLR_LUCRO")
    private Double vlrLucro;

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

    @OneToOne(mappedBy = "idPrecoProduto")
    private Produto produto;

    public PrecoProduto() {
    }

    public PrecoProduto(Integer idPrecoProduto) {
        this.idPrecoProduto = idPrecoProduto;
    }

    public Integer getIdPrecoProduto() {
        return idPrecoProduto;
    }

    public void setIdPrecoProduto(Integer idPrecoProduto) {
        this.idPrecoProduto = idPrecoProduto;
    }

    public Double getVlrBruto() {
        return vlrBruto;
    }

    public void setVlrBruto(Double vlrBruto) {
        this.vlrBruto = vlrBruto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getPercentDescVenda() {
        return percentDescVenda;
    }

    public void setPercentDescVenda(Double percentDescVenda) {
        this.percentDescVenda = percentDescVenda;
    }

    public Double getVlrDescVenda() {
        return vlrDescVenda;
    }

    public void setVlrDescVenda(Double vlrDescVenda) {
        this.vlrDescVenda = vlrDescVenda;
    }

    public Double getPercentIpi() {
        return percentIpi;
    }

    public void setPercentIpi(Double percentIpi) {
        this.percentIpi = percentIpi;
    }

    public Double getVlrIpi() {
        return vlrIpi;
    }

    public void setVlrIpi(Double vlrIpi) {
        this.vlrIpi = vlrIpi;
    }

    public Double getPercentIcms() {
        return percentIcms;
    }

    public void setPercentIcms(Double percentIcms) {
        this.percentIcms = percentIcms;
    }

    public Double getVlrIcms() {
        return vlrIcms;
    }

    public void setVlrIcms(Double vlrIcms) {
        this.vlrIcms = vlrIcms;
    }

    public Double getPercentMargemVenda() {
        return percentMargemVenda;
    }

    public void setPercentMargemVenda(Double percentMargemVenda) {
        this.percentMargemVenda = percentMargemVenda;
    }

    public Double getVlrMargemVenda() {
        return vlrMargemVenda;
    }

    public void setVlrMargemVenda(Double vlrMargemVenda) {
        this.vlrMargemVenda = vlrMargemVenda;
    }

    public Double getPercentMargemAtacado() {
        return percentMargemAtacado;
    }

    public void setPercentMargemAtacado(Double percentMargemAtacado) {
        this.percentMargemAtacado = percentMargemAtacado;
    }

    public Double getVlrMargemAtacado() {
        return vlrMargemAtacado;
    }

    public void setVlrMargemAtacado(Double vlrMargemAtacado) {
        this.vlrMargemAtacado = vlrMargemAtacado;
    }

    public Double getPercentComissao() {
        return percentComissao;
    }

    public void setPercentComissao(Double percentComissao) {
        this.percentComissao = percentComissao;
    }

    public Double getVlrComissao() {
        return vlrComissao;
    }

    public void setVlrComissao(Double vlrComissao) {
        this.vlrComissao = vlrComissao;
    }

    public Double getVlrVenda() {
        return vlrVenda;
    }

    public void setVlrVenda(Double vlrVenda) {
        this.vlrVenda = vlrVenda;
    }

    public Double getVlrLucro() {
        return vlrLucro;
    }

    public void setVlrLucro(Double vlrLucro) {
        this.vlrLucro = vlrLucro;
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

    public Produto getProduto() {

        if (produto == null) {
            produto = new Produto();
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getPercentJurosVendaPrazo() {
        return percentJurosVendaPrazo;
    }

    public void setPercentJurosVendaPrazo(Double percentJurosVendaPrazo) {
        this.percentJurosVendaPrazo = percentJurosVendaPrazo;
    }

    public Double getVlrJurosVendaPrazo() {
        return vlrJurosVendaPrazo;
    }

    public void setVlrJurosVendaPrazo(Double vlrJurosVendaPrazo) {
        this.vlrJurosVendaPrazo = vlrJurosVendaPrazo;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecoProduto != null ? idPrecoProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecoProduto)) {
            return false;
        }
        PrecoProduto other = (PrecoProduto) object;
        if ((this.idPrecoProduto == null && other.idPrecoProduto != null) || (this.idPrecoProduto != null && !this.idPrecoProduto.equals(other.idPrecoProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.PrecoProduto[ idPrecoProduto=" + idPrecoProduto + " ]";
    }

}
