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
@Table(name = "sit_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitVenda.findAll", query = "SELECT s FROM SitVenda s"),
    @NamedQuery(name = "SitVenda.findByIIDSITVENDA", query = "SELECT s FROM SitVenda s WHERE s.iIDSITVENDA = :iIDSITVENDA"),
    @NamedQuery(name = "SitVenda.findByDescSitVenda", query = "SELECT s FROM SitVenda s WHERE s.descSitVenda = :descSitVenda")})
public class SitVenda implements Serializable {
    
    public static enum situacao {
            PENDENTE(1), FECHADA(2), CANCELADA(3);

        private final Integer identificadorSituacao;

        private situacao(Integer identificadorSituacao) {
            this.identificadorSituacao = identificadorSituacao;
        }

        public SitVenda getInstance() {
            SitVenda situacao = new SitVenda(identificadorSituacao, this.toString());

            return situacao;
        }

    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iID_SIT_VENDA")
    private Integer iIDSITVENDA;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_SIT_VENDA")
    private String descSitVenda;
    
    @OneToMany
    private List<CrediarioVendas> crediarioVendasList;

    public SitVenda() {
    }

    public SitVenda(Integer iIDSITVENDA) {
        this.iIDSITVENDA = iIDSITVENDA;
    }

    public SitVenda(Integer iIDSITVENDA, String descSitVenda) {
        this.iIDSITVENDA = iIDSITVENDA;
        this.descSitVenda = descSitVenda;
    }

    public Integer getIIDSITVENDA() {
        return iIDSITVENDA;
    }

    public void setIIDSITVENDA(Integer iIDSITVENDA) {
        this.iIDSITVENDA = iIDSITVENDA;
    }

    public String getDescSitVenda() {
        return descSitVenda;
    }

    public void setDescSitVenda(String descSitVenda) {
        this.descSitVenda = descSitVenda;
    }

    @XmlTransient
    public List<CrediarioVendas> getCrediarioVendasList() {
        return crediarioVendasList;
    }

    public void setCrediarioVendasList(List<CrediarioVendas> crediarioVendasList) {
        this.crediarioVendasList = crediarioVendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iIDSITVENDA != null ? iIDSITVENDA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SitVenda)) {
            return false;
        }
        SitVenda other = (SitVenda) object;
        if ((this.iIDSITVENDA == null && other.iIDSITVENDA != null) || (this.iIDSITVENDA != null && !this.iIDSITVENDA.equals(other.iIDSITVENDA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.SitVenda[ iIDSITVENDA=" + iIDSITVENDA + " ]";
    }
    
}
