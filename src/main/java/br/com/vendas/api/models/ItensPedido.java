/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.vendas.api.models.Produto;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "itens_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensPedido.findAll", query = "SELECT i FROM ItensPedido i"),
    @NamedQuery(name = "ItensPedido.findByIdItensPedido", query = "SELECT i FROM ItensPedido i WHERE i.idItensPedido = :idItensPedido"),
    @NamedQuery(name = "ItensPedido.findByIdPedido", query = "SELECT i FROM ItensPedido i WHERE i.idPedido = :idPedido"),
    @NamedQuery(name = "ItensPedido.listarItensPedidoPorIdPedido", query = "SELECT i FROM ItensPedido i WHERE i.idPedido = :idPedido"),
    @NamedQuery(name = "ItensPedido.ConsultarItemPorIdProduto", query = "SELECT i FROM ItensPedido i WHERE i.idPedido = :idPedido and i.idProduto = :idProduto"),
    @NamedQuery(name = "ItensPedido.findByQuantidade", query = "SELECT i FROM ItensPedido i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItensPedido.findByVlrUnitario", query = "SELECT i FROM ItensPedido i WHERE i.vlrUnitario = :vlrUnitario"),
    @NamedQuery(name = "ItensPedido.findByVlrTotal", query = "SELECT i FROM ItensPedido i WHERE i.vlrTotal = :vlrTotal")})
public class ItensPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ITENS_PEDIDO")
    private Integer idItensPedido;

    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_UNITARIO")
    private double vlrUnitario;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_TOTAL")
    private double vlrTotal;

    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    @ManyToOne(optional = false)
    private Pedido idPedido;

    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    @ManyToOne(optional = false)
    private Produto idProduto;

    /**
     *
     */
    public ItensPedido() {
    }

    /**
     *
     * @param idItensPedido
     */
    public ItensPedido(Integer idItensPedido) {
        this.idItensPedido = idItensPedido;
    }

    /**
     *
     * @param idItensPedido
     * @param quantidade
     * @param vlrUnitario
     * @param vlrTotal
     */
    public ItensPedido(Integer idItensPedido, int quantidade, double vlrUnitario, double vlrTotal) {
        this.idItensPedido = idItensPedido;
        this.quantidade = quantidade;
        this.vlrUnitario = vlrUnitario;
        this.vlrTotal = vlrTotal;
    }

    /**
     *
     * @return
     */
    public Integer getIdItensPedido() {
        return idItensPedido;
    }

    /**
     *
     * @param idItensPedido
     */
    public void setIdItensPedido(Integer idItensPedido) {
        this.idItensPedido = idItensPedido;
    }

    /**
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     *
     * @return
     */
    public double getVlrUnitario() {
        return vlrUnitario;
    }

    /**
     *
     * @param vlrUnitario
     */
    public void setVlrUnitario(double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    /**
     *
     * @return
     */
    public double getVlrTotal() {
        return vlrTotal;
    }

    /**
     *
     * @param vlrTotal
     */
    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    /**
     *
     * @return
     */
    public Pedido getIdPedido() {

        if (idPedido == null) {
            idPedido = new Pedido();
        }
        return idPedido;
    }

    /**
     *
     * @param idPedido
     */
    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    /**
     *
     * @return
     */
    public Produto getIdProduto() {
        if (idProduto == null) {
            idProduto = new Produto();
        }
        return idProduto;
    }

    /**
     *
     * @param idProduto
     */
    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItensPedido != null ? idItensPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensPedido)) {
            return false;
        }
        ItensPedido other = (ItensPedido) object;
        if ((this.idItensPedido == null && other.idItensPedido != null) || (this.idItensPedido != null && !this.idItensPedido.equals(other.idItensPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.ItensPedido[ idItensPedido=" + idItensPedido + " ]";
    }

}
