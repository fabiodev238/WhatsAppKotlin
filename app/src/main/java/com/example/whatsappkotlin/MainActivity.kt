package com.example.whatsappkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.whatsappkotlin.databinding.ActivityMainBinding
import com.example.whatsappkotlin.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT < 31) setTheme(R.style.Theme_WhatsAppClone)
        val splashScreen = installSplashScreen().apply {
            setKeepOnScreenCondition {
                true
            }
        }

        setupObservers()
        loadAppView()

        viewModel.hasSplashFinished.observe(this) {
            splashScreen.setKeepOnScreenCondition {
                false
            }
        }
    }

    private fun loadAppView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupObservers() {
        viewModel.userId.observe(this) { userId ->
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.fMain) as NavHostFragment
            val navController = navHostFragment.navController
            val navGraph =
                findNavController(R.id.fMain).navInflater.inflate(R.navigation.main_nav_graph)

            if (userId.isNotEmpty()) {
                navGraph.setStartDestination(R.id.dashboardFragment)
                navController.setGraph(graph = navGraph, bundleOf("userId" to userId))
            } else {
                navGraph.setStartDestination(R.id.userSelectionFragment)
                navController.graph = navGraph
            }

            viewModel.checkUserSelection()
        }
    }
}