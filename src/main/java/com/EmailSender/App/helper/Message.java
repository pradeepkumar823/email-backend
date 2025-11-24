package com.EmailSender.App.helper;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private String from;

    private String content;

    private List<String> files;

    private String  subject;

}
