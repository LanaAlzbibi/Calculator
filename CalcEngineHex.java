public class CalcEngineHex extends CalcEngine {
    public CalcEngineHex() {
    }

    public void numberPressedHex(String number) {
        if (number.equals("Clear")) {
            this.clear();
        }

        if (this.buildingDisplayValue) {
            this.displayValue = this.displayValue * 16 + this.getNumber(number);
        } else if (number.equals("A")) {
            this.displayValue = 10;
            this.buildingDisplayValue = true;
        } else if (number.equals("B")) {
            this.displayValue = 11;
            this.buildingDisplayValue = true;
        } else if (number.equals("C")) {
            this.displayValue = 12;
            this.buildingDisplayValue = true;
        } else if (number.equals("D")) {
            this.displayValue = 13;
            this.buildingDisplayValue = true;
        } else if (number.equals("E")) {
            this.displayValue = 14;
            this.buildingDisplayValue = true;
        } else if (number.equals("F")) {
            this.displayValue = 15;
            this.buildingDisplayValue = true;
        }

    }

    public String getDisplayValueHex() {
        return Integer.toHexString(this.displayValue);
    }

    private int getNumber(String number) {
        byte var3 = -1;
        switch(number.hashCode()) {
            case 65:
                if (number.equals("A")) {
                    var3 = 0;
                }
                break;
            case 66:
                if (number.equals("B")) {
                    var3 = 1;
                }
                break;
            case 67:
                if (number.equals("C")) {
                    var3 = 2;
                }
                break;
            case 68:
                if (number.equals("D")) {
                    var3 = 3;
                }
                break;
            case 69:
                if (number.equals("E")) {
                    var3 = 4;
                }
                break;
            case 70:
                if (number.equals("F")) {
                    var3 = 5;
                }
        }

        byte var10000;
        switch(var3) {
            case 0:
                var10000 = 10;
                break;
            case 1:
                var10000 = 11;
                break;
            case 2:
                var10000 = 12;
                break;
            case 3:
                var10000 = 13;
                break;
            case 4:
                var10000 = 14;
                break;
            case 5:
                var10000 = 15;
                break;
            default:
                var10000 = 0;
        }

        return var10000;
    }
}
