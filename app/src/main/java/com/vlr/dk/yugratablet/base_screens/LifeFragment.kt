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
import com.vlr.dk.yugratablet.databinding.LifeFragmentBinding
import com.vlr.dk.yugratablet.utils.DeviceDimensionsHelper
import com.vlr.dk.yugratablet.utils.RES_ID

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

        updateUIWithAnimation()
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

        binding.constructionBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 0)
            it.findNavController().navigate(R.id.lifeDetailFragment, data)
        }

        binding.medicineBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 1)
            it.findNavController().navigate(R.id.lifeDetailFragment, data)
        }

        binding.sportsBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 2)
            it.findNavController().navigate(R.id.lifeDetailFragment, data)
        }

        binding.transportBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 3)
            it.findNavController().navigate(R.id.lifeDetailFragment, data)
        }

        binding.trainingBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 4)
            it.findNavController().navigate(R.id.lifeDetailFragment, data)
        }

        binding.childrenBlock.setOnClickListener {
            val data = Bundle()
            data.putInt(RES_ID, 5)
            it.findNavController().navigate(R.id.lifeDetailFragment, data)
        }
    }

    private fun updateUIWithAnimation() {
        scaleHeightIfNeeded(R.drawable.construction_block, binding.constructionBlock)
        scaleHeightIfNeeded(R.drawable.medicine_block, binding.medicineBlock)
        scaleHeightIfNeeded(R.drawable.sports_block, binding.sportsBlock)
        scaleHeightIfNeeded(R.drawable.transport_block, binding.transportBlock)
        scaleHeightIfNeeded(R.drawable.training_block, binding.trainingBlock)
        scaleHeightIfNeeded(R.drawable.children_block, binding.childrenBlock)

        val constractionBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_constraction)
        binding.constructionBlock.startAnimation(constractionBlockAnim)

        val transportBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_transport)
        binding.transportBlock.startAnimation(transportBlockAnim)

        val medicineBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_medicine)
        binding.medicineBlock.startAnimation(medicineBlockAnim)

        val trainingBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_training)
        binding.trainingBlock.startAnimation(trainingBlockAnim)

        val sportBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_sport)
        binding.sportsBlock.startAnimation(sportBlockAnim)

        val childrenBlockAnim = AnimationUtils.loadAnimation(context, R.anim.move_children)
        binding.childrenBlock.startAnimation(childrenBlockAnim)

        val backButtonAnim = AnimationUtils.loadAnimation(context, R.anim.move_ltr)
        binding.backAction.startAnimation(backButtonAnim)
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