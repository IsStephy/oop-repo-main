package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class View{
    public void view(List<JsonNode> starWars, List<JsonNode>hitchhikers, List<JsonNode>rings, List<JsonNode>marvel)throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new File("lab-papers-please/java-classifcation/src/main/resources/outputs/starwars.json"), starWars);
        mapper.writeValue(new File("lab-papers-please/java-classifcation/src/main/resources/outputs/hitchhiker.json"), hitchhikers);
        mapper.writeValue(new File("lab-papers-please/java-classifcation/src/main/resources/outputs/rings.json"), rings);
        mapper.writeValue(new File("lab-papers-please/java-classifcation/src/main/resources/outputs/marvel.json"), marvel);
    }
}
