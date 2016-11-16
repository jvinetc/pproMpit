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
@Table(name = "ppro_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproMenu.findAll", query = "SELECT p FROM PproMenu p")
    , @NamedQuery(name = "PproMenu.findByMenId", query = "SELECT p FROM PproMenu p WHERE p.menId = :menId")
    , @NamedQuery(name = "PproMenu.findByMenNombre", query = "SELECT p FROM PproMenu p WHERE p.menNombre = :menNombre")
    , @NamedQuery(name = "PproMenu.findByMenEstado", query = "SELECT p FROM PproMenu p WHERE p.menEstado = :menEstado")
    , @NamedQuery(name = "PproMenu.findByMenRuta", query = "SELECT p FROM PproMenu p WHERE p.menRuta = :menRuta")})
public class PproMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "men_id")
    private Integer menId;
    @Size(max = 255)
    @Column(name = "men_nombre")
    private String menNombre;
    @Column(name = "men_estado")
    private Integer menEstado;
    @Size(max = 255)
    @Column(name = "men_ruta")
    private String menRuta;
    @OneToMany(mappedBy = "rpmMenId")
    private Collection<PproRelPerfilMenu> pproRelPerfilMenuCollection;

    public PproMenu() {
    }

    public PproMenu(Integer menId) {
        this.menId = menId;
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenNombre() {
        return menNombre;
    }

    public void setMenNombre(String menNombre) {
        this.menNombre = menNombre;
    }

    public Integer getMenEstado() {
        return menEstado;
    }

    public void setMenEstado(Integer menEstado) {
        this.menEstado = menEstado;
    }

    public String getMenRuta() {
        return menRuta;
    }

    public void setMenRuta(String menRuta) {
        this.menRuta = menRuta;
    }

    @XmlTransient
    public Collection<PproRelPerfilMenu> getPproRelPerfilMenuCollection() {
        return pproRelPerfilMenuCollection;
    }

    public void setPproRelPerfilMenuCollection(Collection<PproRelPerfilMenu> pproRelPerfilMenuCollection) {
        this.pproRelPerfilMenuCollection = pproRelPerfilMenuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menId != null ? menId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproMenu)) {
            return false;
        }
        PproMenu other = (PproMenu) object;
        if ((this.menId == null && other.menId != null) || (this.menId != null && !this.menId.equals(other.menId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproMenu[ menId=" + menId + " ]";
    }
    
}
