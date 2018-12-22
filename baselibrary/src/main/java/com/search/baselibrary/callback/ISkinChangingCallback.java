package com.search.baselibrary.callback;

/**
 * @author Tomze
 * @time 2018年12月22日 22:23
 * @desc
 */
public interface ISkinChangingCallback {
    void onStart();

    void onError(Exception e);

    void onComplete();

    public static DefaultSkinChangingCallback DEFAULT_SKIN_CHANGING_CALLBACK = new DefaultSkinChangingCallback();

    public class DefaultSkinChangingCallback implements ISkinChangingCallback
    {
        @Override
        public void onStart()
        {

        }

        @Override
        public void onError(Exception e)
        {

        }

        @Override
        public void onComplete()
        {

        }
    }
}
