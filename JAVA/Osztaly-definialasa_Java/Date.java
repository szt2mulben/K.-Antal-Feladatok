public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        if (isCorrectDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            System.out.println("Hibás dátum!");
        }
    }

    private boolean isCorrectDate(int year, int month, int day) {
        if (month >= 1 && month <= 12) {
            if (day >= 1 && day <= 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
                return true;
            } else if (day >= 1 && day <= 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
                return true;
            } else if (month == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return day >= 1 && day <= 29;
                } else {
                    return day >= 1 && day <= 28;
                }
            }
        }
        return false;
    }

    public void printDate() {
        System.out.println("Dátum: " + year + "." + formatNumber(month) + "." + formatNumber(day) + ".");
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        if (isCorrectDate(year, this.month, this.day)) {
            this.year = year;
        } else {
            System.out.println("Hibás év!");
        }
    }

    public void setMonth(int month) {
        if (isCorrectDate(this.year, month, this.day)) {
            this.month = month;
        } else {
            System.out.println("Hibás hónap!");
        }
    }

    public void setDay(int day) {
        if (isCorrectDate(this.year, this.month, day)) {
            this.day = day;
        } else {
            System.out.println("Hibás nap!");
        }
    }

    private String formatNumber(int number) {
        return (number < 10) ? "0" + number : String.valueOf(number);
    }

    public static void main(String[] args) {
        Date correctDate = new Date(2023, 10, 12);
        correctDate.printDate(); 
        
       // Date incorrectDate = new Date(2023, 13, 32); 

        Date firstDayOfMonth = new Date(2023, 10, 1);
        firstDayOfMonth.printDate(); 
    }

    
}
