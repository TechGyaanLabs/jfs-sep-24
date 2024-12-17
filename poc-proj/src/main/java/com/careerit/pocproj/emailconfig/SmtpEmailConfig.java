package com.careerit.pocproj.emailconfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmtpEmailConfig extends EmailConfig {

    private boolean starttlsEnable;
    private boolean auth;
}
