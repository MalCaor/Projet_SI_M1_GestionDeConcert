/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donnees;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_Billet_bil")
@NamedQueries({
    @NamedQuery(name = "TBilletbil.findAll", query = "SELECT t FROM TBilletbil t"),
    @NamedQuery(name = "TBilletbil.findByBilId", query = "SELECT t FROM TBilletbil t WHERE t.bilId = :bilId")})
public class TBilletbil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bil_id")
    private Integer bilId;
    @JoinColumn(name = "t_Concert_con_con_id", referencedColumnName = "con_id")
    @ManyToOne(optional = false)
    private TConcertcon tConcertconconid;

    public TBilletbil() {
    }

    public TBilletbil(Integer bilId) {
        this.bilId = bilId;
    }

    public Integer getBilId() {
        return bilId;
    }

    public void setBilId(Integer bilId) {
        this.bilId = bilId;
    }

    public TConcertcon getTConcertconconid() {
        return tConcertconconid;
    }

    public void setTConcertconconid(TConcertcon tConcertconconid) {
        this.tConcertconconid = tConcertconconid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bilId != null ? bilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TBilletbil)) {
            return false;
        }
        TBilletbil other = (TBilletbil) object;
        if ((this.bilId == null && other.bilId != null) || (this.bilId != null && !this.bilId.equals(other.bilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnees.TBilletbil[ bilId=" + bilId + " ]";
    }
    
}
