package za.co.phonebook.contact.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.phonebook.contact.domain.PhoneDetail;
import za.co.phonebook.contact.dto.PhoneDTO;
import za.co.phonebook.contact.repo.PhoneBookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneBookService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PhoneBookRepository phoneBookRepository;
    @Autowired
    public PhoneBookService(PhoneBookRepository phoneBookRepository){
        this.phoneBookRepository = phoneBookRepository;
    }

    public String addContact(PhoneDTO phoneDTO){
        PhoneDetail phoneDetail = new PhoneDetail();

        phoneDetail.setName(phoneDTO.getName());
        phoneDetail.setLastname(phoneDTO.getLastname());
        phoneDetail.setContactNumber(phoneDTO.getPhone());
        phoneBookRepository.save(phoneDetail);
        return "Contact saved successfully";
    }
    public List<PhoneDTO> getAllContact(){
        List<PhoneDTO> phoneDTOList = new ArrayList<>();
        phoneBookRepository.findAll().forEach(phoneDetail -> {
            PhoneDTO phoneDTO = new PhoneDTO();
            phoneDTO.setName(phoneDetail.getName());
            phoneDTO.setLastname(phoneDetail.getLastname());
            phoneDTO.setPhone(phoneDetail.getContactNumber());
            phoneDTOList.add(phoneDTO);
        });
        return phoneDTOList;
    }

    public PhoneDTO searchByName(String name){
        PhoneDTO phoneDTO = new PhoneDTO();
        PhoneDetail phoneDetail = new PhoneDetail();
        phoneDetail = phoneBookRepository.getPhoneDetail(name);
        phoneDTO.setName(phoneDetail.getName());
        phoneDTO.setLastname(phoneDetail.getLastname());
        phoneDTO.setPhone(phoneDetail.getContactNumber());

        return phoneDTO;
    }

    public void update(PhoneDTO phoneDTO){
        PhoneDetail phoneDetail = new PhoneDetail();

        phoneDetail.setName(phoneDTO.getName());
        phoneDetail.setLastname(phoneDTO.getLastname());
        phoneDetail.setContactNumber(phoneDTO.getPhone());
        phoneBookRepository.save(phoneDetail);
    }
}
