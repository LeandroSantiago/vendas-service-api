/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor v WHERE v.idVendedor = :idVendedor"),
    @NamedQuery(name = "Vendedor.findByDtCadastro", query = "SELECT v FROM Vendedor v WHERE v.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "Vendedor.consultarVendedores", query = "SELECT v FROM Vendedor v WHERE v.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Vendedor.consultarVendedorPorCPF", query = "SELECT v FROM Vendedor v WHERE v.idEmpresa = :idEmpresa and v.idPessoa = :idPessoa"),
    @NamedQuery(name = "Vendedor.consultarNomeVendedores", query = "SELECT v.idPessoa.nome FROM Vendedor v WHERE v.idEmpresa = :idEmpresa and v.idPessoa.nome = :nome"),
    @NamedQuery(name = "Vendedor.consultarVendedorPorNome", query = "SELECT v FROM Vendedor v WHERE v.idEmpresa = :idEmpresa and v.idPessoa.nome = :nome"),
    @NamedQuery(name = "Vendedor.ListarVendedoresPorNome", query = "SELECT v FROM Vendedor v WHERE v.idEmpresa = :idEmpresa and v.idPessoa.nome like :nome"),
    @NamedQuery(name = "Vendedor.findByDtAdmissao", query = "SELECT v FROM Vendedor v WHERE v.dtAdmissao = :dtAdmissao"),
    @NamedQuery(name = "Vendedor.findByPercentComissao", query = "SELECT v FROM Vendedor v WHERE v.percentComissao = :percentComissao")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENDEDOR")
    private Integer idVendedor;

    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa idPessoa;

    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacao;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dtAdmissao;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PERCENT_COMISSAO")
    private BigDecimal percentComissao;

    @Column(name = "VLR_COMISSAO")
    private Double vlrComissao;

    @Column(name = "PERCENT_DESCONTO")
    private BigDecimal percentDesconto;

    @Column(name = "VLR_DESCONTO")
    private BigDecimal vlrDesconto;

    @Column(name = "VLR_LIMITE_VENDA")
    private BigDecimal vlrLimiteVenda;

    @JoinColumn(name = "ID_FUNCIONRIO", referencedColumnName = "ID_FUNCIONARIO")
    @OneToOne
    private Funcionario idFuncionrio;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_VENDEDOR")
    private boolean statusVendedor;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @OneToOne(mappedBy = "idVendedor")
    private ControleMeta controleMeta;

    @JoinColumn(name = "ID_SITUACAO", referencedColumnName = "ID_SITUACAO")
    @ManyToOne(optional = false)
    private Situacao idSituacao;

    @Column(name = "VLR_MINIMO_VENDA")
    private Double vlrMinimoVenda;

    @OneToMany(mappedBy = "idVendedor")
    private List<Pedido> pedidoList;
    
    @OneToMany(mappedBy = "idVendedor")
    private List<Venda> vendaList;

    public Vendedor() {
    }

    public Vendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor(Integer idVendedor, Date dtCadastro, Date dtAdmissao) {
        this.idVendedor = idVendedor;
        this.dtCadastro = dtCadastro;
        this.dtAdmissao = dtAdmissao;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public BigDecimal getPercentComissao() {
        return percentComissao;
    }

    public void setPercentComissao(BigDecimal percentComissao) {
        this.percentComissao = percentComissao;
    }

    public Funcionario getIdFuncionrio() {

        if (idFuncionrio == null) {
            idFuncionrio = new Funcionario();
        }
        return idFuncionrio;
    }

    public void setIdFuncionrio(Funcionario idFuncionrio) {
        this.idFuncionrio = idFuncionrio;
    }

    public Double getVlrComissao() {
        return vlrComissao;
    }

    public void setVlrComissao(Double vlrComissao) {
        this.vlrComissao = vlrComissao;
    }

    public BigDecimal getPercentDesconto() {
        return percentDesconto;
    }

    public void setPercentDesconto(BigDecimal percentDesconto) {
        this.percentDesconto = percentDesconto;
    }

    public BigDecimal getVlrDesconto() {
        return vlrDesconto;
    }

    public void setVlrDesconto(BigDecimal vlrDesconto) {
        this.vlrDesconto = vlrDesconto;
    }

    public BigDecimal getVlrLimiteVenda() {
        return vlrLimiteVenda;
    }

    public void setVlrLimiteVenda(BigDecimal vlrLimiteVenda) {
        this.vlrLimiteVenda = vlrLimiteVenda;
    }

    public boolean getStatusVendedor() {
        return statusVendedor;
    }

    public void setStatusVendedor(boolean statusVendedor) {
        this.statusVendedor = statusVendedor;
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

    public ControleMeta getControleMeta() {

        if (controleMeta == null) {
            controleMeta = new ControleMeta();
        }
        return controleMeta;
    }

    public void setControleMeta(ControleMeta controleMeta) {
        this.controleMeta = controleMeta;
    }

    public Pessoa getIdPessoa() {

        if(idPessoa == null)
        {
            idPessoa = new Pessoa();
        }
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Double getVlrMinimoVenda() {
        return vlrMinimoVenda;
    }

    public void setVlrMinimoVenda(Double vlrMinimoVenda) {
        this.vlrMinimoVenda = vlrMinimoVenda;
    }

    public Situacao getIdSituacao() {

        if (idSituacao == null) {
            idSituacao = new Situacao();
        }

        return idSituacao;
    }

    public void setIdSituacao(Situacao idSituacao) {
        this.idSituacao = idSituacao;
    }

    public Usuario getIdUserAtualizacao() {

        if (idUserAtualizacao == null) {
            idUserAtualizacao = new Usuario();
        }
        return idUserAtualizacao;
    }

    public void setIdUserAtualizacao(Usuario idUserAtualizacao) {
        this.idUserAtualizacao = idUserAtualizacao;
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

    @XmlTransient
    public List<Pedido> getPedidoList() {

        if (pedidoList == null) {
            pedidoList = new ArrayList<>();
        }
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
    
    @XmlTransient
    public List<Venda> getVendaList() {
        
        if(vendaList == null)
        {
            vendaList = new ArrayList<>();
        }
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.Vendedor[ idVendedor=" + idVendedor + " ]";
    }

}
