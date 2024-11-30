package com.project.spring_boot_file_upload_download.service;


import com.project.spring_boot_file_upload_download.entity.Attachment;
import com.project.spring_boot_file_upload_download.repository.AttachmentRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImp implements AttachmentService {

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImp(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }


    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if (fileName.contains("..")) {
                throw new Exception("Invalid file name"+fileName);
            }
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        }
        catch (Exception e){
            throw new Exception("could not save file: " + e.getMessage());
        }
    }

    @Override
    public Attachment getAttachmentById(String fileId) throws Exception {
        Attachment attachment = null;
        return attachmentRepository
                .findById(fileId)
                .orElseThrow(()-> new Exception("File not found: " + fileId));

    }
}
