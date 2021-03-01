package com.charles.livedatabus;

import android.graphics.Bitmap;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class MyLiveData<T> extends MutableLiveData<T> {
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        super.observe(owner, observer);
        try {
            hook(observer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void hook(@NonNull Observer<? super T> observer) throws Exception{
        Class<LiveData> classLiveData = LiveData.class;
        Field fieldObservers = classLiveData.getDeclaredField("mObservers");
        fieldObservers.setAccessible(true);
        Object mObservers = fieldObservers.get(this);
        Class<?> mObserversClass = mObservers.getClass();

        Method methodGet = mObserversClass.getDeclaredMethod("get",Object.class);
        methodGet.setAccessible(true);
        Object entry = methodGet.invoke(mObservers,observer);
        Object objectWrapper = ((Map.Entry)entry).getValue();

        Class<?> mObserve = objectWrapper.getClass().getSuperclass();
        Field mLastVersion = mObserve.getDeclaredField("mLastVersion");
        mLastVersion.setAccessible(true);
        Field mVersion = classLiveData.getDeclaredField("mVersion");
        mVersion.setAccessible(true);
        Object mVersionValue = mVersion.get(this);
        mLastVersion.set(objectWrapper,mVersionValue);
        Log.d(TAG, "hook: ");
    }
}
