package com.tz.basemapper.model;

import com.tz.basemapper.config.annotation.Column;
import com.tz.basemapper.config.annotation.Table;

import java.util.Date;

/**
 * @className: User
 * @description:
 * @author: Mr.Lin
 * @create: 2019-05-03 15:56
 * @version: 1.0
 **/
@Table("u_user")
public class User {

    @Column(value = "id", primary = true)
    private Long id;

    private String username;

    private String nickName;

    @Column("create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
