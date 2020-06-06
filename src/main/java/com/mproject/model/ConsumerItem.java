package com.mproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ConsumerItem implements Serializable{

    private static final long serialVersionUID = -904360230041854157L;//version control for the serializable class

    /**
     * id of the ConsumerItem
     */
    @Id
    @GeneratedValue
    private int cId;

    /**
     * ConsumerCart of the ConsumerItem
     */
    @ManyToOne
    @JoinColumn(name = "ccId")
    @JsonIgnore
    private ConsumerCart consumerCart;

    /**
     * Item of the ConsumerItem
     */
    @ManyToOne
    @JoinColumn(name = "itemsId")
    private Item item;
    /**
     * number of the ConsumerItem
     */
    private int number;
    /**
     * cost of the ConsumerItem
     */
    private double cost;
    /**
     * Changes the consumerCart of this ConsumerItem.
     * @param consumerCart The consumerCart of this ConsumerItem
     */
    public void setConsumerCart(ConsumerCart consumerCart) {
        this.consumerCart = consumerCart;
    }

    /**
     *  Returns the item of this ConsumerItem.
     *  @return The item of this ConsumerItem
     */
    public Item getItem() {
        return item;
    }
    /**
     * Changes the item of this ConsumerItem.
     * @param item The item of this ConsumerItem
     */
    public void setItem(Item item) {
        this.item = item;
    }
    /**
     *  Returns the number of this ConsumerItem.
     *  @return The number of this ConsumerItem
     */
    public int getNumber() {
        return number;
    }
    /**
     * Changes the number of this ConsumerItem.
     * @param number The number of this ConsumerItem
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     *  Returns the cost of this ConsumerItem.
     *  @return The cost of this ConsumerItem
     */
    public double getCost() {
        return cost;
    }
    /**
     * Changes the cost of this ConsumerItem.
     * @param cost The cost of this ConsumerItem
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}
