/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alejandro
 */
@Embeddable
public class ProyeccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "IDSESION")
    private short idsesion;
    @Basic(optional = false)
    @Column(name = "IDSALA")
    private short idsala;

    public ProyeccionPK() {
    }

    public ProyeccionPK(Date fecha, short idsesion, short idsala) {
        this.fecha = fecha;
        this.idsesion = idsesion;
        this.idsala = idsala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(short idsesion) {
        this.idsesion = idsesion;
    }

    public short getIdsala() {
        return idsala;
    }

    public void setIdsala(short idsala) {
        this.idsala = idsala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) idsesion;
        hash += (int) idsala;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyeccionPK)) {
            return false;
        }
        ProyeccionPK other = (ProyeccionPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.idsesion != other.idsesion) {
            return false;
        }
        if (this.idsala != other.idsala) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProyeccionPK[ fecha=" + fecha + ", idsesion=" + idsesion + ", idsala=" + idsala + " ]";
    }
    
}
