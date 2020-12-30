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

package com.hellojava.disgester.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

/**
 * System master configuration class.<p>
 * 
 * @since 6.0.0
 */
public class CmsSystemConfiguration  {

    /** Enum for the user session mode. */
    public enum UserSessionMode {
        /** Only a single session per user is allowed. */
        single,
        /** Any number of sessions for a user are allowed. */
        standard
    }

    /** The attribute name for the deleted node. */
    public static final String A_DELETED = "deleted";

    /** The "error" attribute. */
    public static final String A_ERROR = "error";

    /** The "errorPage" attribute. */
    public static final String A_ERROR_PAGE = "errorPage";

    /** The "exclusive" attribute. */
    public static final String A_EXCLUSIVE = "exclusive";

    /** The "maxvisited" attribute. */
    public static final String A_MAXVISITED = "maxvisited";

    /** The "mode" attribute. */
    public static final String A_MODE = "mode";

    /** The "offline" attribute. */
    public static final String A_OFFLINE = "offline";

    /** The attribute name for the alias offset. */
    public static final String A_OFFSET = "offset";

    /** The "online" attribute. */
    public static final String A_ONLINE = "online";

    /** The "poolname" attribute. */
    public static final String A_POOLNAME = "poolname";

    /** The "position" attribute. */
    public static final String A_POSITION = "position";

    /** The "server" attribute. */
    public static final String A_SERVER = "server";

    /** The "title" attribute. */
    public static final String A_TITLE = "title";

    /** The "webserver" attribute. */
    public static final String A_WEBSERVER = "webserver";

    /** The name of the DTD for this configuration. */
    public static final String CONFIGURATION_DTD_NAME = "opencms-system.dtd";

    /** The default user session mode. */
    public static final UserSessionMode DEFAULT_USER_SESSION_MODE = UserSessionMode.standard;

    /** The name of the default XML file for this configuration. */
    public static final String DEFAULT_XML_FILE_NAME = "opencms-system.xml";

    /** The node name for the job "active" value. */
    public static final String N_ACTIVE = "active";

    /** The ade node name. */
    public static final String N_ADE = "ade";

    /** The ade-cache node name. */
    public static final String N_ADE_CACHE = "ade-cache";

    /** The node name for the alias node. */
    public static final String N_ALIAS = "alias";

    /** The node name for the authorization handler. */
    public static final String N_AUTHORIZATIONHANDLER = "authorizationhandler";

    /** The node name for the avgcachebytes node. */
    public static final String N_AVGCACHEBYTES = "avgcachebytes";

    /** The node name for the browser-based node. */
    public static final String N_BROWSER_BASED = "browser-based";

    /** The node name for the cache-enabled node. */
    public static final String N_CACHE_ENABLED = "cache-enabled";

    /** The node name for the cache-offline node. */
    public static final String N_CACHE_OFFLINE = "cache-offline";

    /** The node name for a job class. */
    public static final String N_CLASS = "class";
    
    public static final String N_NAME = "name";

    /** The configuration node name. */
    public static final String N_CONFIGURATION = "configuration";

    /** The containerpages node name. */
    public static final String N_CONTAINERPAGES = "containerpages";

    /** The duration after which responsible resource owners will be notified about out-dated content. */
    public static final String N_CONTENT_NOTIFICATION = "content-notification";

    /** The node name for the job context. */
    public static final String N_CONTEXT = "context";

    /** The node name for the job cron expression. */
    public static final String N_CRONEXPRESSION = "cronexpression";

    /** The node name for the defaultcontentencoding node. */
    public static final String N_DEFAULT_CONTENT_ENCODING = "defaultcontentencoding";

    /** The node name for the default-uri node. */
    public static final String N_DEFAULT_URI = "default-uri";

    /** The node name for the defaultusers expression. */
    public static final String N_DEFAULTUSERS = "defaultusers";

    /** The node name for the device selector node. */
    public static final String N_DEVICESELECTOR = "device-selector";

    /** The node name for the digest type. */
    public static final String N_DIGESTTYPE = "digest-type";

    /** The node name for the login account lock minutes.  */
    public static final String N_DISABLEMINUTES = "disableMinutes";

    /** The node name for the sitemap cache for documents. */
    public static final String N_DOCUMENTS = "documents";

    /** The node name for the email-interval node. */
    public static final String N_EMAIL_INTERVAL = "email-interval";

    /** The node name for the email-receiver node. */
    public static final String N_EMAIL_RECEIVER = "email-receiver";

    /** The node name for the email-sender node. */
    public static final String N_EMAIL_SENDER = "email-sender";

    /** The node name for the login message enabled flag. */
    public static final String N_ENABLED = "enabled";

    /** The node name for the login security option enabled flag. */
    public static final String N_ENABLESCURITY = "enableSecurity";

    /** The node name for the context encoding. */
    public static final String N_ENCODING = "encoding";

    /** The node name for the request handler classes. */
    public static final String N_EVENTMANAGER = "eventmanager";

    /** The node name for the events node. */
    public static final String N_EVENTS = "events";

    /** The node name for the flexcache node. */
    public static final String N_FLEXCACHE = "flexcache";

    /** The node name for the form-based node. */
    public static final String N_FORM_BASED = "form-based";

    /** The node name for the group-administrators node. */
    public static final String N_GROUP_ADMINISTRATORS = "group-administrators";

    /** The node name for the group-guests node. */
    public static final String N_GROUP_GUESTS = "group-guests";

    /** The node name for the group-projectmanagers node. */
    public static final String N_GROUP_PROJECTMANAGERS = "group-projectmanagers";

    /** The node name for the group-users node. */
    public static final String N_GROUP_USERS = "group-users";

    /** The groupcontainers node name. */
    public static final String N_GROUPCONTAINERS = "groupcontainers";

    /** The node name for the publish "history-size" value. */
    public static final String N_HISTORYSIZE = "history-size";

    /** The node name for the http-authentication node. */
    public static final String N_HTTP_AUTHENTICATION = "http-authentication";

    /** The node name for the internationalization node. */
    public static final String N_I18N = "internationalization";

    /** The node name for a job. */
    public static final String N_JOB = "job";

    /** The name of the class to generate cache keys. */
    public static final String N_KEYGENERATOR = "keygenerator";

    /** The node name for individual locales. */
    public static final String N_LOCALE = "locale";

    /** The node name for the locale handler. */
    public static final String N_LOCALEHANDLER = "localehandler";

    /** The node name for the configured locales. */
    public static final String N_LOCALESCONFIGURED = "localesconfigured";

    /** The node name for the default locale(s). */
    public static final String N_LOCALESDEFAULT = "localesdefault";

    /** The node name for the log-interval node. */
    public static final String N_LOG_INTERVAL = "log-interval";

    /** The node name for the login message login forbidden flag. */
    public static final String N_LOGINFORBIDDEN = "loginForbidden";

    /** The node name for the login manager. */
    public static final String N_LOGINMANAGER = "loginmanager";

