package ee.bcs.valiit.exercises.allusers;



import ee.bcs.valiit.solution.exception.SampleApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginRepository loginRepository;


    public String loginUsername(AllUsersData allUsersData) {
//        String password = loginRepository.getPasswordByUsername(allUsersData.getUsername());     //<---- TOKENIGA SISSELOGIMINE
//        if (allUsersData.getPassword().equals(password)) {
        String encodedPassword = loginRepository.getPasswordByUsername(allUsersData.getUsername()); // <--- HASHITUD PAROOLIGA SISSELOGIMINE
        if (passwordEncoder.matches(allUsersData.getPassword(), encodedPassword)) {
            Date today = new Date();
            Date tokenExpirationDate = new Date(today.getTime() + 1000 * 60 * 60 * 25);
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setExpiration(tokenExpirationDate)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
                    .claim("username", allUsersData.getUsername());
            return jwtBuilder.compact();
        } else {
            throw new SampleApplicationException("Incorrect password");
        }
    }


    public void createUser(AllUsersData allUsersData2) {
//        String password = allUsersData2.getPassword();
//        loginRepository.createUser(allUsersData2.getUsername(), password);
        String encodedPassword = passwordEncoder.encode(allUsersData2.getPassword());   // <--- KASUTAJA LOOMINE, ET ANDMEBAASI SALVESTUB HASHITUD PAROOL
        loginRepository.createUser(allUsersData2.getUsername(), encodedPassword);
    }


}
