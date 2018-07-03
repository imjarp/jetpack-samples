package com.example.jarp.circus.ui.main


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.jarp.circus.R
import com.example.jarp.circus.features.lifecycle.LifeCycleMirror

/**
 * A simple [Fragment] subclass.
 * Use the [LifecycleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LifecycleFragment : Fragment() {

    private lateinit var lifecycleMirror: LifeCycleMirror

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        lifecycleMirror = LifeCycleMirror(lifecycle, "LifecyleFragment")
        lifecycle.addObserver(lifecycleMirror)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lifecycle, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment LifecycleFragment.
         */
        @JvmStatic
        fun newInstance() = LifecycleFragment()

    }
}
