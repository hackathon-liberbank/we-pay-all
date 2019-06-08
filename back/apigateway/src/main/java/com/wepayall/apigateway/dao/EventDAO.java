package com.wepayall.apigateway.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class EventDAO {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;

    @Column
    private String name;

    @Column
    private Long price;

    @ManyToMany
    @JoinTable(name = "users_like", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
    private Set<UserDAO> users;

    public EventDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public EventDAO(String description, String name, Long price, Set<UserDAO> users) {
        super();
        this.description = description;
        this.name = name;
        this.price = price;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
