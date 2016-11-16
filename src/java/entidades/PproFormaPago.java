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
@Table(name = "ppro_forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproFormaPago.findAll", query = "SELECT p FROM PproFormaPago p")
    , @NamedQuery(name = "PproFormaPago.findByFpagId", query = "SELECT p FROM PproFormaPago p WHERE p.fpagId = :fpagId")
    , @NamedQuery(name = "PproFormaPago.findByFpagNombre", query = "SELECT p FROM PproFormaPago p WHERE p.fpagNombre = :fpagNombre")
    , @NamedQuery(name = "PproFormaPago.findByFpagEstado", query = "SELECT p FROM PproFormaPago p WHERE p.fpagEstado = :fpagEstado")})
public class PproFormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fpag_id")
    private Integer fpagId;
    @Size(max = 255)
    @Column(name = "fpag_nombre")
    private String fpagNombre;
    @Column(name = "fpag_estado")
    private Integer fpagEstado;
    @OneToMany(mappedBy = "provFpagId")
    private Collection<PproProveedor> pproProveedorCollection;

    public PproFormaPago() {
    }

    public PproFormaPago(Integer fpagId) {
        this.fpagId = fpagId;
    }

    public Integer getFpagId() {
        return fpagId;
    }

    public void setFpagId(Integer fpagId) {
        this.fpagId = fpagId;
    }

    public String getFpagNombre() {
        return fpagNombre;
    }

    public void setFpagNombre(String fpagNombre) {
        this.fpagNombre = fpagNombre;
    }

    public Integer getFpagEstado() {
        return fpagEstado;
    }

    public void setFpagEstado(Integer fpagEstado) {
        this.fpagEstado = fpagEstado;
    }

    @XmlTransient
    public Collection<PproProveedor> getPproProveedorCollection() {
        return pproProveedorCollection;
    }

    public void setPproProveedorCollection(Collection<PproProveedor> pproProveedorCollection) {
        this.pproProveedorCollection = pproProveedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpagId != null ? fpagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproFormaPago)) {
            return false;
        }
        PproFormaPago other = (PproFormaPago) object;
        if ((this.fpagId == null && other.fpagId != null) || (this.fpagId != null && !this.fpagId.equals(other.fpagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproFormaPago[ fpagId=" + fpagId + " ]";
    }
    
}
