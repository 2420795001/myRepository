package com.pandawork.common.entity.user;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author : kongyy
 * @time : 2018/7/28 16:38
 */

@Table(name = "t_user")
@Entity
public class Users extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Id
    private int id;

    //get和set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 需要把toString()方法重写。
     * @return
     */
    @Override
    public String toString() {
        return "Users{" +
                "name=" + name +
                ", passwored ='" + password + '\'' +
                "id="+
                '}';
    }
}

