package shop.mtcoding.bank.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 이 클래스가 Spring MVC의 서비스임을 나타냅니다.
// Lombok 어노테이션으로, final 필드에 대해 생성자를 자동으로 생성합니다.
@Service
@RequiredArgsConstructor
public class UserService {

    // UserRepository 주입받기 위한 final 필드
    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;

    // 사용자가 회원가입 요청을 할 때 호출되는 메서드입니다.
    public void join(UserRequest.JoinDTO reqDTO) {
        // UserRequest.JoinDTO를 User 엔티티로 변환
        User user = new User();
        user.setUserId(reqDTO.getUserId());
        user.setPassword(reqDTO.getPassword());
        user.setEmail(reqDTO.getEmail());
        user.setUserName(reqDTO.getUserName());

        // User 엔티티를 저장
        userRepository.save(user);
    }

    // 사용자가 로그인 요청을 할 때 호출되는 메서드입니다.
    public User login(UserRequest.LoginDTO reqDTO) {
        // 사용자 ID로 사용자 조회
        User user = userQueryRepository.findUserIdAndPasswordV1(reqDTO.getUserId());
        if (user == null) throw new RuntimeException("존재하지 않는 ID입니다.");

        // 비밀번호 검증
        if (!user.getPassword().equals(reqDTO.getPassword())) throw new RuntimeException("비밀번호가 틀렸습니다.");

        return user;
    }
}

