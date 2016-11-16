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
@Table(name = "ppro_tipo_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproTipoProveedor.findAll", query = "SELECT p FROM PproTipoProveedor p")
    , @NamedQuery(name = "PproTipoProveedor.findByTiproId", query = "SELECT p FROM PproTipoProveedor p WHERE p.tiproId = :tiproId")
    , @NamedQuery(name = "PproTipoProveedor.findByTiproNombre", query = "SELECT p FROM PproTipoProveedor p WHERE p.tiproNombre = :tiproNombre")})
public class PproTipoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipro_id")
    private Integer tiproId;
    @Size(max = 255)
    @Column(name = "tipro_nombre")
    private String tiproNombre;
    @OneToMany(mappedBy = "provTiproId")
    private Collection<PproProveedor> pproProveedorCollection;
    @OneToMany(mappedBy = "tanTiproId")
    private Collection<PproTipoAnexo> pproTipoAnexoCollection;

    public PproTipoProveedor() {
    }

    public PproTipoProveedor(Integer tiproId) {
        this.tiproId = tiproId;
    }

    public Integer getTiproId() {
        return tiproId;
    }

    public void setTiproId(Integer tiproId) {
        this.tiproId = tiproId;
    }

    public String getTiproNombre() {
        return tiproNombre;
    }

    public void setTiproNombre(String tiproNombre) {
        this.tiproNombre = tiproNombre;
    }

    @XmlTransient
    public Collection<PproProveedor> getPproProveedorCollection() {
        return pproProveedorCollection;
    }

    public void setPproProveedorCollection(Collection<PproProveedor> pproProveedorCollection) {
        this.pproProveedorCollection = pproProveedorCollection;
    }

    @XmlTransient
    public Collection<PproTipoAnexo> getPproTipoAnexoCollection() {
        return pproTipoAnexoCollection;
    }

    public void setPproTipoAnexoCollection(Collection<PproTipoAnexo> pproTipoAnexoCollection) {
        this.pproTipoAnexoCollection = pproTipoAnexoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiproId != null ? tiproId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproTipoProveedor)) {
            return false;
        }
        PproTipoProveedor other = (PproTipoProveedor) object;
        if ((this.tiproId == null && other.tiproId != null) || (this.tiproId != null && !this.tiproId.equals(other.tiproId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproTipoProveedor[ tiproId=" + tiproId + " ]";
    }
    
}
