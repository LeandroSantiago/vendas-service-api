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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "crediario_vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrediarioVendas.findAll", query = "SELECT c FROM CrediarioVendas c"),
    @NamedQuery(name = "CrediarioVendas.findByIdCrediarioVendas", query = "SELECT c FROM CrediarioVendas c WHERE c.idCrediarioVendas = :idCrediarioVendas"),

    @NamedQuery(name = "CrediarioVendas.consultarVendasCrediarioPorIdCrediario",
            query = "SELECT c FROM CrediarioVendas c WHERE c.idCrediario.idEmpresa.idEmpresa = :idEmpresa and c.idCrediario.idCrediario = :idCrediario"),

    @NamedQuery(name = "CrediarioVendas.findByObs", query = "SELECT c FROM CrediarioVendas c WHERE c.obs = :obs")})
public class CrediarioVendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CREDIARIO_VENDAS")
    private Integer idCrediarioVendas;

    @Size(max = 500)
    @Column(name = "OBS")
    private String obs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCrediarioVendas")
    private List<Cobranca> cobrancasList;

    @JoinColumn(name = "ID_CREDIARIO", referencedColumnName = "ID_CREDIARIO")
    @ManyToOne(optional = false)
    private Crediario idCrediario;

    @JoinColumn(name = "ID_VENDA", referencedColumnName = "ID_VENDA")
    @OneToOne(optional = false)
    private Venda idVenda;

    @JoinColumn(name = "ID_PLANO_PGTO", referencedColumnName = "ID_PLANO_PGTO")
    @ManyToOne(optional = false)
    private PlanoPgto idPlanoPgto;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @Column(name = "QTD_PARCELAS")
    private Integer qtdParcelas;

    @Column(name = "VENCTO")
    private Integer vencto;

    @JoinColumn(name = "ID_SIT_VENDA", referencedColumnName = "iID_SIT_VENDA")
    @ManyToOne(optional = false)
    private SitVenda idSitVenda;

    /**
     *
     */
    public CrediarioVendas() {
    }

    /**
     *
     * @param idCrediarioVendas
     */
    public CrediarioVendas(Integer idCrediarioVendas) {
        this.idCrediarioVendas = idCrediarioVendas;
    }

    /**
     *
     * @return
     */
    public Integer getIdCrediarioVendas() {
        return idCrediarioVendas;
    }

    /**
     *
     * @param idCrediarioVendas
     */
    public void setIdCrediarioVendas(Integer idCrediarioVendas) {
        this.idCrediarioVendas = idCrediarioVendas;
    }

    /**
     *
     * @return
     */
    public String getObs() {
        return obs;
    }

    /**
     *
     * @param obs
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Cobranca> getCobrancasList() {
        return cobrancasList;
    }

    /**
     *
     * @param cobrancasList
     */
    public void setCobrancasList(List<Cobranca> cobrancasList) {
        this.cobrancasList = cobrancasList;
    }

    /**
     *
     * @return
     */
    public Crediario getIdCrediario() {
        return idCrediario;
    }

    /**
     *
     * @param idCrediario
     */
    public void setIdCrediario(Crediario idCrediario) {
        this.idCrediario = idCrediario;
    }

    /**
     *
     * @return
     */
    public Venda getIdVenda() {
        return idVenda;
    }

    /**
     *
     * @param idVenda
     */
    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    /**
     *
     * @return
     */
    public PlanoPgto getIdPlanoPgto() {
        return idPlanoPgto;
    }

    /**
     *
     * @param idPlanoPgto
     */
    public void setIdPlanoPgto(PlanoPgto idPlanoPgto) {
        this.idPlanoPgto = idPlanoPgto;
    }

    public Usuario getIdUserCadastro() {

        if (idUserCadastro == null) {
            idUserCadastro = new Usuario();
        }

        return idUserCadastro;
    }

    public void setIdUserCadastro(Usuario idUserCadastro) {
        this.idUserCadastro = idUserCadastro;
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public Integer getVencto() {
        return vencto;
    }

    public void setVencto(Integer vencto) {
        this.vencto = vencto;
    }

    public SitVenda getIdSitVenda() {

        if (idSitVenda == null) {
            idSitVenda = new SitVenda();
        }
        return idSitVenda;
    }

    public void setIdSitVenda(SitVenda idSitVenda) {
        this.idSitVenda = idSitVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCrediarioVendas != null ? idCrediarioVendas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrediarioVendas)) {
            return false;
        }
        CrediarioVendas other = (CrediarioVendas) object;
        if ((this.idCrediarioVendas == null && other.idCrediarioVendas != null) || (this.idCrediarioVendas != null && !this.idCrediarioVendas.equals(other.idCrediarioVendas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.CrediarioVendas[ idCrediarioVendas=" + idCrediarioVendas + " ]";
    }

}
