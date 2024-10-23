package oop.practice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int i = Integer.valueOf(args[args.length-1]);
        List<Display> displays = new ArrayList<>();

        Display display1 = new Display(1920, 1080, 401.5f, "Model A");
        Display display2 = new Display(2560, 1440, 530.3f, "Model B");
        Display display3 = new Display(1920, 1080, 401.5f, "Model C");

        displays.add(display1);
        displays.add(display2);
        displays.add(display3);

        Assistant assistant = new Assistant("Stewart");

        for (Display display : displays) {
            assistant.assignDisplay(display);
        }

        assistant.assist();
        System.out.println(assistant.buyDisplay(displays.get(i)));
    }
}