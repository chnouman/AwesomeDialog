package com.example.awesomedialog

import android.app.Activity
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import com.example.awesomedialog.AwesomeDialog.Companion.onPositive
import kotlinx.android.synthetic.main.awesome_dilaog.*

class AwesomeDialog() {

    companion object {

        private lateinit var layoutInflater: LayoutInflater

        fun AlertDialog.title(
            title: String,
            fontStyle: Typeface? = null,
            titleColor: Int = 0
        ): AlertDialog {
            this.title.text = title.trim()
            if (fontStyle != null) {
                this.title.typeface = fontStyle
            }
            if (titleColor != 0) {
                this.title.setTextColor(titleColor)
            }
            this.title.show()
            return this
        }

        fun AlertDialog.background(
            color: Int? = null
        ): AlertDialog {
            if (color != null) {
                this.mainLayout.setBackgroundResource(color)
            }
            return this
        }

        fun AlertDialog.body(
            body: String,
            fontStyle: Typeface? = null,
            color: Int = 0
        ): AlertDialog {
            this.subHeading.text = body.trim()
            this.subHeading.show()
            if (fontStyle != null) {
                this.subHeading.typeface = fontStyle
            }
            if (color != 0) {
                this.subHeading.setTextColor(color)
            }
            return this
        }

        fun AlertDialog.icon(
            icon: Int,
            animateIcon: Boolean = false
        ): AlertDialog {
            this.image.setImageResource(icon)
            this.image.show()
            // Pulse Animation for Icon
            if (animateIcon) {
                val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                image.startAnimation(pulseAnimation)
            }
            return this
        }

        fun AlertDialog.onPositive(
            text: String,
            color: Int? = null,
            textColor: Int? = null,
            action: () -> Unit
        ): AlertDialog {
            this.yesButton.show()
            if (color != null) {
                this.yesButton.setBackgroundResource(color)
            }
            if (textColor != null) {
                this.yesButton.setTextColor(textColor)
            }
            this.yesButton.text = text.trim()
            this.yesButton.setOnClickListener {
                action.invoke()
                dismiss()
            }
            return this
        }

        fun AlertDialog.onNegative(
            text: String,
            color: Int? = null,
            textColor: Int? = null,
            action: () -> Unit
        ): AlertDialog {
            this.noButton.show()
            this.noButton.text = text.trim()
            if (textColor != null) {
                this.noButton.setTextColor(textColor)
            }
            if (color != null) {
                this.noButton.setBackgroundResource(color)
            }
            this.noButton.setOnClickListener {
                action.invoke()
                dismiss()
            }
            return this
        }

        // all toast CTA
        fun createDialog(
            context: Activity
        ): AlertDialog {
            layoutInflater = LayoutInflater.from(context)
            val alertDialog =
                AlertDialog.Builder(
                    context, R.style.full_screen_dialog
                )
                    .setView(R.layout.awesome_dilaog)
            val alert: AlertDialog = alertDialog.create()
            // Let's start with animation work. We just need to create a style and use it here as follows.
//            alert.window?.attributes?.windowAnimations = R.style.SlidingDialogAnimation
            alert.show()
            return alert

/*

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    // Background tint color for side view
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.success_color)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.success_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.success_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_SUCCESS
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.error_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.error_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.error_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_ERROR
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_WARNING
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.info_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.info_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.info_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_INFO
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    when (duration) {
                        LONG_DURATION -> {
                            val timer = object : CountDownTimer(5000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    toast.show()
                                }

                                override fun onFinish() {
                                    toast.cancel()
                                }
                            }
                            timer.start()

                        }
                        SHORT_DURATION -> {
                            val timer = object : CountDownTimer(3000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    toast.show()
                                }

                                override fun onFinish() {
                                    toast.cancel()
                                }
                            }
                            timer.start()
                        }
                        else -> {
                            val timer = object : CountDownTimer(2000, 1000) {
                                override fun onTick(millisUntilFinished: Long) {
                                    toast.show()
                                }

                                override fun onFinish() {
                                    toast.cancel()
                                }
                            }
                            timer.start()
                        }
                    }
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.delete_color)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.delete_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.delete_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_DELETE
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_NO_INTERNET
                    layout.custom_toast_description.setTextColor(Color.BLACK)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()

                }


            }*/
        }

        /*   // all color toast CTA
        fun createColorToast(
            context: Activity,
            message: String,
            style: String,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.full_color_toast,
                (context).findViewById(R.id.color_toast_view)
            )
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.success_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_SUCCESS
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.error_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_ERROR
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_WARNING
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.info_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_INFO
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )


                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.delete_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_DELETE
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.warning_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(Color.WHITE)
                    layout.color_toast_text.text = TOAST_NO_INTERNET
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
            }
        }

        // all dark toast CTA
        fun darkToast(
            context: Activity,
            message: String,
            style: String,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.full_color_toast,
                (context).findViewById(R.id.color_toast_view)
            )
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable


                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.success_title_color
                        )
                    )
                    layout.color_toast_text.text = TOAST_SUCCESS
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.error_color
                        )
                    )
                    layout.color_toast_text.text = TOAST_ERROR
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.color_toast_text.text = TOAST_WARNING
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.info_color
                        )
                    )
                    layout.color_toast_text.text = TOAST_INFO
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )


                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.delete_color
                        )
                    )
                    layout.color_toast_text.text = TOAST_DELETE
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.color_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.color_toast_image.startAnimation(pulseAnimation)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.color_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.color_toast_text.text = TOAST_NO_INTERNET
                    layout.color_toast_description.setTextColor(Color.WHITE)
                    layout.color_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.color_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }


            }

        }


        // all toast CTA
        fun darkColorToast(
            context: Activity,
            message: String,
            style: String,
            position: Int,
            duration: Int,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.motion_toast,
                (context).findViewById(R.id.motion_toast_view)
            )
            when (style) {
                // Function for Toast Success
                TOAST_SUCCESS -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_check_green
                        )
                    )

                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    // Background tint color for side view
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.success_color)

                    // round background color
                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable

                    // Setting up the color for title & Message text
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.success_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_SUCCESS
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message

                    // Setting typeface for the text
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }

                    // init toast
                    val toast = Toast(context.applicationContext)

                    //   Setting up the duration
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    // Setting Toast Gravity
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                TOAST_ERROR -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_error_
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.error_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.error_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_ERROR
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Warning
                TOAST_WARNING -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_warning_yellow
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )

                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_WARNING
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()

                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Info
                TOAST_INFO -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)

                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.info_color)

                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.info_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_INFO
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
                    toast.show()
                }
                // CTA for Toast Delete
                TOAST_DELETE -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_delete_
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.delete_color)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.delete_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_DELETE
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()

                }
                // CTA for Toast No Internet
                TOAST_NO_INTERNET -> {
                    layout.custom_toast_image.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_no_internet
                        )
                    )


                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    layout.custom_toast_image.startAnimation(pulseAnimation)
                    layout.colorView.backgroundTintList =
                        ContextCompat.getColorStateList(context, R.color.warning_color)


                    val drawable =
                        ContextCompat.getDrawable(context, R.drawable.toast_round_background)
                    drawable?.colorFilter = PorterDuffColorFilter(
                        ContextCompat.getColor(context, R.color.dark_bg_color),
                        PorterDuff.Mode.MULTIPLY
                    )
                    layout.background = drawable
                    layout.custom_toast_text.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.warning_color
                        )
                    )
                    layout.custom_toast_text.text = TOAST_NO_INTERNET
                    layout.custom_toast_description.setTextColor(Color.WHITE)
                    layout.custom_toast_description.text = message
                    font?.let {
                        layout.custom_toast_description.typeface = font
                    }
                    val toast = Toast(context.applicationContext)
                    val durationMillis = when (duration) {
                        LONG_DURATION -> 5000L
                        SHORT_DURATION -> 3000L
                        else -> 2000L
                    }
                    val timer = object : CountDownTimer(durationMillis, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            toast.show()
                        }

                        override fun onFinish() {
                            toast.cancel()
                        }
                    }
                    timer.start()
                    if (position == GRAVITY_BOTTOM) {
                        toast.setGravity(position, 0, 100)
                    } else {
                        toast.setGravity(position, 0, 0)
                    }
                    toast.view = layout//setting the view of custom toast layout
//                    layout.animate().alpha(0f).duration = 3000
                    toast.show()
                }
            }
        }
    }*/
    }
}

private fun View.show() {
    this.visibility = View.VISIBLE
}
