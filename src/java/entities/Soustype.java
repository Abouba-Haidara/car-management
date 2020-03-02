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
@Table(name = "soustype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soustype.findAll", query = "SELECT s FROM Soustype s"),
    @NamedQuery(name = "Soustype.findById", query = "SELECT s FROM Soustype s WHERE s.id = :id"),
    @NamedQuery(name = "Soustype.findByDesignation", query = "SELECT s FROM Soustype s WHERE s.designation = :designation")})
public class Soustype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "designation")
    private String designation;
    @JoinColumn(name = "idtype", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Type idtype;

    public Soustype() {
    }

    public Soustype(Integer id) {
        this.id = id;
    }

    public Soustype(Integer id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Type getIdtype() {
        return idtype;
    }

    public void setIdtype(Type idtype) {
        this.idtype = idtype;
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
        if (!(object instanceof Soustype)) {
            return false;
        }
        Soustype other = (Soustype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Soustype[ id=" + id + " ]";
    }
    
}
