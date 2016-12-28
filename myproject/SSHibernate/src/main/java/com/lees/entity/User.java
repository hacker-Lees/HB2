package com.lees.entity;

import org.hibernate.annotations.IndexColumn;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Component
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String password;
    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "province",column = @Column(name = "p",length = 32)),
//            @AttributeOverride(name = "city",column = @Column(name = "c",length = 32))
//    })
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    ///////////////////////////
    @ElementCollection
    @JoinTable(name = "tb_set",joinColumns = {@JoinColumn(name = ("user_id"))})
    @Column(name = "cardNo")
    private Set<String> cardNo=new HashSet<String>();

    public Set<String> getCardNo() {
        return cardNo;
    }

    public void setCardNo(Set<String> cardNo) {
        this.cardNo = cardNo;
    }
    //////////////////////////////////////////
    @ElementCollection
    @JoinTable(name = "tb_list",joinColumns = {@JoinColumn(name = "user_id")})
    @Column(name = "roomNo")
    @IndexColumn(name = "list_index")
    private List<Integer> roomNo=new ArrayList<Integer>();

    public List<Integer> getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(List<Integer> roomNo) {
        this.roomNo = roomNo;
    }
    ////////////////////////////////////////
    @ElementCollection
    @JoinTable(name = "tb_map",joinColumns = {@JoinColumn(name = "user_id")})
    @Column(name = "map_value")
    @MapKeyColumn(name = "map_key")
    private Map<String,String> map=new HashMap<String, String>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}