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
 * @author Chandramouliswaran
 */
public class Sessionkeys implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long sessionkeyid;
    private BigInteger userid;
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
