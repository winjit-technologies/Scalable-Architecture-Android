# Scalable-Architecture-Android
Highly Scalable / Maintainable Architecture developed for Android using Android Studio

Almost every application does work in a background thread. There are several ways to do background operations in android ecosystem like Async Tasks, Threads, Services, Loaders etc. Async task is tightly coupled with UI where as loaders are not suitable for long running network operations. Services are one of the better option as it de-coupled login with UI however we need a thread pool to process request in parallel which is difficult to manage tasks, task priorities and often-complicated concurrency problems.
 
This Getting Started guide walks you through the process of building an application that uses Volley to consume REST web services and how to well organize the logic and UI operations.

### Consume REST services ###
* Version 1.0 (1)

##Libraries used##
## Volley ##
### Network Library ###
    compile 'eu.the4thfloor.volley:com.android.volley:2015.05.28'
read more @ http://developer.android.com/training/volley/index.html

## GSON ##
### JSON Parsing/Encoding ###
    compile 'com.google.code.gson:gson:2.6.2'
read more @ https://github.com/google/gson

## OrmLite ##
### Database Wrapper ###
    compile 'com.j256.ormlite:ormlite-android:4.48'

## Butterknife ##
### UI Annotations ###
    compile 'com.jakewharton:butterknife:7.0.1'
read more @ http://jakewharton.github.io/butterknife/

## Otto ##
### Event Bus ###
    compile 'com.squareup:otto:1.3.8'
read more @ http://square.github.io/otto/

## UI Libraries ##
    dependencies {
        compile 'com.android.support:appcompat-v7:23.3.0'
        compile 'com.android.support:design:23.3.0'
        compile 'com.android.support:support-v4:23.3.0'
        compile 'com.android.support:recyclerview-v7:23.3.0'
    }

### Basic Architecture ###

![Untitled.png](https://bitbucket.org/repo/ABr46a/images/3409112786-Untitled.png)

### Package Structure ###

![Screen Shot 2016-05-26 at 5.05.43 ![Screen Shot 2016-05-26 at 5.09.15 PM.png](https://bitbucket.org/repo/ABr46a/images/1626837404-Screen%20Shot%202016-05-26%20at%205.09.15%20PM.png)
