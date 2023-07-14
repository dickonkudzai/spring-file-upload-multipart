package com.fileupload.multipart.fileupload.service;

import com.fileupload.multipart.fileupload.model.FileUpload;

public interface FileUploadService {
    FileUpload save(FileUpload fileUpload);
    FileUpload getFileByName(String name);
}
