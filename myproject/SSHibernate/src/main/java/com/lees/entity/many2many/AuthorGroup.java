package com.lees.entity.many2many;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/28.
 */
@Entity
@Table(name = "tb_authorgroup")
public class AuthorGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }

    ///////////////////////////////
    @ManyToMany(mappedBy = "authorGroups",cascade = CascadeType.ALL)
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
