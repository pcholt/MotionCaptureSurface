package com.pcholt.motioncapturesurface.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.pcholt.motioncapturesurface.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var ui: FragmentMainBinding? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentMainBinding.inflate(inflater, container, false).let { ui ->
            ui.moveYaFinger.setOnTouchListener { v, event ->
                ui.message.text = "%04d\n%04d".format(event.x.toInt(), event.y.toInt())
                true
            }
            this.ui = ui
            return ui.root
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

}