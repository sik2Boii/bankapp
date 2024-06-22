package shop.mtcoding.bank.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO{
        private String userId;      // 아이디
        private String password;    // 패스워드
        private String email;       // 이메일
        private String userName;    // 이름
    }
}
