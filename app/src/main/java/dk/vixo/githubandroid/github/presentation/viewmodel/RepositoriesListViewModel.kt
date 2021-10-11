package dk.vixo.githubandroid.github.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dk.vixo.githubandroid.github.domain.model.Repository
import dk.vixo.githubandroid.github.domain.usecase.GetGitRepositoriesUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class RepositoriesListViewModel @Inject constructor(
    private val repositoriesUseCase: GetGitRepositoriesUseCase
) : ViewModel() {

    private val detailCh = Channel<Repository>(Channel.CONFLATED)
    val detailEvent = detailCh.receiveAsFlow()

    val repositories = Pager(PagingConfig(30)) { repositoriesUseCase.getSource() }.flow

    fun onRepositoryClick(repo: Repository) {
        detailCh.trySend(repo)
    }

}