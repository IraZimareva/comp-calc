package zimareva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zimareva.model.City;
import zimareva.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody final City city){
        City addedCity = cityService.addCity(city);
        return new ResponseEntity<>(addedCity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities(){
        List<City> cities = cityService.getCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<City> getCity(@PathVariable final Long id){
        City city = cityService.getCity(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public void deleteCity(@PathVariable final Long id){
        cityService.deleteCity(id);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<City> editCity(@PathVariable final Long id,
                                         @RequestBody final City cityDetails){
        City editedCity = cityService.editCity(id, cityDetails);
        return new ResponseEntity<>(editedCity, HttpStatus.OK);
    }
}
