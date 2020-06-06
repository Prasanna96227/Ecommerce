package com.mproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SManagers implements Serializable {
    private static final long serialVersionUID = 5140900014886997914L;//version control for the serializable class

    /**
     * id of the SManagers
     */
    @Id
    @GeneratedValue
    private int shopId;

    /**
     * name of the SManagers
     */
    private String sName;
    /**
     * email of the SManagers
     */
    private String sEmail;
    /**
     * Phone of the SManagers
     */
    private String sPhone;
    /**
     * username of the SManagers
     */
    private String uname;
    /**
     * password of the SManagers
     */
    private String pword;
    /**
     * streetAddress of the SManagers
     */
    private String streetAddress;
    /**
     * aptNumber of the SManagers
     */
    private String aptNumber;
    /**
     * city of the SManagers
     */
    private String city;
    /**
     * state of the SManagers
     */
    private String state;
    /**
     * zipCode of the SManagers
     */
    private String zipCode;


    /**
     *  Returns the aptNumber of this SManagers.
     *  @return The aptNumber of this SManagers
     */
    public String getAptNumber() {
        return aptNumber;
    }

    /**
     *  Returns the shopId of this SManagers.
     *  @return The shopId of this SManagers
     */
    public int getShopId() {
        return shopId;
    }
    /**
     *  Returns the sName of this SManagers.
     *  @return The sName of this SManagers
     */
    public String getsName() {
        return sName;
    }
    /**
     *  Returns the sEmail of this SManagers.
     *  @return The sEmail of this SManagers
     */
    public String getsEmail() {
        return sEmail;
    }
    /**
     *  Returns the sPhone of this SManagers.
     *  @return The sPhone of this SManagers
     */
    public String getsPhone() {
        return sPhone;
    }
    /**
     *  Returns the uname of this SManagers.
     *  @return The uname of this SManagers
     */
    public String getUname() {
        return uname;
    }
    /**
     * Changes the uname of this SManagers.
     * @param uname The uname of this SManagers
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     *  Returns the pword of this SManagers.
     *  @return The pword of this SManagers
     */
    public String getPword() {
        return pword;
    }
    /**
     *  Returns the streetAddress of this SManagers.
     *  @return The streetAddress of this SManagers
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     *  Returns the city of this SManagers.
     *  @return The city of this SManagers
     */
    public String getCity() {
        return city;
    }
    /**
     *  Returns the state of this SManagers.
     *  @return The state of this SManagers
     */
    public String getState() {
        return state;
    }
    /**
     *  Returns the zipCode of this SManagers.
     *  @return The zipCode of this SManagers
     */
    public String getZipCode() {
        return zipCode;
    }

}
