package com.stegnopin.models;

/**
 * Created by Chandramouliswaran on 2/15/2018.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigInteger;


/**
 *
 * @author Chandramouliswaran
 */
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long transactionid;
    private BigInteger accountid;
    private Double amount;
    private Double balance;
    private String transactiontype;
    private BigInteger typeid;
    private String dateoftransaction;

    public Transactions() {
    }

    public Transactions(Long transactionid) {
        this.transactionid = transactionid;
    }

    public Long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Long transactionid) {
        this.transactionid = transactionid;
    }

    public BigInteger getAccountid() {
        return accountid;
    }

    public void setAccountid(BigInteger accountid) {
        this.accountid = accountid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public BigInteger getTypeid() {
        return typeid;
    }

    public void setTypeid(BigInteger typeid) {
        this.typeid = typeid;
    }

    public String getDateoftransaction() {
        return dateoftransaction;
    }

    public void setDateoftransaction(String dateoftransaction) {
        this.dateoftransaction = dateoftransaction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionid != null ? transactionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionid == null && other.transactionid != null) || (this.transactionid != null && !this.transactionid.equals(other.transactionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stegnopinweb.Transactions[ transactionid=" + transactionid + " ]";
    }
}
