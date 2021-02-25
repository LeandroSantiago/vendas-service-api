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
@Table(name = "status_lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusLancamento.findAll", query = "SELECT s FROM StatusLancamento s"),
    @NamedQuery(name = "StatusLancamento.findByIdStatusLancamento", query = "SELECT s FROM StatusLancamento s WHERE s.idStatusLancamento = :idStatusLancamento"),
    @NamedQuery(name = "StatusLancamento.findByDescStatusRecebimento", query = "SELECT s FROM StatusLancamento s WHERE s.descStatusRecebimento = :descStatusRecebimento")})
public class StatusLancamento implements Serializable {

    public static enum Status {

        CRIADO(1), EM_ANDAMENTO(2), FINALIZADO(3), CANCELADO(4);

        private final Integer identificadorStatus;

        private Status(Integer identificadorStatus) {
            this.identificadorStatus = identificadorStatus;
        }
        
        public StatusLancamento getInstance()
        {
            StatusLancamento statusLancamento = new StatusLancamento(identificadorStatus, this.toString());
            
            return statusLancamento;
        }
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_STATUS_LANCAMENTO")
    private Integer idStatusLancamento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_STATUS_LANCAMENTO")
    private String descStatusRecebimento;

    public StatusLancamento() {
    }

    public StatusLancamento(Integer idStatusLancamento) {
        this.idStatusLancamento = idStatusLancamento;
    }

    public StatusLancamento(Integer idStatusLancamento, String descStatusRecebimento) {
        this.idStatusLancamento = idStatusLancamento;
        this.descStatusRecebimento = descStatusRecebimento;
    }

    public Integer getIdStatusLancamento() {
        return idStatusLancamento;
    }

    public void setIdStatusLancamento(Integer idStatusLancamento) {
        this.idStatusLancamento = idStatusLancamento;
    }

    public String getDescStatusRecebimento() {
        return descStatusRecebimento;
    }

    public void setDescStatusRecebimento(String descStatusRecebimento) {
        this.descStatusRecebimento = descStatusRecebimento;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusLancamento != null ? idStatusLancamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusLancamento)) {
            return false;
        }
        StatusLancamento other = (StatusLancamento) object;
        if ((this.idStatusLancamento == null && other.idStatusLancamento != null) || (this.idStatusLancamento != null && !this.idStatusLancamento.equals(other.idStatusLancamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.StatusLancamento[ idStatusLancamento=" + idStatusLancamento + " ]";
    }

}
