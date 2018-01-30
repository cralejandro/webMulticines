/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SESION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s")
    , @NamedQuery(name = "Sesion.findByIdsesion", query = "SELECT s FROM Sesion s WHERE s.idsesion = :idsesion")
    , @NamedQuery(name = "Sesion.findByHora", query = "SELECT s FROM Sesion s WHERE s.hora = :hora")})
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDSESION")
    private Short idsesion;
    @Column(name = "HORA")
    private String hora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sesion")
    private List<Proyeccion> proyeccionList;

    public Sesion() {
    }

    public Sesion(Short idsesion) {
        this.idsesion = idsesion;
    }

    public Short getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(Short idsesion) {
        this.idsesion = idsesion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @XmlTransient
    public List<Proyeccion> getProyeccionList() {
        return proyeccionList;
    }

    public void setProyeccionList(List<Proyeccion> proyeccionList) {
        this.proyeccionList = proyeccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsesion != null ? idsesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.idsesion == null && other.idsesion != null) || (this.idsesion != null && !this.idsesion.equals(other.idsesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sesion[ idsesion=" + idsesion + " ]";
    }
    
}
