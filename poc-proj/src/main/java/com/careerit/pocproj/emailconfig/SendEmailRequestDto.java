package com.careerit.pocproj.emailconfig;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
@Builder
public class SendEmailRequestDto {

    private List<String> toEmails;
    private List<String> ccEmails;
    private List<String> bccEmails;
    private String subject;
    private String body;
    private List<String> attachments;
    private Map<String,Object> keyValuePairs;
    private boolean html;

}
