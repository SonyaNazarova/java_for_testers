package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends  TestBase{


    @Test
    void сanRegisterUser(){
        var username = CommonFunctions.randomString(8);
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesCli().addUser(email, password);//создать пользователя (адрес) на почтовом сервере(JamesHelper)
        app.registration().start(username, email);// заполняем форму создания и отправляем (браузер)
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));//ждем почту (MailHelper)
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        Assertions.assertTrue(matcher.find());
        var url = text.substring(matcher.start(), matcher.end());// извлекаем ссылку из письма
        app.registration().finish(url, username, password);// проходим по ссылке и завершаем регистрацию пользователя (браузер)
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());// проверяем, что пользователь может залогиниться (HttpSessionHelper)
    }


}
