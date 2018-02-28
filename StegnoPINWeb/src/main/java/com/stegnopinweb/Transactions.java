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
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findByTransactionid", query = "SELECT t FROM Transactions t WHERE t.transactionid = :transactionid"),
    @NamedQuery(name = "Transactions.findByAccountid", query = "SELECT t FROM Transactions t WHERE t.accountid = :accountid"),
    @NamedQuery(name = "Transactions.findByAmount", query = "SELECT t FROM Transactions t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transactions.findByBalance", query = "SELECT t FROM Transactions t WHERE t.balance = :balance"),
    @NamedQuery(name = "Transactions.findByTransactiontype", query = "SELECT t FROM Transactions t WHERE t.transactiontype = :transactiontype"),
    @NamedQuery(name = "Transactions.findByTypeid", query = "SELECT t FROM Transactions t WHERE t.typeid = :typeid"),
    @NamedQuery(name = "Transactions.findByDateoftransaction", query = "SELECT t FROM Transactions t WHERE t.dateoftransaction = :dateoftransaction")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transactionid")
    private Long transactionid;
    @Column(name = "accountid")
    private BigInteger accountid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "balance")
    private Double balance;
    @Size(max = 256)
    @Column(name = "transactiontype")
    private String transactiontype;
    @Column(name = "typeid")
    private BigInteger typeid;
    @Size(max = 1024)
    @Column(name = "dateoftransaction")
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
