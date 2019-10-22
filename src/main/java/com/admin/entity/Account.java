package com.admin.entity;

import com.admin.model.builder.AbstractBuilder;
import com.admin.nullhandler.NotNullObject;
import com.admin.nullhandler.NullObject;
import com.admin.util.DigestUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Account implements Serializable, NotNullObject {
    private Long id;
    private String email;
    private String username;
    private String nickname;
    private String password; 
    private String phone;
    private String company;
    private String location;
    private String gender;
    private String imgsrc;
    private String source;
    private String remark;
    private String type;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public void fillNotRequire() {
    	username = username != null ? username : "unknown";
    	phone = phone != null ? phone : "000";
    	password = password != null ? password : "123456";
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

    private static class Null extends Account implements NullObject {
    }

    public static class Builder extends AbstractBuilder {
        @Override
        public Account build() {
            try {
                return super.build(Account.class);
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

    public String getUsername() {
        return username;
    }

   

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsername(String username) {
        if (!StringUtils.isEmpty(username) && username.length() == 10 && username.indexOf("@") == -1) { //如果是电话
            username = "1" + username; //自动加美国 电话区号
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", nickname=" + nickname
				+ ", password=" + password + ", phone=" + phone + ", company=" + company + ", location=" + location
				+ ", gender=" + gender + ", imgsrc=" + imgsrc + ", source=" + source + ", remark=" + remark
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

     
  


	 
}