package org.Vladsanin777.cleanCode.Ex1;

import static org.Vladsanin777.cleanCode.Ex1.CalculateExperience.Status.*;

public class CalculateExperience {
    private int m_points = 0;
    private Status m_status = USER;
    private double m_experience = 0.0;
    private int m_bonus = 0;

    private final static double COEFFICIENT = 1.5;

    private final static int BONUS_USER = 0;
    private final static int BONUS_VIP = 100;
    private final static int BONUS_ADMINISTRATOR = 150;

    public enum Status {
        USER, VIP, ADMINISTRATOR
    }

    public CalculateExperience() {
        this(0, USER);
    }

    public CalculateExperience(int points) {
        this(points, USER);
    }

    public CalculateExperience(int points, Status status) {
        m_points = Math.max(0, points);
        m_status = status;
        updateExperience();
    }

    protected void updateExperience() {
        int bonus =  switch (m_status) {
            case USER -> BONUS_USER;
            case VIP -> BONUS_VIP;
            case ADMINISTRATOR -> BONUS_ADMINISTRATOR;
        };
        m_bonus += bonus;
        m_experience = m_points * 1.5 + m_bonus;
    }

    public int getPoints() {
        return m_points;
    }

    public Status getStatus() {
        return m_status;
    }

    public double getExperience() {
        return m_experience;
    }

    public double getBonusExperience() {
        return m_bonus;
    }

    public void addPoints(int points) {
        m_points += points;
        updateExperience();
    }

    public void updateStatus(Status status) {
        m_status = status;
    }
}
