package com.studentapp.junit.studentsinfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUDTest extends TestBase {

     static String firstName = "sri";
     static String lastName = "kanth";
     static String programme = "CSC";
     static String email = TestUtils.getRandomValue()+"sri@domain.com";
    @Steps
    StudentSerenitySteps steps;
    @Test
    public void createStudent(){
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");

        steps.createStudent(firstName, lastName, email, programme, courses)
        //        StudentClass student = new StudentClass();
//        student.setFirstName(firstName);
//        student.setLastName(lastName);
//        student.setEmail(email);
//        student.setProgramme(programme);
//        student.setCourses(courses);
//        SerenityRest.rest().given()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(student)
//                .post()
//                .then()
//                .log()
//                .all()
//                .assertThat()
                .statusCode(201);

    }

    @Test
    public void getStudent(){
        HashMap<String, Object> value = steps.getStudentInfoByFirstname(firstName);
//        String p1 = "findAll{it.firstName=='";
//        String p2 = "'}.get(0)";
//       HashMap<String, Object> value = SerenityRest.rest().given()
//                .when()
//                .get("/list")
//                .then()
//                .log()
//                .all()
//                .statusCode(200)
//                .extract()
//                .path(p1+firstName+p2);
                System.out.println("The value is:" +value);
                assertThat(value, hasValue(firstName));
    }
}
