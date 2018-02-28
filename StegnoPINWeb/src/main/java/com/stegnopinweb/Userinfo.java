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
@Table(name = "userinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinfo.findAll", query = "SELECT u FROM Userinfo u"),
    @NamedQuery(name = "Userinfo.findByUserinfoid", query = "SELECT u FROM Userinfo u WHERE u.userinfoid = :userinfoid"),
    @NamedQuery(name = "Userinfo.findByUserid", query = "SELECT u FROM Userinfo u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userinfo.findByName", query = "SELECT u FROM Userinfo u WHERE u.name = :name"),
    @NamedQuery(name = "Userinfo.findByPrimarynumber", query = "SELECT u FROM Userinfo u WHERE u.primarynumber = :primarynumber"),
    @NamedQuery(name = "Userinfo.findBySecondarynumber", query = "SELECT u FROM Userinfo u WHERE u.secondarynumber = :secondarynumber")})
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userinfoid")
    private Long userinfoid;
    @Column(name = "userid")
    private BigInteger userid;
    @Size(max = 256)
    @Column(name = "name")
    private String name;
    @Size(max = 256)
    @Column(name = "primarynumber")
    private String primarynumber;
    @Size(max = 256)
    @Column(name = "secondarynumber")
    private String secondarynumber;

    public Userinfo() {
    }

    public Userinfo(Long userinfoid) {
        this.userinfoid = userinfoid;
    }

    public Long getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(Long userinfoid) {
        this.userinfoid = userinfoid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimarynumber() {
        return primarynumber;
    }

    public void setPrimarynumber(String primarynumber) {
        this.primarynumber = primarynumber;
    }

    public String getSecondarynumber() {
        return secondarynumber;
    }

    public void setSecondarynumber(String secondarynumber) {
        this.secondarynumber = secondarynumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userinfoid != null ? userinfoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinfo)) {
            return false;
        }
        Userinfo other = (Userinfo) object;
        if ((this.userinfoid == null && other.userinfoid != null) || (this.userinfoid != null && !this.userinfoid.equals(other.userinfoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stegnopinweb.Userinfo[ userinfoid=" + userinfoid + " ]";
    }
    
}
