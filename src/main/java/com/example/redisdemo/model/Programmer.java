package com.example.redisdemo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class Programmer implements Serializable {

    private int id;
    private String name;
    private String company;

}