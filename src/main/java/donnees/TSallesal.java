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
@Table(name = "t_Salle_sal")
@NamedQueries({
    @NamedQuery(name = "TSallesal.findAll", query = "SELECT t FROM TSallesal t"),
    @NamedQuery(name = "TSallesal.findBySalId", query = "SELECT t FROM TSallesal t WHERE t.salId = :salId"),
    @NamedQuery(name = "TSallesal.findBySalCapacit\u00e9", query = "SELECT t FROM TSallesal t WHERE t.salCapacit\u00e9 = :salCapacit\u00e9"),
    @NamedQuery(name = "TSallesal.findAgendaSalle", query = "SELECT t FROM TSallesal t "
    		+ "JOIN t.tSoireesorSet s "
    		+ "join s.tConcertconSet c "
    		+ "WHERE t.salId = :salId")})
public class TSallesal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sal_id")
    private Integer salId;
    @Column(name = "sal_capacit\u00e9")
    private Integer salCapacité;
    @Column(name = "sal_nom")
    private String salNom;
    @Column(name = "sal_adresse")
    private String salAdresse;
    @JoinColumn(name = "t_gestionnaire_gst_gst_id", referencedColumnName = "gst_id")
    @ManyToOne(optional = false)
    private TGestionnaireGst tGestionnaireGstGstId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sallId")
    private Set<TSoireesor> tSoireesorSet;

    public TSallesal() {
    }

    public TSallesal(Integer salId) {
        this.salId = salId;
    }

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public Integer getSalCapacité() {
        return salCapacité;
    }

    public void setSalCapacité(Integer salCapacité) {
        this.salCapacité = salCapacité;
    }

    public String getSalNom() {
        return salNom;
    }

    public void setSalNom(String salNom) {
        this.salNom = salNom;
    }

    public String getSalAdresse() {
        return salAdresse;
    }

    public void setSalAdresse(String salAdresse) {
        this.salAdresse = salAdresse;
    }

    public TGestionnaireGst gettGestionnaireGstGstId() {
        return tGestionnaireGstGstId;
    }

    public void settGestionnaireGstGstId(TGestionnaireGst tGestionnaireGstGstId) {
        this.tGestionnaireGstGstId = tGestionnaireGstGstId;
    }

    public Set<TSoireesor> gettSoireesorSet() {
        return tSoireesorSet;
    }

    public void settSoireesorSet(Set<TSoireesor> tSoireesorSet) {
        this.tSoireesorSet = tSoireesorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salId != null ? salId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TSallesal)) {
            return false;
        }
        TSallesal other = (TSallesal) object;
        if ((this.salId == null && other.salId != null) || (this.salId != null && !this.salId.equals(other.salId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	    	if(this.tSoireesorSet==null) {
    	    		return "fuck";
    	    	}
    	    	if(this.tSoireesorSet.isEmpty()) {
    	    		return "vide";
    	    	}else {
    	    		return "non vide";
    	    	}
    	   
    	    
        //return "donnees.TSallesal[ salId=" + salId + " ]";
    }
    
}
