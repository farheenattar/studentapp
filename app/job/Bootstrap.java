package job;

import play.jobs.Every;
import play.jobs.Job;

@Every("2s")
public class Bootstrap{
	public void doJob() {
		System.out.println("-------Scheduled job------"); }

}
