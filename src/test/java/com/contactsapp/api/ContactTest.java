package com.contactsapp.api;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.Test;

public class ContactTest {

    private static final String TEST_CONTACT_JSON = "{\"firstName\":\"Alice\",\"lastName\":\"Persson\",\"address\":\"ABC Heights\",\"postCode\":\"12345\",\"city\":\"Stockholm\",\"phoneNumber\":\"123459687\"}";

    @Test
    public void shouldBePossibleToSerializeToJSONFromPOJO() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Contact target = new Contact("Alice", "Persson", "ABC Heights", "12345", "Stockholm", "123459687");
        ByteArrayOutputStream resultOutputStream = new ByteArrayOutputStream();
        mapper.writeValue(resultOutputStream, target);
        assertThat(resultOutputStream.toString(), is(
            TEST_CONTACT_JSON));
    }

    @Test
    public void shouldBePossibleToDeserializeFromJSONToPOJO() throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);

        Contact contact = mapper.readValue(TEST_CONTACT_JSON, Contact.class);
    }
}
