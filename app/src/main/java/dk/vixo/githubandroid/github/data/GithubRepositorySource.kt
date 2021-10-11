package dk.vixo.githubandroid.github.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dk.vixo.githubandroid.github.domain.mappers.GithubRepositoryDTOToGithubRepositoryMapper
import dk.vixo.githubandroid.github.domain.model.Repository
import javax.inject.Inject

class GithubRepositorySource @Inject constructor(
    private val repository: GithubRepository,
    private val mapper: GithubRepositoryDTOToGithubRepositoryMapper
) : PagingSource<Int, Repository>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
        val nextPage = params.key ?: 1
        val response = repository.getRepositories("stars", nextPage)
        if (response.isSuccessful) {
            return LoadResult.Page(
                data = response.body()!!.items.map(mapper::map),
                prevKey = if (nextPage == 1) null else nextPage.minus(1),
                nextKey = nextPage.plus(1)
            )
        } else {
            return LoadResult.Error(Exception("HEJ"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Repository>): Int {
        return 1
    }
}