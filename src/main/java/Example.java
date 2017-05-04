import dao.ConnectionManager;
import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Administrator on 5/4/2017.
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/getDetails")
    JSONArray home(){
        ConnectionManager man = new ConnectionManager();
        return man.getResult();
    }
    public static void main(String []args)throws Exception{
        SpringApplication.run(Example.class);
    }
}
