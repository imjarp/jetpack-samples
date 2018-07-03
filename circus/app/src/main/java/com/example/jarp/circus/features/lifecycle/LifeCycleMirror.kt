package com.example.jarp.circus.features.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.concurrent.thread


/*
    This class just represent the mirror lifecycle of an activity or fragment
    Just Log
 */
class LifeCycleMirror(private val lifeCycle: Lifecycle, private val source: String) : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        log("onCreate")

        thread(start = true) {

            var keepRunning = true

            while (keepRunning) {


                if (hasReachedStarted()) {
                    log("The state has now reached Resume the current state is ${lifeCycle.currentState.name}")
                    keepRunning = false
                } else {
                    log(buildString {
                        append("Im in the current state ${lifeCycle.currentState.name}")

                    })
                }
            }

        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() = log("onStartEvent")


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() = log("onResumeEvent")


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() = log("onPauseEvent")


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() = log("onStopEvent")


    private fun log(message: String) = Log.v(TAG, "$source : $message")

    private fun hasReachedStarted() =
            lifeCycle.currentState.isAtLeast(Lifecycle.State.RESUMED)


    companion object {

        private const val TAG = "LifecycleMirror"

    }


}