package dk.vixo.githubandroid.github.domain.usecase

import dk.vixo.githubandroid.github.data.GithubRepository
import dk.vixo.githubandroid.github.domain.model.PullRequest
import dk.vixo.githubandroid.github.domain.model.Repository
import javax.inject.Inject

class GetPullRequestsForRepository @Inject constructor(
    private val githubRepo: GithubRepository
) {

    suspend fun getPullRequests(repo: Repository): List<PullRequest> {
        return githubRepo.getPullRequestForRepository(repo.pullRequestUrl)
    }
}