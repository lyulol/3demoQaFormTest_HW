import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    static int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("###   Before all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###     Before each");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###     After each");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("###     After all");
        result = 0;
    }

    @Test
    void firstTest() {
        System.out.println("###     First test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###     Second test");
        Assertions.assertTrue(result > 1);
    }

    private int getResult() {
        return 3;
    }
}
