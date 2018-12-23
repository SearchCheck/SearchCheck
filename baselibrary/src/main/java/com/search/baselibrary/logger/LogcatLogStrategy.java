package com.search.baselibrary.logger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.search.baselibrary.logger.Utils.checkNotNull;

/**
 * @author Tomze
 * @time 2018年12月24日 0:14
 * @desc
 */
public class LogcatLogStrategy implements LogStrategy {

    static final String DEFAULT_TAG = "NO_TAG";

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        checkNotNull(message);

        if (tag == null) {
            tag = DEFAULT_TAG;
        }

        Log.println(priority, tag, message);
    }
}