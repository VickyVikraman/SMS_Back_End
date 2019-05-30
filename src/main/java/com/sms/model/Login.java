package com.sms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="admin_login",uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
            }),
            @UniqueConstraint(columnNames = {
                "email"
            })
})      
public class Login {
	public Login()
	{
		
	}
    public Login(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
			@NotBlank @Size(max = 100) String password, @NotBlank @Size(max = 40) @Email String email, @NotBlank Boolean newUser) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.newUser = newUser;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotBlank
    @Size(max = 40)
    private String name;
    
    @NotBlank
    @Size(max = 15)
	private String username;
    
    @NotBlank
    @Size(max = 100)
	private String password;
    
    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
	private String email;
    
    @Column(name = "newuser")
    private Boolean newUser;
    
    @Column(name="reset_token")
	private Long resetToken;
    
    @Column(name="token_expiry_at")
    private Date tokenExpiryAt;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Boolean getNewUser() {
		return newUser;
	}
	
	public void setNewUser(Boolean newUser) {
		this.newUser = newUser;
	}
	
	public Long getResetToken() {
		return resetToken;
	}
	
	public void setResetToken(Long resetToken) {
		this.resetToken = resetToken;
	}
	public Date getTokenExpiryAt() {
		return tokenExpiryAt;
	}
	public void setTokenExpiryAt(Date date) {
		this.tokenExpiryAt = date;
	}
	
	
  
}
