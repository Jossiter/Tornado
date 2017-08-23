package cookbook;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class Cookbook {
	// Lucene Stuff
    StandardAnalyzer analyzer = new StandardAnalyzer();
    Directory index = new RAMDirectory();
    IndexWriterConfig config = new IndexWriterConfig(analyzer);
    IndexWriter writer;
    
    // Stored Recipes
    Recipe[] storedRecipes;
	
	// Constructors
	public Cookbook () {
		storedRecipes = null;
		
		try {
			writer = new IndexWriter(index, config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			writer = null;
			e.printStackTrace();
		}
	}
	
	// Get methods
	public TopDocs findResource (Resource resource) {
	    IndexReader reader;
	    TopDocs hits = null;
	    
		try {
			reader = DirectoryReader.open(index);
		    IndexSearcher searcher = new IndexSearcher(reader);
			
			//Search by Resource Name
			QueryParser qp = new QueryParser("action", analyzer);
			Query resourcecQuery = qp.parse(resource.getName());
			hits = searcher.search(resourcecQuery, 10);
			
			System.out.println(hits);
			System.out.println("Total Results :: " + hits.totalHits);
	        for (ScoreDoc sd : hits.scoreDocs) 
	        {
	            Document d = searcher.doc(sd.doc);
	            System.out.println(String.format(d.get("action")));
	        }			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			reader = null;
			hits = null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			reader = null;
			hits = null;
		}
		
		return hits;
	}
	
	// Put methods
	public boolean addRecipe (Recipe recipe) {
		boolean added = true;
		
		try {
			writer.addDocument(recipe.document());
			writer.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			added = false;
		} 
		
		return added;
	}
	public boolean close() {
		boolean closed = true;
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			closed = false;
		}
		
		return closed;
	}

}
