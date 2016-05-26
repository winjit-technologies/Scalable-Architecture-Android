
package com.winjit.wsademo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Result implements Serializable {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    private Login login;
    @SerializedName("registered")
    @Expose
    private Integer registered;
    @SerializedName("dob")
    @Expose
    private Integer dob;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("picture")
    @Expose
    private Picture picture;
    @SerializedName("nat")
    @Expose
    private String nat;

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return The name
     */
    public Name getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login The login
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @return The registered
     */
    public Integer getRegistered() {
        return registered;
    }

    /**
     * @param registered The registered
     */
    public void setRegistered(Integer registered) {
        this.registered = registered;
    }

    /**
     * @return The dob
     */
    public Integer getDob() {
        return dob;
    }

    /**
     * @param dob The dob
     */
    public void setDob(Integer dob) {
        this.dob = dob;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The cell
     */
    public String getCell() {
        return cell;
    }

    /**
     * @param cell The cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    /**
     * @return The id
     */
    public Id getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     * @return The picture
     */
    public Picture getPicture() {
        return picture;
    }

    /**
     * @param picture The picture
     */
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    /**
     * @return The nat
     */
    public String getNat() {
        return nat;
    }

    /**
     * @param nat The nat
     */
    public void setNat(String nat) {
        this.nat = nat;
    }

}
