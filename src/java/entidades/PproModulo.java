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
@Table(name = "ppro_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproModulo.findAll", query = "SELECT p FROM PproModulo p")
    , @NamedQuery(name = "PproModulo.findByModId", query = "SELECT p FROM PproModulo p WHERE p.modId = :modId")
    , @NamedQuery(name = "PproModulo.findByModNombre", query = "SELECT p FROM PproModulo p WHERE p.modNombre = :modNombre")
    , @NamedQuery(name = "PproModulo.findByModEstado", query = "SELECT p FROM PproModulo p WHERE p.modEstado = :modEstado")})
public class PproModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mod_id")
    private Integer modId;
    @Size(max = 255)
    @Column(name = "mod_nombre")
    private String modNombre;
    @Column(name = "mod_estado")
    private Integer modEstado;
    @OneToMany(mappedBy = "rmodModId")
    private Collection<PproModuloPerfil> pproModuloPerfilCollection;

    public PproModulo() {
    }

    public PproModulo(Integer modId) {
        this.modId = modId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String getModNombre() {
        return modNombre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }

    public Integer getModEstado() {
        return modEstado;
    }

    public void setModEstado(Integer modEstado) {
        this.modEstado = modEstado;
    }

    @XmlTransient
    public Collection<PproModuloPerfil> getPproModuloPerfilCollection() {
        return pproModuloPerfilCollection;
    }

    public void setPproModuloPerfilCollection(Collection<PproModuloPerfil> pproModuloPerfilCollection) {
        this.pproModuloPerfilCollection = pproModuloPerfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproModulo)) {
            return false;
        }
        PproModulo other = (PproModulo) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproModulo[ modId=" + modId + " ]";
    }
    
}
