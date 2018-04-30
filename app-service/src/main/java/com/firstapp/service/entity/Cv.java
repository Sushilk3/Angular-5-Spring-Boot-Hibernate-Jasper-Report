/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstapp.service.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SRX
 */
@Entity
@Table(name = "cv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c"),
    @NamedQuery(name = "Cv.findByCvId", query = "SELECT c FROM Cv c WHERE c.cvId = :cvId"),
    @NamedQuery(name = "Cv.findByName", query = "SELECT c FROM Cv c WHERE c.name = :name"),
    @NamedQuery(name = "Cv.findByAge", query = "SELECT c FROM Cv c WHERE c.age = :age"),
    @NamedQuery(name = "Cv.findByAddress", query = "SELECT c FROM Cv c WHERE c.address = :address"),
    @NamedQuery(name = "Cv.findByUrbanVillage", query = "SELECT c FROM Cv c WHERE c.urbanVillage = :urbanVillage"),
    @NamedQuery(name = "Cv.findBySubDistrict", query = "SELECT c FROM Cv c WHERE c.subDistrict = :subDistrict"),
    @NamedQuery(name = "Cv.findByDistrict", query = "SELECT c FROM Cv c WHERE c.district = :district"),
    @NamedQuery(name = "Cv.findByProvince", query = "SELECT c FROM Cv c WHERE c.province = :province"),
    @NamedQuery(name = "Cv.findByPostCode", query = "SELECT c FROM Cv c WHERE c.postCode = :postCode"),
    @NamedQuery(name = "Cv.findByUserName", query = "SELECT c FROM Cv c WHERE c.userName = :userName"),
    @NamedQuery(name = "Cv.findByPassword", query = "SELECT c FROM Cv c WHERE c.password = :password"),
    @NamedQuery(name = "Cv.findByEmail", query = "SELECT c FROM Cv c WHERE c.email = :email")})
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CV_ID")
    private Integer cvId;
    @Size(max = 45)
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Size(max = 45)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 45)
    @Column(name = "URBAN_VILLAGE")
    private String urbanVillage;
    @Size(max = 45)
    @Column(name = "SUB_DISTRICT")
    private String subDistrict;
    @Size(max = 45)
    @Column(name = "DISTRICT")
    private String district;
    @Size(max = 45)
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "POST_CODE")
    private Integer postCode;
    @Size(max = 45)
    @Column(name = "USER_NAME")
    private String userName;
    @Size(max = 45)
    @Column(name = "PASSWORD")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "EMAIL")
    private String email;

    public Cv() {
    }

    public Cv(Integer cvId) {
        this.cvId = cvId;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrbanVillage() {
        return urbanVillage;
    }

    public void setUrbanVillage(String urbanVillage) {
        this.urbanVillage = urbanVillage;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cvId != null ? cvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cv)) {
            return false;
        }
        Cv other = (Cv) object;
        if ((this.cvId == null && other.cvId != null) || (this.cvId != null && !this.cvId.equals(other.cvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firstapp.service.entity.Cv[ cvId=" + cvId + " ]";
    }
    
}
