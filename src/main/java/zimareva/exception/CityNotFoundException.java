package zimareva.exception;

import java.text.MessageFormat;

//todo: почему рантайм? Вспомнить про эксепшены, прочитать теорию
public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(Long id){
        super(MessageFormat.format("Could not found city with id : {0}", id));
    }
}
