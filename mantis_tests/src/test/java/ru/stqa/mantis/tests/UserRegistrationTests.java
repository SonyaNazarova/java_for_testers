package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UserRegistrationTests extends  TestBase{

    public static Stream<String> randomUser(){
        return Stream.of(CommonFunctions.randomString(8));
    }

    @ParameterizedTest
    @MethodSource("randomUser")
    void сanRegisterUser(String user){
        var email = String.format("%s@localhost", user);
        var password = "password";
        app.jamesCli().addUser(email, password);//создать пользователя (адрес) на почтовом сервере(JamesHelper)
        app.registration().start(user, email);// заполняем форму создания и отправляем (браузер)
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));//ждем почту (MailHelper)
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        Assertions.assertTrue(matcher.find());
        var url = text.substring(matcher.start(), matcher.end());// извлекаем ссылку из письма
        app.registration().finish(url, user, password);// проходим по ссылке и завершаем регистрацию пользователя (браузер)
        app.http().login(user, password);
        Assertions.assertTrue(app.http().isLoggedIn());// проверяем, что пользователь может залогиниться (HttpSessionHelper)
    }

    @ParameterizedTest
    @MethodSource("randomUser")
    void сanRegisterUser2(String user){
        var email = String.format("%s@localhost", user);
        var password = "password";
        app.jamesApi().addUser(email, password);
        app.registration().start(user,email);

        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        Assertions.assertTrue(matcher.find());
        var url = text.substring(matcher.start(), matcher.end());
        app.registration().finish(url, user, password);
        app.http().login(user, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }


}
