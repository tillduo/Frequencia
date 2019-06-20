package com.tillduo.frequencia

import android.content.Intent
import android.os.Bundle
import android.app.Fragment
import android.media.RingtoneManager.EXTRA_RINGTONE_TITLE
import android.net.Uri
import android.preference.*
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_configuracao.*
import android.preference.Preference
import android.preference.Preference.OnPreferenceChangeListener

class ConfiguracaoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_configuracao)

        var fragment: Fragment = SettingsScreen()
        var fragmentTransaction: android.app.FragmentTransaction? = fragmentManager.beginTransaction()
        if (savedInstanceState == null){
            fragmentTransaction?.add(R.id.relative_layout, fragment, "configuracao_fragment")
            fragmentTransaction?.commit()
        }else{
            fragment = fragmentManager.findFragmentByTag("configuracao_fragment")
        }

        imVoltar.setOnClickListener{
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    class SettingsScreen: PreferenceFragment(){
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.activity_configuracao)

            var etPNome: EditTextPreference = findPreference("nome_usuario") as EditTextPreference
            var etPEmail: EditTextPreference = findPreference("email_usuario") as EditTextPreference
            var cbPNotHab: CheckBoxPreference = findPreference("habilitar_noticacao") as CheckBoxPreference
            var ringP: RingtonePreference = findPreference("som_notificacao") as RingtonePreference
            ringP.isEnabled = cbPNotHab.isChecked


            this.editTextSetOnPreferenceChangeListener(etPNome)
            this.editTextSetOnPreferenceChangeListener(etPEmail)
            this.checkBoxSetOnPreferenceChangeListener(cbPNotHab, ringP)
            this.ringSetOnPreferenceChangeListener(ringP)
        }

        private fun editTextSetOnPreferenceChangeListener(preference: Preference){
            preference.onPreferenceChangeListener = OnPreferenceChangeListener{ preference, newValue ->
                preference.summary = newValue.toString()
                true
            }
        }

        private fun checkBoxSetOnPreferenceChangeListener(preference: Preference, preference2: Preference){
            preference.onPreferenceChangeListener = OnPreferenceChangeListener{ preference, newValue ->
                preference2.isEnabled = !preference2.isEnabled
                true
            }
        }

        private fun ringSetOnPreferenceChangeListener(preference: Preference){
            preference.onPreferenceChangeListener = OnPreferenceChangeListener{ preference, newValue ->
                preference.summary = newValue.toString()
                true
            }
        }
    }
}
