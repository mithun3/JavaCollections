package collections.comparator;

public class Time implements Comparable {
  private int hour, minute; 

  public Time(int hh, int mm) {
    this.hour = hh;
    this.minute = mm;
  }

  public int compareTo(Object o) {
    Time t = (Time) o;
    return hour != t.hour ? hour - t.hour : minute - t.minute;
  }

  public boolean equals(Object o) {
    Time t = (Time) o;
    return hour == t.hour && minute == t.minute;
  }

  public int hashCode() {
    return 60 * hour + minute;
  }
}