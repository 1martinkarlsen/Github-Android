package dk.vixo.githubandroid.github.domain.mappers

import dk.vixo.githubandroid.github.data.network.dto.GithubRepositoryDTO
import dk.vixo.githubandroid.github.domain.model.Repository
import javax.inject.Inject

class GithubRepositoryDTOToGithubRepositoryMapper @Inject constructor() {

    fun map(dto: GithubRepositoryDTO): Repository {
        return with(dto) {
            Repository(
                id = id,
                name = name,
                fullName = full_name,
                description = description,
                owner = owner,
                stars = stargazers_count,
                watchers = watchers,
                pullRequestUrl = pulls_url
                    .replace("{/number}", "")
                    .replace("https://api.github.com/repos/", "")
            )
        }
    }
}