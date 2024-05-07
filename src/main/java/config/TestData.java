package config;

import helpers.EmailGenerator;
import helpers.PasswordStringGenerator;
import org.testng.annotations.DataProvider;

public class TestData extends AppiumConfig{

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        //двухмерный массив - в нем могут быть использованы абсоютно любые символы
        return new Object[][]{
                {"fakeUser1@mail.com", "fakePassword2"},
                {EmailGenerator.generateEmail(5,5,3), "fakePassword1"},
                {"fakeUser2@mail.com", "fakePassword1"}
        };
    }

    @DataProvider(name = "loginDataNegative")
    public Object[][] loginDataNegative() {
            return new Object[][]{
                    {"fakeUser1mail.com", "fakePassword2"},
                    {"fakeUser1@mail.com", ""},
                    {"fakeUser1@mailcom", "fakePassword2"},
                    {"       ", "fakePassword2"},
                    {"fakeUser1@mail.com", "fakeassword"},
                    {EmailGenerator.generateEmail(5,3,3),
                            PasswordStringGenerator.generateString()},//странно, но генерация приавильная,
                    //а тест негатиыный сохраняется
                    {"111111111", "fakeasswordF1"}
            };
    }

}
//написать вместо хардкода генераторы в нескольких сценариях
//приикрутить аллюр сюда
