package com.example.applauchloader

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.REVERSE
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnticipateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import com.example.applauchloader.databinding.ActivityLoaderAnimationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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

//        binding.secondIV.scaleX = .5f
//        binding.secondIV.scaleY = .5f
//        binding.thirdIV.scaleX = .5f
//        binding.thirdIV.scaleY = .5f
//        binding.bookTV.setTextColor(Color.BLACK)
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

         val animInterpolator = AccelerateDecelerateInterpolator()
            var lastPos = 380f - 38f
            var movingIVObjAnimator =
                ObjectAnimator.ofFloat(binding.movingIV, "translationX", 0f, lastPos).apply {
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