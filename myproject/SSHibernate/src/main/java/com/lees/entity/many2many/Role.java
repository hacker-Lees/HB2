package com.lees.entity.many2many;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/28.
 */
@Entity
@Table(name = "tb_role")
public class Role {
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
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorGroups=" + authorGroups +
                '}';
    }

    //////////////////////////////////////////
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_role_authorgroup",joinColumns = {@JoinColumn(name = "role_id")},inverseJoinColumns = {@JoinColumn(name = "authorgroup_id")})
    private Set<AuthorGroup> authorGroups;

    public Set<AuthorGroup> getAuthorGroups() {
        return authorGroups;
    }

    public void setAuthorGroups(Set<AuthorGroup> authorGroups) {
        this.authorGroups = authorGroups;
    }
}
