package com.example.apirest.mapper;

import com.github.dozermapper.core.*;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destination) {
        return mapper.map(origin, destination);
    }
    public static <Origin, Destination> List<Destination> parseListObjects(List<Origin> origin, Class<Destination> destination) {
        List<Destination> destinationObjects = new ArrayList<Destination>();
          for (Origin originObject : origin) {
                destinationObjects.add(mapper.map(originObject, destination));
          }
            return destinationObjects;
    }
}
