package dk.vixo.githubandroid.github.presentation.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import dk.vixo.githubandroid.R
import dk.vixo.githubandroid.github.domain.model.Repository
import dk.vixo.githubandroid.github.presentation.viewmodel.RepositoriesListViewModel

@Composable
fun RepositoriesListView(vm: RepositoriesListViewModel) {
    val repositories = vm.repositories.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Github repositories") },
            )
        }
    ) {
        LazyColumn {
            items(repositories) { repo ->
                if (repo != null) {
                    RepositoryListItem(repo = repo) {
                        vm.onRepositoryClick(repo)
                    }
                }
            }
        }
    }
}

@Composable
fun RepositoryListItem(
    repo: Repository,
    click: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { click() },
    ) {
        val (name, stars) = createRefs()

        Text(
            text = repo.name,
            textAlign = TextAlign.Start,
            modifier = Modifier.constrainAs(name) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
        )
        
        Box(modifier = Modifier.constrainAs(stars) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        }) {
            AmountStarsView(repo.stars)
        }


        Divider()
    }
}

@Composable
fun AmountStarsView(
    amount: Long
) {
    IconAndText(icon = R.drawable.ic_baseline_star_24, title = "$amount")
}

@Composable
fun IconAndText(
    @DrawableRes icon: Int,
    title: String
) {
    val typo = MaterialTheme.typography

    Row {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )

        Text(
            text = title,
            style = typo.body1
        )
    }
}