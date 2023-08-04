package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//회원 저장
    Optional<Member> findById(Long id);//id로 찾음
    Optional<Member> findByName(String name);//name으로 찾음
    //Optional null을 처리하는 방식, java 8 기능
    List<Member> findAll();
}
