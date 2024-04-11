package contolloer;

import domain.Member;
import repository.MemberRepository;
import repository.Service;

public class MemberController implements Controller<Member> {
    private Service service = new MemberRepository();
    public void create(Member mem) {
        service.create(mem);
    }
    public void update(Member mem) {

    }
    public void delete(Member mem) {

    }
    public void read(Member mem) {

    }

    public void loginController(String id, String pwd) {
        s
    }
}
