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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_Soiree_sor")
@NamedQueries({
    @NamedQuery(name = "TSoireesor.findAll", query = "SELECT t FROM TSoireesor t JOIN t.sallId s"),
    @NamedQuery(name = "TSoireesor.findBySorId", query = "SELECT t FROM TSoireesor t WHERE t.sorId = :sorId"),
    @NamedQuery(name = "TSoireesor.findBySorNom", query = "SELECT t FROM TSoireesor t WHERE t.sorNom = :sorNom")})
public class TSoireesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sor_id")
    private Integer sorId;
    @Column(name = "sor_nom")
    private String sorNom;
    @JoinColumn(name = "sall_id", referencedColumnName = "sal_id")
    @ManyToOne(optional = false)
    private TSallesal sallId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sorId")
    private Set<TConcertcon> tConcertconSet;


    public TSoireesor() {
    }

    public TSoireesor(Integer sorId) {
        this.sorId = sorId;
    }

    public Integer getSorId() {
        return sorId;
    }

    public void setSorId(Integer sorId) {
        this.sorId = sorId;
    }

    public String getSorNom() {
        return sorNom;
    }

    public void setSorNom(String sorNom) {
        this.sorNom = sorNom;
    }

    public TSallesal getSallId() {
        return sallId;
    }

    public void setSallId(TSallesal sallId) {
        this.sallId = sallId;
    }

    public Set<TConcertcon> gettConcertconSet() {
        return tConcertconSet;
    }


    public void settConcertconSet(Set<TConcertcon> tConcertconSet) {
        this.tConcertconSet = tConcertconSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sorId != null ? sorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSoireesor)) {
            return false;
        }
        TSoireesor other = (TSoireesor) object;
        if ((this.sorId == null && other.sorId != null) || (this.sorId != null && !this.sorId.equals(other.sorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnees.TSoireesor[ sorId=" + sorId + " ]";
    }
    
    public String tojson() {
    	String json ="{\"Id\":"+this.getSorId()+", \"Nom\":\""+getSorNom()+
    			"\", \"concerts\":[";
    	for(TConcertcon c : this.gettConcertconSet()) {
    		json+=c.tojson()+',';
	    }
	    if(!this.gettConcertconSet().isEmpty()) {
			json=json.substring(0, json.length() - 1);
	    }
    	
    	json+="]}";
    	return json;
    	
    }
    
}
