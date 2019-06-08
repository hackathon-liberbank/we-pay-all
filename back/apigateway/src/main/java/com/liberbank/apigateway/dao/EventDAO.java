package com.liberbank.apigateway.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class EventDAO {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;

    @Column
    private Long price;

    @ManyToMany
    @JoinTable(name = "users_like", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<UserDAO> users;

    public EventDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public EventDAO(Long id, String description, Long price, Set<UserDAO> users) {
        super();
        this.id = id;
        this.description = description;
        this.price = price;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Set<UserDAO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDAO> users) {
        this.users = users;
    }

}
