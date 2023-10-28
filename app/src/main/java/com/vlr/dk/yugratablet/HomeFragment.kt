package com.vlr.dk.yugratablet

import android.os.Bundle
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.vlr.dk.yugratablet.databinding.HomeFragmentBinding
import com.vlr.dk.yugratablet.gesture.CustomGestureListener


class HomeFragment : Fragment() {
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gestureDetector = GestureDetector(activity, CustomGestureListener(activity))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingClicks()
        //animation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindingClicks() {
        binding.lifeBlock.setOnClickListener {
            it.findNavController().navigate(R.id.action_open_lifeFragment)
        }
        binding.restBlock.setOnClickListener {
            it.findNavController().navigate(R.id.action_open_restFragment)
        }
        binding.workBlock.setOnClickListener {
            it.findNavController().navigate(R.id.action_open_workFragment)
        }

        binding.securityButton.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
        }
    }

//    private fun animation() {
//        scaleView(binding.lifeBlock, 0f, 1f)
//
//        Handler().postDelayed({
//            scaleView(binding.restBlock, 0f, 1f)
//        }, 300)
//
//        Handler().postDelayed({
//            scaleView(binding.workBlock, 0f, 1f)
//        }, 500)
//    }
//
//    private fun scaleView(v: View, startScale: Float, endScale: Float) {
//        val anim: Animation = ScaleAnimation(
//            1f, 1f,  // Start and end values for the X axis scaling
//            startScale, endScale,  // Start and end values for the Y axis scaling
//            Animation.RELATIVE_TO_SELF, 0f,  // Pivot point of X scaling
//            Animation.RELATIVE_TO_SELF, 1f
//        ) // Pivot point of Y scaling
//        anim.fillAfter = true // Needed to keep the result of the animation
//        anim.duration = 1200
//        v.startAnimation(anim)
//    }

}