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
@Table(name = "ppro_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproPerfil.findAll", query = "SELECT p FROM PproPerfil p")
    , @NamedQuery(name = "PproPerfil.findByPerfId", query = "SELECT p FROM PproPerfil p WHERE p.perfId = :perfId")
    , @NamedQuery(name = "PproPerfil.findByPerfNombre", query = "SELECT p FROM PproPerfil p WHERE p.perfNombre = :perfNombre")
    , @NamedQuery(name = "PproPerfil.findByPerfEstado", query = "SELECT p FROM PproPerfil p WHERE p.perfEstado = :perfEstado")})
public class PproPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perf_id")
    private Integer perfId;
    @Size(max = 255)
    @Column(name = "perf_nombre")
    private String perfNombre;
    @Column(name = "perf_estado")
    private Integer perfEstado;
    @OneToMany(mappedBy = "rmodPerfId")
    private Collection<PproModuloPerfil> pproModuloPerfilCollection;
    @OneToMany(mappedBy = "rpmPerfId")
    private Collection<PproRelPerfilMenu> pproRelPerfilMenuCollection;
    @OneToMany(mappedBy = "rupPerfId")
    private Collection<PproRelUsuarioPerfil> pproRelUsuarioPerfilCollection;

    public PproPerfil() {
    }

    public PproPerfil(Integer perfId) {
        this.perfId = perfId;
    }

    public Integer getPerfId() {
        return perfId;
    }

    public void setPerfId(Integer perfId) {
        this.perfId = perfId;
    }

    public String getPerfNombre() {
        return perfNombre;
    }

    public void setPerfNombre(String perfNombre) {
        this.perfNombre = perfNombre;
    }

    public Integer getPerfEstado() {
        return perfEstado;
    }

    public void setPerfEstado(Integer perfEstado) {
        this.perfEstado = perfEstado;
    }

    @XmlTransient
    public Collection<PproModuloPerfil> getPproModuloPerfilCollection() {
        return pproModuloPerfilCollection;
    }

    public void setPproModuloPerfilCollection(Collection<PproModuloPerfil> pproModuloPerfilCollection) {
        this.pproModuloPerfilCollection = pproModuloPerfilCollection;
    }

    @XmlTransient
    public Collection<PproRelPerfilMenu> getPproRelPerfilMenuCollection() {
        return pproRelPerfilMenuCollection;
    }

    public void setPproRelPerfilMenuCollection(Collection<PproRelPerfilMenu> pproRelPerfilMenuCollection) {
        this.pproRelPerfilMenuCollection = pproRelPerfilMenuCollection;
    }

    @XmlTransient
    public Collection<PproRelUsuarioPerfil> getPproRelUsuarioPerfilCollection() {
        return pproRelUsuarioPerfilCollection;
    }

    public void setPproRelUsuarioPerfilCollection(Collection<PproRelUsuarioPerfil> pproRelUsuarioPerfilCollection) {
        this.pproRelUsuarioPerfilCollection = pproRelUsuarioPerfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfId != null ? perfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproPerfil)) {
            return false;
        }
        PproPerfil other = (PproPerfil) object;
        if ((this.perfId == null && other.perfId != null) || (this.perfId != null && !this.perfId.equals(other.perfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproPerfil[ perfId=" + perfId + " ]";
    }
    
}
