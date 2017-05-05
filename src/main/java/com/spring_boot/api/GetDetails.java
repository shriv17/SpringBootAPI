package com.spring_boot.api;

import com.spring_boot.dao.ConnectionManager;
import com.spring_boot.models.MemberModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 5/5/2017.
 */
@RestController
public class GetDetails {


    @RequestMapping("/GetMemberDetails, method=GET")
    public MemberModel getMemberDetails(@RequestParam(value="email", defaultValue = "") String email){
        MemberModel model = null;
        ConnectionManager man = new ConnectionManager();
        model = man.getMemberDetails(email);
        return model;
    }
}
