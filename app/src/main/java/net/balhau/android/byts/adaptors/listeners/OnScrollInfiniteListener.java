package net.balhau.android.byts.adaptors.listeners;

import android.os.AsyncTask;
import android.widget.AbsListView;

import net.balhau.android.byts.adaptors.domain.yts.YtsPageResponse;
import net.balhau.android.byts.utils.Generator;

/**
 * Created by balhau on 1/15/17.
 */

public class OnScrollInfiniteListener<T> implements AbsListView.OnScrollListener {

    private int visibleThreshold = 5;
    private int currentPage = 0;
    private int previousTotal = 0;
    private boolean loading = true;
    private Generator<AsyncTask<Integer,Void,T>> taskGenerator;

    public OnScrollInfiniteListener(Generator<AsyncTask<Integer,Void,T>> taskGenerator) {
        this.taskGenerator=taskGenerator;
    }
    public OnScrollInfiniteListener(int visibleThreshold) {
        this.visibleThreshold = visibleThreshold;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                currentPage++;
            }
        }

        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)
                ) {
            // I load the next page of gigs using a background task,
            // but you can call any function here.
            taskGenerator.generate().execute(currentPage + 1);
            loading = true;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }
}
