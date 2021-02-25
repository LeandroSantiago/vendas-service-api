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
@Table(name = "crediario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crediario.findAll", query = "SELECT c FROM Crediario c"),
    @NamedQuery(name = "Crediario.findByIdCrediario", 
            query = "SELECT c FROM Crediario c WHERE c.idCrediario = :idCrediario"),
    @NamedQuery(name = "Crediario.consultarCrediarioPorCodCliente", 
            query = "SELECT c FROM Crediario c WHERE c.idEmpresa.idEmpresa = :idEmpresa and c.idCliente.idCliente = :idCliente"),
    
    @NamedQuery(name = "Crediario.consultarCrediarioNomeCliente", 
            query = "SELECT c FROM Crediario c WHERE c.idEmpresa.idEmpresa = :idEmpresa and c.idCliente.idPessoa.nome like :nomeCliente"),
    
@NamedQuery(name = "Crediario.consultarCrediarioPorCpf", 
            query = "SELECT c FROM Crediario c WHERE c.idEmpresa.idEmpresa = :idEmpresa and c.idCliente.idPessoa.nome = :nome"),    
    @NamedQuery(name = "Crediario.findByDtAbertura", 
            query = "SELECT c FROM Crediario c WHERE c.dtAbertura = :dtAbertura"),
    @NamedQuery(name = "Crediario.findByDtUltAtlz", query = "SELECT c FROM Crediario c WHERE c.dtUltAtlz = :dtUltAtlz"),
    @NamedQuery(name = "Crediario.findByObs", query = "SELECT c FROM Crediario c WHERE c.obs = :obs")})
public class Crediario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CREDIARIO")
    private Integer idCrediario;
    
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    private Cliente idCliente;
    
    @JoinColumn(name = "ID_SITUACAO_CREDIARIO", referencedColumnName = "ID_SITUACAO_CREDIARIO")
    @ManyToOne(optional = false)
    private SituacaoCrediario idSituacaoCrediario;

    @JoinColumn(name = "ID_DETALHES_CREDIARIO", referencedColumnName = "ID_DETALHES_CREDIARIO")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private DetalhesCrediario idDetalhesCrediario;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

