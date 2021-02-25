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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "status_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusPedido.findAll", query = "SELECT s FROM StatusPedido s"),
    @NamedQuery(name = "StatusPedido.findByIdStatusPedido", query = "SELECT s FROM StatusPedido s WHERE s.idStatusPedido = :idStatusPedido"),
    @NamedQuery(name = "StatusPedido.findByDescricaoStatusPedido", query = "SELECT s FROM StatusPedido s WHERE s.descricaoStatusPedido = :descricaoStatusPedido")})
public class StatusPedido implements Serializable {

    public static enum Status {

        CRIADO(1), SOLICITADO(2), RECEBIDO(3), CANCELADO(4), FINALIZADO(5),EMITIDO(6);
        
        private Integer identificador;

        private Status(Integer identificador) {
            this.identificador = identificador;
        }

        public StatusPedido getInstance() {
            StatusPedido statusPedido = new StatusPedido();
            statusPedido.setIdStatusPedido(identificador);
            statusPedido.setDescricaoStatusPedido(this.toString());

            return statusPedido;
        }
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_STATUS_PEDIDO")
    private Integer idStatusPedido;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRICAO_STATUS_PEDIDO")
    private String descricaoStatusPedido;

    /**
     *
     */
    public StatusPedido() {
    }

    /**
     *
     * @param idStatusPedido
     */
    public StatusPedido(Integer idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    /**
     *
     * @param idStatusPedido
     * @param descricaoStatusPedido
     */
    public StatusPedido(Integer idStatusPedido, String descricaoStatusPedido) {
        this.idStatusPedido = idStatusPedido;
        this.descricaoStatusPedido = descricaoStatusPedido;
    }

    /**
     *
     * @return
     */
    public Integer getIdStatusPedido() {
        return idStatusPedido;
    }

    /**
     *
     * @param idStatusPedido
     */
    public void setIdStatusPedido(Integer idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    /**
     *
     * @return
     */
    public String getDescricaoStatusPedido() {
        return descricaoStatusPedido;
    }

    /**
     *
     * @param descricaoStatusPedido
     */
    public void setDescricaoStatusPedido(String descricaoStatusPedido) {
        this.descricaoStatusPedido = descricaoStatusPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusPedido != null ? idStatusPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusPedido)) {
            return false;
        }
        StatusPedido other = (StatusPedido) object;
        if ((this.idStatusPedido == null && other.idStatusPedido != null) || (this.idStatusPedido != null && !this.idStatusPedido.equals(other.idStatusPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.StatusPedido[ idStatusPedido=" + idStatusPedido + " ]";
    }

}
