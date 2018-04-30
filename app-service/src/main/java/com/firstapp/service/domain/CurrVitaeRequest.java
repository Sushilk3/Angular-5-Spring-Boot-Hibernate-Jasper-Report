package com.firstapp.service.domain;

import java.util.List;

import com.firstapp.service.entity.Cv;

public class CurrVitaeRequest {
	
	private Integer cvId;
	private String name;
	private Integer age;
	private String address;
	private String urbanVillage;
	private String subDistrict;
	private String district;
	private String province;
	private Integer postCode;
	
	private List<Cv> listDataCv;

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

	public List<Cv> getListDataCv() {
		return listDataCv;
	}

	public void setListDataCv(List<Cv> listDataCv) {
		this.listDataCv = listDataCv;
	}
	
	

}
