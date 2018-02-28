/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stegnopin.models;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author Cyber
 */
public class Stegnopins implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long pinid;
    private BigInteger userid;
    private String pin;
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
