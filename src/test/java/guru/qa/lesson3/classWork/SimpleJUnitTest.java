package guru.qa.lesson3.classWork;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {
    int result;

    @BeforeAll
    static void beforeAll(){
        System.out.println("###   beforeAll()\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("###   beforeEach()");
          result = getResult();
        }
        @AfterEach
    void afterEach(){
        System.out.println("###   afterEach()\n");
        result = 0;
    }

        @Test
     void firstTest(){
        Assertions.assertTrue(result>2);
        System.out.println("###   firstTest()");
    }

    @Test
    void secondTest(){
        Assertions.assertTrue(result>2);
        System.out.println("###   secondTest()");
    }

    @Test
    void thirdTest(){
        Assertions.assertTrue(result>2);
        System.out.println("###   thirdTest()");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("###   afterAll()");
    }


    private int getResult() {
        return 3;
    }

}
