/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cbendernagel
 */
@Entity
@Table
public class Account implements Serializable{
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp dateOpened;
    private AccountType acctType;
    private Customer customer;
    
    Integer getId(){
        return id;
    }
    
    void setId(Integer id){
        this.id = id;
    }
    
    Timestamp getTimestamp(){
        return dateOpened;
    }
    
    void setTimestamp(Timestamp dateOpened){
        this.dateOpened = dateOpened;
    }
    
    AccountType getAccountType(){
        return acctType;
    }
    
    void setAccountType(AccountType acctType){
        this.acctType = acctType;
    }
    
    Customer getCustomer(){
        return customer;
    }
    
    void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    
}
