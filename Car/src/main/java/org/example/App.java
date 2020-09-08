package org.example;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@SpringBootApplication
@RestController
//@EnableAutoConfiguration
public class App
{
    List<Car> cars = new ArrayList<Car>();
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    public List<JSONObject> mappingCars(){
        List<JSONObject> listOfCar = new ArrayList<JSONObject>();
        for (Car car : cars){
            Map<String, Object> mapping = new HashMap<String, Object>();
            mapping.put("color", car.getColor());
            mapping.put("type", car.getType());
            mapping.put("displacement", car.getDisplacement());
            mapping.put("sunroof", car.getSunroof());
            mapping.put("speed", car.getSpeed());

            JSONObject JSONMapping = new JSONObject(mapping);
            listOfCar.add(JSONMapping);
        }
        return listOfCar;
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<List<JSONObject>> create(@RequestBody Car InputCar) {
        cars.add(InputCar);
        return new ResponseEntity<List<JSONObject>>(mappingCars(), HttpStatus.OK);
    }

    @RequestMapping(value = "/car/{index}", method = RequestMethod.GET)
    public ResponseEntity<Car> get(@PathVariable("index") int index) {
        Car car = cars.get(index - 1);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }


    @RequestMapping(value="/car/{index}", method=RequestMethod.PATCH)
    public ResponseEntity<List<JSONObject>> update(@RequestBody Car InputCar, @PathVariable("index") int index) {
        String color = InputCar.getColor();
        String type = InputCar.getType();
        int displacement = InputCar.getDisplacement();
        boolean hasSunroof = InputCar.getSunroof();
        int speed = InputCar.getSpeed();

        Car car = cars.get(index - 1);

        car.setColor(color);
        car.setType(type);
        car.setDisplacement(displacement);
        car.setSunroof(hasSunroof);
        car.setSpeed(speed);

        return new ResponseEntity<List<JSONObject>>(mappingCars(), HttpStatus.OK);
        //return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/car/{index}", method = RequestMethod.DELETE)
    public ResponseEntity<List<JSONObject>> delete( @PathVariable("index") int index ) {
        Car removedCar = cars.get(index - 1);
        cars.remove(index - 1);
        return new ResponseEntity<List<JSONObject>>(mappingCars(), HttpStatus.OK);
//        return new ResponseEntity<Car>(removedCar, HttpStatus.OK);
    }


}
