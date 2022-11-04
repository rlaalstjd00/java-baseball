package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    private static UserInput userInput;

    @BeforeAll
    public static void setUp() {
        userInput = new UserInput(3);
    }


    @Test
    void 사용자_입력값이_숫자가_아닌_경우_유효성검사() {
        String input = "abcde";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.getUserInput();
        });
        assertEquals("숫자만 입력해주세요.", exception.getMessage());
    }

    @Test
    void 사용자_입력값이_3자리_숫자가_아닌_경우_유효성겁사() {
        String input = "012";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.getUserInput();
        });
        assertEquals("3자리 숫자를 입력해주세요.", exception.getMessage());
    }

    @Test
    void 사용자_입력값이_중복되는_경우_유효성검사() {
        String input = "133";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.getUserInput();
        });
        assertEquals("중복되지 않는 3자리 숫자를 입력해주세요.", exception.getMessage());
    }

    @Test
    void 재시작_여부_입력_숫자_유효성검사() {
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            UserInput.getNewGameStatusInput();
        });
        assertEquals("1 또는 2중에서 입력해주세요.", exception.getMessage());
    }
}