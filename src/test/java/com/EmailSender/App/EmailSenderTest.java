package com.EmailSender.App;


import com.EmailSender.App.helper.Message;
import com.EmailSender.App.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSenderTest() {
        System.out.println("sending email");
        emailService.sendEmail(
                "pksinghgolu76310@gmail.com",
                "email from spring boot",
                "this email is sending to the email service"
        );
    }


    @Test
    void emailSenderTester() {
        System.out.println("sending emailMultiple");

        emailService.sendEmailMultiple(
                new String[] {
                        "pksinghgolu76310@gmail.com",
                        "pk@gmail.com"
                },
                "by multiple",
                "this is my style"
        );
    }


    @Test
    void sendEmailWithHtml() {
        System.out.println("sending htmlEmail");

        String html =
                "<h1 style='color:red;border:1px solid pink;'>Priti, in the future if I propose to you, what will be your response?.</h1>";

        emailService.sendEmailWithHtml(
                "pksinghgolu76310@gmail.com",
                "🫠🫠🫠 (●'◡'●) ️",
                html   // pass the HTML here
        );
    }


    @Test
    void sendEmailWithFile() {
        emailService.sendEmailWithFile(
                "pksinghgolu76310@gmail.com",
                "🫠🫠🫠 (●'◡'●)",
                "this email contains file",
                new File("src/main/resources/email/pradeep.png")
        );
    }


    @Test
    void sendEmailWithFileStream() {

        File file= new File("src/main/resources/email/pradeep.png");
        try {
            InputStream is=new FileInputStream(file);
            emailService.sendEmailWithFile(
                    "pksinghgolu76310@gmail.com",
                    "🫠🫠🫠 (●'◡'●)",
                    "Prk Jii",
                     file.getName(),
                     is

                    );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



   @Test
    void getInbox(){
        List<Message>inboxMessages =emailService.getInboxMessages();
        inboxMessages.forEach(item ->{
            System.out.println(item.getSubject());
            System.out.println(item.getContent());
            System.out.println(item.getFiles());
            System.out.println("______________");
        });
    }
}



