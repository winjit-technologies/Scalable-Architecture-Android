
package com.winjit.wsademo.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Login implements Serializable {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("salt")
    @Expose
    private String salt;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("sha1")
    @Expose
    private String sha1;
    @SerializedName("sha256")
    @Expose
    private String sha256;

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return The salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt The salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return The md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5 The md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * @return The sha1
     */
    public String getSha1() {
        return sha1;
    }

    /**
     * @param sha1 The sha1
     */
    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    /**
     * @return The sha256
     */
    public String getSha256() {
        return sha256;
    }

    /**
     * @param sha256 The sha256
     */
    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

}
