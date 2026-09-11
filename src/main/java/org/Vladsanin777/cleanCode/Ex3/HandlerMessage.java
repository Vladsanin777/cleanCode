package org.Vladsanin777.cleanCode.Ex3;

import static org.Vladsanin777.cleanCode.Ex3.HandlerMessage.Status.*;

public class HandlerMessage {
    private String m_message = null;
    private Status m_status = SUCCESS;
    private int m_countRetries = 0;

    private final static String URL = "http://internal-api.example.com/v1/data";
    private final static int MAX_RETRIES = 5;

    public enum Status {
        SUCCESS, WARNING, ERROR, FATAL_ERROR
    }

    public HandlerMessage(Status status) {
        m_status = status;
    }

    protected void handler() {
        switch (m_status) {
            case SUCCESS:
                if (null != m_message) {
                    sendNotification("SUCCESS", m_message);
                }
                break;
            case WARNING:
                sendNotification("WARNING", m_message);
                break;
            case ERROR:
                sendNotification("ERROR", m_message);
                break;
            case FATAL_ERROR:
                sendNotification("FATAL_ERROR", m_message);
                break;
        }

        System.out.println("Our API Reference: " + URL);

        System.out.println("You spent " + m_countRetries + " retries.");
    }

    public void updateStatus(Status status, String message) {
        if (m_countRetries >= MAX_RETRIES) {
            System.out.println("You have not retries!!!");
            return;
        }

        m_countRetries++;

        m_status = status;
        m_message = message;

        handler();
    }

    private static void sendNotification(String level, String message) {
        System.out.println("[" + level + "] Sending notification: " + message);
    }

    public Status getStatus() {
        return m_status;
    }
}
