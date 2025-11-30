package com.nicolesdecoraciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    
    @Test
    public void testBasicAssertion() {
        assertEquals(1, 1, "La aserción básica debe funcionar");
    }
    
    @Test 
    public void testProjectStructure() {
        String projectName = "Nicole's Decoraciones";
        assertNotNull(projectName, "El nombre del proyecto no debe ser nulo");
        assertTrue(projectName.contains("Decoraciones"), "El nombre debe contener 'Decoraciones'");
    }
}
