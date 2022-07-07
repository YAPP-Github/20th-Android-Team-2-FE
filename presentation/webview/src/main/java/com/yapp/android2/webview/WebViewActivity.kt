package com.yapp.android2.webview

import android.content.Intent
import android.os.Bundle
import android.webkit.CookieManager
import com.best.friends.core.BaseActivity
import com.best.friends.core.ui.gone
import com.best.friends.core.ui.visible
import com.yapp.android2.domain.url.WebURL
import com.yapp.android2.webview.databinding.ActivityWebViewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class WebViewActivity : BaseActivity<ActivityWebViewBinding>(R.layout.activity_web_view) {

    @Inject
    lateinit var baseUrl: WebURL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolbarInit()
        webViewInit()
    }

    private fun toolbarInit() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.policy_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            clearCookie()
            onBackPressed()
        }
    }

    private fun clearCookie() {
        val cookieManager = CookieManager.getInstance()
        cookieManager.removeAllCookies {
            Timber.d("cookies all clear -> $it")
        }
        cookieManager.removeSessionCookies {
            Timber.d("session all clear -> $it")
        }

        cookieManager.flush()
        binding.webView.clearCache(true)
    }

    private fun webViewInit() {

        binding.webView.webViewClient = BestFriendWebViewClient.getInstance(
            onPageStarted = { binding.progressBar.visible() },
        )

        binding.webView.webChromeClient = BestFriendWebChromeClient.getInstance { progress ->
            binding.progressBar.progress = progress

            if(progress == 100) { binding.progressBar.gone() }
        }

        webViewSetting()

        binding.webView.loadUrl(baseUrl.url)
    }

    private fun webViewSetting() {
        with(binding.webView.settings) {
            builtInZoomControls = false
            domStorageEnabled = true
            javaScriptEnabled = true
            loadWithOverviewMode = true
            setSupportZoom(false)
        }
    }

}
