package com.mproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
public class Item implements Serializable{

    private static final long serialVersionUID = -3532377236419382983L;//version control for the serializable class
    /**
     * itemsId of the Item
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemsId;
    /**
     * iName of the Item
     */
    private String iName;
    /**
     * typeofperson of the Item
     */
    private String typeofperson;
    /**
     * iTypeOfProduct of the Item
     */
    private String iTypeOfProduct;
    /**
     * iInformation of the Item
     */
    private String iInformation;
    /**
     * iPrice of the Item
     */
    private double iPrice;
    /**
     * itemAvailable of the Item
     */
    private int itemAvailable;
    /**
     * iBrand of the Item
     */
    private String iBrand;
    /**
     * iImage of the Item
     */
    @Transient
    private MultipartFile iImage;
    /**
     * consumerItems list of the Item
     */
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ConsumerItem> consumerItems;
    /**
     *  Returns the itemsId of this Item.
     *  @return The itemsId of this Item
     */
    public int getItemsId() {
        return itemsId;
    }
    /**
     * Changes the itemsId of this Item.
     * @param itemsId The itemsId of this Item
     */
    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }
    /**
     *  Returns the iName of this Item.
     *  @return The iName of this Item
     */
    public String getiName() {
        return iName;
    }
    /**
     * Changes the iName of this Item.
     * @param iName The iName of this Item
     */
    public void setiName(String iName) {
        this.iName = iName;
    }
    /**
     *  Returns the typeofperson of this Item.
     *  @return The typeofperson of this Item
     */
    public String getTypeofperson() {
        return typeofperson;
    }
    /**
     *  Returns the iTypeOfProduct of this Item.
     *  @return The iTypeOfProduct of this Item
     */
    public String getiTypeOfProduct() {
        return iTypeOfProduct;
    }
    /**
     *  Returns the iInformation of this Item.
     *  @return The iInformation of this Item
     */
    public String getiInformation() {
        return iInformation;
    }
    /**
     *  Returns the iPrice of this Item.
     *  @return The iPrice of this Item
     */
    public double getiPrice() {
        return iPrice;
    }
    /**
     *  Returns the itemAvailable of this Item.
     *  @return The itemAvailable of this Item
     */
    public int getItemAvailable() {
        return itemAvailable;
    }
    /**
     *  Returns the iBrand of this Item.
     *  @return The iBrand of this Item
     */
    public String getiBrand() {
        return iBrand;
    }
    /**
     *  Returns the iImage of this Item.
     *  @return The iImage of this Item
     */
    public MultipartFile getiImage() {
        return iImage;
    }
}
