import java.io.IOException;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
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
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import cookbook.Ingredient;
import cookbook.IngredientList;

import java.util.HashSet;
import java.util.Iterator;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import map.Grid;
import map.Hex;
import utilities.Direction;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		IngredientList i = new IngredientList();

		Ingredient r = new Ingredient("Stone", 1);
		i.add(r);
		i.view();
		
		r = new Ingredient("Brick", 1); 
		i.add(r);		
		i.view();
		
		r = new Ingredient("Wellingtons", 1); 
		i.add(r);		
		i.view();
		
		/*
		Hex x1 = new Hex("X1");
		x1.print();
		System.out.println( );		
		
		Hex x2 = new Hex("X2");
		x2.print();
		System.out.println( );	
		
		x1.setDirection(Direction.NE, x2);
		
		x1.print();
		System.out.println( );		
		x2.print();
		System.out.println( );	
		
		x1.clearDirection(Direction.NE);
		
		x1.print();
		System.out.println( );		
		x2.print();
		System.out.println( );	
		
		Grid g = new Grid();
		g.print();
		*/
		
		/*
	      System.out.println( "Collection Test" );
	      // Create a collection
	      HashSet collection = new HashSet();
	      // Adding
	      String dog1 = "Max", dog2 = "Bailey", dog3 = "Harriet";
	      collection.add( dog1 );
	      collection.add( dog2 );
	      collection.add( dog3 );
	      // Sizing
	      System.out.println( "Collection created" + 
	        ", size=" + collection.size() + 
	        ", isEmpty=" + collection.isEmpty() );
	      // Containment
	      System.out.println( "Collection contains " + dog3 + 
	         ": " + collection.contains( dog3 ) );
	      // Iteration. Iterator supports hasNext, next, remove
	      System.out.println( "Collection iteration (unsorted):" );
	      Iterator iterator = collection.iterator();
	      while ( iterator.hasNext() ) 
	         System.out.println( "   " + iterator.next() );
	      // Removing
	      collection.remove( dog1 );
	      collection.clear();
	    
	      System.out.println( );
	      
	      StandardAnalyzer analyzer = new StandardAnalyzer();

	      // 1. create the index
	      Directory index = new RAMDirectory();

	      IndexWriterConfig config = new IndexWriterConfig(analyzer);

	      IndexWriter w = null;
		try {
			w = new IndexWriter(index, config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			addDoc(w, "Lucene in Action", "193398817");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			addDoc(w, "Lucene for Dummies", "55320055Z");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			addDoc(w, "Managing Gigabytes", "55063554A");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			addDoc(w, "The Art of Computer Science", "9900333X");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      w.close();

	      // 2. query
	      String querystr = args.length > 0 ? args[0] : "lucene";

	      // the "title" arg specifies the default field to use
	      // when no field is explicitly specified in the query.
	      Query q = null;
		try {
			q = new QueryParser("title", analyzer).parse(querystr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      // 3. search
	      int hitsPerPage = 10;
	      IndexReader reader = null;
		try {
			reader = DirectoryReader.open(index);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      IndexSearcher searcher = new IndexSearcher(reader);
	      TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage);
	      try {
			searcher.search(q, collector);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      ScoreDoc[] hits = collector.topDocs().scoreDocs;
	      
	      // 4. display results
	      System.out.println("Found " + hits.length + " hits.");
	      for(int i=0;i<hits.length;++i) {
	        int docId = hits[i].doc;
	        Document d = null;
			try {
				d = searcher.doc(docId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title"));
	      }

	      // reader can only be closed when there
	      // is no need to access the documents any more.
	      reader.close();
	    }

	    private static void addDoc(IndexWriter w, String title, String isbn) throws IOException {
	      Document doc = new Document();
	      doc.add(new TextField("title", title, Field.Store.YES));

	      // use a string field for isbn because we don't want it tokenized
	      doc.add(new StringField("isbn", isbn, Field.Store.YES));
	      w.addDocument(doc);
	 */
	   
	}

}
