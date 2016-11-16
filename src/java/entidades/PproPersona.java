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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Natalia
 */
@Entity
@Table(name = "ppro_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproPersona.findAll", query = "SELECT p FROM PproPersona p")
    , @NamedQuery(name = "PproPersona.findByPerId", query = "SELECT p FROM PproPersona p WHERE p.perId = :perId")
    , @NamedQuery(name = "PproPersona.findByPerRut", query = "SELECT p FROM PproPersona p WHERE p.perRut = :perRut")
    , @NamedQuery(name = "PproPersona.findByPerDigito", query = "SELECT p FROM PproPersona p WHERE p.perDigito = :perDigito")
    , @NamedQuery(name = "PproPersona.findByPerRutComp", query = "SELECT p FROM PproPersona p WHERE p.perRutComp = :perRutComp")
    , @NamedQuery(name = "PproPersona.findByPerNombre", query = "SELECT p FROM PproPersona p WHERE p.perNombre = :perNombre")
    , @NamedQuery(name = "PproPersona.findByPerApePaterno", query = "SELECT p FROM PproPersona p WHERE p.perApePaterno = :perApePaterno")
    , @NamedQuery(name = "PproPersona.findByPerApeMaterno", query = "SELECT p FROM PproPersona p WHERE p.perApeMaterno = :perApeMaterno")
    , @NamedQuery(name = "PproPersona.findByPerDireccion", query = "SELECT p FROM PproPersona p WHERE p.perDireccion = :perDireccion")
    , @NamedQuery(name = "PproPersona.findByPerTelefono", query = "SELECT p FROM PproPersona p WHERE p.perTelefono = :perTelefono")})
public class PproPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_id")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_rut")
    private int perRut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "per_digito")
    private String perDigito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "per_rut_comp")
    private String perRutComp;
    @Size(max = 255)
    @Column(name = "per_nombre")
    private String perNombre;
    @Size(max = 255)
    @Column(name = "per_ape_paterno")
    private String perApePaterno;
    @Size(max = 255)
    @Column(name = "per_ape_materno")
    private String perApeMaterno;
    @Size(max = 255)
    @Column(name = "per_direccion")
    private String perDireccion;
    @Size(max = 255)
    @Column(name = "per_telefono")
    private String perTelefono;
    @OneToMany(mappedBy = "usuPerId")
    private Collection<PproUsuario> pproUsuarioCollection;
    @JoinColumn(name = "per_tiper_id", referencedColumnName = "tiper_id")
    @ManyToOne
    private PproTipoPersona perTiperId;
    @OneToMany(mappedBy = "provPerId")
    private Collection<PproProveedor> pproProveedorCollection;

    public PproPersona() {
    }

    public PproPersona(Integer perId) {
        this.perId = perId;
    }

    public PproPersona(Integer perId, int perRut, String perDigito, String perRutComp) {
        this.perId = perId;
        this.perRut = perRut;
        this.perDigito = perDigito;
        this.perRutComp = perRutComp;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public int getPerRut() {
        return perRut;
    }

    public void setPerRut(int perRut) {
        this.perRut = perRut;
    }

    public String getPerDigito() {
        return perDigito;
    }

    public void setPerDigito(String perDigito) {
        this.perDigito = perDigito;
    }

    public String getPerRutComp() {
        return perRutComp;
    }

    public void setPerRutComp(String perRutComp) {
        this.perRutComp = perRutComp;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApePaterno() {
        return perApePaterno;
    }

    public void setPerApePaterno(String perApePaterno) {
        this.perApePaterno = perApePaterno;
    }

    public String getPerApeMaterno() {
        return perApeMaterno;
    }

    public void setPerApeMaterno(String perApeMaterno) {
        this.perApeMaterno = perApeMaterno;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    @XmlTransient
    public Collection<PproUsuario> getPproUsuarioCollection() {
        return pproUsuarioCollection;
    }

    public void setPproUsuarioCollection(Collection<PproUsuario> pproUsuarioCollection) {
        this.pproUsuarioCollection = pproUsuarioCollection;
    }

    public PproTipoPersona getPerTiperId() {
        return perTiperId;
    }

    public void setPerTiperId(PproTipoPersona perTiperId) {
        this.perTiperId = perTiperId;
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
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproPersona)) {
            return false;
        }
        PproPersona other = (PproPersona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproPersona[ perId=" + perId + " ]";
    }
    
}
