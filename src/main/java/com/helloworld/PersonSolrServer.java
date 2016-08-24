package com.helloworld;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.BinaryRequestWriter;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helloworld.model.PersonDetail;
    
/** 
 * @author Sam 鏃堕棿锛�2011-9-16 涓嬪崍3:25:15 
 */  
public class PersonSolrServer {  
        
    private final static String URL = "http://localhost/solr/person";  
    private Logger logger = LoggerFactory.getLogger(this.getClass());  
    private final static Integer SOCKE_TTIMEOUT = 1000; // socket read timeout  
    private final static Integer CONN_TIMEOUT = 100;  
    private final static Integer MAXCONN_DEFAULT = 100;  
    private final static Integer MAXCONN_TOTAL = 100;  
    private final static Integer MAXRETRIES = 1;  
    private HttpSolrServer server = null;  
    private final static String ASC = "asc";  
        
    public PersonSolrServer() throws MalformedURLException {  
        System.out.println("鍒濆鍖杝olr鏈嶅姟..");  
        server = new HttpSolrServer( URL );//浣跨敤HTTPClient 鍜宻olr鏈嶅姟鍣ㄨ繘琛岄�氫俊  
        server.setRequestWriter(new BinaryRequestWriter());//浣跨敤娴佽緭鍑烘柟寮�  
        server.setSoTimeout(SOCKE_TTIMEOUT);// socket read timeout  
        server.setConnectionTimeout(CONN_TIMEOUT);  
        server.setDefaultMaxConnectionsPerHost(MAXCONN_DEFAULT);  
        server.setMaxTotalConnections(MAXCONN_TOTAL);  
        server.setFollowRedirects(false);  
        server.setAllowCompression(true);  
        server.setMaxRetries(MAXRETRIES); // defaults to 0.  > 1 not recommended.  
    }  
        
    /** 
     * 鍒涘缓绱㈠紩 
     */  
    public void createIndex(PersonDetail pd) throws Exception {  
        SolrInputDocument doc = new SolrInputDocument();  
        doc.addField("id", pd.getId());  
        doc.addField("language", pd.getLanguage());  
            
        server.add(doc);  
        server.optimize();  
        server.commit();  
        System.out.println("----绱㈠紩鍒涘缓瀹屾瘯!!!");      
    }  
    /** 
     * 鍒犻櫎绱㈠紩 
     * @author Sam 鏃堕棿锛�2011-9-16 涓嬪崍3:32:55    
     * @throws Exception 
     */  
    public void delIndex() throws Exception {  
        server.deleteByQuery("*:*");  
        server.commit();  
        System.out.println("----绱㈠紩娓呴櫎瀹屾瘯!!!");  
    }  
        
    /** 
     * 鏌ヨ 
     * @author Sam 鏃堕棿锛�2011-9-16 涓嬪崍3:33:14    
     * @param key 
     * @param startPage 
     * @param pageSize 
     * @throws Exception 
     */  
    public List<Integer> queryList(String key, Integer start, Integer rows) throws Exception {  
        SolrQuery query = new SolrQuery(getkey(key));  
        query.setHighlight(true); //寮�鍚珮浜粍浠�  
        query.addHighlightField("id");  
        query.addHighlightField("chName");//楂樹寒瀛楁  
        query.addHighlightField("enName");  
        query.setHighlightSimplePre("<font color='red'>");//鍓嶇紑  
        query.setHighlightSimplePost("</font>");//鍚庣紑  
        query.set("hl.usePhraseHighlighter", true);  
        query.set("hl.highlightMultiTerm", true);  
        query.set("hl.snippets", 3);//涓変釜鐗囨,榛樿鏄�1  
        query.set("hl.fragsize", 50);//姣忎釜鐗囨50涓瓧锛岄粯璁ゆ槸100  
        query.setStart(start); //璧峰浣嶇疆 鈥﹀垎椤�  
        query.setRows(rows);//鏂囨。鏁�  
            
        QueryResponse rep = server.query(query);  
        List<SolrDocument> docs = rep.getResults();//寰楀埌缁撴灉闆�  
        List<Integer> idList = new ArrayList<Integer>();  
        for(SolrDocument doc : docs) {  
            idList.add(Integer.parseInt((String) doc.getFieldValue("id")));  
            System.out.println(doc.getFieldValue("chName") + "|" + doc.getFieldValue("enName"));  
        }  
        return idList;  
    }  
        
    public String getkey(String strWord) {  
        if(strWord.indexOf(" ") > 0 ){  
            String wordAnd = strWord.replace(" ", "* AND *");  
            String wordOr = strWord.replace(" ", "* *");  
            String rt = "(*" + wordAnd + "*) *" + wordOr + "* " + strWord;  
            return rt;  
        } else {  
            return "*" + strWord + "* " + strWord;  
        }  
            
    }  
    
    public HttpSolrServer getServer() {  
        return server;  
    }  
    
    public void setServer(HttpSolrServer server) {  
        this.server = server;  
    }  
    
    public static void main(String[] args) throws Exception
	{
    	PersonSolrServer person = new PersonSolrServer();
    	
    	PersonDetail pd = new PersonDetail();
    	pd.setId(1);
    	pd.setLanguage("zh");
    	
    	person.createIndex(pd);
	}
}