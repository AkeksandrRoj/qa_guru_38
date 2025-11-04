package guru.qa.lesson7.homeWork;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class ClientJsonTest {
    private ClassLoader cl = ClientJsonTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonFileParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("client.json")) {
            Client client = objectMapper.readValue(is, Client.class);


            Assertions.assertEquals(10245, client.id);
            Assertions.assertEquals("Александр Иванов", client.name);
            Assertions.assertEquals(35, client.age);
            Assertions.assertEquals("alexandr.ivanov@example.com", client.email);
            Assertions.assertTrue(client.isActive);


            Assertions.assertEquals("Москва", client.address.city);
            Assertions.assertEquals("ул. Центральная, д. 10", client.address.street);


            Assertions.assertEquals(2, client.contacts.size());

            Assertions.assertEquals("phone", client.contacts.get(0).type);
            Assertions.assertEquals("+7 (916) 555-32-10", client.contacts.get(0).value);

            Assertions.assertEquals("telegram", client.contacts.get(1).type);
            Assertions.assertEquals("@alexandr_ivanov", client.contacts.get(1).value);
        }
    }
}
