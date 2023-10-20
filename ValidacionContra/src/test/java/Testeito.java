import com.mycompany.validacioncontra.ValidatePas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testeito {

    @Test
    public void validarPass() {
        assertTrue(ValidatePas.validatepassword("Abc@1234", "Abc@1234"));
    }

    @Test
    public void testShortPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> ValidatePas.validatepassword("Short1@", "Short1@"));
        assertEquals("La contraseña debe tener al menos 8 caracteres.", exception.getMessage());
    }

    @Test
    public void testPasswordWithSpace() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> ValidatePas.validatepassword("With Space1@", "With Space1@"));
        assertEquals("La contraseña no debe contener espacios en blanco.", exception.getMessage());
    }

    @Test
    public void testPasswordWithoutLowerCase() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> ValidatePas.validatepassword("WITHOUTLOWERCASE1@", "WITHOUTLOWERCASE1@"));
        assertEquals("La contraseña debe contener al menos un carácter en minúscula, uno en mayúscula, un número y un carácter especial.", exception.getMessage());
    }

    @Test
    public void testPasswordWithoutUpperCase() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> ValidatePas.validatepassword("withoutuppercase1@", "withoutuppercase1@"));
        assertEquals("La contraseña debe contener al menos un carácter en minúscula, uno en mayúscula, un número y un carácter especial.", exception.getMessage());
    }

    @Test
    public void testPasswordWithoutDigit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> ValidatePas.validatepassword("WithoutDigit@@", "WithoutDigit@@"));
        assertEquals("La contraseña debe contener al menos un carácter en minúscula, uno en mayúscula, un número y un carácter especial.", exception.getMessage());
    }

    @Test
    public void testPasswordWithoutSpecialChar() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> ValidatePas.validatepassword("WithoutSpecialChar1", "WithoutSpecialChar1"));
        assertEquals("La contraseña debe contener al menos un carácter en minúscula, uno en mayúscula, un número y un carácter especial.", exception.getMessage());
    }

    @Test
    public void testPasswordsDoNotMatch() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> ValidatePas.validatepassword("Mismatch1@", "Mismatch2@"));
        assertEquals("Las contraseñas no coinciden.", exception.getMessage());
    }

}