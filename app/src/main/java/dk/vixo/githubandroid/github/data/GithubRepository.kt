package dk.vixo.githubandroid.github.data

import dk.vixo.githubandroid.github.data.network.GithubService
import dk.vixo.githubandroid.github.domain.mappers.PullRequestDTOToPullRequestMapper
import dk.vixo.githubandroid.github.domain.model.PullRequest
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val service: GithubService,
    private val prMapper: PullRequestDTOToPullRequestMapper
) {

    suspend fun getRepositories(sort: String, page: Int) =
        service.loadRepositories("stars:>=10", sort, page)

    suspend fun getPullRequestForRepository(repoPath: String): List<PullRequest> {
        val res = service.loadPullRequests(repoPath)
        return if (res.isSuccessful) {
            res.body()!!.map(prMapper::map)
        } else emptyList()
    }

}