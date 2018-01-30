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
public class TaquillaPK implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "IDBUTACA")
    private short idbutaca;

    public TaquillaPK() {
    }

    public TaquillaPK(Date fecha, short idsesion, short idsala, short idbutaca) {
        this.fecha = fecha;
        this.idsesion = idsesion;
        this.idsala = idsala;
        this.idbutaca = idbutaca;
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

    public short getIdbutaca() {
        return idbutaca;
    }

    public void setIdbutaca(short idbutaca) {
        this.idbutaca = idbutaca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) idsesion;
        hash += (int) idsala;
        hash += (int) idbutaca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaquillaPK)) {
            return false;
        }
        TaquillaPK other = (TaquillaPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.idsesion != other.idsesion) {
            return false;
        }
        if (this.idsala != other.idsala) {
            return false;
        }
        if (this.idbutaca != other.idbutaca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TaquillaPK[ fecha=" + fecha + ", idsesion=" + idsesion + ", idsala=" + idsala + ", idbutaca=" + idbutaca + " ]";
    }
    
}
