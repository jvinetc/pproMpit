/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Natalia
 */
@Entity
@Table(name = "ppro_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproDocumento.findAll", query = "SELECT p FROM PproDocumento p")
    , @NamedQuery(name = "PproDocumento.findByDocId", query = "SELECT p FROM PproDocumento p WHERE p.docId = :docId")
    , @NamedQuery(name = "PproDocumento.findByDocNumero", query = "SELECT p FROM PproDocumento p WHERE p.docNumero = :docNumero")
    , @NamedQuery(name = "PproDocumento.findByDocRuta", query = "SELECT p FROM PproDocumento p WHERE p.docRuta = :docRuta")})
public class PproDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doc_id")
    private Integer docId;
    @Column(name = "doc_numero")
    private Integer docNumero;
    @Size(max = 255)
    @Column(name = "doc_ruta")
    private String docRuta;
    @OneToMany(mappedBy = "aneDocId")
    private Collection<PproAnexoDocumento> pproAnexoDocumentoCollection;
    @JoinColumn(name = "doc_edoc_id", referencedColumnName = "edoc_id")
    @ManyToOne
    private PproEstadoDocumento docEdocId;
    @JoinColumn(name = "doc_prov_id", referencedColumnName = "prov_id")
    @ManyToOne
    private PproProveedor docProvId;
    @JoinColumn(name = "doc_tdoc_id", referencedColumnName = "tdoc_id")
    @ManyToOne
    private PproTipoDocumento docTdocId;
    @JoinColumn(name = "doc_usu_autoriza", referencedColumnName = "usu_id")
    @ManyToOne
    private PproUsuario docUsuAutoriza;
    @JoinColumn(name = "doc_usu_ingresa", referencedColumnName = "usu_id")
    @ManyToOne
    private PproUsuario docUsuIngresa;
    @JoinColumn(name = "doc_usu_modifica", referencedColumnName = "usu_id")
    @ManyToOne
    private PproUsuario docUsuModifica;

    public PproDocumento() {
    }

    public PproDocumento(Integer docId) {
        this.docId = docId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getDocNumero() {
        return docNumero;
    }

    public void setDocNumero(Integer docNumero) {
        this.docNumero = docNumero;
    }

    public String getDocRuta() {
        return docRuta;
    }

    public void setDocRuta(String docRuta) {
        this.docRuta = docRuta;
    }

    @XmlTransient
    public Collection<PproAnexoDocumento> getPproAnexoDocumentoCollection() {
        return pproAnexoDocumentoCollection;
    }

    public void setPproAnexoDocumentoCollection(Collection<PproAnexoDocumento> pproAnexoDocumentoCollection) {
        this.pproAnexoDocumentoCollection = pproAnexoDocumentoCollection;
    }

    public PproEstadoDocumento getDocEdocId() {
        return docEdocId;
    }

    public void setDocEdocId(PproEstadoDocumento docEdocId) {
        this.docEdocId = docEdocId;
    }

    public PproProveedor getDocProvId() {
        return docProvId;
    }

    public void setDocProvId(PproProveedor docProvId) {
        this.docProvId = docProvId;
    }

    public PproTipoDocumento getDocTdocId() {
        return docTdocId;
    }

    public void setDocTdocId(PproTipoDocumento docTdocId) {
        this.docTdocId = docTdocId;
    }

    public PproUsuario getDocUsuAutoriza() {
        return docUsuAutoriza;
    }

    public void setDocUsuAutoriza(PproUsuario docUsuAutoriza) {
        this.docUsuAutoriza = docUsuAutoriza;
    }

    public PproUsuario getDocUsuIngresa() {
        return docUsuIngresa;
    }

    public void setDocUsuIngresa(PproUsuario docUsuIngresa) {
        this.docUsuIngresa = docUsuIngresa;
    }

    public PproUsuario getDocUsuModifica() {
        return docUsuModifica;
    }

    public void setDocUsuModifica(PproUsuario docUsuModifica) {
        this.docUsuModifica = docUsuModifica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproDocumento)) {
            return false;
        }
        PproDocumento other = (PproDocumento) object;
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproDocumento[ docId=" + docId + " ]";
    }
    
}
