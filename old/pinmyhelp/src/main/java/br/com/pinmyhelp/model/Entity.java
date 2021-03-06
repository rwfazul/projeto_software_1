package br.com.pinmyhelp.model;
// Generated 17/05/2018 15:02:51 by Hibernate Tools 4.3.1


import br.com.pinmyhelp.model.data.Model;
import br.com.pinmyhelp.model.types.GeoLocation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity generated by hbm2java
 */
@javax.persistence.Entity
@Table(name="entity", catalog="pinmyhelp")
public class Entity  extends Model {

    private Address adress;
    private String name;
    private String cnpj;
    private String password;
    private String description;
    private Date fundDate;
    private String primPhone;
    private String secPhone;
    private String email;
    private String logo;
    private String obs;
    private GeoLocation location;
    private List<Feedback> feedbacks = new ArrayList<>();;
    private List<Help> helps = new ArrayList<>();
    private List<WorkingPeriod> workingPeriods = new ArrayList<>();

    public Entity() {
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="adress_id", nullable=false)
    public Address getAdress() {
        return this.adress;
    }
    
    public void setAdress(Address adress) {
        this.adress = adress;
    }
    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="cnpj", nullable=false, length=14)
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    @Column(name="password", nullable=false, length=35)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fund_date", length=10)
    public Date getFundDate() {
        return this.fundDate;
    }
    
    public void setFundDate(Date fundDate) {
        this.fundDate = fundDate;
    }

    
    @Column(name="prim_phone", nullable=false, length=11)
    public String getPrimPhone() {
        return this.primPhone;
    }
    
    public void setPrimPhone(String primPhone) {
        this.primPhone = primPhone;
    }

    
    @Column(name="sec_phone", length=11)
    public String getSecPhone() {
        return this.secPhone;
    }
    
    public void setSecPhone(String secPhone) {
        this.secPhone = secPhone;
    }

    
    @Column(name="email", nullable=false)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="logo", length=11)
    public String getLogo() {
        return this.logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }

    
    @Column(name="obs", length=65535)
    public String getObs() {
        return this.obs;
    }
    
    public void setObs(String obs) {
        this.obs = obs;
    }

    
    /**
     * @return the location
     */
    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "x", column = @Column(name = "x")),
        @AttributeOverride(name = "y", column = @Column(name = "y"))
    })
    public GeoLocation getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="entity")
    public List<Feedback> getFeedbacks() {
        return this.feedbacks;
    }
    
    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="entity")
    public List<Help> getHelps() {
        return this.helps;
    }
    
    public void setHelps(List<Help> helps) {
        this.helps = helps;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="entity")
    public List<WorkingPeriod> getWorkingPeriods() {
        return this.workingPeriods;
    }
    
    public void setWorkingPeriods(List<WorkingPeriod> workingPeriods) {
        this.workingPeriods = workingPeriods;
    }




}


