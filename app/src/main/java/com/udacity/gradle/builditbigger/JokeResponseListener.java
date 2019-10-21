package com.udacity.gradle.builditbigger;

// Resource: https://gist.github.com/cesarferreira/ef70baa8d64f9753b4da

public interface JokeResponseListener<T> {
     void onSuccess(T object);
     void onFailure(Exception exception);
}
