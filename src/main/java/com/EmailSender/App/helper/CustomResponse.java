package com.EmailSender.App.helper;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomResponse {


    private String message;


    private String httpStatus;


    private boolean success=false;


}
