package controllers.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file/upload")
public class FileController {

    @GetMapping
    public String upload() {
        return "file/upload";
    }

    @PostMapping
    public String uploadPs(MultipartFile file) {
        File path = new File("C:/uploads/" + file.getOriginalFilename());

        try {
            file.transferTo(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "file/upload";
    }
}