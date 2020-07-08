package com.mitbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author pengzhengfa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;
}
