package config;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        //двухмерный массив - в нем могут быть использованы абсоютно любые символы
        return new Object[][]{
                {"fakeUser1@mail.com", "fakePassword2"},
                {"fakeUser2@mail.com", "fakePassword1"}

        };
    }

}
//написать вместо хардкода генераторы в нескольких сценариях
//приикрутить аллюр сюда
