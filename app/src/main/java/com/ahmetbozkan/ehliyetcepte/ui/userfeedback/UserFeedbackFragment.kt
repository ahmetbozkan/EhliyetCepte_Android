package com.ahmetbozkan.ehliyetcepte.ui.userfeedback

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentUserFeedbackBinding
import com.ahmetbozkan.ehliyetcepte.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFeedbackFragment : BaseFragment<FragmentUserFeedbackBinding, UserFeedbackViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_user_feedback

    override val viewModel: UserFeedbackViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {

        manageClick()

    }

    private fun manageClick() = with(binding) {
        btnSend.setOnClickListener {
            val subject = edtSubject.text.toString()
            val message = edtMessage.text.toString()

            if (message.isNotEmpty())
                onSendClicked(subject, message)
        }
    }

    private fun onSendClicked(subject: String, message: String) {
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            type = "message/rfc822"

            putExtra(Intent.EXTRA_EMAIL, arrayOf(Constants.DEVELOPER_EMAIL))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)

            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }, "Mail gonder")
        startActivity(share)
    }
}