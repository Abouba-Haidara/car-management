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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author haida
 */
@Entity
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findById", query = "SELECT p FROM Profile p WHERE p.id = :id"),
    @NamedQuery(name = "Profile.findByProfile", query = "SELECT p FROM Profile p WHERE p.profile = :profile")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "profile")
    private String profile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
    private Collection<Authentifier> authentifierCollection;

    public Profile() {
    }

    public Profile(Integer id) {
        this.id = id;
    }

    public Profile(Integer id, String profile) {
        this.id = id;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Authentifier> getAuthentifierCollection() {
        return authentifierCollection;
    }

    public void setAuthentifierCollection(Collection<Authentifier> authentifierCollection) {
        this.authentifierCollection = authentifierCollection;
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
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Profile[ id=" + id + " ]";
    }
    
}
