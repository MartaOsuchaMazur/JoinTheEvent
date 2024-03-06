package pl.coderslab.Model;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private static final Validator VALIDATOR =
            Validation.byDefaultProvider()
                    .configure()
                    .messageInterpolator(new ParameterMessageInterpolator())
                    .buildValidatorFactory()
                    .getValidator();

    @Test
    void shouldReturnNameWhenValidSetName() {

        Client client1 = new Client("Ania", "Nowacka", "a.nowacka@wp.pl", "+48632765443", new Institution());
        var violations = VALIDATOR.validate(client1);
        assertEquals("Ania", client1.getFirstName());
        assertTrue(violations.isEmpty(), "No validation errors should occur for a valid client");
    }
//
    @Test
    void shouldReturnLastNameWhenValidSetName() {

        Client client1 = new Client("Ania", "Mikulska", "a.mikulska@wp.pl", "+48632765443", new Institution());
        var violations = VALIDATOR.validate(client1);
        assertEquals("Mikulska", client1.getLastName());
        assertTrue(violations.isEmpty(), "No validation errors should occur for a valid client");
    }

    @Test
    void shouldInvalidClient() {
        Client client1 = new Client("Ania", "Nowacka", "a.nowacka@wp.pl", "+4863", new Institution());
        var violations = VALIDATOR.validate(client1);
        assertEquals(1, violations.size());
    }

    @Test
    void shouldGetAllClients() {

    }

}