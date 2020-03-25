package it.dstech.scheduled.restcontroller;

import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.scheduled.model.Sched;

@RestController
public class ExampleRest {

	@Autowired
	TaskScheduler scheduler;

	@GetMapping("/cron")
	public boolean addCron(@RequestBody Sched sched) {
		LocalDateTime dateTime = sched.getDate();
		int minute = dateTime.getMinute();
		int hours = dateTime.getHour();
		int day = dateTime.getDayOfMonth();
		int month = dateTime.getMonth().getValue();
		String expression = " 0 " + minute + " " + hours + " " + day + " " + month + " ?";
		System.out.println(expression);
		CronTrigger trigger = new CronTrigger(expression, TimeZone.getTimeZone(TimeZone.getDefault().getID()));
		scheduler.schedule(sched, trigger);

		return true;
	}
}
