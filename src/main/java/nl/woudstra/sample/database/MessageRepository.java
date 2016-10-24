package nl.woudstra.sample.database;

import org.springframework.stereotype.Component;

/**
 * Not a real database, acts more like a stub in fact
 * Still usefull to determine if the dependency injection system is working
 * Created by bouke on 23-10-16.
 */
@Component
public class MessageRepository {

    public String getMessage(){
        return "Hello world from MessageRepository";
    };
}
