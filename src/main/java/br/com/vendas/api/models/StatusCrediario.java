/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "status_crediario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusCrediario.findAll", query = "SELECT s FROM StatusCrediario s"),
    @NamedQuery(name = "StatusCrediario.findByIdStatusCrediario", query = "SELECT s FROM StatusCrediario s WHERE s.idStatusCrediario = :idStatusCrediario"),
    @NamedQuery(name = "StatusCrediario.findByDescricao", query = "SELECT s FROM StatusCrediario s WHERE s.descricao = :descricao")})
public class StatusCrediario implements Serializable {
    
    public static enum statusCrediario
    {
     ABERTO(1), BLOQUEADO(2), FECHADO(3), CANCELADO(4),PENDENTE_APROVACAO(5), APROVADO(6);
     
     private final Integer identificadorStatus;
     
     private statusCrediario(Integer identificadorStatus)
     {
         this.identificadorStatus = identificadorStatus;
    }
     
     public StatusCrediario getInstance()
     {
         StatusCrediario status = new StatusCrediario(identificadorStatus, this.toString());
         
         return status;
     }
     
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_STATUS_CREDIARIO")
    private Integer idStatusCrediario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatusCrediario")
    private List<Crediario> crediarioList;

    /**
     *
     */
    public StatusCrediario() {
    }

    /**
     *
     * @param idStatusCrediario
     */
    public StatusCrediario(Integer idStatusCrediario) {
        this.idStatusCrediario = idStatusCrediario;
    }

    /**
     *
     * @param idStatusCrediario
     * @param descricao
     */
    public StatusCrediario(Integer idStatusCrediario, String descricao) {
        this.idStatusCrediario = idStatusCrediario;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdStatusCrediario() {
        return idStatusCrediario;
    }

    /**
     *
     * @param idStatusCrediario
     */
    public void setIdStatusCrediario(Integer idStatusCrediario) {
        this.idStatusCrediario = idStatusCrediario;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Crediario> getCrediarioList() {

        if (crediarioList == null) {
            crediarioList = new ArrayList<>();
        }
        return crediarioList;
    }

    /**
     *
     * @param crediarioList
     */
    public void setCrediarioList(List<Crediario> crediarioList) {
        this.crediarioList = crediarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusCrediario != null ? idStatusCrediario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusCrediario)) {
            return false;
        }
        StatusCrediario other = (StatusCrediario) object;
        if ((this.idStatusCrediario == null && other.idStatusCrediario != null) || (this.idStatusCrediario != null && !this.idStatusCrediario.equals(other.idStatusCrediario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.StatusCrediario[ idStatusCrediario=" + idStatusCrediario + " ]";
    }

}
