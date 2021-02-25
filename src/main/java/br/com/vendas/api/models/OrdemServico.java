/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemServico.findAll", query = "SELECT o FROM OrdemServico o"),
    @NamedQuery(name = "OrdemServico.findByIdOrdemServico", query = "SELECT o FROM OrdemServico o WHERE o.idOrdemServico = :idOrdemServico"),
    @NamedQuery(name = "OrdemServico.findByPlaca", query = "SELECT o FROM OrdemServico o WHERE o.placa = :placa"),
    @NamedQuery(name = "OrdemServico.findByCombustivel", query = "SELECT o FROM OrdemServico o WHERE o.combustivel = :combustivel"),
    @NamedQuery(name = "OrdemServico.findByAnoModelo", query = "SELECT o FROM OrdemServico o WHERE o.anoModelo = :anoModelo"),
    @NamedQuery(name = "OrdemServico.findByDtAgendamento", query = "SELECT o FROM OrdemServico o WHERE o.dtAgendamento = :dtAgendamento"),
    @NamedQuery(name = "OrdemServico.findByDtCadastro", query = "SELECT o FROM OrdemServico o WHERE o.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "OrdemServico.findByDtInicioExecucao", query = "SELECT o FROM OrdemServico o WHERE o.dtInicioExecucao = :dtInicioExecucao"),
    @NamedQuery(name = "OrdemServico.findByDtFimExecucao", query = "SELECT o FROM OrdemServico o WHERE o.dtFimExecucao = :dtFimExecucao"),
    @NamedQuery(name = "OrdemServico.findByDtGaratia", query = "SELECT o FROM OrdemServico o WHERE o.dtGaratia = :dtGaratia"),
    @NamedQuery(name = "OrdemServico.findByObs", query = "SELECT o FROM OrdemServico o WHERE o.obs = :obs"),
    @NamedQuery(name = "OrdemServico.findByTelSolic", query = "SELECT o FROM OrdemServico o WHERE o.telSolic = :telSolic"),
    @NamedQuery(name = "OrdemServico.findByVlr", query = "SELECT o FROM OrdemServico o WHERE o.vlr = :vlr"),
    @NamedQuery(name = "OrdemServico.findByDesconto", query = "SELECT o FROM OrdemServico o WHERE o.desconto = :desconto"),
    @NamedQuery(name = "OrdemServico.findByVlrTotal", query = "SELECT o FROM OrdemServico o WHERE o.vlrTotal = :vlrTotal")})
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEM_SERVICO")
    private Integer idOrdemServico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "COMBUSTIVEL")
    private String combustivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ANO_MODELO")
    private String anoModelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_AGENDAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtAgendamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "DT_INICIO_EXECUCAO")
    @Temporal(TemporalType.DATE)
    private Date dtInicioExecucao;
    @Column(name = "DT_FIM_EXECUCAO")
    @Temporal(TemporalType.DATE)
    private Date dtFimExecucao;
    @Column(name = "DT_GARATIA")
    @Temporal(TemporalType.DATE)
    private Date dtGaratia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "OBS")
    private String obs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "TEL_SOLIC")
    private String telSolic;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR")
    private Double vlr;
    @Column(name = "DESCONTO")
    private Double desconto;
    @Column(name = "VLR_TOTAL")
    private Double vlrTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrdemServico")
    private List<ItensOrdemServico> itensOrdemServicoList;
    @JoinColumn(name = "ID_FUNC_EXECUCAO", referencedColumnName = "ID_FUNCIONARIO")
    @ManyToOne
    private Funcionario idFuncExecucao;
    @JoinColumn(name = "ID_MODELO_VEICULO", referencedColumnName = "ID_MODELO")
    @ManyToOne(optional = false)
    private Modelo idModeloVeiculo;
    @JoinColumn(name = "ID_STATUS_ORDEM_SERVICO", referencedColumnName = "ID_STATUS_ORDEM_SERVICO")
    @ManyToOne(optional = false)
    private StatusOrdemServico idStatusOrdemServico;
    @JoinColumn(name = "ID_TIPO_ORDEM_SERVICO", referencedColumnName = "ID_TIPO_ORDEM_SERVICO")
    @ManyToOne(optional = false)
    private TipoOrdemServico idTipoOrdemServico;
    @JoinColumn(name = "ID_VENDA", referencedColumnName = "ID_VENDA")
    @OneToOne(optional = false)
    private Venda idVenda;

    /**
     *
     */
    public OrdemServico() {
    }

    /**
     *
     * @param idOrdemServico
     */
    public OrdemServico(Integer idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    /**
     *
     * @param idOrdemServico
     * @param placa
     * @param combustivel
     * @param anoModelo
     * @param dtAgendamento
     * @param dtCadastro
     * @param obs
     * @param telSolic
     */
    public OrdemServico(Integer idOrdemServico, String placa, String combustivel, String anoModelo, Date dtAgendamento, Date dtCadastro, String obs, String telSolic) {
        this.idOrdemServico = idOrdemServico;
        this.placa = placa;
        this.combustivel = combustivel;
        this.anoModelo = anoModelo;
        this.dtAgendamento = dtAgendamento;
        this.dtCadastro = dtCadastro;
        this.obs = obs;
        this.telSolic = telSolic;
    }

    /**
     *
     * @return
     */
    public Integer getIdOrdemServico() {
        return idOrdemServico;
    }

    /**
     *
     * @param idOrdemServico
     */
    public void setIdOrdemServico(Integer idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    /**
     *
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     *
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     *
     * @return
     */
    public String getCombustivel() {
        return combustivel;
    }

    /**
     *
     * @param combustivel
     */
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    /**
     *
     * @return
     */
    public String getAnoModelo() {
        return anoModelo;
    }

    /**
     *
     * @param anoModelo
     */
    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    /**
     *
     * @return
     */
    public Date getDtAgendamento() {
        return dtAgendamento;
    }

    /**
     *
     * @param dtAgendamento
     */
    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    /**
     *
     * @return
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     *
     * @param dtCadastro
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     *
     * @return
     */
    public Date getDtInicioExecucao() {
        return dtInicioExecucao;
    }

    /**
     *
     * @param dtInicioExecucao
     */
    public void setDtInicioExecucao(Date dtInicioExecucao) {
        this.dtInicioExecucao = dtInicioExecucao;
    }

    /**
     *
     * @return
     */
    public Date getDtFimExecucao() {
        return dtFimExecucao;
    }

    /**
     *
     * @param dtFimExecucao
     */
    public void setDtFimExecucao(Date dtFimExecucao) {
        this.dtFimExecucao = dtFimExecucao;
    }

    /**
     *
     * @return
     */
    public Date getDtGaratia() {
        return dtGaratia;
    }

    /**
     *
     * @param dtGaratia
     */
    public void setDtGaratia(Date dtGaratia) {
        this.dtGaratia = dtGaratia;
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
    public String getTelSolic() {
        return telSolic;
    }

    /**
     *
     * @param telSolic
     */
    public void setTelSolic(String telSolic) {
        this.telSolic = telSolic;
    }

    /**
     *
     * @return
     */
    public Double getVlr() {
        return vlr;
    }

    /**
     *
     * @param vlr
     */
    public void setVlr(Double vlr) {
        this.vlr = vlr;
    }

    /**
     *
     * @return
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     *
     * @param desconto
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    /**
     *
     * @return
     */
    public Double getVlrTotal() {
        return vlrTotal;
    }

    /**
     *
     * @param vlrTotal
     */
    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<ItensOrdemServico> getItensOrdemServicoList() {
        return itensOrdemServicoList;
    }

    /**
     *
     * @param itensOrdemServicoList
     */
    public void setItensOrdemServicoList(List<ItensOrdemServico> itensOrdemServicoList) {
        this.itensOrdemServicoList = itensOrdemServicoList;
    }

    /**
     *
     * @return
     */
    public Funcionario getIdFuncExecucao() {
        return idFuncExecucao;
    }

    /**
     *
     * @param idFuncExecucao
     */
    public void setIdFuncExecucao(Funcionario idFuncExecucao) {
        this.idFuncExecucao = idFuncExecucao;
    }

    /**
     *
     * @return
     */
    public Modelo getIdModeloVeiculo() {
        return idModeloVeiculo;
    }

    /**
     *
     * @param idModeloVeiculo
     */
    public void setIdModeloVeiculo(Modelo idModeloVeiculo) {
        this.idModeloVeiculo = idModeloVeiculo;
    }

    /**
     *
     * @return
     */
    public StatusOrdemServico getIdStatusOrdemServico() {
        return idStatusOrdemServico;
    }

    /**
     *
     * @param idStatusOrdemServico
     */
    public void setIdStatusOrdemServico(StatusOrdemServico idStatusOrdemServico) {
        this.idStatusOrdemServico = idStatusOrdemServico;
    }

    /**
     *
     * @return
     */
    public TipoOrdemServico getIdTipoOrdemServico() {
        return idTipoOrdemServico;
    }

    /**
     *
     * @param idTipoOrdemServico
     */
    public void setIdTipoOrdemServico(TipoOrdemServico idTipoOrdemServico) {
        this.idTipoOrdemServico = idTipoOrdemServico;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdemServico != null ? idOrdemServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        if ((this.idOrdemServico == null && other.idOrdemServico != null) || (this.idOrdemServico != null && !this.idOrdemServico.equals(other.idOrdemServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.OrdemServico[ idOrdemServico=" + idOrdemServico + " ]";
    }

}
