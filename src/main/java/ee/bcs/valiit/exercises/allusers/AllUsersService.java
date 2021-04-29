package ee.bcs.valiit.exercises.allusers;


import ee.bcs.valiit.solution.exception.SampleApplicationException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AllUsersService {

    @Autowired
    AllUsersRepository allUsersRepository;


    public String loginUsername(AllUsersData allUsersData) {

        if (allUsersData.getPassword().equals(allUsersData.getUsername())) {
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


    public void createUsername(AllUsersData allUsersData) {
        allUsersRepository.createUsername(allUsersData);
    }


}
