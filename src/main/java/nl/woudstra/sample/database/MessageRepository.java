package nl.woudstra.sample.database;

import org.springframework.stereotype.Component;

/**
 * Created by bouke on 23-10-16.
 */
@Component
public class MessageRepository {

    public String getMessage(){
        return "Hello world from MessageRepository";
    };
}
