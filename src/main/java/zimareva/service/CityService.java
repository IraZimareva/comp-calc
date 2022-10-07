package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.exception.CityNotFoundException;
import zimareva.model.City;
import zimareva.repository.CityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City addCity(City city){
        return cityRepository.save(city);
    }

    public List<City> getCities(){
        return StreamSupport
                .stream(cityRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public City getCity(Long id){
        return cityRepository.findById(id).orElseThrow(() ->
                new CityNotFoundException(id));
    }

    public void deleteCity(Long id){
        cityRepository.deleteById(id);
    }

    //todo: прочитать про  transactional
    @Transactional
    public City editCity(Long id, City city){
        City cityToEdit = getCity(id);
        cityToEdit.setTitle(city.getTitle());
        return cityToEdit;
    }
}
