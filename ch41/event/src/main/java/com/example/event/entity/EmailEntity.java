package com.example.event.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NonNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : event
 * @Package : com.example.event.entity
 * @ClassName : .java
 * @createTime : 2023/6/15 14:45
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@TableName("email")
public class EmailEntity {
    @TableId(type = IdType.AUTO)
    private long id;
    @TableField
    @NonNull
    private String address;
    @TableField
    @NonNull
    private String content;

    public Email toEmail() {
        return new Email(this.getAddress(), this.getContent());
    }
}