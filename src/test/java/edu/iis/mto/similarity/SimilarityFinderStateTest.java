package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityFinderStateTest {
    private SimilarityFinder similarityFinder;
    private final static double SAME_SET = 1.0;
    private final static double NO_SIMILARITIES_SET = 0.0;
    private final static double SAME_HALF = 0.5;
    private int[] seq1;
    private int[] seq2;

    @Test void calculateSameSetsOfOne(){
        seq1 = new int[]{3};
        seq2 = new int[]{3};
        similarityFinder = new SimilarityFinder((e, seq) ->{
            for(int num:seq){
                if (num == e) {
                    return SearchResult.builder().withFound(true).build();
                }
            }
            return SearchResult.builder().withFound(false).build();
        });

        double result = similarityFinder.calculateJackardSimilarity(seq1,seq2);
        assertEquals(SAME_SET, result);
    }
}
