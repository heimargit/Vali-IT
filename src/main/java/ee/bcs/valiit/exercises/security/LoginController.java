//package ee.bcs.valiit.exercises.security;
//
//import ee.bcs.valiit.exercises.repository.Lesson4bRepository;
//import ee.bcs.valiit.solution.exception.SampleApplicationException;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//
//@RequestMapping("api")
//@RestController
//public class LoginController {
//
//    @Autowired
//    private Lesson4bRepository lesson4bRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    @PutMapping("/public/login")
//    public String login(@RequestBody LoginRequest loginRequest) {
//        //if (loginRequest.getPassword().equals(loginRequest.getUsername())) {
//        if (passwordEncoder.matches(loginRequest.getPassword(), lesson4bRepository.login(loginRequest.getUsername()))) {
//            Date today = new Date();
//            Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60 * 25);
//            JwtBuilder jwtBuilder = Jwts.builder()
//                    .setExpiration(tokenExpirationDate)
//                    .setIssuedAt(new Date())
//                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
//                    .claim("username", loginRequest.getUsername());
//            return jwtBuilder.compact();
//        } else {
//            throw new SampleApplicationException("Incorrect password");
//        }
//    }
//
//
//    @PostMapping("/api/public/register")
//    public void createUser(@RequestBody LoginRequest loginRequest) {
//        String encodedPassword = passwordEncoder.encode(loginRequest.getPassword());
//        lesson4bRepository.createUser(loginRequest.getUsername(), encodedPassword);
//    }
//
//
//}
