package domain;

import lombok.Data;

@Data
public class Member {
    private String member_name;
    private String id;
    private String password;
    private String tel;
}
