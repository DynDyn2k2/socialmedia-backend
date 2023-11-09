import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/images")
public class ImageController {

    @Value("${upload.path}") // Đường dẫn tới thư mục lưu trữ ảnh
    private String uploadPath;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                // Tạo tên ngẫu nhiên cho tệp ảnh
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

                // Lưu ảnh vào thư mục dự án
                Path filePath = Paths.get(uploadPath, fileName);
                file.transferTo(filePath.toFile());

                // Lưu đường dẫn của ảnh vào cơ sở dữ liệu hoặc trả về trực tiếp đường dẫn
                String imageUrl = "/image/uploads/" + fileName; // Đường dẫn tới ảnh từ thư mục gốc
                return new ResponseEntity<>(imageUrl, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Tệp ảnh trống hoặc không tồn tại.", HttpStatus.BAD_REQUEST);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Lỗi khi tải ảnh lên!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
