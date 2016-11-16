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
@Table(name = "ppro_entidad_financiera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproEntidadFinanciera.findAll", query = "SELECT p FROM PproEntidadFinanciera p")
    , @NamedQuery(name = "PproEntidadFinanciera.findByEntFinId", query = "SELECT p FROM PproEntidadFinanciera p WHERE p.entFinId = :entFinId")
    , @NamedQuery(name = "PproEntidadFinanciera.findByEntFinNombre", query = "SELECT p FROM PproEntidadFinanciera p WHERE p.entFinNombre = :entFinNombre")
    , @NamedQuery(name = "PproEntidadFinanciera.findByEntFinCodigo", query = "SELECT p FROM PproEntidadFinanciera p WHERE p.entFinCodigo = :entFinCodigo")
    , @NamedQuery(name = "PproEntidadFinanciera.findByEntFinEstado", query = "SELECT p FROM PproEntidadFinanciera p WHERE p.entFinEstado = :entFinEstado")})
public class PproEntidadFinanciera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ent_fin_id")
    private Integer entFinId;
    @Size(max = 255)
    @Column(name = "ent_fin_nombre")
    private String entFinNombre;
    @Size(max = 255)
    @Column(name = "ent_fin_codigo")
    private String entFinCodigo;
    @Column(name = "ent_fin_estado")
    private Integer entFinEstado;
    @OneToMany(mappedBy = "repEntFinId")
    private Collection<PproRelEntidadProveedor> pproRelEntidadProveedorCollection;

    public PproEntidadFinanciera() {
    }

    public PproEntidadFinanciera(Integer entFinId) {
        this.entFinId = entFinId;
    }

    public Integer getEntFinId() {
        return entFinId;
    }

    public void setEntFinId(Integer entFinId) {
        this.entFinId = entFinId;
    }

    public String getEntFinNombre() {
        return entFinNombre;
    }

    public void setEntFinNombre(String entFinNombre) {
        this.entFinNombre = entFinNombre;
    }

    public String getEntFinCodigo() {
        return entFinCodigo;
    }

    public void setEntFinCodigo(String entFinCodigo) {
        this.entFinCodigo = entFinCodigo;
    }

    public Integer getEntFinEstado() {
        return entFinEstado;
    }

    public void setEntFinEstado(Integer entFinEstado) {
        this.entFinEstado = entFinEstado;
    }

    @XmlTransient
    public Collection<PproRelEntidadProveedor> getPproRelEntidadProveedorCollection() {
        return pproRelEntidadProveedorCollection;
    }

    public void setPproRelEntidadProveedorCollection(Collection<PproRelEntidadProveedor> pproRelEntidadProveedorCollection) {
        this.pproRelEntidadProveedorCollection = pproRelEntidadProveedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entFinId != null ? entFinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproEntidadFinanciera)) {
            return false;
        }
        PproEntidadFinanciera other = (PproEntidadFinanciera) object;
        if ((this.entFinId == null && other.entFinId != null) || (this.entFinId != null && !this.entFinId.equals(other.entFinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproEntidadFinanciera[ entFinId=" + entFinId + " ]";
    }
    
}
