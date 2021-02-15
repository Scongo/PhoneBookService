package za.co.phonebook.contact.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.phonebook.contact.dto.PhoneDTO;
import za.co.phonebook.contact.repo.PhoneBookRepository;
import za.co.phonebook.contact.service.PhoneBookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/phonebook")
@Api(value = "Phone book management api", tags = {"manages operations on a phone book."})
public class PhoneBookController {

    private PhoneBookService phoneBookService;

    @Autowired
    public PhoneBookController(PhoneBookService phoneBookService){
        this.phoneBookService = phoneBookService;
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    @ApiOperation(value = "load all contact details")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<PhoneDTO>> getAllContact(){
        List<PhoneDTO> phoneDTOList = new ArrayList<>();
        phoneDTOList = phoneBookService.getAllContact();
        return ResponseEntity.ok(phoneDTOList);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "save contact details")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<String> save(@RequestBody PhoneDTO phoneDTO){
        String result;
        try {
            result = phoneBookService.addContact(phoneDTO);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "search contact details by name")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<PhoneDTO> search(@RequestParam String name){
        PhoneDTO result;
        try {
            result = phoneBookService.searchByName(name);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
