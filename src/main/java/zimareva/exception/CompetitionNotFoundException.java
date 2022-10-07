package zimareva.exception;

import java.text.MessageFormat;

public class CompetitionNotFoundException extends RuntimeException {

    public CompetitionNotFoundException(Long id){
        super(MessageFormat.format("Could not found competition with id : {0}", id));
    }
}
