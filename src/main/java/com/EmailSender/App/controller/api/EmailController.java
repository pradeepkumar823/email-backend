package com.EmailSender.App.controller.api;


import com.EmailSender.App.helper.CustomResponse;
import com.EmailSender.App.helper.EmailRequest;
import com.EmailSender.App.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController (EmailService emailService){
        this.emailService=emailService;
    }

        @PostMapping("/send")
        public  ResponseEntity<?>sendEmail(@RequestBody EmailRequest request){

          emailService.sendEmailWithHtml(
                  request.getTo(),
                  request.getSubject(),
                  request.getMessage()
          );
          return ResponseEntity.ok(
                  CustomResponse.builder()
                          .message("Email send Successfully !! ")
                          .httpStatus(String.valueOf(HttpStatus.OK))
                          .success(true)
          );
        }


    @PostMapping("/send-with-file")
    public ResponseEntity<CustomResponse> sendWithFile(
            @RequestPart EmailRequest request,
            @RequestPart MultipartFile file
    ) throws IOException {

        emailService.sendEmailWithFile(
                request.getTo(),
                request.getSubject(),
                request.getMessage(),
                file.getOriginalFilename(),  // dynamic name!
                file.getInputStream()
        );

        return ResponseEntity.ok(
                CustomResponse.builder()
                        .message("Email sent Successfully!")
                        .httpStatus(String.valueOf(HttpStatus.OK))
                        .success(true)
                        .build()
        );
    }



}
