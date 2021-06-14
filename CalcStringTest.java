import static org.junit.jupiter.api.Assertions.*;

class CalcStringTest {

    @org.junit.jupiter.api.Test
    void actionPreformed() {
        CalcString c = new CalcString();
        String svalue = c.evaluateInfix("2+3*5");
        double value = Double.parseDouble(svalue);
        assertEquals(17,value);


        String svalue1 = c.evaluateInfix("2+2+8/2");
        double value1 = Double.parseDouble(svalue1);
        assertEquals(8,value1);

        String svalue2 = c.evaluateInfix("5-3+5*1");
        double value2 = Double.parseDouble(svalue2);
        assertEquals(7,value2);

        String svalue3 = c.evaluateInfix("2*(5+5)");
        double value3 = Double.parseDouble(svalue3);
        assertEquals(20,value3);

    }

}