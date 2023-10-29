package com.vlr.dk.yugratablet.base_screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.vlr.dk.yugratablet.R
import com.vlr.dk.yugratablet.databinding.RestFragmentBinding
import com.vlr.dk.yugratablet.utils.DeviceDimensionsHelper
import com.vlr.dk.yugratablet.utils.RES_ID

class RestFragment : Fragment() {
    private var _binding: RestFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RestFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUIWithAnimation()
        bindingAction()
    }

    private fun bindingAction() {
        binding.backAction.setOnClickListener {
            it.findNavController().popBackStack()
        }

        binding.tourismBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 0)
            it.findNavController().navigate(R.id.restDetailFragment, data)
        }

        binding.cultureBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 1)
            it.findNavController().navigate(R.id.restDetailFragment, data)
        }
    }

    private fun updateUIWithAnimation() {
        scaleHeightIfNeeded(R.drawable.tourism_block, binding.tourismBlock)
        scaleHeightIfNeeded(R.drawable.culture_block, binding.cultureBlock)

        val tourismBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_ltr_turism)
        binding.tourismBlock.startAnimation(tourismBlockAnim)

        val cultureBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_rtl_culture)
        binding.cultureBlock.startAnimation(cultureBlockAnim)

        val backButtonAnim = AnimationUtils.loadAnimation(context, R.anim.move_ltr)
        binding.backAction.startAnimation(backButtonAnim)
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