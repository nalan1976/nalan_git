package com.nalan.batis.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable{
    int id;
    String username;
    String password;
}
