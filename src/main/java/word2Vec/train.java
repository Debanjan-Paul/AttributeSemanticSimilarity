package word2Vec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;




import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

public class train {
public static void main (String args[]) throws IOException{
	//SentenceIterator iter = new LineSentenceIterator(new File("E:/work/Cell_Phones_and_Accessories.txt"));
	SentenceIterator iter = new LineSentenceIterator(new File(args[0]));
	iter.setPreProcessor(new SentencePreProcessor() {
        public String preProcess(String sentence) {
            return sentence.toLowerCase();
        }
    });

    
 // Split on white spaces in the line to get words
    TokenizerFactory t = new DefaultTokenizerFactory();
    t.setTokenPreProcessor(new CommonPreprocessor());
   //log.info("Building model....");
    Word2Vec vec = new Word2Vec.Builder()
            .minWordFrequency(1)
            .iterations(1)
            .layerSize(100)
            .seed(42)
            .windowSize(5)
            .iterate(iter)
            .tokenizerFactory(t)
            .build();

    //log.info("Fitting Word2Vec model....");
    vec.fit();
    //log.info("Saving Word2Vec model....");
    WordVectorSerializer.writeFullModel(vec, "pathToSaveModelnew.txt");
    
    

	
	

	


}
}
/* */
