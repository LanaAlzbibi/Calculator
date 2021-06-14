import static org.junit.jupiter.api.Assertions.*;

class UserInterFaceStringTest {

    @org.junit.jupiter.api.Test
    void actionPreformed() {
        CalcString c = new CalcString();
        UserInterFaceString s = new UserInterFaceString(c);
        c.evaluateInfix("2+3*5");
        assertEquals(17,c);
    }
}