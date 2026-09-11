package org.Vladsanin777.cleanCode.Ex1;

import static org.Vladsanin777.cleanCode.Ex1.CalculateExperience.Status.*;

class Ex1 {
    public static void main(String[] args) {
        CalculateExperience user = new CalculateExperience(10, VIP);
        System.out.println("Experience VIP 10 points: "
                + user.getExperience()); // 10 * 1.5 + 100 = 115.0
        
        user.updateStatus(ADMINISTRATOR);
        user.addPoints(10);
        System.out.println("Experience VIP 10 points and ADMINISTRATOR 10 points: "
                + user.getExperience()); // 115.0 + 10 * 1.5 + 150 = 280.0
    }
}
