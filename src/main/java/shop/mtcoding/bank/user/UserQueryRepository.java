package shop.mtcoding.bank.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

    private final EntityManager em;

    // 네이티브 쿼리로 객체에 직접 파싱하여 로그인 구현하기
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

    // 네이티브 쿼리로 JPA를 사용하여 로그인 구현하기
    public User findUserIdAndPasswordV2(String userId) {
        // 네이티브 쿼리를 사용하여 user_tb 테이블에서 user_id에 해당하는 전체 User 객체를 조회합니다.
        Query query = em.createNativeQuery("select * from user_tb where user_id=?", User.class);
        query.setParameter(1, userId);

        try {
            // User 클래스에 디폴트 생성자가 있어야 Hibernate가 new를 통해 객체를 생성하여 파싱해줍니다.
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    // JPQL을 사용하여 로그인 구현
    public User findUserIdAndPasswordV3(String userId) {
        // JPQL을 사용하여 User 엔티티에서 userId에 해당하는 전체 User 객체를 조회합니다.
        Query query = em.createQuery("select u from User u where u.userId=:userId", User.class);
        query.setParameter("userId", userId);

        try {
            // User 클래스에 디폴트 생성자가 있어야 Hibernate가 new를 통해 객체를 생성하여 파싱해줍니다.
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}