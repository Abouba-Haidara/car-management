/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author haida
 */
@Entity
@Table(name = "penalisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penalisation.findAll", query = "SELECT p FROM Penalisation p"),
    @NamedQuery(name = "Penalisation.findById", query = "SELECT p FROM Penalisation p WHERE p.id = :id"),
    @NamedQuery(name = "Penalisation.findByRaison", query = "SELECT p FROM Penalisation p WHERE p.raison = :raison"),
    @NamedQuery(name = "Penalisation.findByCout", query = "SELECT p FROM Penalisation p WHERE p.cout = :cout"),
    @NamedQuery(name = "Penalisation.findByNbh", query = "SELECT p FROM Penalisation p WHERE p.nbh = :nbh"),
    @NamedQuery(name = "Penalisation.findByNbhSup", query = "SELECT p FROM Penalisation p WHERE p.nbhSup = :nbhSup")})
public class Penalisation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "raison")
    private String raison;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cout")
    private double cout;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbh")
    private int nbh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nbhSup")
    private int nbhSup;
    @JoinColumn(name = "idLocation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location idLocation;

    public Penalisation() {
    }

    public Penalisation(Integer id) {
        this.id = id;
    }

    public Penalisation(Integer id, String raison, double cout, int nbh, int nbhSup) {
        this.id = id;
        this.raison = raison;
        this.cout = cout;
        this.nbh = nbh;
        this.nbhSup = nbhSup;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public int getNbh() {
        return nbh;
    }

    public void setNbh(int nbh) {
        this.nbh = nbh;
    }

    public int getNbhSup() {
        return nbhSup;
    }

    public void setNbhSup(int nbhSup) {
        this.nbhSup = nbhSup;
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
        if (!(object instanceof Penalisation)) {
            return false;
        }
        Penalisation other = (Penalisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Penalisation[ id=" + id + " ]";
    }
    
}
