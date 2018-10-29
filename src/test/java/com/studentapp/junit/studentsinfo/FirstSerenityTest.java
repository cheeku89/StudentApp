package com.studentapp.junit.studentsinfo;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost:8080/student";
    }
    @Title("Get all student information")
    @Test
    public void getAllStudents(){
        RestAssured.given()
                .when()
                .get("/list")
                .then()
                .assertThat().statusCode(200);
    }
}
