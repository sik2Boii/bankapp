package shop.mtcoding.bank.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void join_test() {
        // given (데이터준비)
        String userId = "haha";
        String password = "1234";
        String email = "haha@nate.com";
        String userName = "하하";

        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserName(userName);

        // when
        userRepository.save(user);
    }
}
