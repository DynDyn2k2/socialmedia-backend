package com.socialmedia.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.socialmedia.model.Users;
import com.socialmedia.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    @Override
    public List<Users> getAllUser() {
        return repository.findAll();
    }

    @Override
    public void loadData(String filePath) throws FileNotFoundException {
        List<Users> dataList = readDataFromCSV(filePath);

        // Lưu trữ dữ liệu vào CSDL
        repository.saveAll(dataList);

    }

    private List<Users> readDataFromCSV(String filePath) throws FileNotFoundException {
        List<Users> dataList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            try {
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine.length >= 11) { // Kiểm tra xem dòng CSV có đủ cột không
                        Users data = new Users();
                        data.setUserId(Integer.parseInt(nextLine[0]));
                        data.setAvatar(nextLine[1]);
                        data.setFullname(nextLine[2]);
                        data.setGender(nextLine[3]);
                        data.setIntroduce(nextLine[4]);
                        data.setLanguage(nextLine[5]);
                        data.setPassword(nextLine[6]);
                        data.setPrivateBool(Boolean.parseBoolean(nextLine[7]));
                        data.setUsername(nextLine[8]);
                        data.setWebsite(nextLine[9]);
                        try {
                            data.setBirthdate(new SimpleDateFormat("dd-MM-yyy").parse(nextLine[10]));
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        dataList.add(data);
                    }
                }
            } catch (CsvValidationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

}