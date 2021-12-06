/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SkTest.controller;

import com.example.SkTest.entity.DataAdd;
import com.example.SkTest.entity.DataCurrent;
import com.google.gson.Gson;

/**
 *Класс преобразователь объектов json в объекты классов и наоборот
 * @author Denis Ufilin
 */
public class JsonRepeater {

    Gson json = new Gson();

    public DataAdd JsonToDataAdd(String jsonData) {
       DataAdd dataAdd = null;
        try{
        dataAdd = json.fromJson(jsonData, DataAdd.class);
       }catch(Exception e){
           System.out.println(e.toString());
       }
        
        return dataAdd;
    }

    public DataCurrent JsonToDataCurrent(String jsonData) {
        DataCurrent datacurrent = json.fromJson(jsonData, DataCurrent.class);
        return datacurrent;
    }
    public String DataCurrentToJson(DataCurrent datacurrent) {
        String datacurrentToString = json.toJson(datacurrent);
        return datacurrentToString;
    }
    

    
    
}
