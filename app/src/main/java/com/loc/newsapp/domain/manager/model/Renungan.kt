package com.loc.newsapp.domain.manager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Renungan(
    @PrimaryKey val kodeRenungan: Int,
    val penulis: String,
    val judul: String,
    val deskripsi: String,
    val konten: String
)