//    @OneToOne(mappedBy = "idCrediario")
//    private Cliente cliente;
    @JoinColumn(name = "ID_STATUS_CREDIARIO", referencedColumnName = "ID_STATUS_CREDIARIO")
    @ManyToOne(optional = false)
    private StatusCrediario idStatusCrediario;

    @JoinColumn(name = "ID_USER_ATUALIZ", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualiz;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_ABERTURA")
    @Temporal(TemporalType.DATE)
    private Date dtAbertura;

    @Size(max = 255)
    @Column(name = "OBS")
    private String obs;

    @Column(name = "DT_ULT_ATLZ")
    @Temporal(TemporalType.DATE)
    private Date dtUltAtlz;

    @Column(name = "DT_PRIMEIRA_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date dtPrimeiraCompra;

    @Column(name = "DT_ULTIMA_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date dtUltimaCompra;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_RENDA")
    private double vlrRenda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "QTD_PARCELAS")
    private int qtdParcelas;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERCENTUAL_RENDA")
    private double percentualRenda;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_LIMITE")
    private double vlrLimite;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_LIMITE_ULTILIZADO")
    private double vlrLimiteUltilizado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VLR_SALDO")
    private double vlrSaldo;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_SALDO_DEVEDOR")
    private Double vlrSaldoDevedor;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCrediario")
    private List<CrediarioVendas> crediarioVendasList;

    public Crediario() {
    }

    public Date getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getDtUltAtlz() {
        return dtUltAtlz;
    }

    public void setDtUltAtlz(Date dtUltAtlz) {
        this.dtUltAtlz = dtUltAtlz;
    }

    public Date getDtPrimeiraCompra() {
        return dtPrimeiraCompra;
    }

    public void setDtPrimeiraCompra(Date dtPrimeiraCompra) {
        this.dtPrimeiraCompra = dtPrimeiraCompra;
    }

    public Date getDtUltimaCompra() {
        return dtUltimaCompra;
    }

    public void setDtUltimaCompra(Date dtUltimaCompra) {
        this.dtUltimaCompra = dtUltimaCompra;
    }

    public Crediario(Integer idCrediario) {
        this.idCrediario = idCrediario;
    }

    public Integer getIdCrediario() {
        return idCrediario;
    }

    public void setIdCrediario(Integer idCrediario) {
        this.idCrediario = idCrediario;
    }

    public StatusCrediario getIdStatusCrediario() {
        
        if(idStatusCrediario == null)
        {
            idStatusCrediario = new StatusCrediario();
        }
        return idStatusCrediario;
    }

    public void setIdStatusCrediario(StatusCrediario idStatusCrediario) {
        this.idStatusCrediario = idStatusCrediario;
    }

    public Usuario getIdUserAtualiz() {
        return idUserAtualiz;
    }

    public void setIdUserAtualiz(Usuario idUserAtualiz) {
        this.idUserAtualiz = idUserAtualiz;
    }

    public Usuario getIdUserCadastro() {
        return idUserCadastro;
    }

    public void setIdUserCadastro(Usuario idUserCadastro) {
        this.idUserCadastro = idUserCadastro;
    }

    public double getVlrRenda() {
        return vlrRenda;
    }

    public void setVlrRenda(double vlrRenda) {
        this.vlrRenda = vlrRenda;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public double getPercentualRenda() {
        return percentualRenda;
    }

    public void setPercentualRenda(double percentualRenda) {
        this.percentualRenda = percentualRenda;
    }

    public double getVlrLimite() {
        return vlrLimite;
    }

    public void setVlrLimite(double vlrLimite) {
        this.vlrLimite = vlrLimite;
    }

    public double getVlrLimiteUltilizado() {
        return vlrLimiteUltilizado;
    }

    public void setVlrLimiteUltilizado(double vlrLimiteUltilizado) {
        this.vlrLimiteUltilizado = vlrLimiteUltilizado;
    }

    public double getVlrSaldo() {
        return vlrSaldo;
    }

    public void setVlrSaldo(double vlrSaldo) {
        this.vlrSaldo = vlrSaldo;
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

    public DetalhesCrediario getIdDetalhesCrediario() {

        if (idDetalhesCrediario == null) {
            idDetalhesCrediario = new DetalhesCrediario();
        }
        return idDetalhesCrediario;
    }

    public void setIdDetalhesCrediario(DetalhesCrediario idDetalhesCrediario) {
        this.idDetalhesCrediario = idDetalhesCrediario;
    }
    
    public Cliente getIdCliente() {

        if (idCliente == null) {
            idCliente = new Cliente();
        }
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public SituacaoCrediario getIdSituacaoCrediario() {
        
        if(idSituacaoCrediario == null)
        {
            idSituacaoCrediario = new SituacaoCrediario();
        }
        return idSituacaoCrediario;
    }

    public void setIdSituacaoCrediario(SituacaoCrediario idSituacaoCrediario) {
        this.idSituacaoCrediario = idSituacaoCrediario;
    }

    public Double getVlrSaldoDevedor() {
        return vlrSaldoDevedor;
    }

    public void setVlrSaldoDevedor(Double vlrSaldoDevedor) {
        this.vlrSaldoDevedor = vlrSaldoDevedor;
    }

    @XmlTransient
    public List<CrediarioVendas> getCrediarioVendasList() {
        
        if(crediarioVendasList == null)
        {
            crediarioVendasList = new ArrayList<>();
        }
        return crediarioVendasList;
    }

    public void setCrediarioVendasList(List<CrediarioVendas> crediarioVendasList) {
        this.crediarioVendasList = crediarioVendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCrediario != null ? idCrediario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crediario)) {
            return false;
        }
        Crediario other = (Crediario) object;
        if ((this.idCrediario == null && other.idCrediario != null) || (this.idCrediario != null && !this.idCrediario.equals(other.idCrediario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.Crediario[ idCrediario=" + idCrediario + " ]";
    }

}
