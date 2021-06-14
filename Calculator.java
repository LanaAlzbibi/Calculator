//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Calculator {
    private CalcString engine = new CalcString();
    private UserInterFaceString gui;

    public Calculator() {
        this.gui = new UserInterFaceString(this.engine);
    }

    public void show() {
        this.gui.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Calculator();
    }
}
