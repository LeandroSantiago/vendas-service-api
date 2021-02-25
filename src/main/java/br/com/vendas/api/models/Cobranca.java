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
@Table(name = "cobranca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cobranca.listarCobrancaEmAberto",
            query = "SELECT c FROM Cobranca c "
                    + "WHERE c.idCrediarioVendas.idCrediario.idCrediario = :idCrediario "
                    + "and c.idCrediarioVendas.idCrediario.idCliente.idCliente = :idCliente "),
    @NamedQuery(name = "Cobranca.consultarCobrancaPorVenda",            
            query = "SELECT c FROM Cobranca c where c.idCrediarioVendas.idVenda.idVenda = :idVenda"),
    @NamedQuery(name = "Cobranca.findAll", query = "SELECT c FROM Cobranca c"),
    
    @NamedQuery(name = "Cobranca.findByIdCobranca", query = "SELECT c FROM Cobranca c WHERE c.idCobranca = :idCobranca"),
    @NamedQuery(name = "Cobranca.findByValorParcela", query = "SELECT c FROM Cobranca c WHERE c.valorParcela = :valorParcela"),
    @NamedQuery(name = "Cobranca.findByValorPgto", query = "SELECT c FROM Cobranca c WHERE c.valorPgto = :valorPgto"),
    @NamedQuery(name = "Cobranca.findByDtGeracaoCobranca", query = "SELECT c FROM Cobranca c WHERE c.dtGeracaoCobranca = :dtGeracaoCobranca"),
    @NamedQuery(name = "Cobranca.findByDtVencto", query = "SELECT c FROM Cobranca c WHERE c.dtVencto = :dtVencto"),
    @NamedQuery(name = "Cobranca.findByDtBaixa", query = "SELECT c FROM Cobranca c WHERE c.dtBaixa = :dtBaixa"),
    @NamedQuery(name = "Cobranca.findByDtPgto", query = "SELECT c FROM Cobranca c WHERE c.dtPgto = :dtPgto")})
public class Cobranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COBRANCA")
    private Integer idCobranca;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_PARCELA")
    private double valorParcela;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_PGTO")
    private Double valorPgto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_GERACAO_COBRANCA")
    @Temporal(TemporalType.DATE)
    private Date dtGeracaoCobranca;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_VENCTO")
    @Temporal(TemporalType.DATE)
    private Date dtVencto;

    @Column(name = "DT_BAIXA")
    @Temporal(TemporalType.DATE)
    private Date dtBaixa;

    @Column(name = "DT_PGTO")
    @Temporal(TemporalType.DATE)
    private Date dtPgto;

    @JoinColumn(name = "ID_CREDIARIO_VENDAS", referencedColumnName = "ID_CREDIARIO_VENDAS")
    @ManyToOne(optional = false)
    private CrediarioVendas idCrediarioVendas;

    @JoinColumn(name = "ID_SITUACAO_COBRANCA", referencedColumnName = "ID_SITUACAO_COBRANCA")
    @ManyToOne(optional = false)
    private SituacaoCobranca idSituacaoCobranca;

    @JoinColumn(name = "ID_USER_BAIXA", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserBaixa;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_MULTA")
    private Double vlrMulta;
    
    @Column(name = "VLR_JUROS")
    private Double vlrJuros;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_TOTAL")
    private double vlrTotal;
    
    @Column(name = "QTD_DIAS_ATRASO")
    private Integer qtdDiasAtraso;

    /**
     *
     */
    public Cobranca() {
    }

    /**
     *
     * @param idCobranca
     */
    public Cobranca(Integer idCobranca) {
        this.idCobranca = idCobranca;
    }

    /**
     *
     * @return
     */
    public Integer getIdCobranca() {
        return idCobranca;
    }

    /**
     *
     * @param idCobranca
     */
    public void setIdCobranca(Integer idCobranca) {
        this.idCobranca = idCobranca;
    }

    /**
     *
     * @return
     */
    public double getValorParcela() {
        return valorParcela;
    }

    /**
     *
     * @param valorParcela
     */
    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    /**
     *
     * @return
     */
    public Double getValorPgto() {
        return valorPgto;
    }

    /**
     *
     * @param valorPgto
     */
    public void setValorPgto(Double valorPgto) {
        this.valorPgto = valorPgto;
    }

    /**
     *
     * @return
     */
    public Date getDtGeracaoCobranca() {
        return dtGeracaoCobranca;
    }

    /**
     *
     * @param dtGeracaoCobranca
     */
    public void setDtGeracaoCobranca(Date dtGeracaoCobranca) {
        this.dtGeracaoCobranca = dtGeracaoCobranca;
    }

    /**
     *
     * @return
     */
    public Date getDtVencto() {
        return dtVencto;
    }

    /**
     *
     * @param dtVencto
     */
    public void setDtVencto(Date dtVencto) {
        this.dtVencto = dtVencto;
    }

    /**
     *
     * @return
     */
    public Date getDtBaixa() {
        return dtBaixa;
    }

    /**
     *
     * @param dtBaixa
     */
    public void setDtBaixa(Date dtBaixa) {
        this.dtBaixa = dtBaixa;
    }

    /**
     *
     * @return
     */
    public Date getDtPgto() {
        return dtPgto;
    }

    /**
     *
     * @param dtPgto
     */
    public void setDtPgto(Date dtPgto) {
        this.dtPgto = dtPgto;
    }

    /**
     *
     * @return
     */
    public CrediarioVendas getIdCrediarioVendas() {

        if (idCrediarioVendas == null) {
            idCrediarioVendas = new CrediarioVendas();
        }
        return idCrediarioVendas;
    }

    /**
     *
     * @param idCrediarioVendas
     */
    public void setIdCrediarioVendas(CrediarioVendas idCrediarioVendas) {
        this.idCrediarioVendas = idCrediarioVendas;
    }

    /**
     *
     * @return
     */
    public SituacaoCobranca getIdSituacaoCobranca() {

        if (idSituacaoCobranca == null) {
            idSituacaoCobranca = new SituacaoCobranca();
        }
        return idSituacaoCobranca;
    }

    /**
     *
     * @param idSituacaoCobranca
     */
    public void setIdSituacaoCobranca(SituacaoCobranca idSituacaoCobranca) {
        this.idSituacaoCobranca = idSituacaoCobranca;
    }

    public Usuario getIdUserBaixa() {

        if (idUserBaixa == null) {
            idUserBaixa = new Usuario();
        }
        return idUserBaixa;
    }

    public void setIdUserBaixa(Usuario idUserBaixa) {
        this.idUserBaixa = idUserBaixa;
    }
    
    public Double getVlrMulta() {
        return vlrMulta;
    }

    public void setVlrMulta(Double vlrMulta) {
        this.vlrMulta = vlrMulta;
    }

    public Double getVlrJuros() {
        return vlrJuros;
    }

    public void setVlrJuros(Double vlrJuros) {
        this.vlrJuros = vlrJuros;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Integer getQtdDiasAtraso() {
        return qtdDiasAtraso;
    }

    public void setQtdDiasAtraso(Integer qtdDiasAtraso) {
        this.qtdDiasAtraso = qtdDiasAtraso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCobranca != null ? idCobranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobranca)) {
            return false;
        }
        Cobranca other = (Cobranca) object;
        if ((this.idCobranca == null && other.idCobranca != null) || (this.idCobranca != null && !this.idCobranca.equals(other.idCobranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Cobranca[ idCobranca=" + idCobranca + " ]";
    }
}