    /** The node name for the login message. */
    public static final String N_LOGINMESSAGE = "loginmessage";

    /** The node name for the mail configuration. */
    public static final String N_MAIL = "mail";

    /** The node name for the "mail from" node. */
    public static final String N_MAILFROM = "mailfrom";

    /** The node name for the "mail host" node. */
    public static final String N_MAILHOST = "mailhost";

    /** The node name for the login manager bad attempt count. */
    public static final String N_MAXBADATTEMPTS = "maxBadAttempts";

    /** The node name for the maxcachebytes node. */
    public static final String N_MAXCACHEBYTES = "maxcachebytes";

    /** The node name for the maxentrybytes node. */
    public static final String N_MAXENTRYBYTES = "maxentrybytes";

    /** The node name for the maxkeys node. */
    public static final String N_MAXKEYS = "maxkeys";

    /** The node name for the maxusagepercent node. */
    public static final String N_MAXUSAGE_PERCENT = "maxusagepercent";

    /** The node name for the memorymonitor node. */
    public static final String N_MEMORYMONITOR = "memorymonitor";

    /** The node name for the login message text. */
    public static final String N_MESSAGE = "message";

    /** The duration after which responsibles will be notified about out-dated content. */
    public static final String N_NOTIFICATION_PROJECT = "notification-project";

    /** The duration after which responsibles will be notified about out-dated content. */
    public static final String N_NOTIFICATION_TIME = "notification-time";

    /** The node name for the job parameters. */
    public static final String N_PARAMETERS = "parameters";

    /** The node name for the password encoding. */
    public static final String N_PASSWORDENCODING = "encoding";

    /** The node name for the password handler. */
    public static final String N_PASSWORDHANDLER = "passwordhandler";

    /** The node name for the permission handler. */
    public static final String N_PERMISSIONHANDLER = "permissionhandler";

    /** The node name for the prevent-response-flush node. */
    public static final String N_PREVENTRESPONSEFLUSH = "prevent-response-flush";

    /** The node name for the context project name. */
    public static final String N_PROJECT = "project";

    /** The node name for the "publishhistory" section. */
    public static final String N_PUBLISHMANAGER = "publishmanager";

    /** The node name for the "publishhistory" section. */
    public static final String N_QUEUEPERSISTANCE = "queue-persistance";

    /** The node name for the "publishhistory" section. */
    public static final String N_QUEUESHUTDOWNTIME = "queue-shutdowntime";

    /** The node name for the memory email receiver. */
    public static final String N_RECEIVER = "receiver";

    /** The node name for the release-tags-after-end node. */
    public static final String N_RELEASETAGSAFTEREND = "release-tags-after-end";

    /** The node name for the context remote addr. */
    public static final String N_REMOTEADDR = "remoteaddr";

    /** The node name for the context requested uri. */
    public static final String N_REQUESTEDURI = "requesteduri";

    /** The node name for the request-error-page-attribute node. */
    public static final String N_REQUESTERRORPAGEATTRIBUTE = "request-error-page-attribute";

    /** The node name for the request handler classes. */
    public static final String N_REQUESTHANDLER = "requesthandler";

    /** The node name for the request handlers. */
    public static final String N_REQUESTHANDLERS = "requesthandlers";

    /** The node name for the resource init classes. */
    public static final String N_RESOURCEINIT = "resourceinit";

    /** The node name for the resource init classes. */
    public static final String N_RESOURCEINITHANDLER = "resourceinithandler";

    /** the result cache node. */
    public static final String N_RESULTCACHE = "resultcache";

    /** The node name for the job "reuseinstance" value. */
    public static final String N_REUSEINSTANCE = "reuseinstance";

    /** The node name for the runtime info. */
    public static final String N_RUNTIMECLASSES = "runtimeclasses";

    /** The node name for the runtime info factory. */
    public static final String N_RUNTIMEINFO = "runtimeinfo";

    /** The node name for the runtime properties node. */
    public static final String N_RUNTIMEPROPERTIES = "runtimeproperties";

    /** The node name for the scheduler. */
    public static final String N_SCHEDULER = "scheduler";

    /** The node name for the secure site. */
    public static final String N_SECURE = "secure";

    /** The node name for the servlet container settings. */
    public static final String N_SERVLETCONTAINERSETTINGS = "servletcontainer-settings";

    /** The node name for the session-storageprovider node. */
    public static final String N_SESSION_STORAGEPROVIDER = "session-storageprovider";

    /** Shared folder node name. */
    public static final String N_SHARED_FOLDER = "shared-folder";

    /** The sitemap node name. */
    public static final String N_SITEMAP = "sitemap";

    /** The sitemap-cache node name. */
    public static final String N_SITEMAP_CACHE = "sitemap-cache";

    /** The node name for the context site root. */
    public static final String N_SITEROOT = "siteroot";

    /** The node name for the sites node. */
    public static final String N_SITES = "sites";

    /** The size of the memory monitor's cache for ACLS. */
    public static final String N_SIZE_ACLS = "size-accesscontrollists";

    /** The size of the memory monitor's cache for offline container pages. */
    public static final String N_SIZE_CONTAINERPAGE_OFFLINE = "size-containerpage-offline";

    /** The size of the memory monitor's cache for online container pages. */
    public static final String N_SIZE_CONTAINERPAGE_ONLINE = "size-containerpage-online";

    /** The size of the memory monitor's cache for groups. */
    public static final String N_SIZE_GROUPS = "size-groups";

    /** The size of the memory monitor's cache for organizational units. */
    public static final String N_SIZE_ORGUNITS = "size-orgunits";

    /** The size of the memory monitor's cache for permission checks. */
    public static final String N_SIZE_PERMISSIONS = "size-permissions";

    /** The size of the memory monitor's cache for project resources. */
    public static final String N_SIZE_PROJECTRESOURCES = "size-projectresources";

    /** The size of the memory monitor's cache for projects. */
    public static final String N_SIZE_PROJECTS = "size-projects";

    /** The size of the memory monitor's cache for properties. */
    public static final String N_SIZE_PROPERTIES = "size-properties";

    /** The size of the memory monitor's cache for property lists. */
    public static final String N_SIZE_PROPERTYLISTS = "size-propertylists";

    /** The size of the memory monitor's cache for lists of resources. */
    public static final String N_SIZE_RESOURCELISTS = "size-resourcelists";

    /** The size of the memory monitor's cache for resources. */
    public static final String N_SIZE_RESOURCES = "size-resources";

    /** The size of the memory monitor's cache for roles. */
    public static final String N_SIZE_ROLES = "size-roles";

    /** The size of the memory monitor's cache for user/group relations. */
    public static final String N_SIZE_USERGROUPS = "size-usergroups";

    /** The size of the memory monitor's cache for users. */
    public static final String N_SIZE_USERS = "size-users";

    /** The subscriptionmanager node name. */
    public static final String N_SUBSCRIPTIONMANAGER = "subscriptionmanager";

