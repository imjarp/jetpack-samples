package com.example.jarp.circus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jarp.circus.features.lifecycle.LifeCycleMirror
import com.example.jarp.circus.ui.main.LifecycleFragment
import com.example.jarp.circus.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var lifeCycleMirror: LifeCycleMirror

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifeCycleMirror = LifeCycleMirror(lifecycle,"MainActivity")
        lifecycle.addObserver(lifeCycleMirror)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LifecycleFragment.newInstance())
                    .commitNow()
        }
    }

}
