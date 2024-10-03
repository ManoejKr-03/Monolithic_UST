package com.example.monolithic_spring_security.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="user_details")
public class AuthUser {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="authuser_id")
        private int authUserId;
        
        @Column(name="authuser_name")
        private String authUsername;

        @Column(name="authuser_password")
        private String authPassword;

        @ManyToMany(fetch=FetchType.EAGER)
        @JoinTable(name="authuser_role",
        joinColumns = @JoinColumn(name="authuser_id"),
        inverseJoinColumns = @JoinColumn(name="role_id"))
        List<Roles>allRoles;

        public String getName()
        {
                return authUsername;
        }
     
        

    
}
