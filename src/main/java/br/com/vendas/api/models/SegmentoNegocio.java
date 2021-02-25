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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "segmento_negocio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegmentoNegocio.findAll", query = "SELECT s FROM SegmentoNegocio s"),
    @NamedQuery(name = "SegmentoNegocio.findByIdSegmentoNegocio", query = "SELECT s FROM SegmentoNegocio s WHERE s.idSegmentoNegocio = :idSegmentoNegocio"),
    @NamedQuery(name = "SegmentoNegocio.findByDescricao", query = "SELECT s FROM SegmentoNegocio s WHERE s.descricao = :descricao")})
public class SegmentoNegocio implements Serializable {

    @OneToMany(mappedBy = "idSegNegocio")
    private List<DadosEmpregaticios> dadosEmpregaticiosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SEGMENTO_NEGOCIO")
    private Integer idSegmentoNegocio;

    @Size(max = 45)
    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "ID_RAMO_ATIVIDADE", referencedColumnName = "ID_RAMO_ATIVIDADE")
    @ManyToOne(optional = false)
    private RamoAtividade idRamoAtividade;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSegmentoNegocio")
    private List<Empresa> empresaList;

    /**
     *
     */
    public SegmentoNegocio() {
    }

    /**
     *
     * @param idSegmentoNegocio
     */
    public SegmentoNegocio(Integer idSegmentoNegocio) {
        this.idSegmentoNegocio = idSegmentoNegocio;
    }

    /**
     *
     * @return
     */
    public Integer getIdSegmentoNegocio() {
        return idSegmentoNegocio;
    }

    /**
     *
     * @param idSegmentoNegocio
     */
    public void setIdSegmentoNegocio(Integer idSegmentoNegocio) {
        this.idSegmentoNegocio = idSegmentoNegocio;
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
    public RamoAtividade getIdRamoAtividade() {
        return idRamoAtividade;
    }

    /**
     *
     * @param idRamoAtividade
     */
    public void setIdRamoAtividade(RamoAtividade idRamoAtividade) {
        this.idRamoAtividade = idRamoAtividade;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    /**
     *
     * @param empresaList
     */
    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSegmentoNegocio != null ? idSegmentoNegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegmentoNegocio)) {
            return false;
        }
        SegmentoNegocio other = (SegmentoNegocio) object;
        if ((this.idSegmentoNegocio == null && other.idSegmentoNegocio != null) || (this.idSegmentoNegocio != null && !this.idSegmentoNegocio.equals(other.idSegmentoNegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.SegmentoNegocio[ idSegmentoNegocio=" + idSegmentoNegocio + " ]";
    }

    @XmlTransient
    public List<DadosEmpregaticios> getDadosEmpregaticiosList() {
        return dadosEmpregaticiosList;
    }

    public void setDadosEmpregaticiosList(List<DadosEmpregaticios> dadosEmpregaticiosList) {
        this.dadosEmpregaticiosList = dadosEmpregaticiosList;
    }

}
