/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "lancamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lancamentos.findAll", query = "SELECT l FROM Lancamentos l"),
    @NamedQuery(name = "Lancamentos.findByIdLancamento", query = "SELECT l FROM Lancamentos l WHERE l.idLancamento = :idLancamento"),
    @NamedQuery(name = "Lancamentos.findByIdUsrCadastro", query = "SELECT l FROM Lancamentos l WHERE l.idUsrCadastro = :idUsrCadastro"),
    @NamedQuery(name = "Lancamentos.findByDtEntrada", query = "SELECT l FROM Lancamentos l WHERE l.dtEntrada = :dtEntrada"),
    @NamedQuery(name = "Lancamentos.findLancamentosByPeriodo", query = "SELECT l FROM Lancamentos l WHERE l.idEmpresa = :idEmpresa and  l.dtEntrada BETWEEN :dtIniEntrada and :dtFimEntrada"),
    @NamedQuery(name = "Lancamentos.BuscarLancamentosPorIdpedido", query = "SELECT l FROM Lancamentos l WHERE l.idEmpresa = :idEmpresa and l.idPedido = :idPedido"),
    @NamedQuery(name = "Lancamentos.findByIdTipoLancamento", query = "SELECT l FROM Lancamentos l WHERE l.idTipoLancamento = :idTipoLancamento"),
    @NamedQuery(name = "Lancamentos.findByIdEmpresa", query = "SELECT l FROM Lancamentos l WHERE l.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Lancamentos.findByObs", query = "SELECT l FROM Lancamentos l WHERE l.obs = :obs"),
    @NamedQuery(name = "Lancamentos.findByDataCadastro", query = "SELECT l FROM Lancamentos l WHERE l.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Lancamentos.findByDataAtualizacao", query = "SELECT l FROM Lancamentos l WHERE l.dataAtualizacao = :dataAtualizacao"),
    @NamedQuery(name = "Lancamentos.findByIdPedido", query = "SELECT l FROM Lancamentos l WHERE l.idPedido = :idPedido"),
    @NamedQuery(name = "Lancamentos.findLancamentosByIdStatus", query = "SELECT l FROM Lancamentos l WHERE l.idEmpresa = :idEmpresa and  l.idStatusLancamento = :idStatusLancamento")})
public class Lancamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LANCAMENTO")
    private Integer idLancamento;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    @OneToOne(optional = false)
    private Pedido idPedido;

    @JoinColumn(name = "ID_STATUS_LANCAMENTO", referencedColumnName = "ID_STATUS_LANCAMENTO")
    @ManyToOne(optional = false)
    private StatusLancamento idStatusLancamento;

    @JoinColumn(name = "ID_TIPO_LANCAMENTO", referencedColumnName = "ID_TIPO_LANCAMENTO")
    @ManyToOne(optional = false)
    private TipoLancamento idTipoLancamento;

    @JoinColumn(name = "ID_USR_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsrCadastro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLancamento")
    private List<ItemLancamento> itemLancamentoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLancamento")
    private List<EstoqueProdutos> estoqueProdutosList;

    @Column(name = "DT_ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dtEntrada;

    @Column(name = "QTD_ENTRADA")
    private Integer qtdEntrada;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_NOTA")
    private Double vlrNota;

    @Size(max = 100)
    @Column(name = "OBS")
    private String obs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(name = "DATA_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;

    public Lancamentos() {
    }

    public Lancamentos(Integer idLancamento) {
        this.idLancamento = idLancamento;
    }

    public Integer getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(Integer idLancamento) {
        this.idLancamento = idLancamento;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Integer getQtdEntrada() {
        return qtdEntrada;
    }

    public void setQtdEntrada(Integer qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
    }

    public Double getVlrNota() {
        return vlrNota;
    }

    public void setVlrNota(Double vlrNota) {
        this.vlrNota = vlrNota;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Empresa getIdEmpresa() {

        if (idEmpresa == null) {
            idEmpresa = new Empresa();
        }
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Pedido getIdPedido() {

        if (idPedido == null) {
            idPedido = new Pedido();
        }
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public StatusLancamento getIdStatusLancamento() {

        if (idStatusLancamento == null) {
            idStatusLancamento = new StatusLancamento();
        }
        return idStatusLancamento;
    }

    public void setIdStatusLancamento(StatusLancamento idStatusLancamento) {
        this.idStatusLancamento = idStatusLancamento;
    }

    public TipoLancamento getIdTipoLancamento() {

        if (idTipoLancamento == null) {
            idTipoLancamento = new TipoLancamento();
        }
        return idTipoLancamento;
    }

    public void setIdTipoLancamento(TipoLancamento idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }

    public Usuario getIdUsrCadastro() {

        if (idUsrCadastro == null) {
            idUsrCadastro = new Usuario();
        }
        return idUsrCadastro;
    }

    public void setIdUsrCadastro(Usuario idUsrCadastro) {
        this.idUsrCadastro = idUsrCadastro;
    }

    @XmlTransient
    public List<ItemLancamento> getItemLancamentoList() {

        if (itemLancamentoList == null) {
            itemLancamentoList = new ArrayList<>();
        }
        return itemLancamentoList;
    }

    public void setItemLancamentoList(List<ItemLancamento> itemLancamentoList) {
        this.itemLancamentoList = itemLancamentoList;
    }
    
    public void addItensLancamento(ItemLancamento item)
    {
        item.setIdLancamento(this);
        getItemLancamentoList().add(item);
        
    }
    
    public void excluirItensLancamento(ItemLancamento item)
    {
        getItemLancamentoList().remove(item);
        item.setIdLancamento(null);
        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLancamento != null ? idLancamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lancamentos)) {
            return false;
        }
        Lancamentos other = (Lancamentos) object;
        if ((this.idLancamento == null && other.idLancamento != null) || (this.idLancamento != null && !this.idLancamento.equals(other.idLancamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.Lancamentos[ idLancamento=" + idLancamento + " ]";
    }

    @XmlTransient
    public List<EstoqueProdutos> getEstoqueProdutosList() {
        return estoqueProdutosList;
    }

    public void setEstoqueProdutosList(List<EstoqueProdutos> estoqueProdutosList) {
        this.estoqueProdutosList = estoqueProdutosList;
    }

}
