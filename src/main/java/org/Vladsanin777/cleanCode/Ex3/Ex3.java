package org.Vladsanin777.cleanCode.Ex3;

import static org.Vladsanin777.cleanCode.Ex3.HandlerMessage.Status.*;

public class Ex3 {
    public static void main(String[] args) {
        HandlerMessage handlerMessage = new HandlerMessage(SUCCESS);

        handlerMessage.handler();

        handlerMessage.updateStatus(HandlerMessage.Status.WARNING, "Found high ping API");

        handlerMessage.updateStatus(HandlerMessage.Status.ERROR, "Fail connect to Data Base");

        for (int i = 1; i <= 6; i++) {
            handlerMessage.updateStatus(HandlerMessage.Status.FATAL_ERROR, "Fatal error system #" + i);
        }

        System.out.println("\nFinal status: " + handlerMessage.getStatus());
    }
}
