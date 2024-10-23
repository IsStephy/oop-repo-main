package oop.practice;


public class Display {
    // Attributes
    private int width;
    private int height;
    private float ppi;
    private String model;


    // Constructor
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }
    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }


    public float getPpi() {
        return ppi;
    }


    public String getModel() {
        return model;
    }
    public void compareSize(Display m) {
        int thisArea = this.width * this.height;
        int otherArea = m.getWidth() * m.getHeight();


        if (thisArea > otherArea) {
            System.out.println(this.model + " has a larger display than " + m.getModel());
        } else if (thisArea < otherArea) {
            System.out.println(m.getModel() + " has a larger display than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.getModel() + " have the same display size.");
        }
    }


    // Method to compare sharpness (ppi comparison)
    public void compareSharpness(Display m) {
        if (this.ppi > m.getPpi()) {
            System.out.println(this.model + " is sharper than " + m.getModel());
        } else if (this.ppi < m.getPpi()) {
            System.out.println(m.getModel() + " is sharper than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.getModel() + " have the same sharpness.");
        }
    }

    public void compareWithMonitor(Display m) {
        compareSize(m);
        compareSharpness(m);
    }

}
