package com.online_lessons.fw;

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
    public  Iterator<Object[]> signUpWithEmptyFieldsWithCsv() throws IOException {
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
}
