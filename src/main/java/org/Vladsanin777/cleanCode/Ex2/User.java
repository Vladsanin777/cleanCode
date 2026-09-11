package org.Vladsanin777.cleanCode.Ex2;

import java.time.LocalDate;

public class User {
    private long m_id = 0;
    private String m_login = null;
    private String m_hashPassword = null;
    private String m_jwt = null;
    private long m_sendingMessages = 0;

    public User(long id, String login, String hashPassword, String jwt) {
        m_id = id;
        m_login = login;
        m_hashPassword = hashPassword;
        m_jwt = jwt;
    }

    public void send(long channelId, long messageId) {
        m_sendingMessages++;

        if (isAuthorized()) {
            System.out.println("Channel ID: " + channelId + ", Message ID: " + messageId);
        }
    }

    public boolean isAuthorized() {
        return null != m_login && null != m_hashPassword && null != m_jwt;
    }

    public static LocalDate tomorrow() {
        return LocalDate.now().plusDays(1);
    }
    
    public long getId() {
        return m_id;
    }

    public String getLogin() {
        return m_login;
    }

    public long getSendingMessages() {
        return m_sendingMessages;
    }
}
