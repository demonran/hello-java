/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software GmbH, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.helloworld.disgester.config;


import java.util.Collections;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.logging.Log;

import org.quartz.CronTrigger;
import org.quartz.Trigger;


public class CmsScheduledJobInfo  {


    /** Indicates if this job is currently active in the scheduler or not. */
    private boolean m_active;

    /** The name of the class to schedule. */
    private String m_className;

    /** The context information for the user to execute the job with. */
    private CmsContextInfo m_context;

    /** The cron expression for this scheduler job. */
    private String m_cronExpression;

    /** Indicates if the configuration of this job is finalized (frozen). */
    private boolean m_frozen;

    /** The id of this job. */
    private String m_id;

//    /** Instance object of the scheduled job (only required when instance is re-used). */
//    private I_CmsScheduledJob m_jobInstance;

    /** The name of the job (for information purposes). */
    private String m_jobName;

    /** The parameters used for this job entry. */
    private SortedMap<String, String> m_parameters;

    /** Indicates if the job instance should be re-used if the job is run. */
    private boolean m_reuseInstance;

    /** The (cron) trigger used for scheduling this job. */
    private Trigger m_trigger;

    /**
     * Default constructor.<p>
     */
    public CmsScheduledJobInfo() {

        m_reuseInstance = false;
        m_frozen = false;
        // parameters are stored in a tree map 
        m_parameters = new TreeMap<String, String>();
        // a job is active by default
        m_active = true;
    }

    /**
     * Constructor for creating a new job with all required parameters.<p> 
     * 
     * @param id the id of the job of <code>null</code> if a new id should be automatically generated
     * @param jobName the display name of the job 
     * @param className the class name of the job, must be an instance of <code>{@link I_CmsScheduledJob}</code>
     * @param context the OpenCms user context information to use when executing the job
     * @param cronExpression the cron expression for scheduling the job
     * @param reuseInstance indicates if the job class should be re-used
     * @param active indicates if the job should be active in the scheduler
     * @param parameters the job parameters
     */
    public CmsScheduledJobInfo(
//        String id,
        String jobName,
        String className,
        String cronExpression,
        boolean reuseInstance,
        boolean active
        ) {

        m_frozen = false;
//        setId(id);
//        if (CmsStringUtil.isNotEmpty(jobName)) {
//            // job name is optional, if not present class name will be used
//            setJobName(jobName);
//        }
        setClassName(className);
//        setContextInfo(context);
        setCronExpression(cronExpression);
        setReuseInstance(reuseInstance);
        setActive(active);
//        setParameters(parameters);
        
System.out.println("--------------"+jobName);
    }

    /**
     * @see org.opencms.configuration.I_CmsConfigurationParameterHandler#addConfigurationParameter(java.lang.String, java.lang.String)
     */
    public void addConfigurationParameter(String paramName, String paramValue) {

        checkFrozen();
        // add the configured parameter
        m_parameters.put(paramName, paramValue);
//        if (LOG.isDebugEnabled()) {
//            LOG.debug(org.opencms.configuration.Messages.get().getBundle().key(
//                org.opencms.configuration.Messages.LOG_ADD_CONFIG_PARAM_3,
//                paramName,
//                paramValue,
//                this));
//        }
    }

    /**
     * Clears the id of the job.<p>
     * 
     * This is useful if you want to create a copy of a job without keeping the job id.
     * Use <code>{@link CmsScheduledJobInfo#clone()}</code> first to create the copy,
     * and then clear the id of the clone.<p>
     */
    public void clearId() {

        setId(null);
    }

    /**
     * Creates a clone of this scheduled job.<p>
     * 
     * The clone will not be active in the scheduler until it is scheduled
     * with <code>{@link CmsScheduleManager#scheduleJob(org.opencms.file.CmsObject, CmsScheduledJobInfo)}</code>. 
     * The job id returned by <code>{@link #getId()}</code> will be the same.
     * The <code>{@link #isActive()}</code> flag will be set to false. 
     * The clones job instance class will be the same 
     * if the <code>{@link #isReuseInstance()}</code> flag is set.<p>
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() {

        CmsScheduledJobInfo result = new CmsScheduledJobInfo();

        result.m_id = m_id;
        result.m_active = false;
        result.m_frozen = false;
        result.m_className = m_className;
//        if (isReuseInstance()) {
//            result.m_jobInstance = m_jobInstance;
//        }
        result.m_reuseInstance = m_reuseInstance;
        result.m_context = (CmsContextInfo)m_context.clone();
        result.m_cronExpression = m_cronExpression;
        result.m_jobName = m_jobName;
        result.m_parameters = new TreeMap<String, String>(m_parameters);
        result.m_trigger = null;

        return result;
    }

    /**
     * Returns the name of the class to schedule.<p>
     * 
     * @return the name of the class to schedule
     */
    public String getClassName() {

        return m_className;
    }

