package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

import static io.qameta.allure.Allure.step;

public class StudentRegistrationWithFakersTests extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.number().digits(10),
            day = "15",
            month = "May",
            year = "1999",
            subject = "English",
            hobby = "Sports",
            picture = "cat.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Agra";

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @DisplayName("Заполнение формы регистрации")
    @Test
    void registrationTest() {
        step("Открываем страницу", () -> {
            studentRegistrationPage.openPage();
        });

        step("Заполняем инфо о студенте", (s) -> {
            s.parameter("firstName", firstName);
            s.parameter("lastName", lastName);
            s.parameter("email", email);
            s.parameter("gender", gender);
            s.parameter("mobile", mobile);
            studentRegistrationPage.typeFirstName(firstName);
            studentRegistrationPage.typeLastName(lastName);
            studentRegistrationPage.typeEmail(email);
            studentRegistrationPage.chooseGender(gender);
            studentRegistrationPage.typeNumber(mobile);
        });

        step("Заполняем дату рождения", () -> {
            studentRegistrationPage.setDate(day, month, year);
        });

        step("Выбираем предмет", (s) -> {
            s.parameter("subject", subject);
            studentRegistrationPage.typeSubject(subject);
        });
        step("Выбираем хобби", (s) -> {
            s.parameter("hobby", hobby);
            studentRegistrationPage.chooseHobby(hobby);
        });
        step("Загружаем картинку", () -> {
            studentRegistrationPage.uploadPicture(picture);
        });
        step("Заполняем адресс", (s) -> {
            s.parameter("currentAddress", currentAddress);
            studentRegistrationPage.typeAdress(currentAddress);
        });
        step("Выбираем штат и город", (s) -> {
            s.parameter("state", state);
            s.parameter("city", city);
            studentRegistrationPage.selectState(state);
            studentRegistrationPage.selectCity(city);
        });
        step("Нажимаем отправить", () -> {
            studentRegistrationPage.clickSubmit();
        });
        step("Проверяем таблицу с результатом", () -> {
            studentRegistrationPage.checkTableResults(firstName,
                    lastName,
                    email,
                    gender,
                    mobile, day,
                    month,
                    year,
                    subject,
                    hobby,
                    picture,
                    currentAddress,
                    state,
                    city);
        });
    }
}