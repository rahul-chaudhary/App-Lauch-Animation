package com.example.applauchloader

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.applauchloader.databinding.AppLaunchLoaderBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.abs

class AppLaunchLoader : LinearLayout {

    lateinit var mBinding: AppLaunchLoaderBinding
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
        mBinding = AppLaunchLoaderBinding.inflate(LayoutInflater.from(context))
        addView(mBinding.root, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))

        mBinding.secondIV.scaleX = .5f
        mBinding.secondIV.scaleY = .5f
        mBinding.thirdIV.scaleX = .5f
        mBinding.thirdIV.scaleY = .5f

        mBinding.bookTV.setTextColor(Color.BLACK)
    }

    fun startAnimation() {
        CoroutineScope(Dispatchers.Main.immediate).launch {
            stopAnimation = false
            animateViews(mBinding.firstIV, mBinding.secondIV, mBinding.bookTV, mBinding.eatTV, 0f, false )
        }
    }

    fun stopAnimation() {
            stopAnimation = true
    }

    private fun animateViews(
        view1: ImageView,
        view2: ImageView,
        text1: TextView,
        text2: TextView,
        initialX: Float,
        reverse: Boolean
    ) {

            if (stopAnimation)
                return

            text2.setTextColor(Color.BLACK)
            mBinding.movingIV.translationX = initialX

            val animator = ValueAnimator.ofFloat(0f, 1f)

            animator.duration = 450
            animator.interpolator = DecelerateInterpolator()

            val diff = (view2.x - view1.x)
            val x = diff + initialX

            animator.addUpdateListener { valueAnimator ->
                val progress = valueAnimator.animatedValue as Float

                view1.scaleX = 1 - (.5f * progress)
                view1.scaleY = 1 - (.5f * progress)

                view2.scaleX = .5f + (.5f * progress)
                view2.scaleY = .5f + (.5f * progress)

                if (reverse) {
                    val trans = initialX - (abs(diff - 30) * progress)

                    mBinding.movingIV.translationX =
                        if (trans > -15) trans else (-15 - (trans + 15))
                } else {
                    var trans = initialX + ((diff + 30) * progress)

                    mBinding.movingIV.translationX =
                        if (trans < x + 15) trans else (x + 15) - (trans - (x + 15))
                }

                if (progress > 0.25) {
                    val resolvedColor = ContextCompat.getColor(context, R.color.gray_shade_12)
                    text1.setTextColor(resolvedColor)
                }
            }

            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    animator.removeAllUpdateListeners()

                    mBinding.firstIV.postDelayed({
                        when (view2) {
                            mBinding.firstIV -> animateViews(
                                mBinding.firstIV,
                                mBinding.secondIV,
                                mBinding.bookTV,
                                mBinding.eatTV,
                                x,
                                false
                            )

                            mBinding.secondIV -> animateViews(
                                mBinding.secondIV,
                                mBinding.thirdIV,
                                mBinding.eatTV,
                                mBinding.saveTV,
                                x,
                                false
                            )

                            mBinding.thirdIV -> animateViews(
                                mBinding.thirdIV,
                                mBinding.firstIV,
                                mBinding.saveTV,
                                mBinding.bookTV,
                                x,
                                true
                            )
                        }
                    }, 600)

                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })

            animator.start()

    }
}
