package com.project.spring_boot_file_upload_download.controller;

import com.project.spring_boot_file_upload_download.entity.Attachment;
import com.project.spring_boot_file_upload_download.model.ResponseData;
import com.project.spring_boot_file_upload_download.repository.AttachmentRepository;
import com.project.spring_boot_file_upload_download.service.AttachmentService;
import com.project.spring_boot_file_upload_download.service.AttachmentServiceImp;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentController {
    private AttachmentService attachmentService;
    private AttachmentRepository attachmentRepository;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }


    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {

        Attachment attachment = null;
        String downloadUrl = null;
        attachment = attachmentService.saveAttachment(file);
        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download")
                .path(attachment.getId())
                .toUriString();

        return new ResponseData(attachment.getFileName(), downloadUrl, file.getContentType(), file.getSize());
    }

@GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
         attachment = attachmentService.getAttachmentById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_TYPE,"attachment; filename=\"" + attachment.getFileName() + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
}

