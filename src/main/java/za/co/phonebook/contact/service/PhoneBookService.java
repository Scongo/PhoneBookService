package za.co.phonebook.contact.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.phonebook.contact.domain.PhoneDetail;
import za.co.phonebook.contact.dto.PhoneDTO;
import za.co.phonebook.contact.repo.PhoneBookRepository;

@Service
public class PhoneBookService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PhoneBookRepository phoneBookRepository;
    @Autowired
    public PhoneBookService(PhoneBookRepository phoneBookRepository){
        this.phoneBookRepository = phoneBookRepository;
    }

    public String addContact(String name, String lastname, String phone){
        PhoneDetail phoneDetail = new PhoneDetail();
        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDetail.setName(name);
        phoneDetail.setLastname(lastname);
        phoneDetail.setContactNumber(phone);
        phoneBookRepository.save(phoneDetail);
        return "Contact saved successfully";
    }
}
