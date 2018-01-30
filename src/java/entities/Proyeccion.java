/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "PROYECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyeccion.findAll", query = "SELECT p FROM Proyeccion p")
    , @NamedQuery(name = "Proyeccion.findByFecha", query = "SELECT p FROM Proyeccion p WHERE p.proyeccionPK.fecha = :fecha")
    , @NamedQuery(name = "Proyeccion.findByIdsesion", query = "SELECT p FROM Proyeccion p WHERE p.proyeccionPK.idsesion = :idsesion")
    , @NamedQuery(name = "Proyeccion.findByIdsala", query = "SELECT p FROM Proyeccion p WHERE p.proyeccionPK.idsala = :idsala")})
public class Proyeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyeccionPK proyeccionPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyeccion")
    private List<Taquilla> taquillaList;
    @JoinColumn(name = "IDPELICULA", referencedColumnName = "IDPELICULA")
    @ManyToOne
    private Pelicula idpelicula;
    @JoinColumn(name = "IDSALA", referencedColumnName = "IDSALA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sala sala;
    @JoinColumn(name = "IDSESION", referencedColumnName = "IDSESION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sesion sesion;

    public Proyeccion() {
    }

    public Proyeccion(ProyeccionPK proyeccionPK) {
        this.proyeccionPK = proyeccionPK;
    }

    public Proyeccion(Date fecha, short idsesion, short idsala) {
        this.proyeccionPK = new ProyeccionPK(fecha, idsesion, idsala);
    }

    public ProyeccionPK getProyeccionPK() {
        return proyeccionPK;
    }

    public void setProyeccionPK(ProyeccionPK proyeccionPK) {
        this.proyeccionPK = proyeccionPK;
    }

    @XmlTransient
    public List<Taquilla> getTaquillaList() {
        return taquillaList;
    }

    public void setTaquillaList(List<Taquilla> taquillaList) {
        this.taquillaList = taquillaList;
    }

    public Pelicula getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Pelicula idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyeccionPK != null ? proyeccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyeccion)) {
            return false;
        }
        Proyeccion other = (Proyeccion) object;
        if ((this.proyeccionPK == null && other.proyeccionPK != null) || (this.proyeccionPK != null && !this.proyeccionPK.equals(other.proyeccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Proyeccion[ proyeccionPK=" + proyeccionPK + " ]";
    }
    
}
