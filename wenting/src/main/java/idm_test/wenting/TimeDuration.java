package idm_test.wenting;

public class TimeDuration {
	public int seconds = 0;

	public TimeDuration(int s) throws BadBadValueException {
		if (s < 0) {
			throw new BadBadValueException("The number of seconds should not be negative!");
		} else {
			seconds = s;
		}
	}

	public String toString() {
		String time;
		int hour = seconds / 3600;
		int minute = seconds % 3600 / 60;
		int second = seconds % 60;
		if(hour == 0 && minute == 0) {
			time = second + "s";
		}
		else if(hour == 0) {
			time = minute + "m " + second + "s";
		}
		else {
			time = hour + "h " + minute + "m " + second + "s";
		}
		System.out.println(time);
		return time;
	}
	
	public static void main(String[] args) {
		try {
			new TimeDuration(0).toString();
			new TimeDuration(732).toString();
			new TimeDuration(7242).toString();
		} catch (BadBadValueException e) {
			System.out.println("BadBadValueException");
		}
	}
}
