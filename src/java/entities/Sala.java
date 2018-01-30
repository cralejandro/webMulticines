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
@Table(name = "SALA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s")
    , @NamedQuery(name = "Sala.findByIdsala", query = "SELECT s FROM Sala s WHERE s.idsala = :idsala")
    , @NamedQuery(name = "Sala.findByDescripcion", query = "SELECT s FROM Sala s WHERE s.descripcion = :descripcion")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDSALA")
    private Short idsala;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
    private List<Butaca> butacaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
    private List<Proyeccion> proyeccionList;

    public Sala() {
    }

    public Sala(Short idsala) {
        this.idsala = idsala;
    }

    public Short getIdsala() {
        return idsala;
    }

    public void setIdsala(Short idsala) {
        this.idsala = idsala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Butaca> getButacaList() {
        return butacaList;
    }

    public void setButacaList(List<Butaca> butacaList) {
        this.butacaList = butacaList;
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
        hash += (idsala != null ? idsala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.idsala == null && other.idsala != null) || (this.idsala != null && !this.idsala.equals(other.idsala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sala[ idsala=" + idsala + " ]";
    }
    
}
