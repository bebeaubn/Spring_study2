package models.members;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder @Data
@NoArgsConstructor @AllArgsConstructor
public class Member {
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String email;
    private String mobile;
    private LocalDateTime regDt; // 가입일시
    private LocalDateTime modDt;
}