package usermanagement.acl;

import lombok.Data;

import java.util.List;

@Data
public class MyRole {
    String roleId;
    String roleName;
    List<MyPermission> permissionList;
}
