package com.studentapp.cucumber.serenity;

import com.studentapp.model.StudentClass;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class StudentSerenitySteps {
    @Step
    public ValidatableResponse createStudent(String firstName,
                                             String lastName,
                                             String email,
                                             String programme,
                                             List<String> courses) {
        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);
        return SerenityRest.rest().given()
              .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then();
        }

        @Step
    public HashMap<String, Object> getStudentInfoByFirstname(String firstName){

            String p1 = "findAll{it.firstName=='";
            String p2 = "'}.get(0)";
             return SerenityRest.rest().given()
                    .when()
                    .get("/list")
                    .then()
                    .log()
                    .all()
                    .statusCode(200)
                    .extract()
                    .path(p1+firstName+p2);
        }

}
