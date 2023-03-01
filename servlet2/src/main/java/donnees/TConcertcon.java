/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donnees;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_Concert_con")
@NamedQueries({
    @NamedQuery(name = "TConcertcon.findAll", query = "SELECT t FROM TConcertcon t"),
    @NamedQuery(name = "TConcertcon.findByConId", query = "SELECT t FROM TConcertcon t WHERE t.conId = :conId"),
    @NamedQuery(name = "TConcertcon.findByConDateDebut", query = "SELECT t FROM TConcertcon t WHERE t.conDateDebut = :conDateDebut"),
    @NamedQuery(name = "TConcertcon.findByConDateFin", query = "SELECT t FROM TConcertcon t WHERE t.conDateFin = :conDateFin"),
    @NamedQuery(name = "TConcertcon.findByConPrix", query = "SELECT t FROM TConcertcon t WHERE t.conPrix = :conPrix")})
public class TConcertcon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Integer conId;
    @Column(name = "con_date_debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conDateDebut;
    @Column(name = "con_date_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conDateFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "con_prix")
    private Double conPrix;
    @JoinTable(name = "t_Participe_par", joinColumns = {
        @JoinColumn(name = "con_id", referencedColumnName = "con_id")}, inverseJoinColumns = {
        @JoinColumn(name = "grp_id", referencedColumnName = "grp_id")})
    @ManyToMany
    private Set<TGroupeGrp> tGroupeGrpSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tConcertconconid")
    private Set<TBilletbil> tBilletbilSet;
    @JoinColumn(name = "sor_id", referencedColumnName = "sor_id")
    @ManyToOne(optional = false)
    private TSoireesor sorId;

    public TConcertcon() {
    }

    public TConcertcon(Integer conId) {
        this.conId = conId;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public Date getConDateDebut() {
        return conDateDebut;
    }

    public void setConDateDebut(Date conDateDebut) {
        this.conDateDebut = conDateDebut;
    }

    public Date getConDateFin() {
        return conDateFin;
    }

    public void setConDateFin(Date conDateFin) {
        this.conDateFin = conDateFin;
    }

    public Double getConPrix() {
        return conPrix;
    }

    public void setConPrix(Double conPrix) {
        this.conPrix = conPrix;
    }

    public Set<TGroupeGrp> getTGroupeGrpSet() {
        return tGroupeGrpSet;
    }

    public void setTGroupeGrpSet(Set<TGroupeGrp> tGroupeGrpSet) {
        this.tGroupeGrpSet = tGroupeGrpSet;
    }

    public Set<TBilletbil> getTBilletbilSet() {
        return tBilletbilSet;
    }

    public void setTBilletbilSet(Set<TBilletbil> tBilletbilSet) {
        this.tBilletbilSet = tBilletbilSet;
    }

    public TSoireesor getSorId() {
        return sorId;
    }

    public void setSorId(TSoireesor sorId) {
        this.sorId = sorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TConcertcon)) {
            return false;
        }
        TConcertcon other = (TConcertcon) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnees.TConcertcon[ conId=" + conId + " ]";
    }
    
    public String tojson() {
    	return "{\"Id\":"+this.getConId()+", \"DateDebut\":\""+getConDateDebut()+
    			"\", \"DateFin\":\""+getConDateFin()+
    			"\", \"Prix\":"+this.getConPrix()+"}";
    }
    
}
