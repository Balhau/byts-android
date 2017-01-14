package net.balhau.android.byts.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by balhau on 1/14/17.
 */

public class Executor {
    public static final ExecutorService service = Executors.newFixedThreadPool(1);
}
