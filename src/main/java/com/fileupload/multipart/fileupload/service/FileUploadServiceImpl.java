package com.fileupload.multipart.fileupload.service;

import com.fileupload.multipart.fileupload.model.FileUpload;
import com.fileupload.multipart.fileupload.repository.FileUploadRespository;
import com.fileupload.multipart.fileupload.util.FileUploadUtil;
import org.springframework.stereotype.Service;

@Service
public class FileUploadServiceImpl implements FileUploadService{
    private final FileUploadRespository fileUploadRespository;

    public FileUploadServiceImpl(FileUploadRespository fileUploadRespository) {
        this.fileUploadRespository = fileUploadRespository;
    }

    @Override
    public FileUpload save(FileUpload fileUpload) {
        return fileUploadRespository.save(fileUpload);
    }

    @Override
    public FileUpload getFileByName(String name) {
        return fileUploadRespository.getFileUploadByFileName(name);
    }
}
