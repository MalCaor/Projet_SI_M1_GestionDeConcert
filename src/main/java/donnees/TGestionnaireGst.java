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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_gestionnaire_gst")
@NamedQueries({
    @NamedQuery(name = "TGestionnaireGst.findAll", query = "SELECT t FROM TGestionnaireGst t"),
    @NamedQuery(name = "TGestionnaireGst.findByGstId", query = "SELECT t FROM TGestionnaireGst t WHERE t.gstId = :gstId"),
    @NamedQuery(name = "TGestionnaireGst.findByGstPers", query = "SELECT t FROM TGestionnaireGst t WHERE t.gstPers = :gstPers"),
    @NamedQuery(name = "TGestionnaireGst.findByGstAssocNom", query = "SELECT t FROM TGestionnaireGst t WHERE t.gstAssocNom = :gstAssocNom"),
    @NamedQuery(name = "TGestionnaireGst.findByGstAssocPres", query = "SELECT t FROM TGestionnaireGst t WHERE t.gstAssocPres = :gstAssocPres")})
public class TGestionnaireGst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gst_id")
    private Integer gstId;
    @Column(name = "gst_pers")
    private String gstPers;
    @Column(name = "gst_assoc_nom")
    private String gstAssocNom;
    @Column(name = "gst_assoc_pres")
    private String gstAssocPres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tGestionnaireGstGstId")
    private Set<TSallesal> tSallesalSet;

    public TGestionnaireGst() {
    }

    public TGestionnaireGst(Integer gstId) {
        this.gstId = gstId;
    }

    public Integer getGstId() {
        return gstId;
    }

    public void setGstId(Integer gstId) {
        this.gstId = gstId;
    }

    public String getGstPers() {
        return gstPers;
    }

    public void setGstPers(String gstPers) {
        this.gstPers = gstPers;
    }

    public String getGstAssocNom() {
        return gstAssocNom;
    }

    public void setGstAssocNom(String gstAssocNom) {
        this.gstAssocNom = gstAssocNom;
    }

    public String getGstAssocPres() {
        return gstAssocPres;
    }

    public void setGstAssocPres(String gstAssocPres) {
        this.gstAssocPres = gstAssocPres;
    }

    public Set<TSallesal> getTSallesalSet() {
        return tSallesalSet;
    }

    public void setTSallesalSet(Set<TSallesal> tSallesalSet) {
        this.tSallesalSet = tSallesalSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gstId != null ? gstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TGestionnaireGst)) {
            return false;
        }
        TGestionnaireGst other = (TGestionnaireGst) object;
        if ((this.gstId == null && other.gstId != null) || (this.gstId != null && !this.gstId.equals(other.gstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnees.TGestionnaireGst[ gstId=" + gstId + " ]";
    }
    
}
