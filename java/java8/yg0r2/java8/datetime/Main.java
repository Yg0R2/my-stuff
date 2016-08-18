/**
 * Copyright 2016 Yg0R2
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package yg0r2.java8.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author Yg0R2
 *
 * @see http://www.tutorialspoint.com/java8/java8_datetime_api.htm
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Main instance = new Main();

		instance.testLocalDateTime();

		System.out.println("---------------------------------------");

		instance.testZonedDateTime();

		System.out.println("---------------------------------------");

		instance.testChronoUnitsEnum();

		System.out.println("---------------------------------------");

		// It deals with date based amount of time.
		instance.testPeriod();

		System.out.println("---------------------------------------");

		// It deals with time based amount of time.
		instance.testDuration();

		System.out.println("---------------------------------------");

		instance.testAdjusters();

		System.out.println("---------------------------------------");

		instance.testBackwardCompatibility();
	}

	public void testAdjusters() {
		// Get current date
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current date: " + currentDate);

		// Get the next Tuesday
		LocalDate nextTuesday = currentDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday: " + nextTuesday);

		// Get the second Saturday of the next month
		LocalDate firstInYear = LocalDate.of(currentDate.getYear(), currentDate.plusMonths(1).getMonth(), 1);
		LocalDate firstSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
		LocalDate secondSaturday = firstSaturday.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday of the nex month: " + secondSaturday);
	}

	public void testBackwardCompatibility() {
		// Get current date
		Date currentDate = new Date();
		System.out.println("Current date: " + currentDate);

		// Get the instant of current date in terms of milliseconds
		Instant now = currentDate.toInstant();
		ZoneId currentZoneId = ZoneId.systemDefault();

		LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZoneId);
		System.out.println("Local date: " + localDateTime);

		ZonedDateTime zoneDateTime = ZonedDateTime.ofInstant(now, currentZoneId);
		System.out.println("Zoned date: " + zoneDateTime);
	}

	public void testChronoUnitsEnum() {
		// Get the current date
		LocalDate today = LocalDate.now();

		System.out.println("Current date:         " + today);

		// Add 1 week to the current date
		System.out.println("Next week:            " + today.plus(1, ChronoUnit.WEEKS));

		// Add 1 month to the current date
		System.out.println("Next month:           " + today.plus(1, ChronoUnit.MONTHS));

		// Add 1 year to the current date
		System.out.println("Next year:            " + today.plus(1, ChronoUnit.YEARS));

		// Add 10 years to the current date
		System.out.println("Date after ten years: " + today.plus(1, ChronoUnit.DECADES));
	}

	public void testDuration() {
		// Get current date
		LocalTime currentTime = LocalTime.now();
		System.out.println("Current time: " + currentTime);

		Duration twoHours = Duration.ofHours(2);

		LocalTime futureTime = currentTime.plus(twoHours);
		System.out.println("Future time:  " + futureTime);

		System.out.println("Duration: " + Duration.between(currentTime, futureTime));
	}

	public void testLocalDateTime() {
		// Get the current date and time
		LocalDateTime currentDateTime = LocalDateTime.now();

		System.out.println("Current DateTime: " + currentDateTime);

		System.out.println("Date: " + currentDateTime.toLocalDate());

		System.out.println("Time: " + currentDateTime.toLocalTime());

		Month month = currentDateTime.getMonth();
		int day = currentDateTime.getDayOfMonth();
		int second = currentDateTime.getSecond();

		System.out.println("Month: " + month + ", day: " + day + ", second: " + second);

		System.out.println(currentDateTime.withDayOfMonth(10).withYear(2012));

		// 10 December 2014
		System.out.println(LocalDate.of(2014, Month.DECEMBER, 10));

		// 22 hour 15 minutes
		System.out.println(LocalTime.of(22, 15));

		System.out.println(LocalTime.parse("20:15:30"));
	}

	public void testPeriod() {
		// Get current date
		LocalDate currentDate = LocalDate.now();
		System.out.println("Current date: " + currentDate);

		// Add 1 month to the current date
		LocalDate nextMonth = currentDate.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month:   " + nextMonth);

		System.out.println("Period: " + Period.between(nextMonth, currentDate));
	}

	public void testZonedDateTime() {
		// Get current date and time
		ZonedDateTime currentDateTime = ZonedDateTime.now();

		System.out.println("Current DateTime: " + currentDateTime);

		ZonedDateTime dateTime = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");

		System.out.println("Test dateTime: " + dateTime);
		System.out.println("to LocaleDateTime: " + dateTime.toLocalDateTime());
		System.out.println(
			"to Europe/Paris zone: " + ZonedDateTime.ofInstant(dateTime.toInstant(), ZoneId.of("Europe/Paris")));

		ZoneId zoneId = ZoneId.of("Europe/Paris");
		System.out.println("Zone id of Europe/Paris: " + zoneId);

		ZoneId currentZoneId = ZoneId.systemDefault();
		System.out.println("CurrentZoneId: " + currentZoneId);
	}

}
