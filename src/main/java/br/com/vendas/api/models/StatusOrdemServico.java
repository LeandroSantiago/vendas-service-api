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
@Table(name = "status_ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusOrdemServico.findAll", query = "SELECT s FROM StatusOrdemServico s"),
    @NamedQuery(name = "StatusOrdemServico.findByIdStatusOrdemServico", query = "SELECT s FROM StatusOrdemServico s WHERE s.idStatusOrdemServico = :idStatusOrdemServico"),
    @NamedQuery(name = "StatusOrdemServico.findByDescricao", query = "SELECT s FROM StatusOrdemServico s WHERE s.descricao = :descricao")})
public class StatusOrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_STATUS_ORDEM_SERVICO")
    private Integer idStatusOrdemServico;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStatusOrdemServico")
    private List<OrdemServico> ordemServicoList;

    /**
     *
     */
    public StatusOrdemServico() {
    }

    /**
     *
     * @param idStatusOrdemServico
     */
    public StatusOrdemServico(Integer idStatusOrdemServico) {
        this.idStatusOrdemServico = idStatusOrdemServico;
    }

    /**
     *
     * @param idStatusOrdemServico
     * @param descricao
     */
    public StatusOrdemServico(Integer idStatusOrdemServico, String descricao) {
        this.idStatusOrdemServico = idStatusOrdemServico;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdStatusOrdemServico() {
        return idStatusOrdemServico;
    }

    /**
     *
     * @param idStatusOrdemServico
     */
    public void setIdStatusOrdemServico(Integer idStatusOrdemServico) {
        this.idStatusOrdemServico = idStatusOrdemServico;
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
    public List<OrdemServico> getOrdemServicoList() {

        if (ordemServicoList == null) {
            ordemServicoList = new ArrayList<>();
        }
        return ordemServicoList;
    }

    /**
     *
     * @param ordemServicoList
     */
    public void setOrdemServicoList(List<OrdemServico> ordemServicoList) {
        this.ordemServicoList = ordemServicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusOrdemServico != null ? idStatusOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusOrdemServico)) {
            return false;
        }
        StatusOrdemServico other = (StatusOrdemServico) object;
        if ((this.idStatusOrdemServico == null && other.idStatusOrdemServico != null) || (this.idStatusOrdemServico != null && !this.idStatusOrdemServico.equals(other.idStatusOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.StatusOrdemServico[ idStatusOrdemServico=" + idStatusOrdemServico + " ]";
    }

}
