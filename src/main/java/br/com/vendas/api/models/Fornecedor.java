/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vendas.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByNomeCompleto", query = "SELECT f FROM Fornecedor f WHERE f.idEmpresa = :idEmpresa and f.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Fornecedor.findByNomeFantasia", query = "SELECT f.nomeFantasia FROM Fornecedor f WHERE f.idEmpresa = :idEmpresa and f.nomeFantasia like :nomeFantasia"),
    @NamedQuery(name = "Fornecedor.findByIdEmpresa", query = "SELECT f FROM Fornecedor f WHERE f.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Fornecedor.findByIdEmpresaLikeNome", query = "SELECT f.nome FROM Fornecedor f WHERE f.idEmpresa = :idEmpresa and f.nome like :nome"),
    @NamedQuery(name = "Fornecedor.findNomeFornecedorByIdEmpresa", query = "SELECT f.nome FROM Fornecedor f WHERE f.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedor.findByInscricaoEstadual", query = "SELECT f FROM Fornecedor f WHERE f.inscricaoEstadual = :inscricaoEstadual")})
@PrimaryKeyJoinColumn(name = "ID_FORNECEDOR")
@DiscriminatorValue("J")
public class Fornecedor extends Pessoa implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_FANTASIA")
    private String nomeFantasia;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_CONTATO")
    private String nomeContato;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CNPJ")
    private String cnpj;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;

    @OneToMany(mappedBy = "idFornecedor")
    private List<Pedido> pedidoList;

    @JoinColumn(name = "ID_USER_CADASTRO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUserCadastro;

    @JoinColumn(name = "ID_USER_ATUALIZACAO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUserAtualizacao;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecdor")
    private List<MarcaProduto> marcaProdutoList;

    public Fornecedor() {
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
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

    public Empresa getIdEmpresa() {

        if (idEmpresa == null) {
            idEmpresa = new Empresa();
        }
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public List<MarcaProduto> getMarcaProdutoList() {
        if (marcaProdutoList == null) {
            marcaProdutoList = new ArrayList<>();
        }
        return marcaProdutoList;
    }

    public MarcaProduto addMarcaproduto(MarcaProduto marca) {
        getMarcaProdutoList().add(marca);
        marca.setIdFornecdor(this);

        return marca;
    }

    public void setMarcaProdutoList(List<MarcaProduto> marcaProdutoList) {
        this.marcaProdutoList = marcaProdutoList;
    }

    public MarcaProduto removerMarcaproduto(MarcaProduto marca) {
        getMarcaProdutoList().remove(marca);
        marca.setIdFornecdor(null);

        return marca;
    }

}
