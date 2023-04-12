package com.example.thebest_youdo.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@EqualsAndHashCode
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "authority_name")
    private String authorityName;

    @ManyToOne(optional = false)
    private User user;

    public Authority() {
    }
    public Authority(String authority) {
        this.authorityName = authority;
    }
    @Override
    public String getAuthority() {
        return authorityName;
    }
}
