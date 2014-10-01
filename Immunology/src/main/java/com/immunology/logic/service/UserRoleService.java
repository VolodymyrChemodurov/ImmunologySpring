package com.immunology.logic.service;

import com.immunology.logic.utils.enums.UserRoles;
import com.immunology.model.Role;

public interface UserRoleService {

	Role getRoleByName(UserRoles role);
}
