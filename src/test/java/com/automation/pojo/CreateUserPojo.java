package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CreateUserPojo {
      int id;
      String username;
      String firstName;
      String lastName;
      String email;
      String password;
      String phone;
      String userStatus;
}
