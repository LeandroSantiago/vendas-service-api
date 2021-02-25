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
@Table(name = "situacao_cobranca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SituacaoCobranca.findAll", query = "SELECT s FROM SituacaoCobranca s"),
    @NamedQuery(name = "SituacaoCobranca.findByIdSituacaoCobranca", query = "SELECT s FROM SituacaoCobranca s WHERE s.idSituacaoCobranca = :idSituacaoCobranca"),
    @NamedQuery(name = "SituacaoCobranca.findByDescricao", query = "SELECT s FROM SituacaoCobranca s WHERE s.descricao = :descricao")})
public class SituacaoCobranca implements Serializable {
    
    public static enum situacaoCobranca {
        CRIADA(1), EM_ABERTO(2), CANCELADA(3), EM_ATRASO(4), PAGO(5), RENEGOCIADA(6);

        private final Integer identificadorSituacao;

        private situacaoCobranca(Integer identificadorSituacao) {
            this.identificadorSituacao = identificadorSituacao;
        }

        public SituacaoCobranca getInstance() {
            SituacaoCobranca situacao = new SituacaoCobranca(identificadorSituacao, this.toString());

            return situacao;
        }

    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SITUACAO_COBRANCA")
    private Integer idSituacaoCobranca;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSituacaoCobranca")
    private List<Cobranca> cobrancasList;

    /**
     *
     */
    public SituacaoCobranca() {
    }

    /**
     *
     * @param idSituacaoCobranca
     */
    public SituacaoCobranca(Integer idSituacaoCobranca) {
        this.idSituacaoCobranca = idSituacaoCobranca;
    }

    /**
     *
     * @param idSituacaoCobranca
     * @param descricao
     */
    public SituacaoCobranca(Integer idSituacaoCobranca, String descricao) {
        this.idSituacaoCobranca = idSituacaoCobranca;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdSituacaoCobranca() {
        return idSituacaoCobranca;
    }

    /**
     *
     * @param idSituacaoCobranca
     */
    public void setIdSituacaoCobranca(Integer idSituacaoCobranca) {
        this.idSituacaoCobranca = idSituacaoCobranca;
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
    public List<Cobranca> getCobrancasList() {

        if (cobrancasList == null) {
            cobrancasList = new ArrayList<>();
        }
        return cobrancasList;
    }

    /**
     *
     * @param cobrancasList
     */
    public void setCobrancasList(List<Cobranca> cobrancasList) {
        this.cobrancasList = cobrancasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituacaoCobranca != null ? idSituacaoCobranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacaoCobranca)) {
            return false;
        }
        SituacaoCobranca other = (SituacaoCobranca) object;
        if ((this.idSituacaoCobranca == null && other.idSituacaoCobranca != null) || (this.idSituacaoCobranca != null && !this.idSituacaoCobranca.equals(other.idSituacaoCobranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.SituacaoCobranca[ idSituacaoCobranca=" + idSituacaoCobranca + " ]";
    }

}
