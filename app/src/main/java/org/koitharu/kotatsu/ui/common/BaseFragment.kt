package org.koitharu.kotatsu.ui.common

import android.content.Context
import android.content.SharedPreferences
import android.os.Parcelable
import androidx.annotation.LayoutRes
import moxy.MvpAppCompatFragment
import org.koin.android.ext.android.inject
import org.koitharu.kotatsu.core.prefs.AppSettings
import org.koitharu.kotatsu.utils.delegates.ParcelableArgumentDelegate
import org.koitharu.kotatsu.utils.delegates.StringArgumentDelegate

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) :
	MvpAppCompatFragment(contentLayoutId), SharedPreferences.OnSharedPreferenceChangeListener {

	protected val settings by inject<AppSettings>()

	fun stringArg(name: String) = StringArgumentDelegate(name)

	fun <T : Parcelable> arg(name: String) = ParcelableArgumentDelegate<T>(name)

	override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) = Unit

	open fun getTitle(): CharSequence? = null

	override fun onAttach(context: Context) {
		super.onAttach(context)
		getTitle()?.let {
			activity?.title = it
		}
	}
}