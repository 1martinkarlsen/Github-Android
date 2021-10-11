package dk.vixo.githubandroid.github.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import dk.vixo.githubandroid.R
import dk.vixo.githubandroid.github.data.network.dto.OwnerDTO
import dk.vixo.githubandroid.github.domain.model.PullRequest
import dk.vixo.githubandroid.github.presentation.viewmodel.RepositoryDetailViewModel

@Composable
fun RepositoryDetailView(vm: RepositoryDetailViewModel, onBack: () -> Unit) {
    val typo = MaterialTheme.typography
    val repository by vm.repository.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = repository?.name ?: "") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {

        val repo = repository
        if (repo != null) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(text = repo.fullName, modifier = Modifier.fillMaxWidth(), style = typo.h4)

                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (stars, followers) = createRefs()
                    Box(modifier = Modifier.constrainAs(stars) { start.linkTo(parent.start) }) {
                        AmountStarsView(amount = repo.stars)
                    }

                    Box(modifier = Modifier.constrainAs(followers) { end.linkTo(parent.end) }) {
                        AmountWatchersView(amount = repo.watchers)
                    }

                }

                OwnerIllustration(repo.owner)

                PullRequestListView(vm)
            }
        }
    }
    
}

@Composable
fun OwnerIllustration(owner: OwnerDTO) {
    val typo = MaterialTheme.typography

    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (image, name) = createRefs()

        Image(
            painter = rememberImagePainter(
                data = owner.avatar_url,
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(42.dp)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )

        Text(
            text = owner.login,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(name) {
                    start.linkTo(image.end)
                    top.linkTo(image.top)
                    bottom.linkTo(image.bottom)
                },
            style = typo.subtitle1
        )
    }
}

@Composable
fun AmountWatchersView(
    amount: Long
) {
    IconAndText(icon = R.drawable.ic_baseline_remove_red_eye_24, title = "$amount")
}

@Composable
fun PullRequestListView(vm: RepositoryDetailViewModel) {
    val pullRequests by vm.pullRequests.collectAsState()

    LazyColumn {
        items(pullRequests) { pr ->
            PullRequestView(pr = pr)
            Divider()
        }
    }
}

@Composable
fun PullRequestView(pr: PullRequest) {
    val typo = MaterialTheme.typography

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {

        Text(text = pr.title, style = typo.subtitle1)

        Text(text = pr.user.login, style = typo.subtitle2)
    }
}