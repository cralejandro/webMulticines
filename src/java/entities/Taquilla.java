/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "TAQUILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taquilla.findAll", query = "SELECT t FROM Taquilla t")
    , @NamedQuery(name = "Taquilla.findByFecha", query = "SELECT t FROM Taquilla t WHERE t.taquillaPK.fecha = :fecha")
    , @NamedQuery(name = "Taquilla.findByIdsesion", query = "SELECT t FROM Taquilla t WHERE t.taquillaPK.idsesion = :idsesion")
    , @NamedQuery(name = "Taquilla.findByIdsala", query = "SELECT t FROM Taquilla t WHERE t.taquillaPK.idsala = :idsala")
    , @NamedQuery(name = "Taquilla.findByIdbutaca", query = "SELECT t FROM Taquilla t WHERE t.taquillaPK.idbutaca = :idbutaca")})
public class Taquilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaquillaPK taquillaPK;
    @JoinColumns({
        @JoinColumn(name = "IDBUTACA", referencedColumnName = "IDBUTACA", insertable = false, updatable = false)
        , @JoinColumn(name = "IDSALA", referencedColumnName = "IDSALA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Butaca butaca;
    @JoinColumns({
        @JoinColumn(name = "FECHA", referencedColumnName = "FECHA", insertable = false, updatable = false)
        , @JoinColumn(name = "IDSESION", referencedColumnName = "IDSESION", insertable = false, updatable = false)
        , @JoinColumn(name = "IDSALA", referencedColumnName = "IDSALA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Proyeccion proyeccion;
    @JoinColumn(name = "IDTARIFA", referencedColumnName = "IDTARIFA")
    @ManyToOne
    private Tarifa idtarifa;

    public Taquilla() {
    }

    public Taquilla(TaquillaPK taquillaPK) {
        this.taquillaPK = taquillaPK;
    }

    public Taquilla(Date fecha, short idsesion, short idsala, short idbutaca) {
        this.taquillaPK = new TaquillaPK(fecha, idsesion, idsala, idbutaca);
    }

    public TaquillaPK getTaquillaPK() {
        return taquillaPK;
    }

    public void setTaquillaPK(TaquillaPK taquillaPK) {
        this.taquillaPK = taquillaPK;
    }

    public Butaca getButaca() {
        return butaca;
    }

    public void setButaca(Butaca butaca) {
        this.butaca = butaca;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public Tarifa getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Tarifa idtarifa) {
        this.idtarifa = idtarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taquillaPK != null ? taquillaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taquilla)) {
            return false;
        }
        Taquilla other = (Taquilla) object;
        if ((this.taquillaPK == null && other.taquillaPK != null) || (this.taquillaPK != null && !this.taquillaPK.equals(other.taquillaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Taquilla[ taquillaPK=" + taquillaPK + " ]";
    }
    
}
