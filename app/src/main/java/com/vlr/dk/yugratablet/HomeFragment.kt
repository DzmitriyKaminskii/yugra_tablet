package com.vlr.dk.yugratablet

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.vlr.dk.yugratablet.databinding.HomeFragmentBinding
import com.vlr.dk.yugratablet.gesture.CustomGestureListener
import com.vlr.dk.yugratablet.utils.DeviceDimensionsHelper


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

        updateUI()
        bindingClicks()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindingClicks() {
        binding.lifeBlock.setOnClickListener { actionView ->
            context?.let {
                binding.mainBlock.setBackgroundResource(R.drawable.life_bg)
                animation()
                Handler().postDelayed({
                    actionView.findNavController().navigate(R.id.lifeFragment)
                }, 2000)
            }
        }

        binding.restBlock.setOnClickListener {
            binding.mainBlock.setBackgroundResource(R.drawable.rest_bg)
            animation()
            //it.findNavController().navigate(R.id.action_open_restFragment)
        }

        binding.workBlock.setOnClickListener {
            binding.mainBlock.setBackgroundResource(R.drawable.work_bg)
            animation()
            //it.findNavController().navigate(R.id.action_open_workFragment)
        }

        binding.securityButton.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
        }
    }

    private fun animation() {
        val firstBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_up_first)
        val secondBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_up_second)
        val thirdBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_up_third)
        binding.lifeBlock.startAnimation(firstBlockAnim)
        binding.restBlock.startAnimation(secondBlockAnim)
        binding.workBlock.startAnimation(thirdBlockAnim)
    }

    private fun updateUI() {
        scaleHeightIfNeeded(R.drawable.life_block, binding.lifeBlock)
        scaleHeightIfNeeded(R.drawable.rest_block, binding.restBlock)
        scaleHeightIfNeeded(R.drawable.work_block, binding.workBlock)
    }

    private fun scaleHeightIfNeeded(resId: Int, view: ImageView) {
        val resourcesBitmap = BitmapFactory.decodeResource(resources, resId)
        context?.let {
            val displayHeight = DeviceDimensionsHelper.getDisplayHeight(it)
            if (displayHeight < resourcesBitmap.height) {
                val resourcesScaledBitmap = Bitmap.createScaledBitmap(
                    resourcesBitmap,
                    resourcesBitmap.width,
                    displayHeight,
                    true
                )
                view.setImageBitmap(resourcesScaledBitmap)
            }
        }

    }

}