package com.vlr.dk.yugratablet.base_screens

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.vlr.dk.yugratablet.R
import com.vlr.dk.yugratablet.databinding.LifeFragmentBinding
import com.vlr.dk.yugratablet.utils.DeviceDimensionsHelper

class LifeFragment : Fragment() {
    private var _binding: LifeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LifeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
        bindingAction()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindingAction() {
        binding.backAction.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }

    private fun updateUI() {
        scaleHeightIfNeeded(R.drawable.construction_block, binding.constructionBlock)
        scaleHeightIfNeeded(R.drawable.medicine_block, binding.medicineBlock)
        scaleHeightIfNeeded(R.drawable.sports_block, binding.sportsBlock)
        scaleHeightIfNeeded(R.drawable.transport_block, binding.transportBlock)
        scaleHeightIfNeeded(R.drawable.training_block, binding.trainingBlock)
        scaleHeightIfNeeded(R.drawable.children_block, binding.childrenBlock)
    }

    private fun scaleHeightIfNeeded(resId: Int, view: ImageView) {
        val resourcesBitmap = BitmapFactory.decodeResource(resources, resId)
        context?.let {
            val displayHeight = DeviceDimensionsHelper.getDisplayHeight(it)
            if ((displayHeight / 2) < resourcesBitmap.height) {
                val resourcesScaledBitmap = Bitmap.createScaledBitmap(
                    resourcesBitmap,
                    resourcesBitmap.width,
                    displayHeight / 2,
                    true
                )
                view.setImageBitmap(resourcesScaledBitmap)
            }
        }

    }
}