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
 * Classe responsável por representar a tabela FUNCIONARIO no banco de dados.
 * @author sleandro
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.ListarFuncionarios", 
            query = "SELECT f FROM Funcionario f where f.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Funcionario.ConsultarNomeFuncionarios", 
            query = "SELECT f.idPessoa.nome FROM Funcionario f where f.idEmpresa = :idEmpresa and f.idPessoa.nome like :nome"),
    @NamedQuery(name = "Funcionario.ConsultarFuncionarioPorIdPessoa", 
            query = "SELECT f FROM Funcionario f where f.idEmpresa = :idEmpresa and f.idPessoa = :idPessoa"),
    @NamedQuery(name = "Funcionario.ConsultarFuncionarioPorCPF", 
            query = "SELECT f FROM Funcionario f where f.idEmpresa = :idEmpresa and f.idPessoa.cpf = :cpf"),
    @NamedQuery(name = "Funcionario.ConsultarFuncionarioPorNome", 
            query = "SELECT f FROM Funcionario f where f.idEmpresa = :idEmpresa and f.idPessoa.nome = :nome"),    
    @NamedQuery(name = "Funcionario.ConsultarFuncionariosPorNome", 
            query = "SELECT f FROM Funcionario f where f.idEmpresa = :idEmpresa and f.idPessoa.nome like :nome"),    
    @NamedQuery(name = "Funcionario.consultarFuncionarioById", 
            query = "SELECT f FROM Funcionario f WHERE f.idEmpresa = :idEmpresa and f.idFuncionario = :idFuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FUNCIONARIO")
    private Integer idFuncionario;
    
        // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIO")
    private Double salario;
    
    @Column(name = "COMISSAO")
    private Double comissao;
    
    @Column(name = "VALE_ALIMENTACAO")
    private Double valeAlimentacao;
    
    @Column(name = "VALE_TRANSPORTE")
    private Double valeTransporte;
    
    @Column(name = "COMPL_SALARIO")
    private Double complSalario;
    
    @JoinColumn(name = "ID_TIPO_REMUNERACAO", referencedColumnName = "ID_TIPO_REMUNERACAO")
    @ManyToOne(optional = false)
    private TipoRemuneracao idTipoRemuneracao;

    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    @OneToOne(cascade = CascadeType.ALL)
    private PessoaFisica idPessoa;

    @OneToOne(mappedBy = "idFuncionrio", cascade = CascadeType.ALL)
    private Vendedor vendedor;

    @OneToMany(mappedBy = "idGerenteSetor")
    private List<Setor> setorList;

    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID_CARGO")
    @ManyToOne(optional = false)
    private Cargo idCargo;

    @JoinColumn(name = "ID_SITUACAO", referencedColumnName = "ID_SITUACAO")
    @ManyToOne(optional = false)
    private Situacao idSituacao;

    @Size(max = 45)
    @Column(name = "PIS")
    private String pis;

    @Column(name = "DT_ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dtAdmissao;

    @Column(name = "DT_DEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dtDemissao;

    @Size(max = 45)
    @Column(name = "TURNO")
    private String turno;

    @Size(max = 20)
    @Column(name = "CTPS")
    private String ctps;

    @Column(name = "SERIE")
    private Integer serie;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @Basic(optional = false)
    @NotNull
    @Column(name = "VENDE")
    private boolean vende;
    
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZ")
    @Temporal(TemporalType.DATE)
    private Date dtAtualiz;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserCadastro;

    @JoinColumn(name = "ID_USER_ATUALIZ", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualiz;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public List<Setor> getSetorList() {
        return setorList;
    }

    public void setSetorList(List<Setor> setorList) {
        this.setorList = setorList;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    public Vendedor getVendedor() {

        if (vendedor == null) {
            vendedor = new Vendedor();
        }
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
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

    public PessoaFisica getIdPessoa() {

        if (idPessoa == null) {
            idPessoa = new PessoaFisica();
        }
        return idPessoa;
    }

    public void setIdPessoa(PessoaFisica idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Date getDtDemissao() {
        return dtDemissao;
    }

    public void setDtDemissao(Date dtDemissao) {
        this.dtDemissao = dtDemissao;
    }

    public boolean getVende() {
        return vende;
    }

    public void setVende(boolean vende) {
        this.vende = vende;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtAtualiz() {
        return dtAtualiz;
    }

    public void setDtAtualiz(Date dtAtualiz) {
        this.dtAtualiz = dtAtualiz;
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

    public Usuario getIdUserAtualiz() {
        if (idUserAtualiz == null) {
            idUserAtualiz = new Usuario();
        }
        return idUserAtualiz;
    }

    public void setIdUserAtualiz(Usuario idUserAtualiz) {
        this.idUserAtualiz = idUserAtualiz;
    }


    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public Double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(Double valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

    public Double getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(Double valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public Double getComplSalario() {
        return complSalario;
    }

    public void setComplSalario(Double complSalario) {
        this.complSalario = complSalario;
    }

    public TipoRemuneracao getIdTipoRemuneracao() {
        
        if(idTipoRemuneracao == null)
        {
            idTipoRemuneracao = new TipoRemuneracao();
        }
        return idTipoRemuneracao;
    }

    public void setIdTipoRemuneracao(TipoRemuneracao idTipoRemuneracao) {
        this.idTipoRemuneracao = idTipoRemuneracao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }

}
