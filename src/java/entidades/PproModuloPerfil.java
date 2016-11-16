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
@Table(name = "ppro_modulo_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproModuloPerfil.findAll", query = "SELECT p FROM PproModuloPerfil p")
    , @NamedQuery(name = "PproModuloPerfil.findByRmodId", query = "SELECT p FROM PproModuloPerfil p WHERE p.rmodId = :rmodId")
    , @NamedQuery(name = "PproModuloPerfil.findByRmodEstado", query = "SELECT p FROM PproModuloPerfil p WHERE p.rmodEstado = :rmodEstado")})
public class PproModuloPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rmod_id")
    private Integer rmodId;
    @Column(name = "rmod_estado")
    private Integer rmodEstado;
    @JoinColumn(name = "rmod_mod_id", referencedColumnName = "mod_id")
    @ManyToOne
    private PproModulo rmodModId;
    @JoinColumn(name = "rmod_perf_id", referencedColumnName = "perf_id")
    @ManyToOne
    private PproPerfil rmodPerfId;

    public PproModuloPerfil() {
    }

    public PproModuloPerfil(Integer rmodId) {
        this.rmodId = rmodId;
    }

    public Integer getRmodId() {
        return rmodId;
    }

    public void setRmodId(Integer rmodId) {
        this.rmodId = rmodId;
    }

    public Integer getRmodEstado() {
        return rmodEstado;
    }

    public void setRmodEstado(Integer rmodEstado) {
        this.rmodEstado = rmodEstado;
    }

    public PproModulo getRmodModId() {
        return rmodModId;
    }

    public void setRmodModId(PproModulo rmodModId) {
        this.rmodModId = rmodModId;
    }

    public PproPerfil getRmodPerfId() {
        return rmodPerfId;
    }

    public void setRmodPerfId(PproPerfil rmodPerfId) {
        this.rmodPerfId = rmodPerfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmodId != null ? rmodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproModuloPerfil)) {
            return false;
        }
        PproModuloPerfil other = (PproModuloPerfil) object;
        if ((this.rmodId == null && other.rmodId != null) || (this.rmodId != null && !this.rmodId.equals(other.rmodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproModuloPerfil[ rmodId=" + rmodId + " ]";
    }
    
}
