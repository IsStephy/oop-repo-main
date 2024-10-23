package oop.practice;


import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println(args[0] + " " + args[1] + " " + args[2]);


        Display display1 = new Display(1920, 1080, 401.5f, "Model A");
        Display display2 = new Display(2560, 1440, 530.3f, "Model B");
        Display display3 = new Display(1920, 1080, 401.5f, "Model C");
        List<Display> displayList = new ArrayList<>();
        displayList.add(display1);
        displayList.add(display2);
        displayList.add(display3);


        int a = 0;
        for (int i = 0; i < displayList.size(); i++) {
            for (int j = i + 1; j < displayList.size(); j++) {
                Display displayA = displayList.get(i);
                Display displayB = displayList.get(j);


                System.out.println("Comparing " + displayA.getModel() + " with " + displayB.getModel());


                if (args[a].equals("0")) {
                    displayA.compareSize(displayB);
                }
                if (args[a].equals("1")) {
                    displayA.compareSharpness(displayB);
                }
                if (args[a].equals("2")) {
                    displayA.compareWithMonitor(displayB);
                }
                a += 1;
                System.out.println();
            }
        }
    }
}