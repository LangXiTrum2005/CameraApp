package com.photolab.vintage.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.switchmaterial.SwitchMaterial
import com.photolab.vintage.R
import com.photolab.vintage.util.FirebaseAnalyticsHelper
import com.photolab.vintage.util.LanguageUtil
import com.photolab.vintage.util.SharePreferenceUtil

class SettingsActivity : AppCompatActivity() {

    private var appliedLanguageCode: String = ""

    private lateinit var cardLanguage: MaterialCardView
    private lateinit var tvLanguageSubtitle: TextView
    private lateinit var switchGrid: SwitchMaterial
    private lateinit var switchSaveOriginal: SwitchMaterial
    private lateinit var switchMirrorFrontCamera: SwitchMaterial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_layout)
        FirebaseAnalyticsHelper.logEvent(this, "settings_opened")

        val toolbar = findViewById<Toolbar>(R.id.toolbar_settings)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.settings_title)
        }

        cardLanguage = findViewById(R.id.card_language)
        tvLanguageSubtitle = findViewById(R.id.tv_language_subtitle)
        switchGrid = findViewById(R.id.switch_grid)
        switchSaveOriginal = findViewById(R.id.switch_save_original)
        switchMirrorFrontCamera = findViewById(R.id.switch_mirror_front_camera)

        tvLanguageSubtitle.text = LanguageUtil.getCurrentLanguageName(this)
        appliedLanguageCode = SharePreferenceUtil.getAppLanguage(this)

        cardLanguage.setOnClickListener {
            val intent = Intent(this, LanguageActivity::class.java)
            intent.putExtra("from_settings", true)
            startActivity(intent)
        }

        switchGrid.isChecked = SharePreferenceUtil.isGridEnabled(this)
        switchGrid.setOnCheckedChangeListener { _, isChecked ->
            SharePreferenceUtil.setGridEnabled(this, isChecked)
        }

        switchSaveOriginal.isChecked = SharePreferenceUtil.isSaveOriginalEnabled(this)
        switchSaveOriginal.setOnCheckedChangeListener { _, isChecked ->
            SharePreferenceUtil.setSaveOriginalEnabled(this, isChecked)
        }

        switchMirrorFrontCamera.isChecked = SharePreferenceUtil.isMirrorFrontCameraEnabled(this)
        switchMirrorFrontCamera.setOnCheckedChangeListener { _, isChecked ->
            SharePreferenceUtil.setMirrorFrontCameraEnabled(this, isChecked)
        }
    }

    override fun onResume() {
        super.onResume()
        if (::tvLanguageSubtitle.isInitialized) {
            val selectedLanguage = SharePreferenceUtil.getAppLanguage(this)
            if (appliedLanguageCode.isNotEmpty() && selectedLanguage != appliedLanguageCode) {
                recreate()
                return
            }
            tvLanguageSubtitle.text = LanguageUtil.getCurrentLanguageName(this)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
