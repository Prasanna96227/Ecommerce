package com.mproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class enduser {

    /**
     * endId of the enduser
     */
    @Id
    @GeneratedValue
    private int endId;
    /**
     * uname of the enduser
     */
    private String uname;
    /**
     * pword of the enduser
     */
    private String pword;
    /**
     * active of the enduser
     */
    private boolean active;
    /**
     * custId of the enduser
     */
    private int custId;
    /**
     * role of the enduser
     */
    private String role;
    /**
     *  Returns the uname of this enduser.
     *  @return The uname of this enduser
     */
    public String getUname() {
        return uname;
    }
    /**
     * Changes the uname of this enduser.
     * @param uname The uname of this enduser
     */
    public void setUname(String uname) {
        this.uname = uname;
    }
    /**
     * Changes the pword of this enduser.
     * @param pword The pword of this enduser
     */
    public void setPword(String pword) {
        this.pword = pword;
    }
    /**
     * Changes the active of this enduser.
     * @param active The active of this enduser
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    /**
     * Changes the custId of this enduser.
     * @param custId The custId of this enduser
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }
    /**
     * Changes the role of this enduser.
     * @param role The role of this enduser
     */
    public void setRole(String role) {
        this.role = role;
    }

}
