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
@Table(name = "status_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusVenda.findAll", query = "SELECT s FROM StatusVenda s"),
    @NamedQuery(name = "StatusVenda.findByIdStatusVenda", query = "SELECT s FROM StatusVenda s WHERE s.idStatusVenda = :idStatusVenda"),
    @NamedQuery(name = "StatusVenda.findByDescStatusVenda", query = "SELECT s FROM StatusVenda s WHERE s.descStatusVenda = :descStatusVenda")})
public class StatusVenda implements Serializable {

    public static enum status {

        CRIADA(1), CONCLUIDA(2), CANCELADA(3);

        private Integer identificador;

        private status(Integer identificador) {
            this.identificador = identificador;
        }

        public StatusVenda getInstance() {
            StatusVenda statusVenda = new StatusVenda();
            statusVenda.setIdStatusVenda(identificador);
            statusVenda.setDescStatusVenda(this.toString());

            return statusVenda;
        }
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_STATUS_VENDA")
    private Integer idStatusVenda;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_STATUS_VENDA")
    private String descStatusVenda;

    @OneToMany(mappedBy = "idStatusVenda")
    private List<Venda> vendaList;

    public StatusVenda() {
    }

    public StatusVenda(Integer idStatusVenda) {
        this.idStatusVenda = idStatusVenda;
    }

    public StatusVenda(Integer idStatusVenda, String descStatusVenda) {
        this.idStatusVenda = idStatusVenda;
        this.descStatusVenda = descStatusVenda;
    }

    public Integer getIdStatusVenda() {
        return idStatusVenda;
    }

    public void setIdStatusVenda(Integer idStatusVenda) {
        this.idStatusVenda = idStatusVenda;
    }

    public String getDescStatusVenda() {
        return descStatusVenda;
    }

    public void setDescStatusVenda(String descStatusVenda) {
        this.descStatusVenda = descStatusVenda;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusVenda != null ? idStatusVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusVenda)) {
            return false;
        }
        StatusVenda other = (StatusVenda) object;
        if ((this.idStatusVenda == null && other.idStatusVenda != null) || (this.idStatusVenda != null && !this.idStatusVenda.equals(other.idStatusVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.StatusVenda[ idStatusVenda=" + idStatusVenda + " ]";
    }

}
