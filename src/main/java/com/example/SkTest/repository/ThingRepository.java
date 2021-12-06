/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.SkTest.repository;

import com.example.SkTest.entity.Thing;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Denis Ufilin
 */
public interface ThingRepository extends JpaRepository <Thing, Integer>  {

   

  
}