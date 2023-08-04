package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스 간의 상속은 extends
//멤버의 id는 Long이기 때문에
//SpringDataJpaMemberRepository는 상속받는 인터페이스의 구현체를 자동으로 만들어줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
