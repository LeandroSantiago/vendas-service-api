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
@Table(name = "situacao_crediario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacaoCrediario.findAll", query = "SELECT s FROM SituacaoCrediario s"),
    @NamedQuery(name = "SituacaoCrediario.findByIdSituacaoCrediario", query = "SELECT s FROM SituacaoCrediario s WHERE s.idSituacaoCrediario = :idSituacaoCrediario"),
    @NamedQuery(name = "SituacaoCrediario.findByDescSituacaoCrediario", query = "SELECT s FROM SituacaoCrediario s WHERE s.descSituacaoCrediario = :descSituacaoCrediario"),
    @NamedQuery(name = "SituacaoCrediario.findByBloqueado", query = "SELECT s FROM SituacaoCrediario s WHERE s.bloqueado = :bloqueado")})
public class SituacaoCrediario implements Serializable {

    public static enum situacaoCredito {
        REGULAR(1), ATENCAO(2), INADIMPLENTE(3), CANCELADO(4), BLOQUEADO(5);

        private final Integer identificadorSituacao;

        private situacaoCredito(Integer identificadorSituacao) {
            this.identificadorSituacao = identificadorSituacao;
        }

        public SituacaoCrediario getInstance() {
            SituacaoCrediario situacao = new SituacaoCrediario(identificadorSituacao, this.toString());

            return situacao;
        }

    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SITUACAO_CREDIARIO")
    private Integer idSituacaoCrediario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_SITUACAO_CREDIARIO")
    private String descSituacaoCrediario;

    @Column(name = "BLOQUEADO")
    private Boolean bloqueado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacaoCrediario")
    private List<Crediario> crediarioList;

    public SituacaoCrediario() {
    }

    public SituacaoCrediario(Integer idSituacaoCrediario) {
        this.idSituacaoCrediario = idSituacaoCrediario;
    }

    public SituacaoCrediario(Integer idSituacaoCrediario, String descSituacaoCrediario) {
        this.idSituacaoCrediario = idSituacaoCrediario;
        this.descSituacaoCrediario = descSituacaoCrediario;
    }

    public Integer getIdSituacaoCrediario() {
        return idSituacaoCrediario;
    }

    public void setIdSituacaoCrediario(Integer idSituacaoCrediario) {
        this.idSituacaoCrediario = idSituacaoCrediario;
    }

    public String getDescSituacaoCrediario() {
        return descSituacaoCrediario;
    }

    public void setDescSituacaoCrediario(String descSituacaoCrediario) {
        this.descSituacaoCrediario = descSituacaoCrediario;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @XmlTransient
    public List<Crediario> getCrediarioList() {
        return crediarioList;
    }

    public void setCrediarioList(List<Crediario> crediarioList) {
        this.crediarioList = crediarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacaoCrediario != null ? idSituacaoCrediario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacaoCrediario)) {
            return false;
        }
        SituacaoCrediario other = (SituacaoCrediario) object;
        if ((this.idSituacaoCrediario == null && other.idSituacaoCrediario != null) || (this.idSituacaoCrediario != null && !this.idSituacaoCrediario.equals(other.idSituacaoCrediario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.SituacaoCrediario[ idSituacaoCrediario=" + idSituacaoCrediario + " ]";
    }

}
