package za.co.phonebook.contact.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.phonebook.contact.domain.PhoneDetail;

public interface PhoneBookRepository extends JpaRepository<PhoneDetail, Integer> {
    @Query("select p from PhoneDetail p where p.name = :name")
    PhoneDetail getPhoneDetail(@Param("name") String name);
}