    /**
     * @see org.opencms.configuration.I_CmsConfigurationParameterHandler#getConfiguration()
     */
//    public CmsParameterConfiguration getConfiguration() {
//
//        // this configuration does not support parameters
//        if (LOG.isDebugEnabled()) {
//            LOG.debug(org.opencms.configuration.Messages.get().getBundle().key(
//                org.opencms.configuration.Messages.LOG_GET_CONFIGURATION_1,
//                this));
//        }
//
//        return new CmsParameterConfiguration(getParameters());
//    }

    /**
     * Returns the context information for the user executing this job.<p>
     *
     * Please note: The context time returned by {@link org.opencms.file.CmsRequestContext#getRequestTime()}
     * will be set to the time when this job was created.
     * This can be relevant in case you want to perform VFS operations, because it will 
     * affect how resources are processed that have date released / date expired attributes set.<p>
     *
     * @return the context information for the user executing this job
     */
    public CmsContextInfo getContextInfo() {

        return m_context;
    }

    /**
     * Returns the cron expression for this job entry.<p>
     * 
     * @return the cron expression for this job entry
     */
    public String getCronExpression() {

        return m_cronExpression;
    }

    /**
     * Returns the next time at which this job will be executed, after the given time.<p>
     * 
     * If this job will not be executed after the given time, <code>null</code> will be returned..<p>
     * 
     * @param date the after which the next execution time should be calculated
     * @return the next time at which this job will be executed, after the given time
     */
    public Date getExecutionTimeAfter(Date date) {

        if (!m_active || (m_trigger == null)) {
            // if the job is not active, no time can be calculated
            return null;
        }

        return m_trigger.getFireTimeAfter(date);
    }

    /**
     * Returns the next time at which this job will be executed.<p> 
     * 
     * If the job will not execute again, <code>null</code> will be returned.<p>
     * 
     * @return the next time at which this job will be executed
     */
    public Date getExecutionTimeNext() {

        if (!m_active || (m_trigger == null)) {
            // if the job is not active, no time can be calculated
            return null;
        }

        return m_trigger.getNextFireTime();
    }

    /**
     * Returns the previous time at which this job will be executed.<p>
     * 
     * If this job has not yet been executed, <code>null</code> will be returned.
     * 
     * @return the previous time at which this job will be executed
     */
    public Date getExecutionTimePrevious() {

        if (!m_active || (m_trigger == null)) {
            // if the job is not active, no time can be calculated
            return null;
        }

        return m_trigger.getPreviousFireTime();
    }

    /**
     * Returns the internal id of this job in the scheduler.<p>
     * 
     * Can be used to remove this job from the scheduler with 
     * <code>{@link CmsScheduleManager#unscheduleJob(org.opencms.file.CmsObject, String)}</code>.<p> 
     * 
     * @return the internal id of this job in the scheduler
     */
    public String getId() {

        return m_id;
    }

    /**
     * Returns an instance of the configured job class.<p>
     * 
     * If any error occurs during class invocaion, the error 
     * is written to the OpenCms log and <code>null</code> is returned.<p>
     *
     * @return an instance of the configured job class, or null if an error occurred
     */
//    public synchronized I_CmsScheduledJob getJobInstance() {
//
//        if (m_jobInstance != null) {
//
//            if (LOG.isDebugEnabled()) {
//                LOG.debug(Messages.get().getBundle().key(
//                    Messages.LOG_REUSING_INSTANCE_1,
//                    m_jobInstance.getClass().getName()));
//            }
//
//            // job instance already initialized
//            return m_jobInstance;
//        }
//
//        I_CmsScheduledJob job = null;
//
//        try {
//            // create an instance of the OpenCms job class
//            job = (I_CmsScheduledJob)Class.forName(getClassName()).newInstance();
//        } catch (ClassNotFoundException e) {
//            LOG.error(Messages.get().getBundle().key(Messages.LOG_CLASS_NOT_FOUND_1, getClassName()), e);
//        } catch (IllegalAccessException e) {
//            LOG.error(Messages.get().getBundle().key(Messages.LOG_ILLEGAL_ACCESS_0), e);
//        } catch (InstantiationException e) {
//            LOG.error(Messages.get().getBundle().key(Messages.LOG_INSTANCE_GENERATION_0), e);
//        } catch (ClassCastException e) {
//            LOG.error(Messages.get().getBundle().key(Messages.LOG_BAD_INTERFACE_0), e);
//        }
//
//        if (m_reuseInstance) {
//            // job instance must be re-used
//            m_jobInstance = job;
//        }
//
//        if (LOG.isDebugEnabled()) {
//            LOG.debug(Messages.get().getBundle().key(Messages.LOG_JOB_CREATED_1, getClassName()));
//        }
//
//        // this should not flood the log files: if class name is wrong or jar files missing this will 
//        // most likely persist until restart. 
//        if (job == null) {
//            setActive(false);
//        }
//        return job;
//    }

