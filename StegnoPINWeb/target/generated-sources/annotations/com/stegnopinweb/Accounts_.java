package com.stegnopinweb;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-02-15T13:48:33")
@StaticMetamodel(Accounts.class)
public class Accounts_ { 

    public static volatile SingularAttribute<Accounts, Long> accountid;
    public static volatile SingularAttribute<Accounts, String> accountnumber;
    public static volatile SingularAttribute<Accounts, String> accountname;
    public static volatile SingularAttribute<Accounts, Double> balance;
    public static volatile SingularAttribute<Accounts, BigInteger> userid;

}