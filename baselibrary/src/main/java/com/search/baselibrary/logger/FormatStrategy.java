package com.search.baselibrary.logger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @author Tomze
 * @time 2018年12月24日 0:11
 * @desc
 */
public interface FormatStrategy {
    void log(int priority, @Nullable String tag, @NonNull String message);
}
