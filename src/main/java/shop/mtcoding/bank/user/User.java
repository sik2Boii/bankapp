package shop.mtcoding.bank.user;

import jakarta.persistence.*;
import lombok.Data;

// JPA 엔티티 클래스이며 데이터베이스의 "user_tb" 테이블과 매핑됨을 명시
@Table(name = "user_tb")
@Entity
@Data
public class User {

    // 기본 키(PK)이며, 자동 증가 전략을 사용하여 값 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;         // PK

    // 고유한 값으로 설정
    @Column(unique = true)
    private String userId;      // 아이디

    // 최대 길이를 12로 설정
    @Column(length = 12)
    private String password;    // 비밀번호

    private String email;       // 이메일

    private String userName;    // 이름
}
