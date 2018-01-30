/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Alejandro
 */
@Embeddable
public class ButacaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDBUTACA")
    private short idbutaca;
    @Basic(optional = false)
    @Column(name = "IDSALA")
    private short idsala;

    public ButacaPK() {
    }

    public ButacaPK(short idbutaca, short idsala) {
        this.idbutaca = idbutaca;
        this.idsala = idsala;
    }

    public short getIdbutaca() {
        return idbutaca;
    }

    public void setIdbutaca(short idbutaca) {
        this.idbutaca = idbutaca;
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
        hash += (int) idbutaca;
        hash += (int) idsala;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ButacaPK)) {
            return false;
        }
        ButacaPK other = (ButacaPK) object;
        if (this.idbutaca != other.idbutaca) {
            return false;
        }
        if (this.idsala != other.idsala) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ButacaPK[ idbutaca=" + idbutaca + ", idsala=" + idsala + " ]";
    }
    
}
