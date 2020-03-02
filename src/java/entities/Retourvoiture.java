/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author haida
 */
@Entity
@Table(name = "retourvoiture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retourvoiture.findAll", query = "SELECT r FROM Retourvoiture r"),
    @NamedQuery(name = "Retourvoiture.findById", query = "SELECT r FROM Retourvoiture r WHERE r.id = :id"),
    @NamedQuery(name = "Retourvoiture.findByDateretour", query = "SELECT r FROM Retourvoiture r WHERE r.dateretour = :dateretour")})
public class Retourvoiture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateretour")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateretour;
    @JoinColumn(name = "idLocation", referencedColumnName = "id")
    @ManyToOne
    private Location idLocation;

    public Retourvoiture() {
    }

    public Retourvoiture(Integer id) {
        this.id = id;
    }

    public Retourvoiture(Integer id, Date dateretour) {
        this.id = id;
        this.dateretour = dateretour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public Location getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Location idLocation) {
        this.idLocation = idLocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retourvoiture)) {
            return false;
        }
        Retourvoiture other = (Retourvoiture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Retourvoiture[ id=" + id + " ]";
    }
    
}
