package com.mproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Consumer implements Serializable{

    private static final long serialVersionUID = 5140900014886997914L;//version control for the serializable class

    /**
     * id of the consumer(user)
     */
    @Id
    @GeneratedValue
    private int consumerId;

    /**
     * first name of the consumer
     */
    private String cFirstName;
    /**
     * last name of the consumer
     */
    private String cLastName;
    /**
     * email of the consumer
     */
    private String cEmail;
    /**
     * phone of the consumer
     */
    private String cPhone;
    /**
     * username of the consumer
     */
    private String uname;
    /**
     * password of the consumer
     */
    private String pword;
    /**
     * streetAddress of the consumer
     */
    private String streetAddress;
    /**
     * AptNumber of the consumer
     */
    private String AptNumber;
    /**
     * city of the consumer
     */
    private String city;
    /**
     * state of the consumer
     */
    private String state;
    /**
     * zipcode of the consumer
     */
    private String zipCode;
    /**
     * defining ConsumerCart class reference
     */
    @OneToOne
    @JoinColumn(name = "ccId")
    @JsonIgnore
    private ConsumerCart consumerCart;

    /**
     *  Returns the consumerCart of this consumer.
     *  @return The consumerCart of this consumer
     */
    public ConsumerCart getConsumerCart() {
        return consumerCart;
    }

    /**
     * Changes the consumerCart of this consumer.
     * @param consumerCart The consumerCart of this consumer
     */
    public void setConsumerCart(ConsumerCart consumerCart) {
        this.consumerCart = consumerCart;
    }

    /**
     *  Returns the consumerId of this consumer.
     *  @return The consumerId of this consumer
     */
    public int getConsumerId() {
        return consumerId;
    }

    /**
     * Changes the consumerId of this consumer.
     * @param consumerId The consumerId of this consumer
     */
    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    /**
     *  Returns the cFirstName of this consumer.
     *  @return The cFirstName of this consumer
     */
    public String getcFirstName() {
        return cFirstName;
    }

    /**
     * Changes the cFirstName of this consumer.
     * @param cFirstName The cFirstName of this consumer
     */
    public void setcFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    /**
     *  Returns the cLastName of this consumer.
     *  @return The cLastName of this consumer
     */
    public String getcLastName() {
        return cLastName;
    }

    /**
     * Changes the cLastName of this consumer.
     * @param cLastName The cLastName of this consumer
     */
    public void setcLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    /**
     *  Returns the cEmail of this consumer.
     *  @return The cEmail of this consumer
     */
    public String getcEmail() {
        return cEmail;
    }

    /**
     * Changes the cEmail of this consumer.
     * @param cEmail The cEmail of this consumer
     */
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    /**
     *  Returns the cPhone of this consumer.
     *  @return The cPhone of this consumer
     */
    public String getcPhone() {
        return cPhone;
    }

    /**
     * Changes the cPhone of this consumer.
     * @param cPhone The cPhone of this consumer
     */
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    /**
     *  Returns the uname of this consumer.
     *  @return The uname of this consumer
     */
    public String getUname() {
        return uname;
    }

    /**
     * Changes the uname of this consumer.
     * @param uname The uname of this consumer
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     *  Returns the pword of this consumer.
     *  @return The pword of this consumer
     */
    public String getPword() {
        return pword;
    }

    /**
     * Changes the pword of this consumer.
     * @param pword The pword of this consumer
     */
    public void setPword(String pword) {
        this.pword = pword;
    }

    /**
     *  Returns the streetAddress of this consumer.
     *  @return The streetAddress of this consumer
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Changes the streetAddress of this consumer.
     * @param streetAddress The streetAddress of this consumer
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     *  Returns the AptNumber of this consumer.
     *  @return The AptNumber of this consumer
     */
    public String getAptNumber() {
        return AptNumber;
    }

    /**
     * Changes the aptNumber of this consumer.
     * @param aptNumber The aptNumber of this consumer
     */
    public void setAptNumber(String aptNumber) {
        AptNumber = aptNumber;
    }

    /**
     *  Returns the city of this consumer.
     *  @return The city of this consumer
     */
    public String getCity() {
        return city;
    }

    /**
     * Changes the city of this consumer.
     * @param city The city of this consumer
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *  Returns the state of this consumer.
     *  @return The state of this consumer
     */
    public String getState() {
        return state;
    }

    /**
     * Changes the state of this consumer.
     * @param state The state of this consumer
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *  Returns the zipCode of this consumer.
     *  @return The zipCode of this consumer
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Changes the zipCode of this consumer.
     * @param zipCode The zipCode of this consumer
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
