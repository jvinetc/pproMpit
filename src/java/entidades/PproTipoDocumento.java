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
@Table(name = "ppro_tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproTipoDocumento.findAll", query = "SELECT p FROM PproTipoDocumento p")
    , @NamedQuery(name = "PproTipoDocumento.findByTdocId", query = "SELECT p FROM PproTipoDocumento p WHERE p.tdocId = :tdocId")
    , @NamedQuery(name = "PproTipoDocumento.findByTdocNombre", query = "SELECT p FROM PproTipoDocumento p WHERE p.tdocNombre = :tdocNombre")
    , @NamedQuery(name = "PproTipoDocumento.findByTdocEstado", query = "SELECT p FROM PproTipoDocumento p WHERE p.tdocEstado = :tdocEstado")})
public class PproTipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tdoc_id")
    private Integer tdocId;
    @Size(max = 255)
    @Column(name = "tdoc_nombre")
    private String tdocNombre;
    @Size(max = 255)
    @Column(name = "tdoc_estado")
    private String tdocEstado;
    @OneToMany(mappedBy = "docTdocId")
    private Collection<PproDocumento> pproDocumentoCollection;

    public PproTipoDocumento() {
    }

    public PproTipoDocumento(Integer tdocId) {
        this.tdocId = tdocId;
    }

    public Integer getTdocId() {
        return tdocId;
    }

    public void setTdocId(Integer tdocId) {
        this.tdocId = tdocId;
    }

    public String getTdocNombre() {
        return tdocNombre;
    }

    public void setTdocNombre(String tdocNombre) {
        this.tdocNombre = tdocNombre;
    }

    public String getTdocEstado() {
        return tdocEstado;
    }

    public void setTdocEstado(String tdocEstado) {
        this.tdocEstado = tdocEstado;
    }

    @XmlTransient
    public Collection<PproDocumento> getPproDocumentoCollection() {
        return pproDocumentoCollection;
    }

    public void setPproDocumentoCollection(Collection<PproDocumento> pproDocumentoCollection) {
        this.pproDocumentoCollection = pproDocumentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tdocId != null ? tdocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproTipoDocumento)) {
            return false;
        }
        PproTipoDocumento other = (PproTipoDocumento) object;
        if ((this.tdocId == null && other.tdocId != null) || (this.tdocId != null && !this.tdocId.equals(other.tdocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproTipoDocumento[ tdocId=" + tdocId + " ]";
    }
    
}
