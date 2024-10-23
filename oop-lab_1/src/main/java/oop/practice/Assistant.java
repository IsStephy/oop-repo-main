package oop.practice;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    public void assist() {
        for (int i = 0; i < assignedDisplays.size(); i++) {
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                Display displayA = assignedDisplays.get(i);
                Display displayB = assignedDisplays.get(j);
                System.out.println("Assisting with comparison of " + displayA.getModel() + " and " + displayB.getModel());
                displayA.compareWithMonitor(displayB);
                System.out.println();
            }
        }
    }
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            return d;
        }
        return null;
    }
}
