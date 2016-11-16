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
@Table(name = "ppro_tipo_anexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproTipoAnexo.findAll", query = "SELECT p FROM PproTipoAnexo p")
    , @NamedQuery(name = "PproTipoAnexo.findByTanId", query = "SELECT p FROM PproTipoAnexo p WHERE p.tanId = :tanId")
    , @NamedQuery(name = "PproTipoAnexo.findByTanNombre", query = "SELECT p FROM PproTipoAnexo p WHERE p.tanNombre = :tanNombre")
    , @NamedQuery(name = "PproTipoAnexo.findByTanEstado", query = "SELECT p FROM PproTipoAnexo p WHERE p.tanEstado = :tanEstado")})
public class PproTipoAnexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tan_id")
    private Integer tanId;
    @Size(max = 255)
    @Column(name = "tan_nombre")
    private String tanNombre;
    @Column(name = "tan_estado")
    private Integer tanEstado;
    @OneToMany(mappedBy = "aneTanId")
    private Collection<PproAnexoDocumento> pproAnexoDocumentoCollection;
    @JoinColumn(name = "tan_tipro_id", referencedColumnName = "tipro_id")
    @ManyToOne
    private PproTipoProveedor tanTiproId;

    public PproTipoAnexo() {
    }

    public PproTipoAnexo(Integer tanId) {
        this.tanId = tanId;
    }

    public Integer getTanId() {
        return tanId;
    }

    public void setTanId(Integer tanId) {
        this.tanId = tanId;
    }

    public String getTanNombre() {
        return tanNombre;
    }

    public void setTanNombre(String tanNombre) {
        this.tanNombre = tanNombre;
    }

    public Integer getTanEstado() {
        return tanEstado;
    }

    public void setTanEstado(Integer tanEstado) {
        this.tanEstado = tanEstado;
    }

    @XmlTransient
    public Collection<PproAnexoDocumento> getPproAnexoDocumentoCollection() {
        return pproAnexoDocumentoCollection;
    }

    public void setPproAnexoDocumentoCollection(Collection<PproAnexoDocumento> pproAnexoDocumentoCollection) {
        this.pproAnexoDocumentoCollection = pproAnexoDocumentoCollection;
    }

    public PproTipoProveedor getTanTiproId() {
        return tanTiproId;
    }

    public void setTanTiproId(PproTipoProveedor tanTiproId) {
        this.tanTiproId = tanTiproId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tanId != null ? tanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproTipoAnexo)) {
            return false;
        }
        PproTipoAnexo other = (PproTipoAnexo) object;
        if ((this.tanId == null && other.tanId != null) || (this.tanId != null && !this.tanId.equals(other.tanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproTipoAnexo[ tanId=" + tanId + " ]";
    }
    
}
