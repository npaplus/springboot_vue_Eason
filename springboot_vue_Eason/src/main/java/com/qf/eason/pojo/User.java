package com.qf.eason.pojo;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.Data;

/**
 * Created by ZhangDian on 2019/7/17.
 */
@Data
public class User {
    /*`tb_user_id` int(20) NOT NULL,
  `tb_user_nickname` varchar(50) DEFAULT NULL,
  `tb_user_phone` varchar(50) DEFAULT NULL,
  `tb_user_img` varchar(50) DEFAULT NULL,*/

    private Integer userId;
    private String userNickname;
    private String userPhone;
    private String userPassword;
    private String userImg;

}