    /**
     * Returns the job name.<p>
     *
     * @return the job name
     */
    public String getJobName() {

        return m_jobName;
    }

    /**
     * Returns the parameters.<p>
     *
     * @return the parameters
     */
    public SortedMap<String, String> getParameters() {

        return m_parameters;
    }

    /**
     * Finalizes (freezes) the configuration of this scheduler job entry.<p>
     * 
     * After this job entry has been frozen, any attempt to change the 
     * configuration of this entry with one of the "set..." methods
     * will lead to a <code>RuntimeException</code>.<p> 
     * 
     * @see org.opencms.configuration.I_CmsConfigurationParameterHandler#initConfiguration()
     */
    public void initConfiguration() {

        // simple default configuration does not need to be initialized
//        if (LOG.isDebugEnabled()) {
//            LOG.debug(org.opencms.configuration.Messages.get().getBundle().key(
//                org.opencms.configuration.Messages.LOG_INIT_CONFIGURATION_1,
//                this));
//        }
        setFrozen(true);
    }

    /**
     * Returns <code>true</code> if this job is currently active in the scheduler.<p>
     *
     * @return <code>true</code> if this job is currently active in the scheduler
     */
    public boolean isActive() {

        return m_active;
    }

    /**
     * Returns true if the job instance class is reused for this job.<p>
     *
     * @return true if the job instance class is reused for this job
     */
    public boolean isReuseInstance() {

        return m_reuseInstance;
    }

    /**
     * Sets the active state of this job.<p>
     *
     * @param active the active state to set
     */
    public void setActive(boolean active) {

        checkFrozen();
        m_active = active;
    }

    /**
     * Sets the name of the class to schedule.<p>
     * 
     * @param className the class name to set
     */
    public void setClassName(String className) {

        checkFrozen();
        if (className != null) {
            // remove leading or trailing white space
            className = className.trim();
        }
//        if (!CmsStringUtil.isValidJavaClassName(className)) {
//            CmsMessageContainer message = Messages.get().container(Messages.ERR_BAD_JOB_CLASS_NAME_1, className);
//            if (OpenCms.getRunLevel() > OpenCms.RUNLEVEL_2_INITIALIZING) {
//                throw new CmsIllegalArgumentException(message);
//            } else {
//                LOG.warn(message.key());
//            }
//        } else {
//            Class<?> jobClass;
//            try {
//                jobClass = Class.forName(className);
//                if (!I_CmsScheduledJob.class.isAssignableFrom(jobClass)) {
//                    CmsMessageContainer message = Messages.get().container(
//                        Messages.ERR_JOB_CLASS_BAD_INTERFACE_2,
//                        className,
//                        I_CmsScheduledJob.class.getName());
//
//                    if (OpenCms.getRunLevel() > OpenCms.RUNLEVEL_2_INITIALIZING) {
//                        throw new CmsIllegalArgumentException(message);
//                    } else {
//                        LOG.warn(message.key());
//                    }
//
//                }
//            } catch (ClassNotFoundException e) {
//                CmsMessageContainer message = Messages.get().container(Messages.ERR_JOB_CLASS_NOT_FOUND_1, className);
//                if (OpenCms.getRunLevel() > OpenCms.RUNLEVEL_2_INITIALIZING) {
//                    throw new CmsIllegalArgumentException(message);
//                } else {
//                    LOG.warn(message.key());
//                }
//
//            }
//        }
        m_className = className;
        if (getJobName() == null) {
            // initialize job name with class name as default
            setJobName(className);
        }

    }

