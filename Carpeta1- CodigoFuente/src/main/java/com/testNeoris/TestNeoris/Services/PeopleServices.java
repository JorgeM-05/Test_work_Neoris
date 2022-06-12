package com.testNeoris.TestNeoris.Services;

import com.testNeoris.TestNeoris.DTO.NewPeopleDTO;
import com.testNeoris.TestNeoris.DTO.PeopleDTO;
import com.testNeoris.TestNeoris.DTO.People_DTO;
import com.testNeoris.TestNeoris.DTO.UpdatePeople;
import com.testNeoris.TestNeoris.Entity.PeopleEntity;
import com.testNeoris.TestNeoris.Repositories.PeopleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServices {
    Logger logger = LoggerFactory.getLogger(PeopleServices.class);

    @Autowired
    private PeopleRepository peopleRepository;


    public PeopleDTO getPeople(){
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setPeople(mapToCountriesDTO(getUsers()));
        return peopleDTO;
    }
    public List<PeopleEntity> getUsers(){
        logger.info("countries :::: --> "+peopleRepository.findAll());
        return peopleRepository.findAll();
    }
    public List<People_DTO> mapToCountriesDTO(List<PeopleEntity> users){
        List<People_DTO> usersDTOs = new ArrayList<People_DTO>();

        if(users.size() > 0) {
            for(PeopleEntity user : users) {
                System.out.println("**** "+users);
                People_DTO people_dto = new People_DTO();
                people_dto.setUser_uniqid(user.getUniqid());
                people_dto.setNames(user.getNames());
                people_dto.setLastNames(user.getLastNames());
                people_dto.setNumber(user.getNumber());
                people_dto.setDateofBirth(user.getDateofBirth());
                people_dto.setPlaceOfBirth(user.getPlaceOfBirth());
                people_dto.setHeight(user.getHeight());
                people_dto.setRh(user.getRh());
                people_dto.setSex(user.getType_sex());
                people_dto.setExpeditionDate(user.getExpeditionDate());
                people_dto.setExpeditionPlace(user.getExpeditionPlace());

                usersDTOs.add(people_dto);
            }
        }
        return usersDTOs;
    }

    //*** Get data user_id

    public People_DTO getDataUser(int user_id){
        logger.info("user :: " + user_id);
        PeopleEntity peopleEntity = peopleRepository.findByUniqid(user_id);

        if(peopleEntity == null){
            return  null;
        }
        return mapToUserDTO(peopleEntity);
    }

    public People_DTO mapToUserDTO(PeopleEntity peopleEntity) {
        logger.info("****************** " +  peopleEntity);

        People_DTO people_dto = new People_DTO();

        if(peopleEntity != null) {
            people_dto.setUser_uniqid(peopleEntity.getUniqid());
            people_dto.setNames(peopleEntity.getNames());
            people_dto.setLastNames(peopleEntity.getLastNames());
            people_dto.setNumber(peopleEntity.getNumber());
            people_dto.setDateofBirth(peopleEntity.getDateofBirth());
            people_dto.setPlaceOfBirth(peopleEntity.getPlaceOfBirth());
            people_dto.setHeight(peopleEntity.getHeight());
            people_dto.setRh(peopleEntity.getRh());
            people_dto.setSex(peopleEntity.getType_sex());
            people_dto.setExpeditionDate(peopleEntity.getExpeditionDate());
            people_dto.setExpeditionPlace(peopleEntity.getExpeditionPlace());
        }
        return people_dto;
    }




    //*** Post update user
    public People_DTO createUser(NewPeopleDTO newPeopleDTO){
        System.out.println("createUser");
        return mapToUserDemographicDTO(createNewUser(newPeopleDTO));
    }

    public PeopleEntity createNewUser(NewPeopleDTO newPeopleDTO){
        logger.info("******  >>>> " + newPeopleDTO);

        PeopleEntity peopleEntity = null;

        //if(isValidNewUserReceptionRecord(newPeopleDTO)){

            peopleEntity = new PeopleEntity();

            peopleEntity.setNames(newPeopleDTO.getNames());
            peopleEntity.setLastNames(newPeopleDTO.getLastNames());
            peopleEntity.setNumber(newPeopleDTO.getNumber());
            peopleEntity.setDateofBirth(newPeopleDTO.getDateofBirth());
            peopleEntity.setPlaceOfBirth(newPeopleDTO.getPlaceOfBirth());
            peopleEntity.setHeight(newPeopleDTO.getHeight());
            peopleEntity.setRh((newPeopleDTO.getRh()));
            peopleEntity.setType_sex(newPeopleDTO.getSex());
            peopleEntity.setExpeditionDate(newPeopleDTO.getExpeditionDate());
            peopleEntity.setExpeditionPlace(newPeopleDTO.getExpeditionPlace());

            peopleRepository.save(peopleEntity);
        //}
        return peopleEntity;
    }

    public People_DTO mapToUserDemographicDTO(PeopleEntity peopleEntity) {
        logger.info("****************** " +  peopleEntity);
        People_DTO people_dto = new People_DTO();

        if(people_dto != null) {
            people_dto.setUser_uniqid(peopleEntity.getUniqid());
            people_dto.setNames(peopleEntity.getNames());

            people_dto.setLastNames(peopleEntity.getLastNames());
            people_dto.setNumber(peopleEntity.getNumber());
            people_dto.setDateofBirth(peopleEntity.getDateofBirth());
            people_dto.setPlaceOfBirth(peopleEntity.getPlaceOfBirth());
            people_dto.setHeight(peopleEntity.getHeight());
            people_dto.setRh(peopleEntity.getRh());
            people_dto.setSex(peopleEntity.getType_sex());
            people_dto.setExpeditionDate(peopleEntity.getExpeditionDate());
            people_dto.setExpeditionPlace(peopleEntity.getExpeditionPlace());

        }
        return people_dto;
    }


    //*** PUT, update user

    public People_DTO updateUser(int user_id, UpdatePeople updatePeople){
        System.out.println("\n " + "user id : " + user_id);
        System.out.println("\n " + updatePeople);
        return mapToUserDemographicDTO(update_User(user_id, updatePeople));
    }

    public PeopleEntity update_User(int userId, UpdatePeople updatePeople){

        PeopleEntity peopleEntity = peopleRepository.findByUniqid(userId);

        if(peopleEntity == null) {
            return null;
        }
        peopleEntity.setNames(updatePeople.getNames());
        peopleEntity.setLastNames(updatePeople.getLastNames());
        peopleEntity.setNumber(updatePeople.getNumber());
        peopleEntity.setDateofBirth(updatePeople.getDateofBirth());
        peopleEntity.setPlaceOfBirth(updatePeople.getPlaceOfBirth());
        peopleEntity.setHeight(updatePeople.getHeight());
        peopleEntity.setRh(updatePeople.getRh());
        peopleEntity.setType_sex(updatePeople.getSex());
        peopleEntity.setExpeditionDate(updatePeople.getExpeditionDate());
        peopleEntity.setExpeditionPlace(updatePeople.getExpeditionPlace());

        peopleRepository.save(peopleEntity);

        return peopleEntity;
    }


}
