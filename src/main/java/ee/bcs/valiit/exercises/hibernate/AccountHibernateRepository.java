package ee.bcs.valiit.exercises.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHibernateRepository extends JpaRepository<Account, String> { //DTO ja primaarvõti
}
