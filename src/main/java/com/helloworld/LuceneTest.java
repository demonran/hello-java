package com.tcl.helloworld;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.IOUtils;
import org.apache.lucene.util.Version;

import com.tcl.helloworld.util.FileUitls;

public class LuceneTest
{
	private static String INDEX_DIR = "f:/indexDir";
	
	private static String DATA_DIR = "f:/dataDir";

	public void createIndex() throws IOException
	{
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
		
		IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_36, analyzer);
		
		Directory directory = FSDirectory.open(new File(INDEX_DIR));
		
		IndexWriter indexWriter = new IndexWriter(directory, conf);
		
		File dataDir = new File(DATA_DIR);
		
		
		long start = System.currentTimeMillis();
		
		for(File file : dataDir.listFiles())
		{
			Document doc = new Document();
			doc.add(new Field("path",file.getAbsolutePath(),Field.Store.YES, Field.Index.NO));
			doc.add(new Field("content",FileUitls.read(file), Field.Store.YES,    
                    Field.Index.ANALYZED,    
                    Field.TermVector.WITH_POSITIONS_OFFSETS));
			indexWriter.addDocument(doc);
		}
		indexWriter.close();
		System.out.println("花费了"+(System.currentTimeMillis() -start)+ "毫秒来创建索引文件");
		
	}
	
	public void searchByKeyword(String Keyword) throws Exception
	{
		FSDirectory directory = FSDirectory.open(new File(INDEX_DIR));
		IndexReader reader = IndexReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);
		
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);

		QueryParser parser = new QueryParser(Version.LUCENE_36, "content",analyzer);
		Query query = parser.parse(Keyword);
		TopDocs topdocs = searcher.search(query, 1000);
		
		ScoreDoc[] scoreDocs = topdocs.scoreDocs;
		
		if(scoreDocs.length == 0)
		{
			System.out.println("error");
		}
		
		for(ScoreDoc score :scoreDocs )
		{
			Document doc = searcher.doc(score.doc);
			
			System.out.println(doc.get("path"));
			
			System.out.println("内容："+doc.get("content"));
		}
		
		searcher.close();
	}
	
	public void searchByKeyword2(String Keyword) throws Exception
	{
		FSDirectory directory = FSDirectory.open(new File(INDEX_DIR));
		IndexReader reader = IndexReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);
		
//		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);

		
		 Term term = new Term("content",Keyword.toLowerCase()); 
	        TermQuery luceneQuery = new TermQuery(term); 
//		QueryParser parser = new QueryParser(Version.LUCENE_36, "content",analyzer);
//		Query query = parser.parse(Keyword);
		TopDocs topdocs = searcher.search(luceneQuery, 1000);
		
		ScoreDoc[] scoreDocs = topdocs.scoreDocs;
		
		if(scoreDocs.length == 0)
		{
			System.out.println("error");
		}
		
		for(ScoreDoc score :scoreDocs )
		{
			Document doc = searcher.doc(score.doc);
			
			System.out.println(doc.get("path"));
			
			System.out.println("内容："+doc.get("content"));
		}
		
		searcher.close();
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		LuceneTest test = new LuceneTest();
//		test.createIndex();
		test.searchByKeyword("严重");
	}
	
	
}
