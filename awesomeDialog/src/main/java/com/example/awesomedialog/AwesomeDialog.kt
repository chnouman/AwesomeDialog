package com.example.awesomedialog

import android.app.Activity
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.awesome_dilaog.*


class AwesomeDialog() {

    enum class POSITIONS {
        CENTER, BOTTOM
    }

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

        fun AlertDialog.position(
            position: POSITIONS = POSITIONS.BOTTOM
        ): AlertDialog {
            val layoutParams = mainLayout.layoutParams as RelativeLayout.LayoutParams
            if (position == POSITIONS.CENTER) {
                layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
            } else if (position == POSITIONS.BOTTOM) {
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            }
            mainLayout!!.layoutParams = layoutParams
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
        }


    }
}

private fun View.show() {
    this.visibility = View.VISIBLE
}
