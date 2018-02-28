package com.stegnopinweb;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-15T13:48:33")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, BigInteger> accountid;
    public static volatile SingularAttribute<Transactions, Double> amount;
    public static volatile SingularAttribute<Transactions, Double> balance;
    public static volatile SingularAttribute<Transactions, BigInteger> typeid;
    public static volatile SingularAttribute<Transactions, Long> transactionid;
    public static volatile SingularAttribute<Transactions, String> transactiontype;

}