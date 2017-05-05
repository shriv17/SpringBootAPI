package springBoot.api;

import org.springframework.web.bind.annotation.*;
import springBoot.dao.ConnectionManager;
import springBoot.models.MemberModel;

/**
 * Created by Administrator on 5/5/2017.
 */
@RestController
public class ServerInteraction {

    ConnectionManager man = new ConnectionManager();

    @RequestMapping("/GetMemberDetails")
    public MemberModel getMemberDetails(@RequestParam(value="email", defaultValue = "") String email){
        MemberModel model = null;
        if(!email.equals("")) {
            model = man.getMemberDetails(email);
            return model;
        }
        else{
            model = new MemberModel();
            model.setError("Email is required");
            return model;
        }
    }
    @RequestMapping(value = "/InsertMember", method= RequestMethod.POST)
    public String insertMember(@RequestBody MemberModel model){
        return man.insertMember(model.getName(), model.getEmail(), model.getPhone(), model.getId());
    }
}
