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
@Table(name = "tipo_ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoOrdemServico.findAll", query = "SELECT t FROM TipoOrdemServico t"),
    @NamedQuery(name = "TipoOrdemServico.findByIdTipoOrdemServico", query = "SELECT t FROM TipoOrdemServico t WHERE t.idTipoOrdemServico = :idTipoOrdemServico"),
    @NamedQuery(name = "TipoOrdemServico.findByDescricao", query = "SELECT t FROM TipoOrdemServico t WHERE t.descricao = :descricao")})
public class TipoOrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ORDEM_SERVICO")
    private Integer idTipoOrdemServico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoOrdemServico")
    private List<OrdemServico> ordemServicoList;

    /**
     *
     */
    public TipoOrdemServico() {
    }

    /**
     *
     * @param idTipoOrdemServico
     */
    public TipoOrdemServico(Integer idTipoOrdemServico) {
        this.idTipoOrdemServico = idTipoOrdemServico;
    }

    /**
     *
     * @param idTipoOrdemServico
     * @param descricao
     */
    public TipoOrdemServico(Integer idTipoOrdemServico, String descricao) {
        this.idTipoOrdemServico = idTipoOrdemServico;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdTipoOrdemServico() {
        return idTipoOrdemServico;
    }

    /**
     *
     * @param idTipoOrdemServico
     */
    public void setIdTipoOrdemServico(Integer idTipoOrdemServico) {
        this.idTipoOrdemServico = idTipoOrdemServico;
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
        hash += (idTipoOrdemServico != null ? idTipoOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOrdemServico)) {
            return false;
        }
        TipoOrdemServico other = (TipoOrdemServico) object;
        if ((this.idTipoOrdemServico == null && other.idTipoOrdemServico != null) || (this.idTipoOrdemServico != null && !this.idTipoOrdemServico.equals(other.idTipoOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.TipoOrdemServico[ idTipoOrdemServico=" + idTipoOrdemServico + " ]";
    }

}
