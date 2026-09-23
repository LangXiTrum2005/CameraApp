package com.photolab.vintage.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.util.LanguageUtil
import com.photolab.vintage.util.SharePreferenceUtil
import com.photolab.vintage.util.adapter.LanguageAdapter

class LanguageActivity : AppCompatActivity() {

    private lateinit var rvLanguage: RecyclerView
    private lateinit var btnConfirm: FrameLayout
    private lateinit var adapter: LanguageAdapter
    private var isFromSettings: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isFromSettings = intent.getBooleanExtra("from_settings", false)

        if (!isFromSettings && !SharePreferenceUtil.isFirstRun(this)) {
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
            return
        }

        setContentView(R.layout.activity_language)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = 0xFF0D111D.toInt()
        }
        window.decorView.systemUiVisibility = 0

        rvLanguage = findViewById(R.id.rvLanguage)
        btnConfirm = findViewById(R.id.btnConfirm)

        val currentCode = SharePreferenceUtil.getAppLanguage(this)
        val defaultSelectedCode = if (LanguageUtil.POPULAR_LANGUAGES.any { it.code.equals(currentCode, ignoreCase = true) }) {
            currentCode
        } else {
            "vi"
        }

        adapter = LanguageAdapter(LanguageUtil.POPULAR_LANGUAGES, defaultSelectedCode) { _ -> }
        rvLanguage.layoutManager = LinearLayoutManager(this)
        rvLanguage.adapter = adapter

        btnConfirm.setOnClickListener {
            val selectedCode = adapter.selectedCode
            LanguageUtil.applyLanguage(this, selectedCode)

            if (isFromSettings) {
                setResult(RESULT_OK)
                finish()
            } else {
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }
        }
    }
}
