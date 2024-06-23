package shop.mtcoding.bank.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

    private final EntityManager em;

    // 로그인 처리를 위해 아이디로 사용자 아이디와 비밀번호를 조회하는 메서드
    public User findUserIdAndPasswordV1(String userId) {
        // 네이티브 쿼리를 사용하여 user_tb 테이블에서 user_id와 password를 조회합니다.
        Query query = em.createNativeQuery("select user_id, password from user_tb where user_id=?");
        query.setParameter(1, userId);

        try {
            // 쿼리 결과를 단일 객체 배열로 받습니다.
            Object[] obs = (Object[]) query.getSingleResult();

            // User 객체를 생성하고 조회된 user_id와 password를 설정합니다.
            User user = new User();
            user.setUserId((String) obs[0]);
            user.setPassword((String) obs[1]);

            return user;
        } catch (Exception e) {
            return null;
        }
    }
}