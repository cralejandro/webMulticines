/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TARIFA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t")
    , @NamedQuery(name = "Tarifa.findByIdtarifa", query = "SELECT t FROM Tarifa t WHERE t.idtarifa = :idtarifa")
    , @NamedQuery(name = "Tarifa.findByDescripcion", query = "SELECT t FROM Tarifa t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tarifa.findByPrecio", query = "SELECT t FROM Tarifa t WHERE t.precio = :precio")})
public class Tarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTARIFA")
    private Short idtarifa;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "PRECIO")
    private Integer precio;
    @OneToMany(mappedBy = "idtarifa")
    private List<Taquilla> taquillaList;

    public Tarifa() {
    }

    public Tarifa(Short idtarifa) {
        this.idtarifa = idtarifa;
    }

    public Short getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Short idtarifa) {
        this.idtarifa = idtarifa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Taquilla> getTaquillaList() {
        return taquillaList;
    }

    public void setTaquillaList(List<Taquilla> taquillaList) {
        this.taquillaList = taquillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarifa != null ? idtarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.idtarifa == null && other.idtarifa != null) || (this.idtarifa != null && !this.idtarifa.equals(other.idtarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tarifa[ idtarifa=" + idtarifa + " ]";
    }
    
}