    /** The main system configuration node name. */
    public static final String N_SYSTEM = "system";

    /** The node name for the login message end time. */
    public static final String N_TIMEEND = "timeEnd";

    /** The node name for the login message start time. */
    public static final String N_TIMESTART = "timeStart";

    /** The node name for the time zone configuration. */
    public static final String N_TIMEZONE = "timezone";

    /** The node name for the user-admin node. */
    public static final String N_USER_ADMIN = "user-admin";

    /** The node name for the user-deletedresource node. */
    public static final String N_USER_DELETEDRESOURCE = "user-deletedresource";

    /** The node name for the user-export node. */
    public static final String N_USER_EXPORT = "user-export";

    /** The node name for the user-guest node. */
    public static final String N_USER_GUEST = "user-guest";

    /** The node name for the context user name. */
    public static final String N_USERNAME = "user";

    /** The node name for the validation handler. */
    public static final String N_VALIDATIONHANDLER = "validationhandler";

    /** The node name for the version history. */
    public static final String N_VERSIONHISTORY = "versionhistory";

    /** The node name for the warning-interval node. */
    public static final String N_WARNING_INTERVAL = "warning-interval";

    /** The node name for the workflow configuration. */
    public static final String N_WORKFLOW = "workflow";

    /** The node name for the workplace-server node. */
    public static final String N_WORKPLACE_SERVER = "workplace-server";


    /** Node name for the credentials resolver setting. */
    private static final String N_CREDENTIALS_RESOLVER = "credentials-resolver";

    /** Node name for the user session mode. */
    private static final String N_USER_SESSION_MODE = "user-session-mode";

    /** The ADE configuration. */
    private String m_adeConfiguration;

    /** The ADE configuration parameters. */
    private Map<String, String> m_adeParameters = new LinkedHashMap<String, String>();

    /** The authorization handler. */
    private String m_authorizationHandler;

//    /** The settings of the memory monitor. */
//    private CmsCacheSettings m_cacheSettings;
//
//    /** The configured OpenCms default users and groups. */
//    private CmsDefaultUsers m_cmsDefaultUsers;
//
//    /** The flex cache configuration object. */
//    private CmsFlexCacheConfiguration m_cmsFlexCacheConfiguration;
//
//    /** The memory monitor configuration. */
//    private CmsMemoryMonitorConfiguration m_cmsMemoryMonitorConfiguration;
//
//    /** The list of jobs for the scheduler. */
//    private List<CmsScheduledJobInfo> m_configuredJobs;
//
//    /** The credentials resolver instance. */
//    private I_CmsCredentialsResolver m_credentialsResolver;

    /** The configured credentials resolver class name. */
    private String m_credentialsResolverClass;

    /** The default content encoding. */
    private String m_defaultContentEncoding;

//    /** The configured OpenCms event manager. */
//    private CmsEventManager m_eventManager;

    /** Indicates if the version history is enabled. */
    private boolean m_historyEnabled;

    /** The maximum number of historical versions per resource. */
    private int m_historyVersions;

    /** The maximum number of historical versions for deleted resources. */
    private int m_historyVersionsAfterDeletion;

//    /** The HTTP basic authentication settings. */
//    private CmsHttpAuthenticationSettings m_httpAuthenticationSettings;
//
//    /** The configured locale manager for multi language support. */
//    private CmsLocaleManager m_localeManager;
//
//    /** The configured login manager. */
//    private CmsLoginManager m_loginManager;
//
//    /** The configured login message. */
//    private CmsLoginMessage m_loginMessage;
//
//    /** The mail settings. */
//    private CmsMailSettings m_mailSettings;

    /** Notification project. */
    private String m_notificationProject;

    /** The duration after which responsibles will be notified about out-dated content (in days). */
    // It is an Integer object so that it can be distinguished if this optional element was set or not
    private Integer m_notificationTime;

//    /** The password handler. */
//    private I_CmsPasswordHandler m_passwordHandler;
//
//    /** The permission handler. */
//    private String m_permissionHandler;
//
//    /** The configured publish manager. */
//    private CmsPublishManager m_publishManager;
//
//    /** A list of instantiated request handler classes. */
//    private List<I_CmsRequestHandler> m_requestHandlers;
//
//    /** A list of instantiated resource init handler classes. */
//    private List<I_CmsResourceInit> m_resourceInitHandlers;
//
//    /** The runtime info factory. */
//    private I_CmsDbContextFactory m_runtimeInfoFactory;

    /** The runtime properties. */
    private Map<String, String> m_runtimeProperties;
//
//    /** The configured schedule manager. */
//    private CmsScheduleManager m_scheduleManager;

    /** The configured session storage provider class name. */
    private String m_sessionStorageProvider;
//
//    /** The configured site manager. */
//    private CmsSiteManagerImpl m_siteManager;
//
//    /** The subscription manager. */
//    private CmsSubscriptionManager m_subscriptionManager;

    /** The temporary file project id. */
    private int m_tempFileProjectId;

    /** The user session mode. */
    private UserSessionMode m_userSessionMode;

    /** The configured validation handler. */
    private String m_validationHandler;

    /** The configured workflow manager. */
   // private I_CmsWorkflowManager m_workflowManager;

    /** 
     * Adds an ADE configuration parameter.<p>
     * 
     * @param name the parameter name 
     * @param value the parameter value 
     */
    public void addAdeParameter(String name, String value) {

        m_adeParameters.put(name, value);
    }

    /**
     * @see org.opencms.configuration.I_CmsConfigurationParameterHandler#addConfigurationParameter(java.lang.String, java.lang.String)
     */
    public void addConfigurationParameter(String paramName, String paramValue) {

        m_runtimeProperties.put(paramName, paramValue);
    }

    /**
     * Adds the event manager class.<p>
     * 
     * @param clazz the class name of event manager class  to instantiate and add
     */
    public void addEventManager(String clazz) {

//        try {
//            m_eventManager = (CmsEventManager)Class.forName(clazz).newInstance();
//            if (CmsLog.INIT.isInfoEnabled()) {
//                CmsLog.INIT.info(Messages.get().getBundle().key(
//                    Messages.INIT_EVENTMANAGER_CLASS_SUCCESS_1,
//                    m_eventManager));
//            }
//        } catch (Throwable t) {
//            LOG.error(Messages.get().getBundle().key(Messages.INIT_EVENTMANAGER_CLASS_INVALID_1, clazz), t);
//            return;
//        }
    }

    /**
     * Adds a new job description for the scheduler.<p>
     * 
     * @param jobInfo the job description to add
     */
    public void addJobFromConfiguration(CmsScheduledJobInfo jobInfo) {
System.out.println("-------------"+jobInfo);
//        m_configuredJobs.add(jobInfo);
//
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_SCHEDULER_CONFIG_JOB_3,
//                jobInfo.getJobName(),
//                jobInfo.getClassName(),
//                jobInfo.getContextInfo().getUserName()));
//        }
    }

