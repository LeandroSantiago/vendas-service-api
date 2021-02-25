/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "pedido_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoVenda.findAll", query = "SELECT p FROM PedidoVenda p"),
    @NamedQuery(name = "PedidoVenda.findByIdPedidoVenda", query = "SELECT p FROM PedidoVenda p WHERE p.idPedidoVenda = :idPedidoVenda"),
    @NamedQuery(name = "PedidoVenda.findByDtProcessamento", query = "SELECT p FROM PedidoVenda p WHERE p.dtProcessamento = :dtProcessamento")})
public class PedidoVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PEDIDO_VENDA")
    private Integer idPedidoVenda;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_PROCESSAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtProcessamento;
    
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    private Pedido idPedido;
    
    @JoinColumn(name = "ID_VENDA", referencedColumnName = "ID_VENDA")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Venda idVenda;
    
    @JoinColumn(name = "ID_USER_PROCESSAMENTO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserProcessamento;

    public PedidoVenda() {
    }

    public PedidoVenda(Integer idPedidoVenda) {
        this.idPedidoVenda = idPedidoVenda;
    }

    public PedidoVenda(Integer idPedidoVenda, Date dtProcessamento) {
        this.idPedidoVenda = idPedidoVenda;
        this.dtProcessamento = dtProcessamento;
    }

    public Integer getIdPedidoVenda() {
        return idPedidoVenda;
    }

    public void setIdPedidoVenda(Integer idPedidoVenda) {
        this.idPedidoVenda = idPedidoVenda;
    }

    public Date getDtProcessamento() {
        return dtProcessamento;
    }

    public void setDtProcessamento(Date dtProcessamento) {
        this.dtProcessamento = dtProcessamento;
    }

    public Pedido getIdPedido() {
        
        if(idPedido == null)
        {
            idPedido = new Pedido();
        }
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Venda getIdVenda() {
        
        if(idVenda == null)
        {
            idVenda = new Venda();
        }
        return idVenda;
    }

    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    public Usuario getIdUserProcessamento() {
        if(idUserProcessamento == null)
        {
            idUserProcessamento = new Usuario();
        }
        return idUserProcessamento;
    }

    public void setIdUserProcessamento(Usuario idUserProcessamento) {
        this.idUserProcessamento = idUserProcessamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidoVenda != null ? idPedidoVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoVenda)) {
            return false;
        }
        PedidoVenda other = (PedidoVenda) object;
        if ((this.idPedidoVenda == null && other.idPedidoVenda != null) || (this.idPedidoVenda != null && !this.idPedidoVenda.equals(other.idPedidoVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.PedidoVenda[ idPedidoVenda=" + idPedidoVenda + " ]";
    }
    
}
