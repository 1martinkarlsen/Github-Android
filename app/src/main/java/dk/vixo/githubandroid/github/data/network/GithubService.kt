package dk.vixo.githubandroid.github.data.network

import dk.vixo.githubandroid.github.data.network.dto.GithubRepositoryDTO
import dk.vixo.githubandroid.github.data.network.dto.PullRequestDTO
import dk.vixo.githubandroid.github.domain.model.PageWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET(GithubApi.REPOSITORIES)
    suspend fun loadRepositories(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): Response<PageWrapper<GithubRepositoryDTO>>

    @GET(GithubApi.PULL_REQUESTS)
    suspend fun loadPullRequests(
        @Path("repo", encoded = true) repoPath: String,
        @Query("per_page") number: Long = 10,
        @Query("page") page: Long = 1,
        @Query("sort") sort: String = "updated",
        @Query("direction") direction: String = "asc"
    ): Response<List<PullRequestDTO>>
}