    /**
     * Adds a new instance of a request handler class.<p>
     * 
     * @param clazz the class name of the request handler to instantiate and add
     */
    public void addRequestHandler(String clazz) {

//        Object initClass;
//        try {
//            initClass = Class.forName(clazz).newInstance();
//        } catch (Throwable t) {
//            return;
//        }
//        if (initClass instanceof I_CmsRequestHandler) {
//            m_requestHandlers.add((I_CmsRequestHandler)initClass);
//            if (CmsLog.INIT.isInfoEnabled()) {
//                CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_REQUEST_HANDLER_SUCCESS_1, clazz));
//            }
//        } else {
//            if (CmsLog.INIT.isErrorEnabled()) {
//                CmsLog.INIT.error(Messages.get().getBundle().key(Messages.INIT_REQUEST_HANDLER_INVALID_1, clazz));
//            }
//        }
    }
    public void addResourceInitHandler(String clazz) {

//        Object initClass;
//        try {
//            initClass = Class.forName(clazz).newInstance();
//        } catch (Throwable t) {
//            LOG.error(Messages.get().getBundle().key(Messages.LOG_RESOURCE_INIT_CLASS_INVALID_1, clazz), t);
//            return;
//        }
//        if (initClass instanceof I_CmsResourceInit) {
//            m_resourceInitHandlers.add((I_CmsResourceInit)initClass);
//            if (CmsLog.INIT.isInfoEnabled()) {
//                CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_RESOURCE_INIT_SUCCESS_1, clazz));
//            }
//        } else {
//            if (CmsLog.INIT.isErrorEnabled()) {
//                CmsLog.INIT.error(Messages.get().getBundle().key(Messages.INIT_RESOURCE_INIT_INVALID_CLASS_1, clazz));
//            }
//        }
    }

    /**
     * Generates the schedule manager.<p>
     */
    public void addScheduleManager() {
    	System.out.println("---------------addScheduleManager----------------");

//        m_scheduleManager = new CmsScheduleManager(m_configuredJobs);
    }

