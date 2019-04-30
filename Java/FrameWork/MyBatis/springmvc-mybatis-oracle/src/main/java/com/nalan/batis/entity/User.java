package com.nalan.batis.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class User implements Serializable{
    int id;
    String username;
    String password;
    byte[] photo;
}
