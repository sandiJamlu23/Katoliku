package com.loc.newsapp.presentation.credo

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.manager.model.Article
import com.loc.newsapp.domain.manager.model.Renungan
import com.loc.newsapp.domain.manager.model.Source
import com.loc.newsapp.presentation.details.components.DetailsEvent
import com.loc.newsapp.presentation.onBoarding.Dimens.ArticleImageHeight
import com.loc.newsapp.presentation.onBoarding.Dimens.mediumPadding1
import com.loc.newsapp.ui.theme.NewsAppTheme

val renungan = listOf(
    Renungan(
        kodeRenungan = 1,
        penulis = "Author 1",
        judul = "Title 1",
        deskripsi = "Description 1",
        konten = "Content 1"
    ),
    Renungan(
        kodeRenungan = 2,
        penulis = "Author 2",
        judul = "Title 2",
        deskripsi = "Description 2",
        konten = "Content 2"
    ),
    Renungan(
        kodeRenungan = 3,
        penulis = "Author 3",
        judul = "Title 3",
        deskripsi = "Description 3",
        konten = "Content 3"
    ),
    Renungan(
        kodeRenungan = 4,
        penulis = "Author 4",
        judul = "Title 4",
        deskripsi = "Description 4",
        konten = "Content 4"
    )
)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CredoScreen(
    renungan: List<Renungan>,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit,
    navigateToSearch:() -> Unit,
    navigateToDetails:(Article) -> Unit,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        CredoTopBar(
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, renungan[0].konten)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            /*
            onBookMarkClick = {
                event(DetailsEvent.UpsertDeleteArticle(renungan[0]))
            },

             */
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = mediumPadding1,
                end = mediumPadding1,
                top = mediumPadding1
            )
        ) {
            items(renungan.take(4)) { renunganItem ->
                Text(
                    text = renunganItem.judul,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(id = R.color.text_title)
                )

                Text(
                    text = renunganItem.konten,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}

@Preview
@Composable
fun CredoScreenPreview() {
    NewsAppTheme {
        CredoScreen(
            renungan = renungan,
            event = {},
            navigateUp = {},
            navigateToSearch = {},
            navigateToDetails = {}
        )
    }
}









