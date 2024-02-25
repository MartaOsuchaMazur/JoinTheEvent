package pl.coderslab.Model;


import javax.validation.Validation;
import javax.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {

    private static final Validator VALIDATOR =
        Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator();

    @BeforeEach
    void setUp() {

    }

    @Test
    void ClientShouldReturnNameWhenSet() {
        Client client = new Client("Aleksandra", "Marszalek", "email", "phone");

        assertEquals("Aleksandra", client.getFirstName());
    }

    @Test
    void ClientShouldReturnPhoneWhenSet() {
        Client client = new Client("Aleksandra", "Marszalek", "email", "phone");
        client.setPhone("a");

        assertEquals("b", client.getPhone());
    }

    @Test
    void testValidClient() {
        // Arrange
        Client client = new Client("John", "Doe", "john@example.com", "123456789", new Institution());

        // Act
        var violations = VALIDATOR.validate(client);

        // Assert
        assertTrue(violations.isEmpty(), "No validation errors should occur for a valid client");
    }

    @Test
    public void testInvalidClient() {
        // Arrange
        Client client = new Client("", "", "invalid_email", "invalid_phone", new Institution());

        // Act
        var violations = VALIDATOR.validate(client);

        // Assert
        assertEquals(4, violations.size(), "There should be 4 validation errors for an invalid client");
    }

}