package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherMock implements SequenceSearcher {

    public int methodCallCounter = 0;

    @Override public SearchResult search(int elem, int[] seq) {
        methodCallCounter++;
        SearchResult.Builder builder = null;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == elem) {
                builder = SearchResult.builder().withPosition(i).withFound(true);
            }
        }
        if (builder == null)
            builder = SearchResult.builder().withPosition(-1).withFound(false);

        return builder.build();
    }
}
