package com.testNeoris.TestNeoris.Controllers;

import com.testNeoris.TestNeoris.DTO.NewPeopleDTO;
import com.testNeoris.TestNeoris.DTO.PeopleDTO;
import com.testNeoris.TestNeoris.DTO.People_DTO;
import com.testNeoris.TestNeoris.DTO.UpdatePeople;
import com.testNeoris.TestNeoris.Services.PeopleServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("people")
public class PeopleController {
    Logger logger = LoggerFactory.getLogger(PeopleController.class);
    @Autowired
    private PeopleServices peopleServices;

    @GetMapping("")
    public ResponseEntity<PeopleDTO> getDataCountry(){
        PeopleDTO peopleDTO = peopleServices.getPeople();
        ResponseEntity<PeopleDTO> responseEntity
                = new ResponseEntity<PeopleDTO>(peopleDTO, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<People_DTO> getUserDto(@PathVariable int user_id){
        People_DTO people_dto = peopleServices.getDataUser(user_id);
        HttpStatus httpStatus = people_dto.getUser_uniqid() == 0 ? HttpStatus.NOT_FOUND:HttpStatus.OK;
        return new ResponseEntity<People_DTO>(people_dto, httpStatus);
    }

    @PostMapping
    public ResponseEntity<People_DTO> createNewDataDemo(@RequestBody NewPeopleDTO newPeopleDTO){
        logger.info("POST....."+newPeopleDTO);
        People_DTO people_dto = peopleServices.createUser(newPeopleDTO);
        return new ResponseEntity<People_DTO>(people_dto, HttpStatus.CREATED);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<People_DTO> getUserRecordsDTO(@PathVariable int user_id,
                                                        @RequestBody UpdatePeople updatePeople){
        People_DTO people_dto =  peopleServices.updateUser(user_id,updatePeople);
        return new ResponseEntity<People_DTO>(people_dto, HttpStatus.OK);
    }

}
