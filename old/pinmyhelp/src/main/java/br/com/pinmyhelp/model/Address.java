package br.com.pinmyhelp.model;
// Generated 17/05/2018 15:02:51 by Hibernate Tools 4.3.1


import br.com.pinmyhelp.model.data.Model;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Adress generated by hbm2java
 */
@javax.persistence.Entity
@Table(name="address",catalog="pinmyhelp")
public class Address  extends Model {

    private String street;
    private Integer number;
    private String neib;
    private String postalCode;
    private String compl;
    private String city;
    private String state;
     
    public Address() {
    }
   
    @Column(name="street", nullable=false)
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    @Column(name="number")
    public Integer getNumber() {
        return this.number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }

    
    @Column(name="neib")
    public String getNeib() {
        return this.neib;
    }
    
    public void setNeib(String neib) {
        this.neib = neib;
    }

    
    @Column(name="postal_code", nullable=false, length=8)
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
    @Column(name="compl")
    public String getCompl() {
        return this.compl;
    }
    
    public void setCompl(String compl) {
        this.compl = compl;
    }

    
    @Column(name="city", nullable=false)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="state", nullable=false, length=2)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

}


