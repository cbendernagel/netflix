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
import javax.persistence.OneToOne;
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
    @OneToOne
    private AccountType acctType;
    private Customer customer;
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public Timestamp getTimestamp(){
        return dateOpened;
    }
    
    public void setTimestamp(Timestamp dateOpened){
        this.dateOpened = dateOpened;
    }
    
    public AccountType getAccountType(){
        return acctType;
    }
    
    public void setAccountType(AccountType acctType){
        this.acctType = acctType;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    
}
