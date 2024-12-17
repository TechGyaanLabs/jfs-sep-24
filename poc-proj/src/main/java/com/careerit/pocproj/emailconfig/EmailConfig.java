package com.careerit.pocproj.emailconfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailConfig {

    private String host;
    private int port;
    private String username;
    private String password;
    private MailProvider provider;





    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public MailProvider getProvider() {
        return provider;
    }
}
