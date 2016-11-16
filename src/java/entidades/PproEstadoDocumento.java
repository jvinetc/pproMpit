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
@Table(name = "ppro_estado_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproEstadoDocumento.findAll", query = "SELECT p FROM PproEstadoDocumento p")
    , @NamedQuery(name = "PproEstadoDocumento.findByEdocId", query = "SELECT p FROM PproEstadoDocumento p WHERE p.edocId = :edocId")
    , @NamedQuery(name = "PproEstadoDocumento.findByEdocNombre", query = "SELECT p FROM PproEstadoDocumento p WHERE p.edocNombre = :edocNombre")})
public class PproEstadoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "edoc_id")
    private Integer edocId;
    @Size(max = 255)
    @Column(name = "edoc_nombre")
    private String edocNombre;
    @OneToMany(mappedBy = "docEdocId")
    private Collection<PproDocumento> pproDocumentoCollection;

    public PproEstadoDocumento() {
    }

    public PproEstadoDocumento(Integer edocId) {
        this.edocId = edocId;
    }

    public Integer getEdocId() {
        return edocId;
    }

    public void setEdocId(Integer edocId) {
        this.edocId = edocId;
    }

    public String getEdocNombre() {
        return edocNombre;
    }

    public void setEdocNombre(String edocNombre) {
        this.edocNombre = edocNombre;
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
        hash += (edocId != null ? edocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproEstadoDocumento)) {
            return false;
        }
        PproEstadoDocumento other = (PproEstadoDocumento) object;
        if ((this.edocId == null && other.edocId != null) || (this.edocId != null && !this.edocId.equals(other.edocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproEstadoDocumento[ edocId=" + edocId + " ]";
    }
    
}
