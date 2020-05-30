package com.mproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class ConsumerCart implements Serializable {

    private static final long serialVersionUID = 3940548625296145582L;//version control for the serializable class

    /**
     * id of the ConsumerCart
     */
    @Id
    @GeneratedValue
    private int ccId;

    /**
     * List<ConsumerItem> of the ConsumerCart
     */
    @OneToMany(mappedBy = "consumerCart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ConsumerItem> ci;

    /**
     * Consumer of the ConsumerCart
     */
    @OneToOne
    @JoinColumn(name = "consumerId")
    @JsonIgnore
    private Consumer consumer;
    /**
     * gcost of the ConsumerCart
     */
    private double gcost;
    /**
     *  Returns the ccId of this ConsumerCart.
     *  @return The ccId of this ConsumerCart
     */
    public int getCcId() {
        return ccId;
    }

    /**
     *  Returns the ci of this ConsumerCart.
     *  @return The ci of this ConsumerCart
     */
    public List<ConsumerItem> getCi() {
        return ci;
    }

    /**
     *  Returns the consumer of this ConsumerCart.
     *  @return The consumer of this ConsumerCart
     */
    public Consumer getConsumer() {
        return consumer;
    }
    /**
     * Changes the consumer of this ConsumerCart.
     * @param consumer The consumer of this ConsumerCart
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }



}
