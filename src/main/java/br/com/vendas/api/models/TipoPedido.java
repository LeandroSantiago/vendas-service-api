/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "tipo_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPedido.findAll", query = "SELECT t FROM TipoPedido t"),
    @NamedQuery(name = "TipoPedido.findByIdTipoPedido", query = "SELECT t FROM TipoPedido t WHERE t.idTipoPedido = :idTipoPedido"),
    @NamedQuery(name = "TipoPedido.findByDescTipoPedido", query = "SELECT t FROM TipoPedido t WHERE t.descTipoPedido = :descTipoPedido")})
public class TipoPedido implements Serializable {

    public static enum Tipo {

        COMPRA(1), VENDA(2), ORCAMENTO(3);

        private final Integer identificadorTipo;

        private Tipo(Integer identificadorTipo) {
            this.identificadorTipo = identificadorTipo;
        }

        public TipoPedido getInstance() {
            TipoPedido tipo = new TipoPedido(identificadorTipo, this.toString());

            return tipo;
        }
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PEDIDO")
    private Integer idTipoPedido;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_TIPO_PEDIDO")
    private String descTipoPedido;

    public TipoPedido() {
    }

    public TipoPedido(Integer idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public TipoPedido(Integer idTipoPedido, String descTipoPedido) {
        this.idTipoPedido = idTipoPedido;
        this.descTipoPedido = descTipoPedido;
    }

    public Integer getIdTipoPedido() {
        return idTipoPedido;
    }

    public void setIdTipoPedido(Integer idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public String getDescTipoPedido() {
        return descTipoPedido;
    }

    public void setDescTipoPedido(String descTipoPedido) {
        this.descTipoPedido = descTipoPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPedido != null ? idTipoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPedido)) {
            return false;
        }
        TipoPedido other = (TipoPedido) object;
        if ((this.idTipoPedido == null && other.idTipoPedido != null) || (this.idTipoPedido != null && !this.idTipoPedido.equals(other.idTipoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.TipoPedido[ idTipoPedido=" + idTipoPedido + " ]";
    }

}
