package hello.hellospring.domain;

import javax.persistence.*;

@Entity//jpa가 관리하는 entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //db에서 id자동설정을 identity
    private Long id;//임의의 값, 시스템이 지정

    //@Column(name="username") col명이 username일시 자동매핑
    private String name;

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
}
