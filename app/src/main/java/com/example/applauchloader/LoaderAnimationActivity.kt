package com.example.applauchloader

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.applauchloader.databinding.ActivityLoaderAnimationBinding


class LoaderAnimationActivity : LinearLayout {
    private lateinit var binding: ActivityLoaderAnimationBinding
    private var stopAnimation = false

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) :
            super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    private fun init() {
        binding = ActivityLoaderAnimationBinding.inflate(LayoutInflater.from(context))
        addView(binding.root, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))




        binding.motionLayout.transitionToStart()
        var looped = false

        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, i: Int, i1: Int) {
            }

            override fun onTransitionChange(motionLayout: MotionLayout, i: Int, i1: Int, v: Float) {
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, i: Int) {

                if (!looped) motionLayout.transitionToStart()
                else motionLayout.transitionToEnd()

                looped = !looped
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout,
                i: Int,
                b: Boolean,
                v: Float
            ) {
            }
        })
    }

    fun startAnimation() {
        stopAnimation = false
        animViews(
            binding.firstIV,
            binding.secondIV,
            binding.thirdIV,
            binding.bookTV,
            binding.eatTV,
            binding.saveTV,
            0f
        )
    }

    private fun animViews(
        firstIV: ImageView,
        secondIV: ImageView,
        thirdIV: ImageView,
        bookTV: AppCompatTextView,
        eatTV: AppCompatTextView,
        saveTV: AppCompatTextView,
        initialX: Float
    ) {
        if (stopAnimation) return



    }


}