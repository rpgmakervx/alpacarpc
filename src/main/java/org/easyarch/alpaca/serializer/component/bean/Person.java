package org.easyarch.alpaca.serializer.component.bean;

import org.easyarch.alpaca.serializer.component.annotation.Member;

import java.io.Serializable;

/**
 * Description :
 * Created by xingtianyu on 16-12-3
 * 上午1:37
 */

public class Person implements Serializable{

    @Member
    private String id;

    @Member
    private String username;

    @Member
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
