package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Users;
import com.socialmedia.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import static jakarta.persistence.GenerationType.UUID;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Users getUserByUsername(String username) {
        return repository.findOneByUsername(username);
    }

    @Override
    public Optional<Users> getUserById(int id) {
        return repository.findById(id);
    }

    @Override
    public void loadData(String filPath) throws FileNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadData'");
    }

    @Override
    public void updateAvatar(Integer id, MultipartFile avatarfile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void changeUserPassword(int id, String currentPassword, String newPassword) {
        Optional<Users> optional = repository.findById(id);
        if (optional.isPresent()) {
            Users user = optional.get();
            System.out.println("user pass +" + user.getPassword());
            System.out.println("current pass : " + currentPassword);
            System.out.println("new pass: " + newPassword);
            // thưc hien kiem tra mat khau cu
            if (user.getPassword().equals(currentPassword)) {
                user.setPassword(newPassword);
                repository.save(user);
            } else {
                System.out.println("current password is not correct");
            }

        } else {
            throw new EntityNotFoundException("user not found");
        }
    }

    @Override
    public void changeUserPrivateState(int id, boolean currentState) {
        Optional<Users> optional = repository.findById(id);
        if (optional.isPresent()) {
            Users user = optional.get();
            if (user.getPrivateBool()) {
                System.out.println("User is private, change to UnPrivate" + user.getPrivateBool());
                user.setPrivateBool(!currentState);
                repository.save(user);

            }
            if (!(user.getPrivateBool())) {
                System.out.println("User is not private, change to Private"+ user.getPrivateBool());
                user.setPrivateBool(!currentState);
                repository.save(user);
            }
        } else {
            throw new EntityNotFoundException("User not found to set private");
        }
    }

    @Override
    public void changeUserbirthday(int id, Date birthday) {
        Optional<Users> optional = repository.findById(id);
        if(optional.isPresent()){
            try {
            Users user = optional.get();
            user.setBirthdate(birthday);
            repository.save(user);
            } catch (Exception e){
                System.out.println(e.toString());
            }

        }
        else {
            throw new EntityNotFoundException("user not found to set birthday");
        }
    }

//    public String saveAvatar(MultipartFile avatarFile) {
//        // 1. Tạo một thư mục hoặc hệ thống lưu trữ tệp cho các avatar (nếu chưa tồn tại).
//        // 2. Tạo một tên tệp duy nhất cho avatar mới, ví dụ:
//        String newFileName = avatarFile.getOriginalFilename();
//        // 3. Xác định đường dẫn đầy đủ cho avatar mới (đường dẫn tới thư mục + tên tệp).
//        String avatarFilePath = "/path/to/avatar/directory/" + newFileName;
//
//        try {
//            // 4. Lưu tệp avatar vào đường dẫn đã xác định.
//            avatarFile.transferTo(new File(avatarFilePath));
//            // 5. Trả về đường dẫn avatar mới.
//            return avatarFilePath;
//        } catch (IOException e) {
//            // Xử lý lỗi nếu có.
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public void updateAvatar(Integer id, MultipartFile avatarfile) {
//        Users user = repository.findById(id).orElse(null);
//        if (user != null) {
//            // Lưu hình ảnh mới vào cơ sở dữ liệu và cập nhật trường avatar
//            String newAvatarUrl = saveAvatar(avatarfile); // Hàm này lưu tệp và trả về đường dẫn mới
//            user.setAvatar(newAvatarUrl);
//            repository.save(user);
//
//        }
//    }
//    
    // @Override
    // public void loadData(String filePath) throws FileNotFoundException {
    // List<Users> dataList = readDataFromCSV(filePath);
    // // Lưu trữ dữ liệu vào CSDL
    // repository.saveAll(dataList);
    // }
    // private List<Users> readDataFromCSV(String filePath) throws
    // FileNotFoundException {
    // List<Users> dataList = new ArrayList<>();
    // try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
    // String[] nextLine;
    // try {
    // while ((nextLine = reader.readNext()) != null) {
    // if (nextLine.length >= 11) { // Kiểm tra xem dòng CSV có đủ cột không
    // Users data = new Users();
    // data.setUserId(Integer.parseInt(nextLine[0]));
    // data.setAvatar(nextLine[1]);
    // data.setFullname(nextLine[2]);
    // data.setGender(nextLine[3]);
    // data.setIntroduce(nextLine[4]);
    // data.setLanguage(nextLine[5]);
    // data.setPassword(nextLine[6]);
    // data.setPrivateBool(Boolean.parseBoolean(nextLine[7]));
    // data.setUsername(nextLine[8]);
    // data.setWebsite(nextLine[9]);
    // try {
    // data.setBirthdate(new SimpleDateFormat("dd-MM-yyy").parse(nextLine[10]));
    // } catch (ParseException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // dataList.add(data);
    // }
    // }
    // } catch (CsvValidationException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // return dataList;
}
