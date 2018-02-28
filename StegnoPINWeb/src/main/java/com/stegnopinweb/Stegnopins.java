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
 * @author Cyber
 */
@Entity
@Table(name = "stegnopins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stegnopins.findAll", query = "SELECT s FROM Stegnopins s"),
    @NamedQuery(name = "Stegnopins.findByPinid", query = "SELECT s FROM Stegnopins s WHERE s.pinid = :pinid"),
    @NamedQuery(name = "Stegnopins.findByUserid", query = "SELECT s FROM Stegnopins s WHERE s.userid = :userid"),
    @NamedQuery(name = "Stegnopins.findByPin", query = "SELECT s FROM Stegnopins s WHERE s.pin = :pin"),
    @NamedQuery(name = "Stegnopins.findByOtp", query = "SELECT s FROM Stegnopins s WHERE s.otp = :otp")})
public class Stegnopins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pinid")
    private Long pinid;
    @Column(name = "userid")
    private BigInteger userid;
    @Size(max = 256)
    @Column(name = "pin")
    private String pin;
    @Size(max = 256)
    @Column(name = "otp")
    private String otp;

    public Stegnopins() {
    }

    public Stegnopins(Long pinid) {
        this.pinid = pinid;
    }

    public Long getPinid() {
        return pinid;
    }

    public void setPinid(Long pinid) {
        this.pinid = pinid;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinid != null ? pinid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stegnopins)) {
            return false;
        }
        Stegnopins other = (Stegnopins) object;
        if ((this.pinid == null && other.pinid != null) || (this.pinid != null && !this.pinid.equals(other.pinid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stegnopinweb.Stegnopins[ pinid=" + pinid + " ]";
    }
    
}
