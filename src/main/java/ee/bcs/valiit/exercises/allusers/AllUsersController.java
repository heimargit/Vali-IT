package ee.bcs.valiit.exercises.allusers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api")
@RestController
public class AllUsersController {

    @Autowired
    private AllUsersService allUsersService;


    //    URL: http://localhost:8080/api/login/
    @GetMapping("/login")
    public String loginUsername(@RequestBody AllUsersData allUsersData) {
        return allUsersService.loginUsername(allUsersData);
    }

    @PostMapping("")
    public void createUsername(@RequestBody AllUsersData allUsersData) {
        allUsersService.createUsername(allUsersData);
    }
}
