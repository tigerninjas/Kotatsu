package org.koitharu.kotatsu.utils.ext

fun String.longHashCode(): Long {
	var h = 1125899906842597L
	val len: Int = this.length
	for (i in 0 until len) {
		h = 31 * h + this[i].toLong()
	}
	return h
}

fun String.withDomain(domain: String, ssl: Boolean = true) = when {
	this.startsWith("/") -> buildString {
		append("http")
		if (ssl) {
			append('s')
		}
		append("://")
		append(domain)
		append(this@withDomain)
	}
	else -> this
}

fun String.removeSurrounding(vararg chars: Char): String {
	if (length == 0) {
		return this
	}
	for (c in chars) {
		if (first() == c && last() == c) {
			return substring(1, length - 1)
		}
	}
	return this
}