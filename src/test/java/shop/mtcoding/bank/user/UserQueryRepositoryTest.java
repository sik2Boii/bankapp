package shop.mtcoding.bank.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import({UserQueryRepository.class})
public class UserQueryRepositoryTest {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Test
    public void findByIdAndPasswordV1_Test(){
        // given
        String id = "stud";
        String pw = "1234";

        // when
        User user = userQueryRepository.findUserIdAndPasswordV1(id);

        // then
        System.out.println("#####ID: " + user.getUserId());
        System.out.println("#####Password: " + user.getPassword());
        System.out.println("#####Email: " + user.getEmail());
        System.out.println("#####UserName: " + user.getUserName());
    }
}
