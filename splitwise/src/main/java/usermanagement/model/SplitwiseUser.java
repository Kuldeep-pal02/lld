package usermanagement.model;

import lombok.Data;
import usermanagement.acl.MyRole;

import java.util.List;

@Data
public class SplitwiseUser {

    private String userId;
    private String name;
    private String email;
    private String passwordHash;
    private List<MyRole> roleList;
}
