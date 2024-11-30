package com.project.spring_boot_file_upload_download.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private String  fileName;
    private String downloadUrl;
    private String  fileType;
    private long fileSize;
}
