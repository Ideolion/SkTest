package com.example.SkTest.controller;

import com.example.SkTest.entity.DataCurrent;
import com.example.SkTest.entity.DataAdd;
import com.example.SkTest.entity.Thing;
import com.example.SkTest.repository.ThingRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс - контроллер, осуществляющий обработку POST запроса
 *
 * @author Denis Ufilin
 */
@RestController
@AllArgsConstructor

public class ThingController {

    @Autowired
    ThingRepository thingRepository;

    /**
     * Метод для обработки запроса POST. Осуществляет запись в БД поля current
     * увеличенного на значение<br>
     * add строки с идентификатором id
     *
     * @param jsonData принимаемое от пользователя значния id и add.
     * @return возвращает значение поля current увеличенное на величину значение
     * add.
     */
    @PostMapping(path = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json; charset=UTF-8")
    @Transactional
    public ResponseEntity<String> setThing(@RequestBody String jsonData) {
        ResponseEntity<String> rE = null;
        JsonRepeater JR = new JsonRepeater();
        DataAdd dataAdd = JR.JsonToDataAdd(jsonData);
        if (dataAdd != null) {
            Optional<Thing> thing = thingRepository.findById(dataAdd.getId());
            String dataReturnJson = null;
            if (thing.isPresent() && !thing.get().getObj().isEmpty()) {
                DataCurrent datacurrent = JR.JsonToDataCurrent(thing.get().getObj());
                int number = datacurrent.getCurrent() + dataAdd.getAdd();
                datacurrent.setCurrent(number);
                Thing thingReturn = new Thing();
               
                thingReturn.setId(dataAdd.getId());
                thingReturn.setObj(JR.DataCurrentToJson(datacurrent));
                //записали
                thingRepository.save(thingReturn);
                //запросили новый
                Optional<Thing> thingAfterSave = thingRepository.findById(dataAdd.getId());
                //вернули ответ
                dataReturnJson = thingAfterSave.get().getObj();
                rE = new ResponseEntity<>(dataReturnJson, HttpStatus.OK);
            } else {
                rE = new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
            }
        } else {
            rE = new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        
        
        
        return rE;
        
        

    }

}
