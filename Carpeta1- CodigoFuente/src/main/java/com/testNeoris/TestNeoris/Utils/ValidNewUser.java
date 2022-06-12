package com.testNeoris.TestNeoris.Utils;

public class ValidNewUser {
    /*
    public boolean isValidNewUserReceptionRecord(NewDemographicDTO newDemographicDTO)
            throws NotFoundException, ConflictException {
        boolean isValid = true;

        System.out.println("newUniq :: " + newDemographicDTO.getUser_uniqid());
        UserEntity user_Entity = userService.getUserEntity(newDemographicDTO.getUser_uniqid());
        logger.info("----->> :: " + user_Entity);
        System.out.println(user_Entity);
        UserDemographicEntity userDemographicEntity = userDemographicRepository.findByUser(user_Entity);

        logger.info(">> userRecep..Entity encontrado  :: " +  userDemographicEntity);

        if(userDemographicEntity != null) {
            String cause = String.format("There is already a User Reception Record for user whit id %d", newDemographicDTO.getUser_uniqid());
            String id = exceptionLoggin.getUUID();
            String message = exceptionLoggin.buildMessage(ErrorMessageEnum.ConflictException, id, cause,this.getClass().toString());
            exceptionLoggin.saveLog(message, id);

            throw new ConflictException(message);
        }
        return isValid;
    }*/
}
