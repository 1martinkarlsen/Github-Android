package dk.vixo.githubandroid.github.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dk.vixo.githubandroid.github.domain.model.PullRequest
import dk.vixo.githubandroid.github.domain.model.Repository
import dk.vixo.githubandroid.github.domain.usecase.GetPullRequestsForRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RepositoryDetailViewModel @Inject constructor(
    private val pullRequestUseCase: GetPullRequestsForRepository
) : ViewModel() {

    val repository = MutableStateFlow<Repository?>(null)
    val pullRequests = MutableStateFlow<List<PullRequest>>(emptyList())

    fun setRepository(repo: Repository) {
        repository.value = repo
        loadPullRequests(repo)
    }

    private fun loadPullRequests(repo: Repository) {
        viewModelScope.launch {
            val prs = pullRequestUseCase.getPullRequests(repo)
            pullRequests.value = prs
        }
    }
}