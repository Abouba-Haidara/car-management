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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author haida
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByAddresse", query = "SELECT c FROM Client c WHERE c.addresse = :addresse"),
    @NamedQuery(name = "Client.findByPhoto", query = "SELECT c FROM Client c WHERE c.photo = :photo"),
    @NamedQuery(name = "Client.findByMatricule", query = "SELECT c FROM Client c WHERE c.matricule = :matricule"),
    @NamedQuery(name = "Client.findByGenre", query = "SELECT c FROM Client c WHERE c.genre = :genre"),
    @NamedQuery(name = "Client.findByNidn", query = "SELECT c FROM Client c WHERE c.nidn = :nidn"),
    @NamedQuery(name = "Client.findByBp", query = "SELECT c FROM Client c WHERE c.bp = :bp")})
public class Client implements Serializable {
    @OneToMany(mappedBy = "client")
    private Collection<Authentifier> authentifierCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "addresse")
    private String addresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "genre")
    private String genre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NIDN")
    private String nidn;
    @Size(max = 13)
    @Column(name = "bp")
    private String bp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private Collection<Contrat> contratCollection;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String nom, String prenom, String telephone, String addresse, String photo, String matricule, String genre, String nidn) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.addresse = addresse;
        this.photo = photo;
        this.matricule = matricule;
        this.genre = genre;
        this.nidn = nidn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    @XmlTransient
//    @JsonIgnore
    public Collection<Contrat> getContratCollection() {
        return contratCollection;
    }

    public void setContratCollection(Collection<Contrat> contratCollection) {
        this.contratCollection = contratCollection;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Client[ id=" + id + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Authentifier> getAuthentifierCollection() {
        return authentifierCollection;
    }

    public void setAuthentifierCollection(Collection<Authentifier> authentifierCollection) {
        this.authentifierCollection = authentifierCollection;
    }
    
}
