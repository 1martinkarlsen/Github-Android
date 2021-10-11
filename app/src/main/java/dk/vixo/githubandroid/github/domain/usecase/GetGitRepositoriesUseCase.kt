package dk.vixo.githubandroid.github.domain.usecase

import dk.vixo.githubandroid.github.data.GithubRepositorySource
import javax.inject.Inject

class GetGitRepositoriesUseCase @Inject constructor(
    private val source: GithubRepositorySource
) {

    fun getSource() = source
}