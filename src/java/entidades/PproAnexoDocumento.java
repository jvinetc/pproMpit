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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Natalia
 */
@Entity
@Table(name = "ppro_anexo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PproAnexoDocumento.findAll", query = "SELECT p FROM PproAnexoDocumento p")
    , @NamedQuery(name = "PproAnexoDocumento.findByAneId", query = "SELECT p FROM PproAnexoDocumento p WHERE p.aneId = :aneId")
    , @NamedQuery(name = "PproAnexoDocumento.findByAneRuta", query = "SELECT p FROM PproAnexoDocumento p WHERE p.aneRuta = :aneRuta")
    , @NamedQuery(name = "PproAnexoDocumento.findByAneNota", query = "SELECT p FROM PproAnexoDocumento p WHERE p.aneNota = :aneNota")})
public class PproAnexoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ane_id")
    private Integer aneId;
    @Size(max = 255)
    @Column(name = "ane_ruta")
    private String aneRuta;
    @Size(max = 255)
    @Column(name = "ane_nota")
    private String aneNota;
    @JoinColumn(name = "ane_doc_id", referencedColumnName = "doc_id")
    @ManyToOne
    private PproDocumento aneDocId;
    @JoinColumn(name = "ane_tan_id", referencedColumnName = "tan_id")
    @ManyToOne
    private PproTipoAnexo aneTanId;

    public PproAnexoDocumento() {
    }

    public PproAnexoDocumento(Integer aneId) {
        this.aneId = aneId;
    }

    public Integer getAneId() {
        return aneId;
    }

    public void setAneId(Integer aneId) {
        this.aneId = aneId;
    }

    public String getAneRuta() {
        return aneRuta;
    }

    public void setAneRuta(String aneRuta) {
        this.aneRuta = aneRuta;
    }

    public String getAneNota() {
        return aneNota;
    }

    public void setAneNota(String aneNota) {
        this.aneNota = aneNota;
    }

    public PproDocumento getAneDocId() {
        return aneDocId;
    }

    public void setAneDocId(PproDocumento aneDocId) {
        this.aneDocId = aneDocId;
    }

    public PproTipoAnexo getAneTanId() {
        return aneTanId;
    }

    public void setAneTanId(PproTipoAnexo aneTanId) {
        this.aneTanId = aneTanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aneId != null ? aneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PproAnexoDocumento)) {
            return false;
        }
        PproAnexoDocumento other = (PproAnexoDocumento) object;
        if ((this.aneId == null && other.aneId != null) || (this.aneId != null && !this.aneId.equals(other.aneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PproAnexoDocumento[ aneId=" + aneId + " ]";
    }
    
}
