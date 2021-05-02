package ee.bcs.valiit.exercises.allusers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
public class LoginController2 {

    @Autowired
    private LoginService loginService;


    //    URL: http://localhost:8080/api/public/loginuser/
    @PutMapping("public/loginuser")
    public String loginUsername(@RequestBody AllUsersData allUsersData) {
        return loginService.loginUsername(allUsersData);
    }

    //    URL: http://localhost:8080/api/public/createuser/
    @PostMapping("public/createuser")
    public void createUser(@RequestBody AllUsersData allUsersData2) {
        loginService.createUser(allUsersData2);
    }
}
