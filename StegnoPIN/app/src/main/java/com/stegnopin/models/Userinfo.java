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
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long userinfoid;
    private BigInteger userid;
    private String name;
    private String primarynumber;
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
