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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo"),
    @NamedQuery(name = "Cargo.buscarCargosPorSetor", query = "SELECT c FROM Cargo c WHERE c.idSetor = :idSetor"),
    @NamedQuery(name = "Cargo.findByDescricao", query = "SELECT c FROM Cargo c WHERE c.descricao = :descricao")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CARGO")
    private Integer idCargo;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserAtualizacao;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @Column(name = "SALARIO_EFETIVO")
    private Double salarioEfetivo;

    @Column(name = "SALARIO_EXPERIENCIA")
    private Double salarioExperiencia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargo")
    private List<Funcionario> funcionarioList;

    @JoinColumn(name = "ID_SETOR", referencedColumnName = "ID_SETOR")
    @ManyToOne(optional = false)
    private Setor idSetor;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCargo")
    private List<DadosEmpregaticios> dadosEmpregaticiosList;

    /**
     *
     */
    public Cargo() {
    }

    /**
     *
     * @param idCargo
     */
    public Cargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    /**
     *
     * @param idCargo
     * @param descricao
     */
    public Cargo(Integer idCargo, String descricao) {
        this.idCargo = idCargo;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Integer getIdCargo() {
        return idCargo;
    }

    /**
     *
     * @param idCargo
     */
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
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
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    /**
     *
     * @param funcionarioList
     */
    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    /**
     *
     * @return
     */
    public Setor getIdSetor() {

        if (idSetor == null) {
            idSetor = new Setor();
        }
        return idSetor;
    }

    /**
     *
     * @param idSetor
     */
    public void setIdSetor(Setor idSetor) {
        this.idSetor = idSetor;
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

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
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

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public Double getSalarioEfetivo() {
        return salarioEfetivo;
    }

    public void setSalarioEfetivo(Double salarioEfetivo) {
        this.salarioEfetivo = salarioEfetivo;
    }

    public Double getSalarioExperiencia() {
        return salarioExperiencia;
    }

    public void setSalarioExperiencia(Double salarioExperiencia) {
        this.salarioExperiencia = salarioExperiencia;
    }
    
    @XmlTransient
    public List<DadosEmpregaticios> getDadosEmpregaticiosList() {
        return dadosEmpregaticiosList;
    }

    public void setDadosEmpregaticiosList(List<DadosEmpregaticios> dadosEmpregaticiosList) {
        this.dadosEmpregaticiosList = dadosEmpregaticiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.GlobalVendasOn.Entidades.Cargo[ idCargo=" + idCargo + " ]";
    }


}
