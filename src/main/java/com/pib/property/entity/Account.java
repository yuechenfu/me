package com.pib.property.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pib.nullhandler.NotNullObject;
import com.pib.nullhandler.NullObject;
import com.pib.property.model.builder.AbstractBuilder;
import com.pib.util.DigestUtil;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Account implements Serializable, NotNullObject {
    private Long id;
    private String username;
    @JsonIgnore
    private String password; 
    private String type;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public void fillNotRequire() {
    	type = type != null ? type : "SE";
        status = status != null ? status : "Active";
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

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

     

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", status=" + status + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}



	 
}