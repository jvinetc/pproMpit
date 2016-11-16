/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Natalia
 */
@Entity
@Table(name = "ppro_rel_entidad_proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproRelEntidadProveedor.findAll", query = "SELECT p FROM PproRelEntidadProveedor p")
    , @NamedQuery(name = "PproRelEntidadProveedor.findByRepId", query = "SELECT p FROM PproRelEntidadProveedor p WHERE p.repId = :repId")
    , @NamedQuery(name = "PproRelEntidadProveedor.findByRepEstado", query = "SELECT p FROM PproRelEntidadProveedor p WHERE p.repEstado = :repEstado")})
public class PproRelEntidadProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rep_id")
    private Integer repId;
    @Column(name = "rep_estado")
    private Integer repEstado;
    @JoinColumn(name = "rep_ent_fin_id", referencedColumnName = "ent_fin_id")
    @ManyToOne
    private PproEntidadFinanciera repEntFinId;
    @JoinColumn(name = "rep_prov_id", referencedColumnName = "prov_id")
    @ManyToOne
    private PproProveedor repProvId;

    public PproRelEntidadProveedor() {
    }

    public PproRelEntidadProveedor(Integer repId) {
        this.repId = repId;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public Integer getRepEstado() {
        return repEstado;
    }

    public void setRepEstado(Integer repEstado) {
        this.repEstado = repEstado;
    }

    public PproEntidadFinanciera getRepEntFinId() {
        return repEntFinId;
    }

    public void setRepEntFinId(PproEntidadFinanciera repEntFinId) {
        this.repEntFinId = repEntFinId;
    }

    public PproProveedor getRepProvId() {
        return repProvId;
    }

    public void setRepProvId(PproProveedor repProvId) {
        this.repProvId = repProvId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repId != null ? repId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproRelEntidadProveedor)) {
            return false;
        }
        PproRelEntidadProveedor other = (PproRelEntidadProveedor) object;
        if ((this.repId == null && other.repId != null) || (this.repId != null && !this.repId.equals(other.repId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproRelEntidadProveedor[ repId=" + repId + " ]";
    }
    
}
