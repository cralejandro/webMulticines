/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "BUTACA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Butaca.findAll", query = "SELECT b FROM Butaca b")
    , @NamedQuery(name = "Butaca.findByIdbutaca", query = "SELECT b FROM Butaca b WHERE b.butacaPK.idbutaca = :idbutaca")
    , @NamedQuery(name = "Butaca.findByIdsala", query = "SELECT b FROM Butaca b WHERE b.butacaPK.idsala = :idsala")
    , @NamedQuery(name = "Butaca.findByFila", query = "SELECT b FROM Butaca b WHERE b.fila = :fila")
    , @NamedQuery(name = "Butaca.findByAsiento", query = "SELECT b FROM Butaca b WHERE b.asiento = :asiento")})
public class Butaca implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ButacaPK butacaPK;
    @Column(name = "FILA")
    private Short fila;
    @Column(name = "ASIENTO")
    private Short asiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "butaca")
    private List<Taquilla> taquillaList;
    @JoinColumn(name = "IDSALA", referencedColumnName = "IDSALA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sala sala;

    public Butaca() {
    }

    public Butaca(ButacaPK butacaPK) {
        this.butacaPK = butacaPK;
    }

    public Butaca(short idbutaca, short idsala) {
        this.butacaPK = new ButacaPK(idbutaca, idsala);
    }

    public ButacaPK getButacaPK() {
        return butacaPK;
    }

    public void setButacaPK(ButacaPK butacaPK) {
        this.butacaPK = butacaPK;
    }

    public Short getFila() {
        return fila;
    }

    public void setFila(Short fila) {
        this.fila = fila;
    }

    public Short getAsiento() {
        return asiento;
    }

    public void setAsiento(Short asiento) {
        this.asiento = asiento;
    }

    @XmlTransient
    public List<Taquilla> getTaquillaList() {
        return taquillaList;
    }

    public void setTaquillaList(List<Taquilla> taquillaList) {
        this.taquillaList = taquillaList;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (butacaPK != null ? butacaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Butaca)) {
            return false;
        }
        Butaca other = (Butaca) object;
        if ((this.butacaPK == null && other.butacaPK != null) || (this.butacaPK != null && !this.butacaPK.equals(other.butacaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Butaca[ butacaPK=" + butacaPK + " ]";
    }
    
}
