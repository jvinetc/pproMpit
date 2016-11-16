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
@Table(name = "ppro_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproProveedor.findAll", query = "SELECT p FROM PproProveedor p")
    , @NamedQuery(name = "PproProveedor.findByProvId", query = "SELECT p FROM PproProveedor p WHERE p.provId = :provId")
    , @NamedQuery(name = "PproProveedor.findByProvRazonSocial", query = "SELECT p FROM PproProveedor p WHERE p.provRazonSocial = :provRazonSocial")
    , @NamedQuery(name = "PproProveedor.findByProvEstado", query = "SELECT p FROM PproProveedor p WHERE p.provEstado = :provEstado")})
public class PproProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prov_id")
    private Integer provId;
    @Size(max = 255)
    @Column(name = "prov_razon_social")
    private String provRazonSocial;
    @Column(name = "prov_estado")
    private Integer provEstado;
    @OneToMany(mappedBy = "docProvId")
    private Collection<PproDocumento> pproDocumentoCollection;
    @OneToMany(mappedBy = "repProvId")
    private Collection<PproRelEntidadProveedor> pproRelEntidadProveedorCollection;
    @JoinColumn(name = "prov_fpag_id", referencedColumnName = "fpag_id")
    @ManyToOne
    private PproFormaPago provFpagId;
    @JoinColumn(name = "prov_per_id", referencedColumnName = "per_id")
    @ManyToOne
    private PproPersona provPerId;
    @JoinColumn(name = "prov_tipro_id", referencedColumnName = "tipro_id")
    @ManyToOne
    private PproTipoProveedor provTiproId;

    public PproProveedor() {
    }

    public PproProveedor(Integer provId) {
        this.provId = provId;
    }

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    public String getProvRazonSocial() {
        return provRazonSocial;
    }

    public void setProvRazonSocial(String provRazonSocial) {
        this.provRazonSocial = provRazonSocial;
    }

    public Integer getProvEstado() {
        return provEstado;
    }

    public void setProvEstado(Integer provEstado) {
        this.provEstado = provEstado;
    }

    @XmlTransient
    public Collection<PproDocumento> getPproDocumentoCollection() {
        return pproDocumentoCollection;
    }

    public void setPproDocumentoCollection(Collection<PproDocumento> pproDocumentoCollection) {
        this.pproDocumentoCollection = pproDocumentoCollection;
    }

    @XmlTransient
    public Collection<PproRelEntidadProveedor> getPproRelEntidadProveedorCollection() {
        return pproRelEntidadProveedorCollection;
    }

    public void setPproRelEntidadProveedorCollection(Collection<PproRelEntidadProveedor> pproRelEntidadProveedorCollection) {
        this.pproRelEntidadProveedorCollection = pproRelEntidadProveedorCollection;
    }

    public PproFormaPago getProvFpagId() {
        return provFpagId;
    }

    public void setProvFpagId(PproFormaPago provFpagId) {
        this.provFpagId = provFpagId;
    }

    public PproPersona getProvPerId() {
        return provPerId;
    }

    public void setProvPerId(PproPersona provPerId) {
        this.provPerId = provPerId;
    }

    public PproTipoProveedor getProvTiproId() {
        return provTiproId;
    }

    public void setProvTiproId(PproTipoProveedor provTiproId) {
        this.provTiproId = provTiproId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproProveedor)) {
            return false;
        }
        PproProveedor other = (PproProveedor) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproProveedor[ provId=" + provId + " ]";
    }
    
}
