package cookbook;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
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
    ArrayList<Recipe> storedRecipes;
	
	// Constructors
	public Cookbook () {		
		try {
			writer = new IndexWriter(index, config);
			storedRecipes = new ArrayList<Recipe>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			writer = null;
			storedRecipes = null;
			e.printStackTrace();
		}
	}
	
	// Search methods
	//
	public Recipe[] findResource (Resource resource) {
	    IndexReader reader;
	    TopDocs hits = null;
	    Recipe[] ra = null;
	    
		try {
			reader = DirectoryReader.open(index);
		    IndexSearcher searcher = new IndexSearcher(reader);
			
			//Search by Resource Name
			QueryParser qp = new QueryParser("action", analyzer);
			Query resourcecQuery = qp.parse(resource.getName());
			hits = searcher.search(resourcecQuery, 10);		
			
			//System.out.println("Total Results :: " + hits.totalHits);
			ra = new Recipe[hits.totalHits];
			int offset = 0;
	        for (ScoreDoc sd : hits.scoreDocs) 
	        {
	            Document d = searcher.doc(sd.doc);
	            int i = Integer.parseInt(d.get("ID"));
	            ra[offset++] = storedRecipes.get(i);
	            //System.out.println(String.format(d.get("action")));
	            //System.out.println(String.format(d.get("ID")));
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
		
		return ra;
	}
	
	// Put methods
	//
	public boolean addRecipe (Recipe recipe) {
		boolean added = true;
		
		try {
			storedRecipes.add(recipe);
			
		    Document document = new Document();
		    document.add(new StoredField("ID", storedRecipes.size() - 1));
		    document.add(new TextField("action", recipe.print(), Field.Store.NO));
		    document.add(new TextField("output", recipe.printFull() , Field.Store.NO));		
			
			writer.addDocument(document);
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
