package oath.server.auth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUser implements UserDetails{

	private String password;
	private String username;
	private String email;
	
	private boolean isAccountNonLocked;
	private boolean isAccountNonExpired;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	
	public AppUser(String password, String username, String email, boolean isAccountNonLocked, boolean isAccountNonExpired,
			boolean isCredentialsNonExpired, boolean isEnabled) {
		super();
		this.password = password;
		this.username = username;
		this.email = email;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return authorities;
	}

}
