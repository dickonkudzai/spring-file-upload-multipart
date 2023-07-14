package com.fileupload.multipart.fileupload.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FileUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "upload_directory")
    private String uploadDirectory;
    @Column(name = "file_name")
    private String fileName;
}
