package za.co.phonebook.contact.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.phonebook.contact.dto.PhoneDTO;
import za.co.phonebook.contact.service.PhoneBookService;

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
    public ResponseEntity<PhoneDTO> getAllContact(){
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "save contact details")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<String> save(@RequestParam String name, @RequestParam String lastName, @RequestParam String phone){
        String result;
        result = phoneBookService.addContact(name, lastName, phone);
        return ResponseEntity.ok(result);
    }
}
