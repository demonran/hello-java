package com.hellojava.disgester;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.hellojava.disgester.config.CmsSystemConfiguration;

public class Main {
	
	public static void main(String[] args) throws IOException, SAXException {
		Digester m_digester = new Digester();
        m_digester.setUseContextClassLoader(true);
        m_digester.setValidating(true);
//        m_digester.setEntityResolver(new CmsXmlEntityResolver(null));
        m_digester.setRuleNamespaceURI(null);
//        m_digester.setErrorHandler(new CmsXmlErrorHandler(fileUrl.getFile()));

        
        CmsSystemConfiguration configuration = new CmsSystemConfiguration();
        // add this class to the Digester
//        m_digester.push(configuration);

        configuration.addXmlDigesterRules(m_digester);

        // start the parsing process  
        
       
        Object o = m_digester.parse( Main.class.getResourceAsStream("schedule.xml"));
        
        System.out.println(o);
	}
}
