package com.testNeoris.TestNeoris.Entity;

import lombok.Data;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Data
@Entity
@Table(name = "people")
public class PeopleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uniqid;
    @Column(name = "name")
    public String names;
    @Column(name = "last_names")
    public String lastNames;
    @Column(name = "identity")
    public long number;
    @Column(name = "date_of_birth")
    public Date dateofBirth;
    @Column(name = "place_of_birth")
    public String placeOfBirth;
    @Column(name = "height")
    public float height;
    @Column(name = "rh")
    public String rh;
    @Column(name = "sex")
    public String sex;
    @Column(name = "expedition_date")
    public String expeditionDate;
    @Column(name = "expedition_place")
    public String expeditionPlace;
}
