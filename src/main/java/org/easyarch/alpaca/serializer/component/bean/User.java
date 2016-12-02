package org.easyarch.alpaca.serializer.component.bean;

import org.easyarch.alpaca.serializer.component.annotation.Member;
import org.easyarch.alpaca.serializer.component.annotation.NotMember;
import org.easyarch.alpaca.serializer.component.annotation.RPCEntity;

import java.io.Serializable;

/**
 * Description :
 * Created by xingtianyu on 16-11-27
 * 下午12:24
 */
@RPCEntity
public class User implements Serializable{

    @Member
    private String username;

    @Member
    private String id;

    @Member
    private String mobile;

    @NotMember
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
