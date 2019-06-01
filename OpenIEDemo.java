import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.simple.*;
import java.io.*; 

public class OpenIEDemo {

	public static void main(String[] args) throws Exception {

	    	File file = new File("data/bailii_test_case.txt");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
		String sentence = new String("None");
		String st;
		while ((st = br.readLine()) != null)
			sentence += st;
			//System.out.println(st);

		// Create a CoreNLP document
		Document doc = new Document(sentence);

		BufferedWriter writer = new BufferedWriter(new FileWriter("data/bailii_test_case_result.txt"));
		// Iterate over the sentences in the document
		for (Sentence sent : doc.sentences()) {
		      	// Iterate over the triples in the sentence
			for (RelationTriple triple : sent.openieTriples()) {
			writer.write(triple.confidence + " < " +
			    triple.subjectLemmaGloss() + ", " +
			    triple.relationLemmaGloss() + ", " +
			    triple.objectLemmaGloss() + " >\n");
			// Print the triple
			System.out.println(triple.confidence + " < " +
			    triple.subjectLemmaGloss() + ", " +
			    triple.relationLemmaGloss() + ", " +
			    triple.objectLemmaGloss() + " >");
		      	}
		}
		writer.close();
	}
}
