package com.testNeoris.TestNeoris.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class People_DTO {
    public int user_uniqid;
    public String names;
    public String lastNames;
    public long number;
    public Date dateofBirth;
    public String placeOfBirth;
    public float height;
    public String rh;
    public String sex;
    public String expeditionDate;
    public String expeditionPlace;
}
