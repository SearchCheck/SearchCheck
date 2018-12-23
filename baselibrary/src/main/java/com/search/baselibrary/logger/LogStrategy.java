package com.search.baselibrary.logger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Tomze
 * @time 2018年12月24日 0:13
 * @desc
 */
public interface LogStrategy {

    /**
     * This is invoked by Logger each time a log message is processed.
     * Interpret this method as last destination of the log in whole pipeline.
     *
     * @param priority is the log level e.g. DEBUG, WARNING
     * @param tag      is the given tag for the log message.
     * @param message  is the given message for the log message.
     */
    void log(int priority, @Nullable String tag, @NonNull String message);
}
