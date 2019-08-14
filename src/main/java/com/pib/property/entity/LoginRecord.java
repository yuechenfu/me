package com.pib.property.entity;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.pib.nullhandler.NotNullObject;
import com.pib.nullhandler.NullObject;
import com.pib.property.model.builder.AbstractBuilder;



public class LoginRecord implements Serializable, NotNullObject {

    private Long id;
    private String personId;
    private String ip;
    private String device;
    private LocalDateTime updateAt;

    public static final Null NULL = new Null();
    public void updateAt() {
        updateAt =  LocalDateTime.now(ZoneId.of("UTC"));
    }
    public void fillNotRequire() {
        ip = ip != null ? ip : "";
        device = device != null ? device : "";
    }

    private static class Null extends LoginRecord implements NullObject {
    }
    public static class Builder extends AbstractBuilder {
        @Override
        public LoginRecord build() {
            try {
                return super.build(LoginRecord.class);
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

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", personId=" + personId +
                ", updateAt='" + updateAt + '\'' +
                ", ip='" + ip + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}
