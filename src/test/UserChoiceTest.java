package test;

import org.junit.jupiter.api.Test;
import ru.aston.homework2.UserChoice;


import static org.junit.jupiter.api.Assertions.*;

class UserChoiceTest {

    @Test
    void getUserInputWrite() {
        assertEquals("2", UserChoice.WriteFile.getUserInput());
    }

    @Test
    void getUserInputRead() {
        assertEquals("1", UserChoice.ReadFile.getUserInput());
    }

    @Test
    void getUserInputClose() {
        assertEquals("3", UserChoice.CloseApplication.getUserInput());
    }

}