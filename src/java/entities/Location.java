/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author haida
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id"),
    @NamedQuery(name = "Location.findByDatedebut", query = "SELECT l FROM Location l WHERE l.datedebut = :datedebut"),
    @NamedQuery(name = "Location.findByDateretour", query = "SELECT l FROM Location l WHERE l.dateretour = :dateretour"),
    @NamedQuery(name = "Location.findByHeurederetour", query = "SELECT l FROM Location l WHERE l.heurederetour = :heurederetour"),
    @NamedQuery(name = "Location.findByMontant", query = "SELECT l FROM Location l WHERE l.montant = :montant"),
    @NamedQuery(name = "Location.findByTypePayment", query = "SELECT l FROM Location l WHERE l.typePayment = :typePayment"),
    @NamedQuery(name = "Location.findByDateLocation", query = "SELECT l FROM Location l WHERE l.dateLocation = :dateLocation"),
    @NamedQuery(name = "Location.findByMatricule", query = "SELECT l FROM Location l WHERE l.matricule = :matricule")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datedebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateretour")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateretour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heurederetour")
    @Temporal(TemporalType.TIME)
    private Date heurederetour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private double montant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "typePayment")
    private String typePayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateLocation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "matricule")
    private String matricule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocation")
    private Collection<Penalisation> penalisationCollection;
    @OneToMany(mappedBy = "idLocation")
    private Collection<Retourvoiture> retourvoitureCollection;
    @JoinColumn(name = "idvoiture", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voiture idvoiture;
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idClient;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Location(Integer id, Date datedebut, Date dateretour, Date heurederetour, double montant, String typePayment, Date dateLocation, String matricule) {
        this.id = id;
        this.datedebut = datedebut;
        this.dateretour = dateretour;
        this.heurederetour = heurederetour;
        this.montant = montant;
        this.typePayment = typePayment;
        this.dateLocation = dateLocation;
        this.matricule = matricule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public Date getHeurederetour() {
        return heurederetour;
    }

    public void setHeurederetour(Date heurederetour) {
        this.heurederetour = heurederetour;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(Date dateLocation) {
        this.dateLocation = dateLocation;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Penalisation> getPenalisationCollection() {
        return penalisationCollection;
    }

    public void setPenalisationCollection(Collection<Penalisation> penalisationCollection) {
        this.penalisationCollection = penalisationCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Retourvoiture> getRetourvoitureCollection() {
        return retourvoitureCollection;
    }

    public void setRetourvoitureCollection(Collection<Retourvoiture> retourvoitureCollection) {
        this.retourvoitureCollection = retourvoitureCollection;
    }

    public Voiture getIdvoiture() {
        return idvoiture;
    }

    public void setIdvoiture(Voiture idvoiture) {
        this.idvoiture = idvoiture;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Location[ id=" + id + " ]";
    }
    
}
