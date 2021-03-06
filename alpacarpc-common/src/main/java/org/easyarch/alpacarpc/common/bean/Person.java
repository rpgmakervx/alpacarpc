package org.easyarch.alpacarpc.common.bean;

import org.easyarch.alpacarpc.common.annotation.RPCEntity;
import org.easyarch.alpacarpc.common.annotation.Transient;

import java.io.Serializable;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 上午1:37
 */
@RPCEntity
public class Person implements Serializable{

    private String id;

    private String username;
    @Transient
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
