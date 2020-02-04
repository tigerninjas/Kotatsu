package org.koitharu.kotatsu.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Manga(
	val id: Long,
	val title: String,
	val localizedTitle: String? = null,
	val url: String,
	val rating: Float = NO_RATING, //normalized value [0..1] or -1
	val coverUrl: String,
	val largeCoverUrl: String? = null,
	val summary: String,
	val description: String? = null, //HTML
	val tags: Set<MangaTag> = emptySet(),
	val state: MangaState? = null,
	val chapters: List<MangaChapter>? = null,
	val source: MangaSource
) : Parcelable {

	companion object {

		const val NO_RATING = -1f
	}
}