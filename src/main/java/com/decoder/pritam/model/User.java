package com.decoder.pritam.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column(unique=true)
	private String email;
	
	private String username;
	private String password;
	private String phoneNumber;
	private String role;
	
	@CreationTimestamp
	private Date createdAt;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Property> properties;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Favorite> favorites;
	
	@OneToMany(mappedBy="sender", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Message> messagesSent;
	 
	@OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Message> messagesReceived;
	
}
