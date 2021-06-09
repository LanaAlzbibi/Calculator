//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Calculator {
    private CalcString engine = new CalcString();
    private UserInterFaceStringHex gui;

    public Calculator() {
        this.gui = new UserInterFaceStringHex(this.engine);
    }

    public void show() {
        this.gui.setVisible(true);
    }

    public static void main(String[] args)
    {
        new Calculator();
    }
}
