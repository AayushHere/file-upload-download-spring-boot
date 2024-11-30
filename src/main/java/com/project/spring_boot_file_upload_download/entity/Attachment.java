package com.project.spring_boot_file_upload_download.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data@NoArgsConstructor
public class Attachment {

    @Id
    // this below two line of code is telling Hibernate  to automatically generate unique IDs for a database entity using a UUID (Universally Unique Identifier).
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

        public Attachment(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}
