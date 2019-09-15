package com.pib.admin.entity;

import org.apache.commons.lang.StringUtils;

import com.pib.admin.model.builder.AbstractBuilder;
import com.pib.admin.nullhandler.NotNullObject;
import com.pib.admin.nullhandler.NullObject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Person implements Serializable, NotNullObject {
	private Long id;
    private String type;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String imgsrc;
    private String location;
    private String jobTitle;
    private Long accountId;
    private Account account;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public static final Null NULL = new Null();
    
    public void fillNotRequire() {
    	firstName = firstName != null ? firstName : "";
    	lastName = lastName != null ? lastName : "";
    	phone = phone != null ? phone : "";
    	jobTitle = jobTitle != null ? jobTitle : "";
        imgsrc = imgsrc != null ? imgsrc : "";
        location = location != null ? location : "";
   }
    public void createAt() {
        createAt =  LocalDateTime.now(ZoneId.of("UTC"));
    }
    public void updateAt() {
        updateAt =  LocalDateTime.now(ZoneId.of("UTC"));
    }
    private static class Null extends Person implements NullObject { 
    }
    public static class Builder extends AbstractBuilder {
        @Override
        public Person build() {
            try {
                return super.build(Person.class);
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
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        if (!StringUtils.isEmpty(phone) && phone.length() == 10) {
            phone = "1" + phone; //自动加美国区号
        }
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

	 

    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}


    public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", type=" + type + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", email=" + email + ", imgsrc=" + imgsrc + ", location=" + location
				+ ", jobTitle=" + jobTitle + ", accountId=" + accountId + ", createAt=" + createAt + ", updateAt="
				+ updateAt + "]";
	}
 
	 
	 
 
 

    
}
