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
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.consultarPedidoPorId", 
            query = "SELECT p FROM Pedido p "
                    + "WHERE p.idStatusPedido.idStatusPedido not in (4,5,6) "
                    + "and p.idEmpresa = :idEmpresa "
                    + "and p.idPedido = :idPedido"),
    
    @NamedQuery(name = "Pedido.listarPedidosPorDataPedido", 
            query = "SELECT p "
                    + "FROM Pedido p "
                    + "WHERE p.idEmpresa.idEmpresa = :idEmpresa and p.dtPedido >= :dtInicioPedido "
                    + "and p.dtPedido <= :dtFimPedido "),
    @NamedQuery(name = "Pedido.listarPedidosPorDataEntregaPedido", 
            query = "SELECT p FROM Pedido p WHERE p.idEmpresa.idEmpresa = :idEmpresa and p.dtEntrega >= :dtInicioEntrega and p.dtEntrega <= :dtFimEntrega"),
    
    @NamedQuery(name = "Pedido.buscarPedidoPorFornecedor", query = "SELECT p FROM Pedido p WHERE  p.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "Pedido.buscarPedidoPorRequisitante", query = "SELECT p FROM Pedido p WHERE p.idUserPedido = :idUserPedido"),
    @NamedQuery(name = "Pedido.buscarPedidoPorStatusPedido", query = "SELECT p FROM Pedido p WHERE p.idStatusPedido = :idStatusPedido"),
    @NamedQuery(name = "Pedido.findByTotalItens", query = "SELECT p FROM Pedido p WHERE p.totalItens = :totalItens"),
    @NamedQuery(name = "Pedido.findByVlrTotal", query = "SELECT p FROM Pedido p WHERE p.vlrTotal = :vlrTotal")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PEDIDO")
    private Integer idPedido;

    @OneToOne(mappedBy = "idPedido")
    private Lancamentos lancamentos;

    @JoinColumn(name = "ID_STATUS_PEDIDO", referencedColumnName = "ID_STATUS_PEDIDO")
    @ManyToOne(optional = false)
    private StatusPedido idStatusPedido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_PEDIDO")
    @Temporal(TemporalType.DATE)
    private Date dtPedido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date dtEntrega;

    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_ITENS")
    private int totalItens;

    @Column(name = "VLR_TOTAL")
    private Double vlrTotal;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_FRETE")
    private Double vlrFrete;

    @Column(name = "VLR_DESCONTO")
    private Double vlrDesconto;

    @Column(name = "SUB_TOTAL")
    private Double subTotal;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR")
    @ManyToOne
    private Fornecedor idFornecedor;

    @JoinColumn(name = "ID_USER_PEDIDO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserPedido;

    @OneToMany(mappedBy = "idPedido", cascade = CascadeType.ALL)
    private List<ItensPedido> itensPedidoList;

    @Column(name = "ID_ENDER_ENTREGA")
    private Integer idEnderEntrega;

    @JoinColumn(name = "ID_TIPO_PEDIDO", referencedColumnName = "ID_TIPO_PEDIDO")
    @ManyToOne(optional = false)
    private TipoPedido idTipoPedido;

    @JoinColumn(name = "ID_FORMA_PAGTO", referencedColumnName = "ID_FORMA_PAGTO")
    @ManyToOne(optional = false)
    private FormaPagto idFormaPagto;

    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente idCliente;

    @JoinColumn(name = "ID_VENDEDOR", referencedColumnName = "ID_VENDEDOR")
    @ManyToOne
    private Vendedor idVendedor;
    
    @OneToOne(mappedBy = "idPedido")
    private PedidoVenda pedidoVenda;

    /**
     *
     */
    public Pedido() {
    }

    /**
     *
     * @param idPedido
     */
    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public void adicionarItensPedido(ItensPedido item) {
        getItensPedidoList().add(item);
        item.setIdPedido(this);

        //return item;
    }

    public void removerItensPedido(ItensPedido item) {
        getItensPedidoList().remove(item);
        item.setIdPedido(null);

        //return item;
    }

    /**
     *
     * @return
     */
    public Integer getIdPedido() {
        return idPedido;
    }

    /**
     *
     * @param idPedido
     */
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    /**
     *
     * @return
     */
    public Date getDtPedido() {
        return dtPedido;
    }

    /**
     *
     * @param dtPedido
     */
    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    /**
     *
     * @return
     */
    public Date getDtEntrega() {
        return dtEntrega;
    }

    /**
     *
     * @param dtEntrega
     */
    public void setDtEntrega(Date dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    /**
     *
     * @return
     */
    public int getTotalItens() {
        return totalItens;
    }

    /**
     *
     * @param totalItens
     */
    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    /**
     *
     * @return
     */
    public Double getVlrTotal() {
        return vlrTotal;
    }

    /**
     *
     * @param vlrTotal
     */
    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
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

    /**
     *
     * @param idEmpresa
     */
    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     *
     * @return
     */
    public Fornecedor getIdFornecedor() {

        if (idFornecedor == null) {
            idFornecedor = new Fornecedor();
        }
        return idFornecedor;
    }

    /**
     *
     * @param idFornecedor
     */
    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     *
     * @return
     */
    public Usuario getIdUserPedido() {

        if (idUserPedido == null) {
            idUserPedido = new Usuario();
        }

        return idUserPedido;
    }

    /**
     *
     * @param idUserPedido
     */
    public void setIdUserPedido(Usuario idUserPedido) {
        this.idUserPedido = idUserPedido;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<ItensPedido> getItensPedidoList() {

        if (itensPedidoList == null) {
            itensPedidoList = new ArrayList<>();
        }
        return itensPedidoList;
    }

    /**
     *
     * @param itensPedidoList
     */
    public void setItensPedidoList(List<ItensPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }

    /**
     *
     * @return
     */
    public StatusPedido getIdStatusPedido() {
        if (idStatusPedido == null) {
            idStatusPedido = new StatusPedido();
        }
        return idStatusPedido;
    }

    /**
     *
     * @param idStatusPedido
     */
    public void setIdStatusPedido(StatusPedido idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    public Lancamentos getLancamentos() {

        if (lancamentos == null) {
            lancamentos = new Lancamentos();
        }
        return lancamentos;
    }

    public void setLancamentos(Lancamentos lancamentos) {
        this.lancamentos = lancamentos;
    }

    public Double getVlrFrete() {
        return vlrFrete;
    }

    public void setVlrFrete(Double vlrFrete) {
        this.vlrFrete = vlrFrete;
    }

    public Double getVlrDesconto() {
        return vlrDesconto;
    }

    public void setVlrDesconto(Double vlrDesconto) {
        this.vlrDesconto = vlrDesconto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getIdEnderEntrega() {
        return idEnderEntrega;
    }

    public void setIdEnderEntrega(Integer idEnderEntrega) {
        this.idEnderEntrega = idEnderEntrega;
    }

    public TipoPedido getIdTipoPedido() {

        if (idTipoPedido == null) {
            idTipoPedido = new TipoPedido();
        }
        return idTipoPedido;
    }

    public void setIdTipoPedido(TipoPedido idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public FormaPagto getIdFormaPagto() {

        if (idFormaPagto == null) {
            idFormaPagto = new FormaPagto();
        }
        return idFormaPagto;
    }

    public void setIdFormaPagto(FormaPagto idFormaPagto) {
        this.idFormaPagto = idFormaPagto;
    }

    public Cliente getIdCliente() {

        if (idCliente == null) {
            idCliente = new Cliente();
        }
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
    
    public PedidoVenda getPedidoVenda() {
        
        if(pedidoVenda == null)
        {
            pedidoVenda = new PedidoVenda();
        }
        return pedidoVenda;
    }

    public void setPedidoVenda(PedidoVenda pedidoVenda) {
        this.pedidoVenda = pedidoVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Pedido[ idPedido=" + idPedido + " ]";
    }

}
