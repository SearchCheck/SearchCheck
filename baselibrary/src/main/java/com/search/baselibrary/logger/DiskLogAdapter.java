package com.search.baselibrary.logger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.search.baselibrary.adapter.LogAdapter;

import static com.search.baselibrary.logger.Utils.checkNotNull;

/**
 * @author Tomze
 * @time 2018年12月24日 0:08
 * @desc
 */
public class DiskLogAdapter implements LogAdapter {

    @NonNull
    private final FormatStrategy formatStrategy;

    public DiskLogAdapter() {
        formatStrategy = CsvFormatStrategy.newBuilder().build();
    }

    public DiskLogAdapter(@NonNull FormatStrategy formatStrategy) {
        this.formatStrategy = checkNotNull(formatStrategy);
    }

    @Override
    public boolean isLoggable(int priority, @Nullable String tag) {
        return true;
    }

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        formatStrategy.log(priority, tag, message);
    }
}
