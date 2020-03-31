package edu.iis.mto.similarity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityFinderBehaviorTests {
    private int[] seq1 = null;
    private int[] seq2 = null;
    private SequenceSearcherMock sequenceSearcherMock;
    private SimilarityFinder similarityFinder;

    @BeforeEach
    public void prep() {
        sequenceSearcherMock = new SequenceSearcherMock();
        similarityFinder = new SimilarityFinder(sequenceSearcherMock);
    }

    @Test
    public void isSearchCalledForNonEmptySequence(){
        seq1=new int[]{1};
        seq2=new int[]{5};
        similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertEquals(1, sequenceSearcherMock.methodCallCounter);
    }


}
