package ee.bcs.valiit.exercises.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class LoginController {

    @PutMapping("/api/public/login")
    public String login(@RequestBody LoginRequest loginRequest){
       Date today = new Date();
        Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60 * 25);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setExpiration(tokenExpirationDate)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
                .claim("username", loginRequest.getUsername());
                return jwtBuilder.compact();
    }
}
