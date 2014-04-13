package com.immunology.logic.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.UserDao;
import com.immunology.model.Role;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		com.immunology.model.User user = userDao.findByLogin(login);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return buildUserFromUserEntity(user);
	}

	 private User buildUserFromUserEntity(com.immunology.model.User userEntity) {

		    String username = userEntity.getLogin();
		    String password = userEntity.getPassword();
		    boolean enabled = true;//userEntity.isActive();
		    boolean accountNonExpired = true;//userEntity.isActive();
		    boolean credentialsNonExpired = true;//userEntity.isActive();
		    boolean accountNonLocked = true;//userEntity.isActive();

		    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		    for (Role role : userEntity.getRoles()) {
		      authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
		    }

		    User user = new User(username, password, enabled,
		      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		    return user;
		  }
}
