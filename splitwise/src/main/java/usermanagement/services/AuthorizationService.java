package usermanagement.services;

import usermanagement.acl.MyPermission;
import usermanagement.acl.MyRole;
import usermanagement.model.SplitwiseUser;

import java.util.List;

public class AuthorizationService implements  IAuthorizeService{

    private final List<MyRole> roleList ;

    public AuthorizationService( List<MyRole> roleList ) {
        this.roleList = roleList;
    }

    @Override
    public boolean checkAccess( MyPermission permission, SplitwiseUser user ) {

        return roleList.stream().flatMap(role -> role.getPermissionList().stream()).anyMatch(permission1 -> permission1.getPermissionName().equals( permission ));

    }
}
