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



    }

    fun startAnimation() {
        stopAnimation = false
        animViews()
    }
    fun stopAnimation() {
        stopAnimation = true
    }

    private fun animViews() {
        if (stopAnimation) return

        addView(binding.root, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
        binding.motionLayout.transitionToStart()
        binding.motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, startId: Int, endId: Int) {
                // No-op
            }

            override fun onTransitionChange(motionLayout: MotionLayout, startId: Int, endId: Int, progress: Float) {
                // No-op
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                if (currentId == motionLayout.endState) {
                    // When the transition to the end is completed, start the transition back to start
                    motionLayout.post {
//                        motionLayout.transitionToStart()
                        motionLayout.progress = 0f
                    }
                } else if (currentId == motionLayout.startState) {
                    // When the transition to the start is completed, start the transition to end
                    motionLayout.post {
//                        motionLayout.transitionToStart()
                    }
                }
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


}