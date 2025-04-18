public class APCalendar {

private static boolean isLeapYear(int year) { 
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) return true;
    return false;
}

public static int numberOfLeapYears(int year1, int year2) {
    int count = 0;
    for (int year = year1; year <= year2; year++) {
        if (isLeapYear(year) == true) count++;
    }
    return count;
}
 
private static int firstDayOfYear(int year) {  
    int day = 1;
    for(int i = 1; i < year; i++) {
        day++;
        if (isLeapYear(i)) day++;
    }
    return day % 7;
}

private static int dayOfYear(int month, int day, int year) {
    int days = 0;
    if (month > 1) days += 31;
    if (month > 2) days += 28;
    if (isLeapYear(year)) days++;
    if (month > 3) days += 31;
    if (month > 4) days += 30;
    if (month > 5) days += 31;
    if (month > 6) days += 30;
    if (month > 7) days += 31;
    if (month > 8) days += 31;
    if (month > 9) days += 30;
    if (month > 10) days += 31;
    if (month > 11) days += 30;
    days += day;
    return days;
}

public static int dayOfWeek(int month, int day, int year) {  
    int days = dayOfYear(month, day, year) % 7;
    return firstDayOfYear(year) + day - 1;
}

}