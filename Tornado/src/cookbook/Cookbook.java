package cookbook;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class Cookbook {
    StandardAnalyzer analyzer = new StandardAnalyzer();

    // 1. create the index
    Directory index = new RAMDirectory();
    IndexWriterConfig config = new IndexWriterConfig(analyzer);
    IndexWriter writer = null;
	
	// Constructors
	public Cookbook () throws Exception {
		writer = new IndexWriter(index, config);
	}
	
	// Get methods
	public TopDocs findRecipe (Resource resource) throws Exception {
	    IndexReader reader = DirectoryReader.open(index);
	    IndexSearcher searcher = new IndexSearcher(reader);
		
		//Search by Resource Name
		QueryParser qp = new QueryParser("resource", analyzer);
		Query resourcecQuery = qp.parse(resource.getName());
		TopDocs hits = searcher.search(resourcecQuery, 10);
		return hits;
	}
	
	// Put methods
	public void addRecipe (Recipe recipe) throws IOException {
		Document doc = recipe.document();
		writer.addDocument(doc); 
		writer.commit();
	}
	public void close() throws IOException {
		writer.close();
	}

}
