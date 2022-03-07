package com.koreait.cgvproject.dto;

import com.koreait.cgvproject.entity.AdminNewsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor // 모든 생성자를 자동으로 만들게 해주는 롬복
@ToString // toString 쓸수있게해줌
@Data
public class Admin_News_DTO {

    private Long idx; // 업데이트를 위한 idx
    private String title;
    private String content;
    private String category;
//    private int hit;
    private LocalDateTime regdate;

    public AdminNewsEntity toEntity(){
        return new AdminNewsEntity(idx,title,content,category,0,regdate.now());
    }
}
