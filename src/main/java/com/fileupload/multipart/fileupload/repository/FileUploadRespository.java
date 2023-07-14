package com.fileupload.multipart.fileupload.repository;

import com.fileupload.multipart.fileupload.model.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRespository extends JpaRepository<FileUpload, Long> {
    FileUpload getFileUploadByFileName(String fileName);
}
