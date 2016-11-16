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
@Table(name = "ppro_tipo_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproTipoPersona.findAll", query = "SELECT p FROM PproTipoPersona p")
    , @NamedQuery(name = "PproTipoPersona.findByTiperId", query = "SELECT p FROM PproTipoPersona p WHERE p.tiperId = :tiperId")
    , @NamedQuery(name = "PproTipoPersona.findByTiperNombre", query = "SELECT p FROM PproTipoPersona p WHERE p.tiperNombre = :tiperNombre")
    , @NamedQuery(name = "PproTipoPersona.findByTiperEstado", query = "SELECT p FROM PproTipoPersona p WHERE p.tiperEstado = :tiperEstado")})
public class PproTipoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tiper_id")
    private Integer tiperId;
    @Size(max = 255)
    @Column(name = "tiper_nombre")
    private String tiperNombre;
    @Column(name = "tiper_estado")
    private Integer tiperEstado;
    @OneToMany(mappedBy = "perTiperId")
    private Collection<PproPersona> pproPersonaCollection;

    public PproTipoPersona() {
    }

    public PproTipoPersona(Integer tiperId) {
        this.tiperId = tiperId;
    }

    public Integer getTiperId() {
        return tiperId;
    }

    public void setTiperId(Integer tiperId) {
        this.tiperId = tiperId;
    }

    public String getTiperNombre() {
        return tiperNombre;
    }

    public void setTiperNombre(String tiperNombre) {
        this.tiperNombre = tiperNombre;
    }

    public Integer getTiperEstado() {
        return tiperEstado;
    }

    public void setTiperEstado(Integer tiperEstado) {
        this.tiperEstado = tiperEstado;
    }

    @XmlTransient
    public Collection<PproPersona> getPproPersonaCollection() {
        return pproPersonaCollection;
    }

    public void setPproPersonaCollection(Collection<PproPersona> pproPersonaCollection) {
        this.pproPersonaCollection = pproPersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiperId != null ? tiperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproTipoPersona)) {
            return false;
        }
        PproTipoPersona other = (PproTipoPersona) object;
        if ((this.tiperId == null && other.tiperId != null) || (this.tiperId != null && !this.tiperId.equals(other.tiperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproTipoPersona[ tiperId=" + tiperId + " ]";
    }
    
}
