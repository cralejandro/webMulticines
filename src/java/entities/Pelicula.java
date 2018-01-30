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
@Table(name = "PELICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findByIdpelicula", query = "SELECT p FROM Pelicula p WHERE p.idpelicula = :idpelicula")
    , @NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Pelicula.findByAnio", query = "SELECT p FROM Pelicula p WHERE p.anio = :anio")
    , @NamedQuery(name = "Pelicula.findByDirector", query = "SELECT p FROM Pelicula p WHERE p.director = :director")
    , @NamedQuery(name = "Pelicula.findByTrama", query = "SELECT p FROM Pelicula p WHERE p.trama = :trama")
    , @NamedQuery(name = "Pelicula.findByPoster", query = "SELECT p FROM Pelicula p WHERE p.poster = :poster")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPELICULA")
    private Short idpelicula;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ANIO")
    private Short anio;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "TRAMA")
    private String trama;
    @Column(name = "POSTER")
    private String poster;
    @OneToMany(mappedBy = "idpelicula")
    private List<Rating> ratingList;
    @OneToMany(mappedBy = "idpelicula")
    private List<Proyeccion> proyeccionList;

    public Pelicula() {
    }

    public Pelicula(Short idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Short getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Short idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @XmlTransient
    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
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
        hash += (idpelicula != null ? idpelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.idpelicula == null && other.idpelicula != null) || (this.idpelicula != null && !this.idpelicula.equals(other.idpelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pelicula[ idpelicula=" + idpelicula + " ]";
    }
    
}
