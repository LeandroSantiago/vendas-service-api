/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sleandro
 */
@Entity
@Table(name = "controle_meta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControleMeta.findAll", query = "SELECT c FROM ControleMeta c"),
    @NamedQuery(name = "ControleMeta.findByIdMetas", query = "SELECT c FROM ControleMeta c WHERE c.idMetas = :idMetas"),
    @NamedQuery(name = "ControleMeta.findByDtInicioMeta", query = "SELECT c FROM ControleMeta c WHERE c.dtInicioMeta = :dtInicioMeta"),
    @NamedQuery(name = "ControleMeta.findByDtFimMeta", query = "SELECT c FROM ControleMeta c WHERE c.dtFimMeta = :dtFimMeta"),
    @NamedQuery(name = "ControleMeta.findByVlrMeta", query = "SELECT c FROM ControleMeta c WHERE c.vlrMeta = :vlrMeta"),
    @NamedQuery(name = "ControleMeta.findByVlrMetaAtingida", query = "SELECT c FROM ControleMeta c WHERE c.vlrMetaAtingida = :vlrMetaAtingida"),
    @NamedQuery(name = "ControleMeta.findByPercentMetaAtingida", query = "SELECT c FROM ControleMeta c WHERE c.percentMetaAtingida = :percentMetaAtingida"),
    @NamedQuery(name = "ControleMeta.findByPercentComissao", query = "SELECT c FROM ControleMeta c WHERE c.percentComissao = :percentComissao"),
    @NamedQuery(name = "ControleMeta.findByIdUserCadastro", query = "SELECT c FROM ControleMeta c WHERE c.idUserCadastro = :idUserCadastro"),
    @NamedQuery(name = "ControleMeta.findByDtCadastro", query = "SELECT c FROM ControleMeta c WHERE c.dtCadastro = :dtCadastro"),
    @NamedQuery(name = "ControleMeta.findByIdUserAtualizacao", query = "SELECT c FROM ControleMeta c WHERE c.idUserAtualizacao = :idUserAtualizacao"),
    @NamedQuery(name = "ControleMeta.findByDtAtualizacao", query = "SELECT c FROM ControleMeta c WHERE c.dtAtualizacao = :dtAtualizacao")})
public class ControleMeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_metas")
    private Integer idMetas;

    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_inicio_meta")
    @Temporal(TemporalType.DATE)
    private Date dtInicioMeta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_fim_meta")
    @Temporal(TemporalType.DATE)
    private Date dtFimMeta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "vlr_meta")
    private double vlrMeta;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlr_meta_atingida")
    private Double vlrMetaAtingida;

    @Column(name = "percent_meta_atingida")
    private Double percentMetaAtingida;

    @Column(name = "percent_comissao")
    private Double percentComissao;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtCadastro;

    @Column(name = "DT_ATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dtAtualizacao;

    @JoinColumn(name = "id_empresa", referencedColumnName = "ID_EMPRESA")
    @OneToOne
    private Empresa idEmpresa;

    @JoinColumn(name = "ID_SITUACAO_META", referencedColumnName = "ID_SITUACAO_META")
    @ManyToOne(optional = false)
    private SituacaoMeta idSituacaoMeta;

    @JoinColumn(name = "ID_TIPO_META", referencedColumnName = "ID_TIPO_META")
    @ManyToOne(optional = false)
    private TipoMeta idTipoMeta;

    @JoinColumn(name = "id_vendedor", referencedColumnName = "ID_VENDEDOR")
    @OneToOne(cascade = CascadeType.ALL)
    private Vendedor idVendedor;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacao;

    public ControleMeta() {
    }

    public ControleMeta(Integer idMetas) {
        this.idMetas = idMetas;
    }


    public Integer getIdMetas() {
        return idMetas;
    }

    public void setIdMetas(Integer idMetas) {
        this.idMetas = idMetas;
    }

    public Date getDtInicioMeta() {
        return dtInicioMeta;
    }

    public void setDtInicioMeta(Date dtInicioMeta) {
        this.dtInicioMeta = dtInicioMeta;
    }

    public Date getDtFimMeta() {
        return dtFimMeta;
    }

    public void setDtFimMeta(Date dtFimMeta) {
        this.dtFimMeta = dtFimMeta;
    }

    public double getVlrMeta() {
        return vlrMeta;
    }

    public void setVlrMeta(double vlrMeta) {
        this.vlrMeta = vlrMeta;
    }

    public Double getVlrMetaAtingida() {
        return vlrMetaAtingida;
    }

    public void setVlrMetaAtingida(Double vlrMetaAtingida) {
        this.vlrMetaAtingida = vlrMetaAtingida;
    }

    public Double getPercentMetaAtingida() {
        return percentMetaAtingida;
    }

    public void setPercentMetaAtingida(Double percentMetaAtingida) {
        this.percentMetaAtingida = percentMetaAtingida;
    }

    public Double getPercentComissao() {
        return percentComissao;
    }

    public void setPercentComissao(Double percentComissao) {
        this.percentComissao = percentComissao;
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

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public SituacaoMeta getIdSituacaoMeta() {
        return idSituacaoMeta;
    }

    public void setIdSituacaoMeta(SituacaoMeta idSituacaoMeta) {
        this.idSituacaoMeta = idSituacaoMeta;
    }

    public TipoMeta getIdTipoMeta() {
        return idTipoMeta;
    }

    public void setIdTipoMeta(TipoMeta idTipoMeta) {
        this.idTipoMeta = idTipoMeta;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
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

    public Usuario getIdUserAtualizacao() {

        if (idUserAtualizacao == null) {
            idUserAtualizacao = new Usuario();
        }
        return idUserAtualizacao;
    }

    public void setIdUserAtualizacao(Usuario idUserAtualizacao) {
        this.idUserAtualizacao = idUserAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetas != null ? idMetas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControleMeta)) {
            return false;
        }
        ControleMeta other = (ControleMeta) object;
        if ((this.idMetas == null && other.idMetas != null) || (this.idMetas != null && !this.idMetas.equals(other.idMetas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vendas.vendasapi.models.ControleMeta[ idMetas=" + idMetas + " ]";
    }

}
