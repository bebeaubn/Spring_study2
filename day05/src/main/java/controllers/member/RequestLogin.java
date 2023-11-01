package controllers.member;

public record RequestLogin(
        String userId,
        String userPw,
        boolean savaId
) {}
