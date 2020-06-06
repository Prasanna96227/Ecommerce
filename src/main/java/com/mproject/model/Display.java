package com.mproject.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Display implements Serializable {
    private static final long serialVersionUID = 5140900014886997914L;//version control for the serializable class

    /**
     * id of the Display
     */
    @Id
    @GeneratedValue
    private int id;
    /**
     * custid of the Display
     */
    private int custid;
    /**
     * fname of the Display
     */
    private String fname;
    /**
     * lname of the Display
     */
    private String lname;
    /**
     * uname of the Display
     */
    private String uname;
    /**
     * cEmail of the Display
     */
    private String cEmail;
    /**
     * cPhone of the Display
     */
    private String cPhone;
    /**
     * type of the Display
     */
    private String type;
    /**
     *  Returns the id of this Display.
     *  @return The id of this Display
     */
    public int getId() {
        return id;
    }
    /**
     * Changes the id of this Display.
     * @param id The id of this Display
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *  Returns the custid of this Display.
     *  @return The custid of this Display
     */
    public int getCustid() {
        return custid;
    }
    /**
     * Changes the custid of this Display.
     * @param custid The custid of this Display
     */
    public void setCustid(int custid) {
        this.custid = custid;
    }
    /**
     *  Returns the fname of this Display.
     *  @return The fname of this Display
     */
    public String getFname() {

        return fname;
    }
    /**
     * Changes the fname of this Display.
     * @param fname The fname of this Display
     */
    public void setFname(String fname) {
        this.fname = fname;
    }
    /**
     *  Returns the lname of this Display.
     *  @return The lname of this Display
     */
    public String getLname() {
        return lname;
    }
    /**
     * Changes the lname of this Display.
     * @param lname The lname of this Display
     */
    public void setLname(String lname) {
        this.lname = lname;
    }
    /**
     *  Returns the uname of this Display.
     *  @return The uname of this Display
     */
    public String getUname() {
        return uname;
    }
    /**
     * Changes the uname of this Display.
     * @param uname The uname of this Display
     */
    public void setUname(String uname) {
        this.uname = uname;
    }
    /**
     *  Returns the cEmail of this Display.
     *  @return The cEmail of this Display
     */
    public String getcEmail() {
        return cEmail;
    }
    /**
     * Changes the cEmail of this Display.
     * @param cEmail The cEmail of this Display
     */
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }
    /**
     *  Returns the cPhone of this Display.
     *  @return The cPhone of this Display
     */
    public String getcPhone() {
        return cPhone;
    }
    /**
     * Changes the cPhone of this Display.
     * @param cPhone The cPhone of this Display
     */
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
    /**
     *  Returns the type of this Display.
     *  @return The type of this Display
     */
    public String getType() {
        return type;
    }
    /**
     * Changes the type of this Display.
     * @param type The type of this Display
     */
    public void setType(String type) {
        this.type = type;
    }
}
