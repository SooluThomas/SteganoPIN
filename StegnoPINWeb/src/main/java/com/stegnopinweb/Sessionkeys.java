/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stegnopinweb;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chandramouliswaran
 */
@Entity
@Table(name = "sessionkeys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessionkeys.findAll", query = "SELECT s FROM Sessionkeys s"),
    @NamedQuery(name = "Sessionkeys.findBySessionkeyid", query = "SELECT s FROM Sessionkeys s WHERE s.sessionkeyid = :sessionkeyid"),
    @NamedQuery(name = "Sessionkeys.findByUserid", query = "SELECT s FROM Sessionkeys s WHERE s.userid = :userid"),
    @NamedQuery(name = "Sessionkeys.findBySessionkeys", query = "SELECT s FROM Sessionkeys s WHERE s.sessionkeys = :sessionkeys")})
public class Sessionkeys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sessionkeyid")
    private Long sessionkeyid;
    @Column(name = "userid")
    private BigInteger userid;
    @Size(max = 1024)
    @Column(name = "sessionkeys")
    private String sessionkeys;

    public Sessionkeys() {
    }

    public Sessionkeys(Long sessionkeyid) {
        this.sessionkeyid = sessionkeyid;
    }

    public Long getSessionkeyid() {
        return sessionkeyid;
    }

    public void setSessionkeyid(Long sessionkeyid) {
        this.sessionkeyid = sessionkeyid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getSessionkeys() {
        return sessionkeys;
    }

    public void setSessionkeys(String sessionkeys) {
        this.sessionkeys = sessionkeys;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionkeyid != null ? sessionkeyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessionkeys)) {
            return false;
        }
        Sessionkeys other = (Sessionkeys) object;
        if ((this.sessionkeyid == null && other.sessionkeyid != null) || (this.sessionkeyid != null && !this.sessionkeyid.equals(other.sessionkeyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stegnopinweb.Sessionkeys[ sessionkeyid=" + sessionkeyid + " ]";
    }
    
}
