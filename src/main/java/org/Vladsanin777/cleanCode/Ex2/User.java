package org.Vladsanin777.cleanCode.Ex2;

import java.time.LocalDate;

public class User {
    private long m_id = 0;
    private String m_login = null;
    private String m_hashPassword = null;
    private ArrayList<String> m_jwt = new ArrayList<String>;
    private long m_sendingMessages = 0;
    private Ststus m_status = USER;

    public enum Status {
        RIP, USER, VIP, ADMINISTRATOR
    }

    public User(long id, String login, String hashPassword, String jwt) {
        this(id, login, hashPassword, jwt, USER);
    }

    public User(long id, String login, String hashPassword, String jwt, Status status) {
        m_id = id;
        m_login = login;
        m_hashPassword = hashPassword;
        m_jwt.add(jwt);
        m_status = status;
    }

    public boolean is() {
        return masterUser.isAuthorized() && !masterUser.isRip();
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

    public addJwt(String jwt) {
        m_jwt.add(jwt);
    }

    public removeJwt(String jwt) {
        m_jwt.remove(jwt);
    }

    public cleanJwt(String jwt) {
        m_jwt.clean();
    }

    public Status getStatus() {
        return m_status;
    }

    public void updateStatus(Status status) {
        m_status = status;
    }

    public boolean isRip() {
        return m_status == RIP;
    }

    public boolean isUser() {
        return m_status == USER;
    }

    public boolean isVip() {
        return m_status == VIP;
    }

    public boolean isAdministrator() {
        return m_status == ADMINISTRATOR;
    }
}
