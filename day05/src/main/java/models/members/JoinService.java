package models.members;

import commons.Validator;
import controllers.member.RequestJoin;

public class JoinService {
    private Validator validator;
    private MemberDao memberDao;

    public JoinService(Validator validator, MemberDao memberDao) {
        this.validator = validator;
        this.memberDao = memberDao;
    }

    public void join(RequestJoin form) {

        validator.check(form);


        //memberDao.register(from);
      }

}
