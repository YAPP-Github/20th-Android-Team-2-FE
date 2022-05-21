package com.best.friends.home

import android.os.Bundle
import androidx.activity.viewModels
import com.best.friends.core.BaseActivity
import com.best.friends.home.databinding.ActivityMainBinding
import com.best.friends.navigator.SecondsNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var secondsNavigator: SecondsNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tvNavigation.setOnClickListener {
            val intent = secondsNavigator.intent(this)
            startActivity(intent)
        }
    }
}
