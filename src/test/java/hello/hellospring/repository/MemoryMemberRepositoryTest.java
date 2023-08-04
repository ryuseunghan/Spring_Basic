package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    //Test 주도 개발에서는 반대로 Test case를 먼저 작성 후 거기에 맞춰서 개발

    @AfterEach//메서드 실행 끝날 때마다 특정 메서드 실행
    public void afterEach(){
        repository.clearStore();
    }
    //Test는 서로 순서와 상관 없어야하며 의존관계가 있어서는 안됨 그러기 위해서 AfterEach 이용
    @Test
    public void save(){
        //잘 저장되는지를 테스트
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        //repository에 저장

        Member result = repository.findById(member.getId()).get();
        //반환 타입이 optional일 시 get()으로 꺼낼 수 있음, 좋은 방법은 아님
        System.out.println("result = "+(result == member));//기본적인 방법
        assertEquals(member, result);//2번째 방법, 다를 시 null/빨간불
        assertThat(member).isEqualTo(result);//3번째 방법

    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
