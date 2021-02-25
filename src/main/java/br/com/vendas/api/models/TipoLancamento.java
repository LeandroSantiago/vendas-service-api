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
@Table(name = "tipo_lancamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLancamento.findAll", query = "SELECT t FROM TipoLancamento t"),
    @NamedQuery(name = "TipoLancamento.findByIdTipoLancamento", query = "SELECT t FROM TipoLancamento t WHERE t.idTipoLancamento = :idTipoLancamento"),
    @NamedQuery(name = "TipoLancamento.findByDescTipoLancamento", query = "SELECT t FROM TipoLancamento t WHERE t.descTipoLancamento = :descTipoLancamento")})
public class TipoLancamento implements Serializable {

    
    public static enum tipoLancamento{
     
        RECEBIMENTO(1), DEVOLUCAO(2), TRANSFERENCIA(3), ATUALIZACAO(4);
        
        private final Integer identificadorTipo;
        
        private tipoLancamento(Integer identificadorTipo)
        {
            this.identificadorTipo = identificadorTipo;
        }
        
        public TipoLancamento getInstance()
        {
            TipoLancamento tipo = new TipoLancamento(identificadorTipo, this.toString());
            
            return tipo;
        }
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_LANCAMENTO")
    private Integer idTipoLancamento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoLancamento")
    private List<Lancamentos> lancamentosList;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DESC_TIPO_LANCAMENTO")
    private String descTipoLancamento;

    /**
     *
     */
    public TipoLancamento() {
    }

    /**
     *
     * @param idTipoLancamento
     */
    public TipoLancamento(Integer idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }

    /**
     *
     * @param idTipoLancamento
     * @param descTipoLancamento
     */
    public TipoLancamento(Integer idTipoLancamento, String descTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
        this.descTipoLancamento = descTipoLancamento;
    }

    /**
     *
     * @return
     */
    public Integer getIdTipoLancamento() {
        return idTipoLancamento;
    }

    /**
     *
     * @param idTipoLancamento
     */
    public void setIdTipoLancamento(Integer idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }

    /**
     *
     * @return
     */
    public String getDescTipoLancamento() {
        return descTipoLancamento;
    }

    /**
     *
     * @param descTipoLancamento
     */
    public void setDescTipoLancamento(String descTipoLancamento) {
        this.descTipoLancamento = descTipoLancamento;
    }

    @XmlTransient
    public List<Lancamentos> getLancamentosList() {
        return lancamentosList;
    }

    public void setLancamentosList(List<Lancamentos> lancamentosList) {
        this.lancamentosList = lancamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoLancamento != null ? idTipoLancamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLancamento)) {
            return false;
        }
        TipoLancamento other = (TipoLancamento) object;
        if ((this.idTipoLancamento == null && other.idTipoLancamento != null) || (this.idTipoLancamento != null && !this.idTipoLancamento.equals(other.idTipoLancamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.TipoLancamento[ idTipoLancamento=" + idTipoLancamento + " ]";
    }

}
