package com.chj.model;

import lombok.Data;

import java.util.Date;

/**
 * @author ：chj
 * @date ：Created in 2021/2/16 19:23
 * @params :  实体
 */
@Data
public class UserVo {
    private Integer id;

    private String username;

    private String password;

    private String created;
}
