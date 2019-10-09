package com.pib.admin.entity;

import com.pib.admin.model.builder.AbstractBuilder;
import com.pib.admin.nullhandler.NotNullObject;
import com.pib.admin.nullhandler.NullObject;
import com.pib.admin.util.DigestUtil;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class Agent implements Serializable, NotNullObject {
    private Long id;
    private String firstname;
    private String lastname;
    private String password; 
    private String phone;
    private String email;
    private String city;
    private String state;
    private String postcode;
    private String company;
    private String location;
    private String gender;
    private String aboutme;
    private String photoUrl;
    private byte[] photo;
    private String remark;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public void fillNotRequire() {
    	phone = phone != null ? phone : "000";
    	password = password != null ? password : "1";
    }

    public void createAt() {
        createAt = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public void updateAt() {
        updateAt = LocalDateTime.now(ZoneId.of("UTC"));
    }

    public void md5Password(){
        if(this.getPassword()!=null){
            this.setPassword(DigestUtil.md5(this.getPassword()));
        }
    }

    public static final Null NULL = new Null();

    private static class Null extends Agent implements NullObject {
    }

    public static class Builder extends AbstractBuilder {
        @Override
        public Agent build() {
            try {
                return super.build(Agent.class);
            } catch (InstantiationException | IllegalAccessException e) {
                return NULL;
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	 

	 
 



	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}


	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", city=" + city + ", state=" + state + ", postcode="
				+ postcode + ", company=" + company + ", location=" + location + ", gender=" + gender + ", aboutme="
				+ aboutme + ", photoUrl=" + photoUrl + ", photo=" + Arrays.toString(photo) + ", remark=" + remark
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

	 


 
	 

 

 
  
     
  


	 
}