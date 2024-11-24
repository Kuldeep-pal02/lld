package usermanagement.services;

import usermanagement.acl.MyPermission;
import usermanagement.model.SplitwiseUser;

public interface IAuthorizeService {
    boolean checkAccess( MyPermission permission, SplitwiseUser user);
}