    /**
     * @see org.opencms.configuration.I_CmsXmlConfiguration#addXmlDigesterRules(org.apache.commons.digester.Digester)
     */
    public void addXmlDigesterRules(Digester digester) {

      
        // add scheduler creation rule
    	digester.addObjectCreate("/opencms", CmsScheduledJobInfo.class);
     digester.addCallMethod("/opencms", "addScheduleManager");
        digester.addCallMethod("/opencms/" + N_SYSTEM + "/" + N_SCHEDULER, "addScheduleManager");

        // add scheduler job creation rule
        digester.addObjectCreate("/opencms/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB, CmsScheduledJobInfo.class);
        digester.addBeanPropertySetter("/opencms/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB + "/" + N_NAME, "jobName");
        digester.addBeanPropertySetter("/opencms/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB + "/" + N_CLASS, "className");
        digester.addBeanPropertySetter(
            "/opencms/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB + "/" + N_CRONEXPRESSION,
            "cronExpression");
        digester.addBeanPropertySetter(
            "/opencms/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB + "/" + N_REUSEINSTANCE,
            "reuseInstance");
        digester.addBeanPropertySetter("/opencms/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB + "/" + N_ACTIVE, "active");
//        digester.addSetNext("*/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB, "addJobFromConfiguration");
//
//        // add job context creation rule
//        digester.addObjectCreate(
//            "*/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB + "/" + N_CONTEXT,
//            CmsContextInfo.class);
//        digester.addBeanPropertySetter("*/"
//            + N_SYSTEM
//            + "/"
//            + N_SCHEDULER
//            + "/"
//            + N_JOB
//            + "/"
//            + N_CONTEXT
//            + "/"
//            + N_USERNAME, "userName");
//        digester.addBeanPropertySetter("*/"
//            + N_SYSTEM
//            + "/"
//            + N_SCHEDULER
//            + "/"
//            + N_JOB
//            + "/"
//            + N_CONTEXT
//            + "/"
//            + N_PROJECT, "projectName");
//        digester.addBeanPropertySetter("*/"
//            + N_SYSTEM
//            + "/"
//            + N_SCHEDULER
//            + "/"
//            + N_JOB
//            + "/"
//            + N_CONTEXT
//            + "/"
//            + N_SITEROOT, "siteRoot");
//        digester.addBeanPropertySetter("*/"
//            + N_SYSTEM
//            + "/"
//            + N_SCHEDULER
//            + "/"
//            + N_JOB
//            + "/"
//            + N_CONTEXT
//            + "/"
//            + N_REQUESTEDURI, "requestedUri");
//        digester.addBeanPropertySetter("*/"
//            + N_SYSTEM
//            + "/"
//            + N_SCHEDULER
//            + "/"
//            + N_JOB
//            + "/"
//            + N_CONTEXT
//            + "/"
//            + N_LOCALE, "localeName");
//        digester.addBeanPropertySetter("*/"
//            + N_SYSTEM
//            + "/"
//            + N_SCHEDULER
//            + "/"
//            + N_JOB
//            + "/"
//            + N_CONTEXT
//            + "/"
//            + N_ENCODING);
//        digester.addBeanPropertySetter("*/"
//            + N_SYSTEM
//            + "/"
//            + N_SCHEDULER
//            + "/"
//            + N_JOB
//            + "/"
//            + N_CONTEXT
//            + "/"
//            + N_REMOTEADDR, "remoteAddr");
//        digester.addSetNext("*/" + N_SYSTEM + "/" + N_SCHEDULER + "/" + N_JOB + "/" + N_CONTEXT, "setContextInfo");

      
    }

   
//    public CmsADECacheSettings getAdeCacheSettings() {
//
//        return m_adeCacheSettings;
//    }

    /**
     * Returns the ade configuration class name.<p>
     *
     * @return the ade configuration class name
     */
    public String getAdeConfiguration() {

        return m_adeConfiguration;
    }

    /**
     * Gets the ADE configuration parameters.<p>
     * 
     * @return the ADE configuration parameters 
     */
    public Map<String, String> getAdeParameters() {

        return m_adeParameters;
    }

//    /**
//     * Returns an instance of the configured authorization handler.<p>
//     * 
//     * @return an instance of the configured authorization handler
//     */
//    public I_CmsAuthorizationHandler getAuthorizationHandler() {
//
//        if (CmsStringUtil.isEmptyOrWhitespaceOnly(m_authorizationHandler)) {
//            return new CmsDefaultAuthorizationHandler();
//        }
//        try {
//            I_CmsAuthorizationHandler authorizationHandler = (I_CmsAuthorizationHandler)Class.forName(
//                m_authorizationHandler).newInstance();
//            if (LOG.isInfoEnabled()) {
//                LOG.info(Messages.get().getBundle().key(
//                    Messages.INIT_AUTHORIZATION_HANDLER_CLASS_SUCCESS_1,
//                    m_authorizationHandler));
//            }
//            authorizationHandler.setParameters(m_runtimeProperties);
//            return authorizationHandler;
//        } catch (Throwable t) {
//            LOG.error(
//                Messages.get().getBundle().key(
//                    Messages.INIT_AUTHORIZATION_HANDLER_CLASS_INVALID_1,
//                    m_authorizationHandler),
//                t);
//            return new CmsDefaultAuthorizationHandler();
//        }
//    }

//    /**
//     * Returns the settings of the memory monitor.<p>
//     *
//     * @return the settings of the memory monitor
//     */
//    public CmsCacheSettings getCacheSettings() {
//
//        return m_cacheSettings;
//    }
//
//    /**
//     * Returns the default users.<p>
//     *
//     * @return the default users
//     */
//    public CmsDefaultUsers getCmsDefaultUsers() {
//
//        return m_cmsDefaultUsers;
//    }
//
//    /**
//     * Returns the flexCacheConfiguration.<p>
//     *
//     * @return the flexCacheConfiguration
//     */
//    public CmsFlexCacheConfiguration getCmsFlexCacheConfiguration() {
//
//        return m_cmsFlexCacheConfiguration;
//    }
//
//    /**
//     * Returns the memory monitor configuration.<p>
//     *
//     * @return the memory monitor configuration
//     */
//    public CmsMemoryMonitorConfiguration getCmsMemoryMonitorConfiguration() {
//
//        return m_cmsMemoryMonitorConfiguration;
//    }
//
//    /**
//     * Gets the credentials resolver.<p>
//     * 
//     * @return the credentials resolver 
//     */
//    public I_CmsCredentialsResolver getCredentialsResolver() {
//
//        if (m_credentialsResolver == null) {
//            m_credentialsResolver = new CmsDefaultCredentialsResolver();
//        }
//        return m_credentialsResolver;
//    }
//
//    /**
//     * Gets the configured credentials resolver class name (null if no class is explicity configured).<p>
//     * 
//     * @return the name of the configured credentials resolver class 
//     */
//    public String getCredentialsResolverClass() {
//
//        return m_credentialsResolverClass;
//    }
//
//    /**
//     * Returns the defaultContentEncoding.<p>
//     *
//     * @return the defaultContentEncoding
//     */
//    public String getDefaultContentEncoding() {
//
//        return m_defaultContentEncoding;
//    }
//
//    /**
//     * @see org.opencms.configuration.I_CmsXmlConfiguration#getDtdFilename()
//     */
//    public String getDtdFilename() {
//
//        return CONFIGURATION_DTD_NAME;
//    }
//
//    /**
//     * Returns the configured OpenCms event manager instance.<p>
//     * 
//     * @return the configured OpenCms event manager instance
//     */
//    public CmsEventManager getEventManager() {
//
//        return m_eventManager;
//    }
//
//    /**
//     * Returns the maximum number of versions that are kept per resource in the VFS version history.<p>
//     * 
//     * If the version history is disabled, this setting has no effect.<p>
//     * 
//     * @return the maximum number of versions that are kept per resource
//     * 
//     * @see #isHistoryEnabled()
//     */
//    public int getHistoryVersions() {
//
//        return m_historyVersions;
//    }
//
//    /**
//     * Returns the maximum number of versions that are kept in the VFS version history for deleted resources.<p>
//     * 
//     * If the version history is disabled, this setting has no effect.<p>
//     * 
//     * @return the maximum number of versions that are kept for deleted resources
//     * 
//     * @see #isHistoryEnabled()
//     */
//    public int getHistoryVersionsAfterDeletion() {
//
//        return m_historyVersionsAfterDeletion;
//    }
//
//    /**
//     * Returns the HTTP authentication settings.<p>
//     *
//     * @return the HTTP authentication settings
//     */
//    public CmsHttpAuthenticationSettings getHttpAuthenticationSettings() {
//
//        return m_httpAuthenticationSettings;
//    }
//
//    /**
//     * Returns the configured locale manager for multi language support.<p>
//     * 
//     * @return the configured locale manager for multi language support
//     */
//    public CmsLocaleManager getLocaleManager() {
//
//        return m_localeManager;
//    }
//
//    /**
//     * Returns the configured login manager.<p>
//     *
//     * @return the configured login manager
//     */
//    public CmsLoginManager getLoginManager() {
//
//        if (m_loginManager == null) {
//            // no login manager configured, create default
//            m_loginManager = new CmsLoginManager(
//                CmsLoginManager.DISABLE_MINUTES_DEFAULT,
//                CmsLoginManager.MAX_BAD_ATTEMPTS_DEFAULT,
//                CmsLoginManager.ENABLE_SECURITY_DEFAULT);
//        }
//        if (m_loginMessage != null) {
//            // null OpenCms object is ok during configuration
//            try {
//                m_loginManager.setLoginMessage(null, m_loginMessage);
//            } catch (CmsRoleViolationException e) {
//                // this should never happen
//            }
//        }
//        return m_loginManager;
//    }
//
//    /**
//     * Returns the configured mail settings.<p>
//     * 
//     * @return the configured mail settings
//     */
//    public CmsMailSettings getMailSettings() {
//
//        return m_mailSettings;
//    }
//
//    /**
//     * Returns the project in which timestamps for the content notification are read.<p>
//     * 
//     * @return the project in which timestamps for the content notification are read
//     */
//    public String getNotificationProject() {
//
//        return m_notificationProject;
//    }
//
//    /**
//     * Returns the duration after which responsibles will be notified about out-dated content (in days).<p>
//     * 
//     * @return the duration after which responsibles will be notified about out-dated content
//     */
//    public int getNotificationTime() {
//
//        if (m_notificationTime != null) {
//            return m_notificationTime.intValue();
//        } else {
//            return -1;
//        }
//    }
//
//    /**
//     * Returns the configured password handler.<p>
//     * 
//     * @return the configured password handler
//     */
//    public I_CmsPasswordHandler getPasswordHandler() {
//
//        return m_passwordHandler;
//    }
//
//    /**
//     * Returns the permission Handler class name.<p>
//     *
//     * @return the permission Handler class name
//     */
//    public String getPermissionHandler() {
//
//        return m_permissionHandler;
//    }
//
//    /**
//     * Returns the configured publish manager.<p>
//     * 
//     * @return the configured publish manager
//     */
//    public CmsPublishManager getPublishManager() {
//
//        if (m_publishManager == null) {
//            // no publish manager configured, create default
//            m_publishManager = new CmsPublishManager(
//                CmsPublishManager.DEFAULT_HISTORY_SIZE,
//                CmsPublishManager.DEFAULT_QUEUE_PERSISTANCE,
//                CmsPublishManager.DEFAULT_QUEUE_SHUTDOWNTIME);
//        }
//        return m_publishManager;
//    }
//
//    /**
//     * Returns the list of instantiated request handler classes.<p>
//     * 
//     * @return the list of instantiated request handler classes
//     */
//    public List<I_CmsRequestHandler> getRequestHandlers() {
//
//        return m_requestHandlers;
//    }
//
//    /**
//     * Returns the list of instantiated resource init handler classes.<p>
//     * 
//     * @return the list of instantiated resource init handler classes
//     */
//    public List<I_CmsResourceInit> getResourceInitHandlers() {
//
//        return m_resourceInitHandlers;
//    }
//
//    /**
//     * Returns the runtime info factory instance.<p>
//     * 
//     * @return the runtime info factory instance
//     */
//    public I_CmsDbContextFactory getRuntimeInfoFactory() {
//
//        return m_runtimeInfoFactory;
//    }
//
//    /**
//     * Returns the runtime Properties.<p>
//     *
//     * @return the runtime Properties
//     */
//    public Map<String, String> getRuntimeProperties() {
//
//        return m_runtimeProperties;
//    }
//
//    /**
//     * Returns the configured schedule manager.<p>
//     *
//     * @return the configured schedule manager
//     */
//    public CmsScheduleManager getScheduleManager() {
//
//        return m_scheduleManager;
//    }
//
//    /**
//     * Returns an instance of the configured session storage provider.<p>
//     * 
//     * @return an instance of the configured session storage provider
//     */
//    public I_CmsSessionStorageProvider getSessionStorageProvider() {
//
//        if (CmsStringUtil.isEmptyOrWhitespaceOnly(m_sessionStorageProvider)) {
//            return new CmsDefaultSessionStorageProvider();
//        }
//        try {
//            I_CmsSessionStorageProvider sessionCacheProvider = (I_CmsSessionStorageProvider)Class.forName(
//                m_sessionStorageProvider).newInstance();
//            if (CmsLog.INIT.isInfoEnabled()) {
//                CmsLog.INIT.info(Messages.get().getBundle().key(
//                    Messages.INIT_SESSION_STORAGEPROVIDER_SUCCESS_1,
//                    m_sessionStorageProvider));
//            }
//            return sessionCacheProvider;
//        } catch (Throwable t) {
//            LOG.error(
//                Messages.get().getBundle().key(
//                    Messages.LOG_INIT_SESSION_STORAGEPROVIDER_FAILURE_1,
//                    m_sessionStorageProvider),
//                t);
//            return new CmsDefaultSessionStorageProvider();
//        }
//    }
//
//    /**
//     * Returns the site manager.<p>
//     *
//     * @return the site manager
//     */
//    public CmsSiteManagerImpl getSiteManager() {
//
//        return m_siteManager;
//    }
//
//    /**
//     * Returns the configured subscription manager.<p>
//     * 
//     * @return the configured subscription manager
//     */
//    public CmsSubscriptionManager getSubscriptionManager() {
//
//        if (m_subscriptionManager == null) {
//            // no subscription manager configured, create default
//            m_subscriptionManager = new CmsSubscriptionManager();
//        }
//        return m_subscriptionManager;
//    }
//
//    /**
//     * Returns temporary file project id.<p>
//     * 
//     * @return temporary file project id
//     */
//    public int getTempFileProjectId() {
//
//        return m_tempFileProjectId;
//    }
//
//    /**
//     * Gets the user session mode.<p>
//     * 
//     * @param useDefault if true, and no user session mode was configured, this will return the default value 
//     * 
//     * @return the user session mode 
//     */
//    public UserSessionMode getUserSessionMode(boolean useDefault) {
//
//        if (m_userSessionMode != null) {
//            return m_userSessionMode;
//        } else if (useDefault) {
//            return DEFAULT_USER_SESSION_MODE;
//        } else {
//            return null;
//        }
//    }
//
//    /**
//     * Returns an instance of the configured validation handler.<p>
//     * 
//     * @return an instance of the configured validation handler
//     */
//    public I_CmsValidationHandler getValidationHandler() {
//
//        if (CmsStringUtil.isEmptyOrWhitespaceOnly(m_validationHandler)) {
//            return new CmsDefaultValidationHandler();
//        }
//        try {
//            I_CmsValidationHandler validationHandler = (I_CmsValidationHandler)Class.forName(m_validationHandler).newInstance();
//            if (LOG.isInfoEnabled()) {
//                LOG.info(Messages.get().getBundle().key(
//                    Messages.INIT_VALIDATION_HANDLER_CLASS_SUCCESS_1,
//                    m_validationHandler));
//            }
//            return validationHandler;
//        } catch (Throwable t) {
//            LOG.error(
//                Messages.get().getBundle().key(Messages.INIT_VALIDATION_HANDLER_CLASS_INVALID_1, m_validationHandler),
//                t);
//            return new CmsDefaultValidationHandler();
//        }
//    }
//
//    /**
//     * Gets the configured workflow manager instance.<p>
//     * 
//     * @return the configured workflow manager instance.
//     */
//    public I_CmsWorkflowManager getWorkflowManager() {
//
//        return m_workflowManager;
//    }
//
//    /**
//     * Will be called when configuration of this object is finished.<p> 
//     */
//    public void initializeFinished() {
//
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_SYSTEM_CONFIG_FINISHED_0));
//        }
//    }
//
//    /**
//     * Returns if the VFS version history is enabled.<p> 
//     * 
//     * @return if the VFS version history is enabled
//     */
//    public boolean isHistoryEnabled() {
//
//        return m_historyEnabled;
//    }
//
//    /**
//     * Sets the cache settings for ADE.<p>
//     *
//     * @param settings the cache settings for ADE
//     */
//    public void setAdeCacheSettings(CmsADECacheSettings settings) {
//
//        m_adeCacheSettings = settings;
//    }
//
//    /**
//     * Sets the ADE configuration class name.<p>
//     *
//     * @param className the class name to set
//     */
//    public void setAdeConfiguration(String className) {
//
//        m_adeConfiguration = className;
//    }
//
//    /**
//     * Sets the authorization handler.<p>
//     * 
//     * @param authorizationHandlerClass the authorization handler class to set.
//     */
//    public void setAuthorizationHandler(String authorizationHandlerClass) {
//
//        m_authorizationHandler = authorizationHandlerClass;
//    }
//
//    /**
//     * Sets the settings of the memory monitor.<p>
//     *
//     * @param settings the settings of the memory monitor
//     */
//    public void setCacheSettings(CmsCacheSettings settings) {
//
//        m_cacheSettings = settings;
//    }
//
//    /**
//     * Sets the CmsDefaultUsers.<p>
//     * 
//     * @param userAdmin the name of the default admin user
//     * @param userGuest the name of the guest user
//     * @param userExport the name of the export user
//     * @param userDeletedResource the name of the deleted resource user, can be <code>null</code>
//     * @param groupAdministrators the name of the administrators group
//     * @param groupProjectmanagers the name of the project managers group
//     * @param groupUsers the name of the users group
//     * @param groupGuests the name of the guests group
//     */
//    public void setCmsDefaultUsers(
//
//        String userAdmin,
//        String userGuest,
//        String userExport,
//        String userDeletedResource,
//        String groupAdministrators,
//        String groupProjectmanagers,
//        String groupUsers,
//        String groupGuests) {
//
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_CHECKING_DEFAULT_USER_NAMES_0));
//        }
//        m_cmsDefaultUsers = new CmsDefaultUsers(
//            userAdmin,
//            userGuest,
//            userExport,
//            userDeletedResource,
//            groupAdministrators,
//            groupProjectmanagers,
//            groupUsers,
//            groupGuests);
//
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_ADMIN_USER_1,
//                m_cmsDefaultUsers.getUserAdmin()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_GUEST_USER_1,
//                m_cmsDefaultUsers.getUserGuest()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_EXPORT_USER_1,
//                m_cmsDefaultUsers.getUserExport()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_DELETED_RESOURCE_USER_1,
//                m_cmsDefaultUsers.getUserDeletedResource()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_ADMIN_GROUP_1,
//                m_cmsDefaultUsers.getGroupAdministrators()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_PROJECT_MANAGERS_GROUP_1,
//                m_cmsDefaultUsers.getGroupProjectmanagers()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_USERS_GROUP_1,
//                m_cmsDefaultUsers.getGroupUsers()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_GUESTS_GROUP_1,
//                m_cmsDefaultUsers.getGroupGuests()));
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_DEFAULT_USER_NAMES_INITIALIZED_0));
//        }
//    }
//
//    /**
//     * Sets the flexCacheConfiguration.<p>
//     *
//     * @param flexCacheConfiguration the flexCacheConfiguration to set
//     */
//    public void setCmsFlexCacheConfiguration(CmsFlexCacheConfiguration flexCacheConfiguration) {
//
//        m_cmsFlexCacheConfiguration = flexCacheConfiguration;
//    }
//
//    /**
//     * Sets the cmsMemoryMonitorConfiguration.<p>
//     *
//     * @param cmsMemoryMonitorConfiguration the cmsMemoryMonitorConfiguration to set
//     */
//    public void setCmsMemoryMonitorConfiguration(CmsMemoryMonitorConfiguration cmsMemoryMonitorConfiguration) {
//
//        m_cmsMemoryMonitorConfiguration = cmsMemoryMonitorConfiguration;
//    }
//
//    /**
//     * Sets the credentials resolver class.<p>
//     * 
//     * @param className the name of the credentials resolver class 
//     * 
//     * @throws Exception if something goes wrong  
//     */
//    public void setCredentialsResolver(String className) throws Exception {
//
//        String originalClassName = className;
//        className = className.trim();
//        Class<?> resolverClass = Class.forName(className);
//        m_credentialsResolver = (I_CmsCredentialsResolver)(resolverClass.newInstance());
//        m_credentialsResolverClass = originalClassName;
//    }
//
//    /**
//     * Sets the defaultContentEncoding.<p>
//     *
//     * @param defaultContentEncoding the defaultContentEncoding to set
//     */
//    public void setDefaultContentEncoding(String defaultContentEncoding) {
//
//        m_defaultContentEncoding = defaultContentEncoding;
//    }
//
//    /**
//     * VFS version history settings are set here.<p>
//     * 
//     * @param historyEnabled if true the history is enabled
//     * @param historyVersions the maximum number of versions that are kept per VFS resource
//     * @param historyVersionsAfterDeletion the maximum number of versions for deleted resources
//     */
//    public void setHistorySettings(String historyEnabled, String historyVersions, String historyVersionsAfterDeletion) {
//
//        m_historyEnabled = Boolean.valueOf(historyEnabled).booleanValue();
//        m_historyVersions = Integer.valueOf(historyVersions).intValue();
//        m_historyVersionsAfterDeletion = Integer.valueOf(historyVersionsAfterDeletion).intValue();
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_HISTORY_SETTINGS_3,
//                Boolean.valueOf(m_historyEnabled),
//                new Integer(m_historyVersions),
//                new Integer(m_historyVersionsAfterDeletion)));
//        }
//    }
//
//    /**
//     * Sets the HTTP authentication settings.<p>
//     *
//     * @param httpAuthenticationSettings the HTTP authentication settings to set
//     */
//    public void setHttpAuthenticationSettings(CmsHttpAuthenticationSettings httpAuthenticationSettings) {
//
//        m_httpAuthenticationSettings = httpAuthenticationSettings;
//    }
//
//    /**
//     * Sets the locale manager for multi language support.<p>
//     * 
//     * @param localeManager the locale manager to set
//     */
//    public void setLocaleManager(CmsLocaleManager localeManager) {
//
//        m_localeManager = localeManager;
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_CONFIG_I18N_FINISHED_0));
//        }
//    }
//
//    /**
//     * Sets the configured login manager.<p>
//     *
//     * @param maxBadAttemptsStr the number of allowed bad login attempts
//     * @param disableMinutesStr the time an account gets locked if to many bad logins are attempted
//     * @param enableSecurityStr flag to determine if the security option should be enabled on the login dialog
//     */
//    public void setLoginManager(String disableMinutesStr, String maxBadAttemptsStr, String enableSecurityStr) {
//
//        int disableMinutes;
//        try {
//            disableMinutes = Integer.valueOf(disableMinutesStr).intValue();
//        } catch (NumberFormatException e) {
//            disableMinutes = CmsLoginManager.DISABLE_MINUTES_DEFAULT;
//        }
//        int maxBadAttempts;
//        try {
//            maxBadAttempts = Integer.valueOf(maxBadAttemptsStr).intValue();
//        } catch (NumberFormatException e) {
//            maxBadAttempts = CmsLoginManager.MAX_BAD_ATTEMPTS_DEFAULT;
//        }
//        boolean enableSecurity = Boolean.valueOf(enableSecurityStr).booleanValue();
//        m_loginManager = new CmsLoginManager(disableMinutes, maxBadAttempts, enableSecurity);
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_LOGINMANAGER_3,
//                new Integer(disableMinutes),
//                new Integer(maxBadAttempts),
//                new Boolean(enableSecurity)));
//        }
//    }
//
//    /**
//     * Adds the login message from the configuration.<p>
//     * 
//     * @param message the login message to add
//     */
//    public void setLoginMessage(CmsLoginMessage message) {
//
//        m_loginMessage = message;
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_LOGINMESSAGE_3,
//                Boolean.valueOf(message.isEnabled()),
//                Boolean.valueOf(message.isLoginForbidden()),
//                message.getMessage()));
//        }
//    }
//
//
//    /**
//     * Sets the project in which timestamps for the content notification are read.<p>
//     * 
//     * @param notificationProject the project in which timestamps for the content notification are read
//     */
//    public void setNotificationProject(String notificationProject) {
//
//        m_notificationProject = notificationProject;
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_NOTIFICATION_PROJECT_1, m_notificationProject));
//        }
//    }
//
//    /**
//     * Sets the duration after which responsibles will be notified about out-dated content (in days).<p>
//     * 
//     * @param notificationTime the duration after which responsibles will be notified about out-dated content
//     */
//    public void setNotificationTime(String notificationTime) {
//
//        try {
//            m_notificationTime = new Integer(notificationTime);
//        } catch (Throwable t) {
//            m_notificationTime = new Integer(-1);
//        }
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_NOTIFICATION_TIME_1, m_notificationTime));
//        }
//    }
//
//    /**
//     * Sets the password handler class.<p>
//     * 
//     * @param passwordHandler the password handler to set
//     */
//    public void setPasswordHandler(I_CmsPasswordHandler passwordHandler) {
//
//        m_passwordHandler = passwordHandler;
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_PWD_HANDLER_SUCCESS_1,
//                passwordHandler.getClass().getName()));
//        }
//    }
//
//    /**
//     * Sets the permission Handler class name.<p>
//     *
//     * @param permissionHandler the class name to set
//     */
//    public void setPermissionHandler(String permissionHandler) {
//
//        m_permissionHandler = permissionHandler;
//    }
//
//    /**
//     * Sets the servlet container specific setting.<p>
//     * 
//     * @param configValue the configuration value
//     */
//    public void setPreventResponseFlush(String configValue) {
//
//        OpenCms.getSystemInfo().getServletContainerSettings().setPreventResponseFlush(
//            Boolean.valueOf(configValue).booleanValue());
//    }
//
//    /**
//     * Sets the publish manager.<p>
//     * 
//     * @param publishManager the publish manager
//     */
//    public void setPublishManager(CmsPublishManager publishManager) {
//
//        m_publishManager = publishManager;
//    }
//
//    /**
//     * Sets the servlet container specific setting.<p>
//     * 
//     * @param configValue the configuration value
//     */
//    public void setReleaseTagsAfterEnd(String configValue) {
//
//        OpenCms.getSystemInfo().getServletContainerSettings().setReleaseTagsAfterEnd(
//            Boolean.valueOf(configValue).booleanValue());
//    }
//
//    /**
//     * Sets the servlet container specific setting.<p>
//     * 
//     * @param configValue the configuration value
//     */
//    public void setRequestErrorPageAttribute(String configValue) {
//
//        OpenCms.getSystemInfo().getServletContainerSettings().setRequestErrorPageAttribute(configValue);
//    }
//
//    /**
//     * Sets the runtime info factory.<p>
//     * 
//     * @param className the class name of the configured runtime info factory
//     */
//    public void setRuntimeInfoFactory(String className) {
//
//        Object objectInstance;
//
//        try {
//            objectInstance = Class.forName(className).newInstance();
//        } catch (Throwable t) {
//            LOG.error(Messages.get().getBundle().key(Messages.LOG_CLASS_INIT_FAILURE_1, className), t);
//            return;
//        }
//
//        if (objectInstance instanceof I_CmsDbContextFactory) {
//            m_runtimeInfoFactory = (I_CmsDbContextFactory)objectInstance;
//            if (CmsLog.INIT.isInfoEnabled()) {
//                CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_RUNTIME_INFO_FACTORY_SUCCESS_1, className));
//            }
//        } else {
//            if (CmsLog.INIT.isFatalEnabled()) {
//                CmsLog.INIT.fatal(Messages.get().getBundle().key(
//                    Messages.INIT_RUNTIME_INFO_FACTORY_FAILURE_1,
//                    className));
//            }
//        }
//
//    }
//
//    /**
//     * Sets the servlet container settings configuration mode.<p>
//     * 
//     * @param configValue the value to set
//     */
//    public void setServletContainerSettingsMode(String configValue) {
//
//        OpenCms.getSystemInfo().getServletContainerSettings().setMode(configValue);
//    }
//
//    /**
//     * Sets the session storage provider.<p>
//     * 
//     * @param sessionStorageProviderClass the session storage provider class to set.
//     */
//    public void setSessionStorageProvider(String sessionStorageProviderClass) {
//
//        m_sessionStorageProvider = sessionStorageProviderClass;
//    }
//
//    /**
//     * Sets the site manager.<p>
//     *
//     * @param siteManager the site manager to set
//     */
//    public void setSiteManager(CmsSiteManagerImpl siteManager) {
//
//        m_siteManager = siteManager;
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_SITE_CONFIG_FINISHED_0));
//        }
//    }
//
//    /**
//     * Sets the subscription manager.<p>
//     * 
//     * @param subscriptionManager the subscription manager
//     */
//    public void setSubscriptionManager(CmsSubscriptionManager subscriptionManager) {
//
//        m_subscriptionManager = subscriptionManager;
//    }
//
//    /**
//     * Sets the temporary file project id.<p>
//     * 
//     * @param tempFileProjectId the temporary file project id to set
//     */
//    public void setTempFileProjectId(String tempFileProjectId) {
//
//        try {
//            m_tempFileProjectId = Integer.valueOf(tempFileProjectId).intValue();
//        } catch (Throwable t) {
//            m_tempFileProjectId = -1;
//        }
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(
//                Messages.INIT_TEMPFILE_PROJECT_ID_1,
//                new Integer(m_tempFileProjectId)));
//        }
//    }
//
//    /**
//     * Sets the user session mode.<p>
//     * 
//     * @param userSessionMode the user session mode 
//     */
//    public void setUserSessionMode(String userSessionMode) {
//
//        if ((userSessionMode == null) || (m_userSessionMode != null)) {
//            throw new IllegalStateException("Can't set user session mode to " + userSessionMode);
//        }
//        m_userSessionMode = UserSessionMode.valueOf(userSessionMode);
//    }
//
//    /**
//     * Sets the validation handler.<p>
//     * 
//     * @param validationHandlerClass the validation handler class to set.
//     */
//    public void setValidationHandler(String validationHandlerClass) {
//
//        m_validationHandler = validationHandlerClass;
//    }
//
//    /**
//     * Sets the configured workflow manager instance.<p>
//     * 
//     * @param workflowManager the configured workflow manager 
//     */
//    public void setWorkflowManager(I_CmsWorkflowManager workflowManager) {
//
//        m_workflowManager = workflowManager;
//    }
//
//    /**
//     * @see org.opencms.configuration.A_CmsXmlConfiguration#initMembers()
//     */
//    @Override
//    protected void initMembers() {
//
//        setXmlFileName(DEFAULT_XML_FILE_NAME);
//        m_historyEnabled = true;
//        m_historyVersions = 10;
//        m_historyVersionsAfterDeletion = -1; // use m_historyVersions instead
//        m_resourceInitHandlers = new ArrayList<I_CmsResourceInit>();
//        m_requestHandlers = new ArrayList<I_CmsRequestHandler>();
//        m_configuredJobs = new ArrayList<CmsScheduledJobInfo>();
//        m_runtimeProperties = new HashMap<String, String>();
//        m_eventManager = new CmsEventManager();
//        if (CmsLog.INIT.isInfoEnabled()) {
//            CmsLog.INIT.info(Messages.get().getBundle().key(Messages.INIT_SYSTEM_CONFIG_INIT_0));
//        }
//    }
}
