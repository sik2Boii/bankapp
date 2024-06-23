package shop.mtcoding.bank.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Id 값으로 조회하는 메서드
    // 'Optional'은 값이 존재할 수도 있고 존재하지 않을 수도 있는 컨테이너입니다.
    Optional<User> findByUserId(String userId);
}
