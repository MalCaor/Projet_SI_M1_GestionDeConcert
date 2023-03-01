/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donnees;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_groupe_grp")
@NamedQueries({
    @NamedQuery(name = "TGroupeGrp.findAll", query = "SELECT t FROM TGroupeGrp t"),
    @NamedQuery(name = "TGroupeGrp.findByGrpId", query = "SELECT t FROM TGroupeGrp t WHERE t.grpId = :grpId"),
    @NamedQuery(name = "TGroupeGrp.findByGrpDescription", query = "SELECT t FROM TGroupeGrp t WHERE t.grpDescription = :grpDescription"),
    @NamedQuery(name = "TGroupeGrp.findByGrpNom", query = "SELECT t FROM TGroupeGrp t WHERE t.grpNom = :grpNom")})
public class TGroupeGrp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grp_id")
    private Integer grpId;
    @Column(name = "grp_description")
    private String grpDescription;
    @Column(name = "grp_nom")
    private String grpNom;
    @ManyToMany(mappedBy = "tGroupeGrpSet")
    private Set<TConcertcon> tConcertconSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grpId")
    private Set<TArtisteart> tArtisteartSet;

    public TGroupeGrp() {
    }

    public TGroupeGrp(Integer grpId) {
        this.grpId = grpId;
    }

    public Integer getGrpId() {
        return grpId;
    }

    public void setGrpId(Integer grpId) {
        this.grpId = grpId;
    }

    public String getGrpDescription() {
        return grpDescription;
    }

    public void setGrpDescription(String grpDescription) {
        this.grpDescription = grpDescription;
    }

    public String getGrpNom() {
        return grpNom;
    }

    public void setGrpNom(String grpNom) {
        this.grpNom = grpNom;
    }

    public Set<TConcertcon> getTConcertconSet() {
        return tConcertconSet;
    }

    public void setTConcertconSet(Set<TConcertcon> tConcertconSet) {
        this.tConcertconSet = tConcertconSet;
    }

    public Set<TArtisteart> getTArtisteartSet() {
        return tArtisteartSet;
    }

    public void setTArtisteartSet(Set<TArtisteart> tArtisteartSet) {
        this.tArtisteartSet = tArtisteartSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grpId != null ? grpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TGroupeGrp)) {
            return false;
        }
        TGroupeGrp other = (TGroupeGrp) object;
        if ((this.grpId == null && other.grpId != null) || (this.grpId != null && !this.grpId.equals(other.grpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnees.TGroupeGrp[ grpId=" + grpId + " ]";
    }
    
}
