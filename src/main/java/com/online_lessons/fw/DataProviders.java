package com.online_lessons.fw;

import com.online_lessons.models.Course;
import com.online_lessons.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> signUpNegativeFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registration_negative.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setNickname(split[0]).setEmail(split[1]).setPassword(split[2])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public  Iterator<Object[]> signUpWithEmptyFieldsFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registration_emptyFields.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setNickname(split[0]).setEmail(split[1]).setPassword(split[2])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> updateCoursePositiveFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/update_course_positive.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new Course().setTitle(split[0]).setPrice(Integer.parseInt(split[1])).setDescription(split[2])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> updateCourseNegativeFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/update_course_negative.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new Course().setTitle(split[0]).setPrice(Integer.parseInt(split[1])).setDescription(split[2])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> createCourseNegativeFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/create_course_negative.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new Course().setTitle(split[0]).setPrice(Integer.parseInt(split[1])).setPhotoPath(split[2]).setDescription(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
