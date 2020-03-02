/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "voiture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voiture.findAll", query = "SELECT v FROM Voiture v"),
    @NamedQuery(name = "Voiture.findById", query = "SELECT v FROM Voiture v WHERE v.id = :id"),
    @NamedQuery(name = "Voiture.findByMarque", query = "SELECT v FROM Voiture v WHERE v.marque = :marque"),
    @NamedQuery(name = "Voiture.findByStatutretour", query = "SELECT v FROM Voiture v WHERE v.statutretour = :statutretour"),
    @NamedQuery(name = "Voiture.findByCouleur", query = "SELECT v FROM Voiture v WHERE v.couleur = :couleur"),
    @NamedQuery(name = "Voiture.findByModele", query = "SELECT v FROM Voiture v WHERE v.modele = :modele"),
    @NamedQuery(name = "Voiture.findByPuissance", query = "SELECT v FROM Voiture v WHERE v.puissance = :puissance"),
    @NamedQuery(name = "Voiture.findByCoutparJour", query = "SELECT v FROM Voiture v WHERE v.coutparJour = :coutparJour"),
    @NamedQuery(name = "Voiture.findByPhoto", query = "SELECT v FROM Voiture v WHERE v.photo = :photo"),
    @NamedQuery(name = "Voiture.findByMatricule", query = "SELECT v FROM Voiture v WHERE v.matricule = :matricule")})
public class Voiture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "marque")
    private String marque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "statutretour")
    private int statutretour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "couleur")
    private String couleur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "modele")
    private String modele;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puissance")
    private double puissance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coutparJour")
    private double coutparJour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matricule")
    private String matricule;
    @JoinColumn(name = "idtype", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Type idtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvoiture")
    private Collection<Location> locationCollection;

    public Voiture() {
    }

    public Voiture(Integer id) {
        this.id = id;
    }

    public Voiture(Integer id, String marque, int statutretour, String couleur, String modele, double puissance, double coutparJour, String photo, String matricule) {
        this.id = id;
        this.marque = marque;
        this.statutretour = statutretour;
        this.couleur = couleur;
        this.modele = modele;
        this.puissance = puissance;
        this.coutparJour = coutparJour;
        this.photo = photo;
        this.matricule = matricule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getStatutretour() {
        return statutretour;
    }

    public void setStatutretour(int statutretour) {
        this.statutretour = statutretour;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getPuissance() {
        return puissance;
    }

    public void setPuissance(double puissance) {
        this.puissance = puissance;
    }

    public double getCoutparJour() {
        return coutparJour;
    }

    public void setCoutparJour(double coutparJour) {
        this.coutparJour = coutparJour;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Type getIdtype() {
        return idtype;
    }

    public void setIdtype(Type idtype) {
        this.idtype = idtype;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
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
        if (!(object instanceof Voiture)) {
            return false;
        }
        Voiture other = (Voiture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Voiture[ id=" + id + " ]";
    }
    
}
