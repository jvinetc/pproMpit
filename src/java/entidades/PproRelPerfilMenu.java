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
@Table(name = "ppro_rel_perfil_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproRelPerfilMenu.findAll", query = "SELECT p FROM PproRelPerfilMenu p")
    , @NamedQuery(name = "PproRelPerfilMenu.findByRpmId", query = "SELECT p FROM PproRelPerfilMenu p WHERE p.rpmId = :rpmId")
    , @NamedQuery(name = "PproRelPerfilMenu.findByRpmEstado", query = "SELECT p FROM PproRelPerfilMenu p WHERE p.rpmEstado = :rpmEstado")})
public class PproRelPerfilMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rpm_id")
    private Integer rpmId;
    @Column(name = "rpm_estado")
    private Integer rpmEstado;
    @JoinColumn(name = "rpm_men_id", referencedColumnName = "men_id")
    @ManyToOne
    private PproMenu rpmMenId;
    @JoinColumn(name = "rpm_perf_id", referencedColumnName = "perf_id")
    @ManyToOne
    private PproPerfil rpmPerfId;

    public PproRelPerfilMenu() {
    }

    public PproRelPerfilMenu(Integer rpmId) {
        this.rpmId = rpmId;
    }

    public Integer getRpmId() {
        return rpmId;
    }

    public void setRpmId(Integer rpmId) {
        this.rpmId = rpmId;
    }

    public Integer getRpmEstado() {
        return rpmEstado;
    }

    public void setRpmEstado(Integer rpmEstado) {
        this.rpmEstado = rpmEstado;
    }

    public PproMenu getRpmMenId() {
        return rpmMenId;
    }

    public void setRpmMenId(PproMenu rpmMenId) {
        this.rpmMenId = rpmMenId;
    }

    public PproPerfil getRpmPerfId() {
        return rpmPerfId;
    }

    public void setRpmPerfId(PproPerfil rpmPerfId) {
        this.rpmPerfId = rpmPerfId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rpmId != null ? rpmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproRelPerfilMenu)) {
            return false;
        }
        PproRelPerfilMenu other = (PproRelPerfilMenu) object;
        if ((this.rpmId == null && other.rpmId != null) || (this.rpmId != null && !this.rpmId.equals(other.rpmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproRelPerfilMenu[ rpmId=" + rpmId + " ]";
    }
    
}
