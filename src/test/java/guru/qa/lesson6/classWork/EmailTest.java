package guru.qa.lesson6.classWork;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

//@Disabled("Пока тесты на Email отключены")
@DisplayName("Тесты на email рассылку")
public class EmailTest {

   @Test
   @Tag("smoke")
   @DisplayName("Email должен быть отправлен новому клиенту")
 void emailShouldBeSentForNewUser(){
       System.out.println("Hello! You're new user");
   }
    @Tag("smoke")
   @Test
   @DisplayName("Email должен быть отправлен  клиенту")
   void emailShouldBeSentForBannedUser(){
       System.out.println("Attention: You're banned!");
   }
    @Tag("Noweb")
    @Test
    @DisplayName("Email должен быть отправлен только женщинам")
    void emailShouldBeSentForOnlyWomen(){
        System.out.println("Hello! You're so beautiful!!!");
    }

    @Disabled("Bug BNPL-1025")
    @Test
    @DisplayName("Email должен быть отправлен после изменения метода платежа")
    void emailShouldBeSentAfterChangePaymentMethod(){
        throw new AssertionError("Тест упал!!!");
    }
}
