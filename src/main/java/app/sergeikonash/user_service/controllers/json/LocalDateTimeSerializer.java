package app.sergeikonash.user_service.controllers.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(value != null){
            gen.writeNumber(value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        } else {
            gen.writeNull();
        }
    }
}
