/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package donnees;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_Admin_adm")
@NamedQueries({
    @NamedQuery(name = "TAdminadm.findAll", query = "SELECT t FROM TAdminadm t"),
    @NamedQuery(name = "TAdminadm.findByAdmId", query = "SELECT t FROM TAdminadm t WHERE t.admId = :admId"),
    @NamedQuery(name = "TAdminadm.findByAdmPassord", query = "SELECT t FROM TAdminadm t WHERE t.admPassord = :admPassord")})
public class TAdminadm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "adm_id")
    private String admId;
    @Column(name = "adm_passord")
    private String admPassord;

    public TAdminadm() {
    }

    public TAdminadm(String admId) {
        this.admId = admId;
    }

    public String getAdmId() {
        return admId;
    }

    public void setAdmId(String admId) {
        this.admId = admId;
    }

    public String getAdmPassord() {
        return admPassord;
    }

    public void setAdmPassord(String admPassord) {
        this.admPassord = admPassord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admId != null ? admId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAdminadm)) {
            return false;
        }
        TAdminadm other = (TAdminadm) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "donnees.TAdminadm[ admId=" + admId + " ]";
    }
    
}
