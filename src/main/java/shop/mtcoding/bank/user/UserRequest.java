package shop.mtcoding.bank.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO{
        private String userId;      // 아이디
        private String password;    // 비밀번호
        private String email;       // 이메일
        private String userName;    // 이름
    }

    @Data
    public static class LoginDTO{
        private String userId;      // 아이디
        private String password;    // 비밀번호
    }
}
