package com.example.applauchloader

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation

class LoaderAnimViewActivity: View {

    constructor(context: Context) : super(context) {

    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) :
            super(context, attrs, defStyleAttr, defStyleRes) {

    }

    override fun getAnimation(): Animation {
        return super.getAnimation()
    }

}