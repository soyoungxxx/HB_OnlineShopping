package domain;

import lombok.Data;

@Data
public class Member {
    private int member_no;
    private String name;
    private String id;
    private String password;
    private String tel;
}
