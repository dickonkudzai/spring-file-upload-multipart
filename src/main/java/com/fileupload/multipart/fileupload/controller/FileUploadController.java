package com.fileupload.multipart.fileupload.controller;

import com.fileupload.multipart.fileupload.model.FileUpload;
import com.fileupload.multipart.fileupload.service.FileUploadService;
import com.fileupload.multipart.fileupload.util.FileUploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("file-upload")
public class FileUploadController {
    private final String UPLOAD_DIR = "./uploads/";
    private final FileUploadUtil fileUploadUtil;
    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadUtil fileUploadUtil, FileUploadService fileUploadService) {
        this.fileUploadUtil = fileUploadUtil;
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String uploadDir = UPLOAD_DIR;
        fileUploadUtil.saveFile(uploadDir, fileName, file);
        FileUpload fileUpload = new FileUpload();
        fileUpload.setFileName(fileName);
        fileUpload.setUploadDirectory(uploadDir);
        fileUploadService.save(fileUpload);
        return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully!");
    }

    @GetMapping("/download/{fileName}")
    public void downloadFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        String uploadDir = UPLOAD_DIR;
        String filePath = uploadDir + fileName;
        fileUploadUtil.downloadFile(response, filePath);
    }
}
