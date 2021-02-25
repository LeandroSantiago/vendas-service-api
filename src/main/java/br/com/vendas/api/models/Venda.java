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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdVenda", query = "SELECT v FROM Venda v WHERE v.idVenda = :idVenda"),
    @NamedQuery(name = "Venda.findByDtVenda", query = "SELECT v FROM Venda v WHERE v.dtVenda = :dtVenda"),
    @NamedQuery(name = "Venda.findByItensTotal", query = "SELECT v FROM Venda v WHERE v.itensTotal = :itensTotal"),
    @NamedQuery(name = "Venda.findByTotalVenda", query = "SELECT v FROM Venda v WHERE v.totalVenda = :totalVenda")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENDA")
    private Integer idVenda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_VENDA")
    @Temporal(TemporalType.DATE)
    private Date dtVenda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ITENS_TOTAL")
    private int itensTotal;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_VENDA")
    private double totalVenda;

    @OneToOne(mappedBy = "idVenda")
    private CrediarioVendas crediarioVendas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenda")
    private List<ItensVenda> itensVendaList;

    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idVenda")
    private OrdemServico ordemServico;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_RECEBIDO")
    private Double vlrRecebido;

    @Column(name = "VLR_TROCO")
    private Double vlrTroco;

    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_PARCELAS")
    private int qtdParcelas;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @OneToOne(mappedBy = "idVenda")
    private PedidoVenda pedidoVenda;

    @JoinColumn(name = "ID_VENDEDOR", referencedColumnName = "ID_VENDEDOR")
    @ManyToOne(optional = false)
    private Vendedor idVendedor;

    @JoinColumn(name = "ID_FORMA_PAGTO", referencedColumnName = "ID_FORMA_PAGTO")
    @ManyToOne(optional = false)
    private FormaPagto idFormaPagto;

    @JoinColumn(name = "ID_STATUS_VENDA", referencedColumnName = "ID_STATUS_VENDA")
    @ManyToOne(optional = false)
    private StatusVenda idStatusVenda;
    
    @JoinColumn(name = "ID_PLANO_PGTO", referencedColumnName = "ID_PLANO_PGTO")
    @ManyToOne
    private PlanoPgto idPlanoPgto;

    /**
     *
     */
    public Venda() {
    }

    /**
     *
     * @param idVenda
     */
    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    /**
     *
     * @param idVenda
     * @param dtVenda
     * @param itensTotal
     * @param totalVenda
     */
    public Venda(Integer idVenda, Date dtVenda, int itensTotal, double totalVenda) {
        this.idVenda = idVenda;
        this.dtVenda = dtVenda;
        this.itensTotal = itensTotal;
        this.totalVenda = totalVenda;
    }

    /**
     *
     * @return
     */
    public Integer getIdVenda() {
        return idVenda;
    }

    /**
     *
     * @param idVenda
     */
    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    /**
     *
     * @return
     */
    public Date getDtVenda() {
        return dtVenda;
    }

    /**
     *
     * @param dtVenda
     */
    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    /**
     *
     * @return
     */
    public int getItensTotal() {
        return itensTotal;
    }

    /**
     *
     * @param itensTotal
     */
    public void setItensTotal(int itensTotal) {
        this.itensTotal = itensTotal;
    }

    /**
     *
     * @return
     */
    public double getTotalVenda() {
        return totalVenda;
    }

    /**
     *
     * @param totalVenda
     */
    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    /**
     *
     * @return
     */
    public CrediarioVendas getCrediarioVendas() {
        return crediarioVendas;
    }

    /**
     *
     * @param crediarioVendas
     */
    public void setCrediarioVendas(CrediarioVendas crediarioVendas) {
        this.crediarioVendas = crediarioVendas;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<ItensVenda> getItensVendaList() {
        return itensVendaList;
    }

    /**
     *
     * @param itensVendaList
     */
    public void setItensVendaList(List<ItensVenda> itensVendaList) {
        this.itensVendaList = itensVendaList;
    }

    /**
     *
     * @return
     */
    public Cliente getIdCliente() {
        return idCliente;
    }

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     */
    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    /**
     *
     * @param ordemServico
     */
    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Double getVlrRecebido() {
        return vlrRecebido;
    }

    public void setVlrRecebido(Double vlrRecebido) {
        this.vlrRecebido = vlrRecebido;
    }

    public Double getVlrTroco() {
        return vlrTroco;
    }

    public void setVlrTroco(Double vlrTroco) {
        this.vlrTroco = vlrTroco;
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

    public PedidoVenda getPedidoVenda() {

        if (pedidoVenda == null) {
            pedidoVenda = new PedidoVenda();
        }
        return pedidoVenda;
    }

    public void setPedidoVenda(PedidoVenda pedidoVenda) {
        this.pedidoVenda = pedidoVenda;
    }

    public Vendedor getIdVendedor() {

        if (idVendedor == null) {
            idVendedor = new Vendedor();
        }
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public FormaPagto getIdFormaPagto() {
        return idFormaPagto;
    }

    public void setIdFormaPagto(FormaPagto idFormaPagto) {
        this.idFormaPagto = idFormaPagto;
    }

    public StatusVenda getIdStatusVenda() {

        if (idStatusVenda == null) {
            idStatusVenda = new StatusVenda();
        }
        return idStatusVenda;
    }

    public void setIdStatusVenda(StatusVenda idStatusVenda) {
        this.idStatusVenda = idStatusVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Venda[ idVenda=" + idVenda + " ]";
    }

    public PlanoPgto getIdPlanoPgto() {
        
        if(idPlanoPgto == null)
        {
            idPlanoPgto = new PlanoPgto();
        }
        return idPlanoPgto;
    }

    public void setIdPlanoPgto(PlanoPgto idPlanoPgto) {
        this.idPlanoPgto = idPlanoPgto;
    }
}
