package com.example.applauchloader

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.REVERSE
import android.animation.ValueAnimator.setFrameDelay
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import com.example.applauchloader.databinding.ActivityLoaderAnimationBinding
import kotlinx.coroutines.delay


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
            binding.movingIV,
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
        movingIV: ImageView,
        initialX: Float
    ) {
        if (stopAnimation) return

         val animInterpolator = AccelerateDecelerateInterpolator()
            val lastPos = 380f
            var movingIVObjAnimator =
                ObjectAnimator.ofFloat(binding.movingIV, "translationX", secondIV.x.toFloat(), lastPos).apply {
                    startDelay = 400
                    duration = 1000
                    interpolator = animInterpolator
                    repeatCount = INFINITE
                    repeatMode = REVERSE
                    start()
                }

            val firstIVObjAnimatorX = ObjectAnimator.ofFloat(binding.firstIV, "scaleX", 1f, 0.5f).apply {
                duration = 1000
                interpolator = animInterpolator
                repeatCount = INFINITE
                repeatMode = REVERSE
//                movingIV.x = secondIV.x
//                startDelay = 400
                start()
            }
            val firstIVObjAnimatorY = ObjectAnimator.ofFloat(binding.firstIV, "scaleY", 1f, 0.5f).apply {
                duration = 1000
                interpolator = animInterpolator
                repeatCount = INFINITE
                repeatMode = REVERSE
                start()

            }
            val secondIVObjAnimatorX = ObjectAnimator.ofFloat(binding.secondIV, "scaleX", 0.5f, 1f).apply {
                duration = 1000
                interpolator = animInterpolator
                repeatCount = INFINITE
                repeatMode = REVERSE
                start()
            }
            val secondIVObjAnimatorY = ObjectAnimator.ofFloat(binding.secondIV, "scaleY", 0.5f, 1f).apply {
                duration = 1000
                interpolator = animInterpolator
                repeatCount = INFINITE
                repeatMode = REVERSE
                start()
            }



            val thirdIVObjAnimatorX = ObjectAnimator.ofFloat(binding.thirdIV, "scaleX", 0.5f, 1f).apply {
                duration = 1000
                interpolator = animInterpolator
                repeatCount = INFINITE
                repeatMode = REVERSE
                start()
            }
            val thirdIVObjAnimatorY = ObjectAnimator.ofFloat(binding.thirdIV, "scaleY", 0.5f, 1f).apply {
                duration = 1000
                interpolator = AccelerateDecelerateInterpolator()
                repeatCount = INFINITE
                repeatMode = REVERSE
                start()
            }

        val bookTVObjAnimator = ObjectAnimator.ofFloat(binding.bookTV, "alpha",  0.5f, 1f).apply {
            duration = 1000
            interpolator = animInterpolator
            repeatCount = INFINITE
            repeatMode = REVERSE
            start()
        }

        val eatTVObjAnimator = ObjectAnimator.ofFloat(binding.eatTV, "alpha",  0.5f, 1f).apply {
            duration = 1000
            interpolator = animInterpolator
            repeatCount = INFINITE
            repeatMode = REVERSE
            start()
        }

        val saveTVObjAnimator = ObjectAnimator.ofFloat(binding.saveTV, "alpha",  0.5f, 1f).apply {
            duration = 1000
            interpolator = animInterpolator
            repeatCount = INFINITE
            repeatMode = REVERSE
            start()
        }




    }


}