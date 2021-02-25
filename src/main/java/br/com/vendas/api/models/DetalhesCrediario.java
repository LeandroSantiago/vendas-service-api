/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "detalhes_crediario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalhesCrediario.findAll", query = "SELECT d FROM DetalhesCrediario d"),
    @NamedQuery(name = "DetalhesCrediario.findByIdDetalhesCrediario", query = "SELECT d FROM DetalhesCrediario d WHERE d.idDetalhesCrediario = :idDetalhesCrediario"),
    @NamedQuery(name = "DetalhesCrediario.findByTelPrincipal", query = "SELECT d FROM DetalhesCrediario d WHERE d.telPrincipal = :telPrincipal"),
    @NamedQuery(name = "DetalhesCrediario.findByTelCelular", query = "SELECT d FROM DetalhesCrediario d WHERE d.telCelular = :telCelular"),
    @NamedQuery(name = "DetalhesCrediario.findByTelComercial", query = "SELECT d FROM DetalhesCrediario d WHERE d.telComercial = :telComercial"),
    @NamedQuery(name = "DetalhesCrediario.findByRamal", query = "SELECT d FROM DetalhesCrediario d WHERE d.ramal = :ramal"),
    @NamedQuery(name = "DetalhesCrediario.findByTelRecado", query = "SELECT d FROM DetalhesCrediario d WHERE d.telRecado = :telRecado"),
    @NamedQuery(name = "DetalhesCrediario.findByNomeRecado", query = "SELECT d FROM DetalhesCrediario d WHERE d.nomeRecado = :nomeRecado"),
    @NamedQuery(name = "DetalhesCrediario.findByReferencia1", query = "SELECT d FROM DetalhesCrediario d WHERE d.referencia1 = :referencia1"),
    @NamedQuery(name = "DetalhesCrediario.findByFoneReferencia1", query = "SELECT d FROM DetalhesCrediario d WHERE d.foneReferencia1 = :foneReferencia1"),
    @NamedQuery(name = "DetalhesCrediario.findByTipoReferencia1", query = "SELECT d FROM DetalhesCrediario d WHERE d.tipoReferencia1 = :tipoReferencia1"),
    @NamedQuery(name = "DetalhesCrediario.findByReferencia2", query = "SELECT d FROM DetalhesCrediario d WHERE d.referencia2 = :referencia2"),
    @NamedQuery(name = "DetalhesCrediario.findByFoneReferencia2", query = "SELECT d FROM DetalhesCrediario d WHERE d.foneReferencia2 = :foneReferencia2"),
    @NamedQuery(name = "DetalhesCrediario.findByTipoReferencia2", query = "SELECT d FROM DetalhesCrediario d WHERE d.tipoReferencia2 = :tipoReferencia2")})
public class DetalhesCrediario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALHES_CREDIARIO")
    private Integer idDetalhesCrediario;
    
    @OneToOne(mappedBy = "idDetalhesCrediario")
    private Crediario crediario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEL_PRINCIPAL")
    private String telPrincipal;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEL_CELULAR")
    private String telCelular;
    
    @Size(max = 15)
    @Column(name = "TEL_COMERCIAL")
    private String telComercial;
    
    @Size(max = 4)
    @Column(name = "RAMAL")
    private String ramal;
    
    @Size(max = 15)
    @Column(name = "TEL_RECADO")
    private String telRecado;
    
    @Size(max = 45)
    @Column(name = "NOME_RECADO")
    private String nomeRecado;
    
    @Size(max = 45)
    @Column(name = "REFERENCIA1")
    private String referencia1;
    
    @Size(max = 15)
    @Column(name = "FONE_REFERENCIA1")
    private String foneReferencia1;
    
    @Size(max = 20)
    @Column(name = "TIPO_REFERENCIA1")
    private String tipoReferencia1;
    
    @Size(max = 45)
    @Column(name = "REFERENCIA2")
    private String referencia2;
    
    @Size(max = 15)
    @Column(name = "FONE_REFERENCIA2")
    private String foneReferencia2;
    
    @Size(max = 20)
    @Column(name = "TIPO_REFERENCIA2")
    private String tipoReferencia2;


    public DetalhesCrediario() {
    }

    public DetalhesCrediario(Integer idDetalhesCrediario) {
        this.idDetalhesCrediario = idDetalhesCrediario;
    }

    public DetalhesCrediario(Integer idDetalhesCrediario, String telPrincipal, String telCelular) {
        this.idDetalhesCrediario = idDetalhesCrediario;
        this.telPrincipal = telPrincipal;
        this.telCelular = telCelular;
    }

    public Integer getIdDetalhesCrediario() {
        return idDetalhesCrediario;
    }

    public void setIdDetalhesCrediario(Integer idDetalhesCrediario) {
        this.idDetalhesCrediario = idDetalhesCrediario;
    }

    public String getTelPrincipal() {
        return telPrincipal;
    }

    public void setTelPrincipal(String telPrincipal) {
        this.telPrincipal = telPrincipal;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getTelComercial() {
        return telComercial;
    }

    public void setTelComercial(String telComercial) {
        this.telComercial = telComercial;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getTelRecado() {
        return telRecado;
    }

    public void setTelRecado(String telRecado) {
        this.telRecado = telRecado;
    }

    public String getNomeRecado() {
        return nomeRecado;
    }

    public void setNomeRecado(String nomeRecado) {
        this.nomeRecado = nomeRecado;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getFoneReferencia1() {
        return foneReferencia1;
    }

    public void setFoneReferencia1(String foneReferencia1) {
        this.foneReferencia1 = foneReferencia1;
    }

    public String getTipoReferencia1() {
        return tipoReferencia1;
    }

    public void setTipoReferencia1(String tipoReferencia1) {
        this.tipoReferencia1 = tipoReferencia1;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getFoneReferencia2() {
        return foneReferencia2;
    }

    public void setFoneReferencia2(String foneReferencia2) {
        this.foneReferencia2 = foneReferencia2;
    }

    public String getTipoReferencia2() {
        return tipoReferencia2;
    }

    public void setTipoReferencia2(String tipoReferencia2) {
        this.tipoReferencia2 = tipoReferencia2;
    }
    
        public Crediario getCrediario() {
        
        if(crediario == null)
        {
            crediario = new Crediario();
        }
        return crediario;
    }

    public void setCrediario(Crediario crediario) {
        this.crediario = crediario;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalhesCrediario != null ? idDetalhesCrediario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalhesCrediario)) {
            return false;
        }
        DetalhesCrediario other = (DetalhesCrediario) object;
        if ((this.idDetalhesCrediario == null && other.idDetalhesCrediario != null) || (this.idDetalhesCrediario != null && !this.idDetalhesCrediario.equals(other.idDetalhesCrediario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.DetalhesCrediario[ idDetalhesCrediario=" + idDetalhesCrediario + " ]";
    }


    
}
