#  File Upload and Download API

### Overview
This is a Spring Boot project that provides RESTful APIs for uploading and downloading files. It includes functionality to handle various file types, store files locally  and retrieve files via secure endpoints.

### Technologies Used 
1. **Spring Boot:** Framework for building REST APIs.
2. **Java:** Programming language.
3. **Maven:** Dependency management.
4. **MySQL:** Database for storing file metadata and content.

### API Endpoints

### File Upload
- Endpoint: POST /upload
- Description: Uploads a file and stores it in the database.
  
Request:
- Body: File to upload.

Response:
  ![image](https://github.com/user-attachments/assets/2e18755c-d5e6-4974-9614-b02665d6bdc7)

### File Download
- Endpoint: GET /download/{fileId}
- Description: Downloads the requested file using its unique ID.

Response: 
![image](https://github.com/user-attachments/assets/360572b9-034d-4043-8cf4-288a4a8adf92)



