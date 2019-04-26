package com.hellojava.quartz;

import java.util.UUID;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class ScheduleManager implements Job{
	
	private Scheduler m_scheduler;

	public void initialize()
	{
		  // Quartz scheduler settings
//        Properties properties = new Properties();
//        properties.put(StdSchedulerFactory.PROP_SCHED_INSTANCE_NAME, "OpenCmsScheduler");
//        properties.put(StdSchedulerFactory.PROP_SCHED_THREAD_NAME, "OpenCms: Scheduler");
//        properties.put(StdSchedulerFactory.PROP_SCHED_RMI_EXPORT, false);
//        properties.put(StdSchedulerFactory.PROP_SCHED_RMI_PROXY, false);
//        properties.put(StdSchedulerFactory.PROP_JOB_STORE_CLASS, "org.quartz.simpl.RAMJobStore");
//        properties.put(StdSchedulerFactory.PROP_THREAD_POOL_CLASS, "org.quartz.simpl.SimpleThreadPool");
//        properties.put(StdSchedulerFactory., "org.quartz.simpl.SimpleThreadPool");
        
        
        try {
            // initialize the Quartz scheduler
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            m_scheduler = schedulerFactory.getScheduler();
        } catch (Exception e) {
            // can not continue
        	e.printStackTrace();
            m_scheduler = null;
            return;
        }
        
        UUID jobUUID = UUID.randomUUID();
        String jobId = "OpenCmsJob_".concat(jobUUID.toString());
        
        // generate Quartz job trigger
        CronTrigger trigger = new CronTrigger(jobId, Scheduler.DEFAULT_GROUP);
        
        JobDetail jobDetail = new JobDetail(jobId, Scheduler.DEFAULT_GROUP, ScheduleManager.class);

        
        
        String cronExpr = "1/2 * * * * ? *";
            // set the cron expression
        	
        // finally add the job to the Quartz scheduler
            try {
            	trigger.setCronExpression(cronExpr);
				m_scheduler.scheduleJob(jobDetail, trigger);
				  m_scheduler.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
          
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("����");
		
	}
}
