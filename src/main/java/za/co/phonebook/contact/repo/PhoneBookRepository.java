package za.co.phonebook.contact.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.phonebook.contact.domain.PhoneDetail;

public interface PhoneBookRepository extends JpaRepository<PhoneDetail, Integer> {
}