    /**
     * Sets the context information for the user executing the job.<p>
     *
     * This will also "freeze" the context information that is set.<p>
     *
     * @param contextInfo the context information for the user executing the job
     * 
     * @see CmsContextInfo#freeze()
     */
    public void setContextInfo(CmsContextInfo contextInfo) {

        checkFrozen();
//        if (contextInfo == null) {
//            throw new CmsIllegalArgumentException(Messages.get().container(Messages.ERR_BAD_CONTEXT_INFO_0));
//        }
        m_context = contextInfo;
    }

    /**
     * Sets the cron expression for this job entry.<p>
     * 
     * @param cronExpression the cron expression to set
     */
    public void setCronExpression(String cronExpression) {

        checkFrozen();

        try {
            // check if the cron expression is valid
            new CronTrigger().setCronExpression(cronExpression);
        } catch (Exception e) {
//            throw new CmsIllegalArgumentException(Messages.get().container(
//                Messages.ERR_BAD_CRON_EXPRESSION_2,
//                getJobName(),
//                cronExpression));
        }

        m_cronExpression = cronExpression;
    }

    /**
     * Sets the job name.<p>
     *
     * @param jobName the job name to set
     */
    public void setJobName(String jobName) {

        checkFrozen();
//        if (CmsStringUtil.isEmpty(jobName) || !jobName.trim().equals(jobName)) {
//            throw new IllegalArgumentException(jobName);
//
//        }
        m_jobName = jobName;
    }

    /**
     * Sets the job parameters.<p>
     *
     * @param parameters the parameters to set
     */
    public void setParameters(SortedMap<String, String> parameters) {

        checkFrozen();
        if (parameters == null) {
            throw new IllegalArgumentException();
        }
        // make sure the parameters are a sorted map
        m_parameters = new TreeMap<String, String>(parameters);
    }

    /**
     * Controls if the job instance class is reused for this job,
     * of if a new instance is generated every time the job is run.<p>
     * 
     * @param reuseInstance must be true if the job instance class is to be reused
     */
    public void setReuseInstance(boolean reuseInstance) {

        checkFrozen();
        m_reuseInstance = reuseInstance;
    }

    /**
     * Checks if this job info configuration is frozen.<p>
     * 
     * @throws CmsRuntimeException in case the configuration is already frozen
     */
    protected void checkFrozen() throws RuntimeException {

        if (m_frozen) {
            throw new RuntimeException( getJobName());
        }
    }

    /**
     * Returns the Quartz trigger used for scheduling this job.<p>
     *
     * This is an internal operation that should only by performed by the 
     * <code>{@link CmsScheduleManager}</code>, never by using this API directly.<p>
     * 
     * @return the Quartz trigger used for scheduling this job
     */
    protected Trigger getTrigger() {

        return m_trigger;
    }

    /**
     * Sets the "frozen" state of this job.<p>
     *
     * This is an internal operation to be used only by the <code>{@link CmsScheduleManager}</code>.<p>
     *
     * @param frozen the "frozen" state to set
     */
    protected synchronized void setFrozen(boolean frozen) {

        if (frozen && !m_frozen) {
            // "freeze" the job configuration
            m_parameters = Collections.unmodifiableSortedMap(m_parameters);
            m_context.freeze();
            m_frozen = true;
        } else if (!frozen && m_frozen) {
            // "unfreeze" the job configuration
            m_parameters = new TreeMap<String, String>(m_parameters);
            m_frozen = false;
        }
    }

    /**
     * Sets the is used for scheduling this job.<p>
     *
     * This is an internal operation that should only by performed by the 
     * <code>{@link CmsScheduleManager}</code>, never by using this API directly.<p>
     * 
     * @param id the id to set
     */
    protected void setId(String id) {

        checkFrozen();
        m_id = id;
    }

    /**
     * Sets the Quartz trigger used for scheduling this job.<p>
     *
     * This is an internal operation that should only by performed by the 
     * <code>{@link CmsScheduleManager}</code>, never by using this API directly.<p>
     * 
     * @param trigger the Quartz trigger to set
     */
    protected void setTrigger(Trigger trigger) {

        checkFrozen();
        m_trigger = trigger;
    }

    /**
     * Updates the request time in the internal context information of the user with the current system time.<p>
     * 
     * This is required before executing the job, otherwise the context information request time would be the time
     * the context object was initially created.<p>
     */
    protected void updateContextRequestTime() {

        CmsContextInfo context = (CmsContextInfo)m_context.clone();
        context.setRequestTime(System.currentTimeMillis());
        context.freeze();
        m_context = context;
    }
}